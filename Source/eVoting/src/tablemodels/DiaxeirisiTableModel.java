/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import db.DBManager;
import dbentity.Candidate;
import dbentity.ElectoralPeriphery;
import dbentity.PoliticalParty;
import gui.Diaxeirisi;
import gui.utilities.UtilFuncs;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Nikos
 */
public class DiaxeirisiTableModel extends AbstractTableModel {

    public static List<Candidate> result;
    private static TypedQuery<Candidate> query;
    private static final String TEXT_ONLY_REGEX = "!|@|#|\\$|%|\\^|&|\\*|\\(|\\)|`|~|-|_|=|\\+|\\[|\\]|\\{|\\}|;|:|'|\\\"|,|\\.|<|>|/|\\?|\\\\|\\||[0-9]";
    private static final Pattern TEXT_ONLY_PATTERN = Pattern.compile(TEXT_ONLY_REGEX);
    private boolean canIdGenerated = false;
    long canId = 0L;

    public static List<Integer> unsavedEdits = new ArrayList<Integer>();

    private final String[] columns = {"Επώνυμο", "Όνομα"};

    public DiaxeirisiTableModel() {
        DBManager.create();
        query = DBManager.em().createNamedQuery("Candidate.findAll", Candidate.class);
        result = query.getResultList();
    }

    public void updateTable(String periphery, String pParty) {

        unsavedEdits.clear();

        if (periphery.equals("(Επιλέξτε εκλογική περιφέρεια)") && pParty.equals("(Επιλέξτε κόμμα)")) {
            query = DBManager.em().createNamedQuery("Candidate.findAll", Candidate.class);
            result = query.getResultList();
            fireTableDataChanged();
        } else if (periphery.equals("(Επιλέξτε εκλογική περιφέρεια)") && !pParty.equals("(Επιλέξτε κόμμα)")) {
            TypedQuery<PoliticalParty> q = DBManager.em().createNamedQuery("PoliticalParty.findByFldTitle", PoliticalParty.class);
            q.setParameter("fldTitle", pParty);
            PoliticalParty pPartyParam = q.getSingleResult();

            query = DBManager.em().createNamedQuery("Candidate.findByFkPoliticalPartyId", Candidate.class);
            query.setParameter("fkPoliticalPartyId", pPartyParam);
            result = query.getResultList();
            fireTableDataChanged();
        } else if (!periphery.equals("(Επιλέξτε εκλογική περιφέρεια)") && pParty.equals("(Επιλέξτε κόμμα)")) {
            TypedQuery<ElectoralPeriphery> q = DBManager.em().createNamedQuery("ElectoralPeriphery.findByFldName", ElectoralPeriphery.class);
            q.setParameter("fldName", periphery);
            ElectoralPeriphery peripheryParam = q.getSingleResult();

            query = DBManager.em().createNamedQuery("Candidate.findByFkElectoralPeriphery", Candidate.class);
            query.setParameter("fkElectoralPeripheryId", peripheryParam);
            result = query.getResultList();
            fireTableDataChanged();
        } else {
            TypedQuery<PoliticalParty> q = DBManager.em().createNamedQuery("PoliticalParty.findByFldTitle", PoliticalParty.class);
            q.setParameter("fldTitle", pParty);
            PoliticalParty pPartyParam = q.getSingleResult();

            TypedQuery<ElectoralPeriphery> q1 = DBManager.em().createNamedQuery("ElectoralPeriphery.findByFldName", ElectoralPeriphery.class);
            q1.setParameter("fldName", periphery);
            ElectoralPeriphery peripheryParam = q1.getSingleResult();

            query = DBManager.em().createNamedQuery("Candidate.findByElectPerAndPolParty", Candidate.class);
            query.setParameter("fkElectoralPeripheryId", peripheryParam);
            query.setParameter("fkPoliticalPartyId", pPartyParam);
            result = query.getResultList();
            fireTableDataChanged();
        }
        canIdGenerated = false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String surname = StringUtils.stripAccents(((String) aValue).toUpperCase().trim());
        String name = StringUtils.stripAccents(((String) aValue).toUpperCase().trim());
        Matcher m1 = TEXT_ONLY_PATTERN.matcher(surname);
        Matcher m2 = TEXT_ONLY_PATTERN.matcher(name);

        if (m1.find() || m2.find()) {
            String inputError = "Τα ονοματεπώνυμα δεν μπορούν να περιέχουν αριθμούς ή σύμβολα";
            String inputErrorTitle = "Σφάλμα εισόδου";
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), inputError, inputErrorTitle, JOptionPane.ERROR_MESSAGE);
            return;
        }

        switch (columnIndex) {
            case 0:
                result.get(rowIndex).setFldSurname(surname);
                break;
            case 1:
                result.get(rowIndex).setFldName(name);
                break;
            default:
                break;
        }
        if (!unsavedEdits.contains(rowIndex)) {
            unsavedEdits.add(rowIndex);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public int getRowCount() {
        return result.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Candidate candi = (Candidate) result.get(row);

        switch (col) {
            case 0:
                return candi.getFldSurname();
            case 1:
                return candi.getFldName();
            default:
                return null;
        }
    }

    public void removeValueAt(int[] index) {
        try {
            DBManager.em().getTransaction().begin();
        } catch (Exception e) {

        }
        for (int i : index) {
            DBManager.em().remove(result.get(i));
        }
        try {
            DBManager.em().getTransaction().commit();
        } catch (javax.persistence.RollbackException e) {
            String deleteError = "Κάποιοι από τους επιλεγμένους υποψηφίους, δεν μπορούν να διαγραφούν "
                    + "γιατί υπάρχουν για αυτούς καταχωρημένοι ψήφοι";
            String deleteErrorTitle = "Σφάλμα";
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), deleteError, deleteErrorTitle, JOptionPane.ERROR_MESSAGE);
        }
        updateTable(Diaxeirisi.getSelectedPeriphery(), Diaxeirisi.getSelectedParty());

    }

    public void removeAllDisplayed() {

        try {
            DBManager.em().getTransaction().begin();
        } catch (Exception e) {

        }
        for (Candidate c : result) {
            DBManager.em().remove(c);
        }
        try {
            DBManager.em().getTransaction().commit();
            result.clear();
        } catch (javax.persistence.RollbackException e) {
            String deleteError = "Η διαγραφή απέτυχε.\n"
                    + "Κάποιοι από τους υποψηφίους, δεν μπορούν να διαγραφούν "
                    + "γιατί υπάρχουν για αυτούς καταχωρημένοι ψήφοι.";
            String deleteErrorTitle = "Σφάλμα";
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), deleteError, deleteErrorTitle, JOptionPane.ERROR_MESSAGE);
        }
        fireTableDataChanged();
    }

    public void addRow() {
        if (!canIdGenerated) {
            Query q = DBManager.em().createNativeQuery("SELECT MAX(PK_CANDIDATE_ID) FROM TBL_CANDIDATE");
            canId = Long.parseLong(q.getSingleResult().toString());
            canIdGenerated = true;
        }

        Candidate c = new Candidate();
        c.setPkCandidateId(++canId);
        c.setFkElectoralPeripheryId(UtilFuncs.getPeripheryByName(Diaxeirisi.getSelectedPeriphery()));
        c.setFkPoliticalPartyId(UtilFuncs.getPoliticalPartyByName(Diaxeirisi.getSelectedParty()));
        c.setFldSurname("");
        c.setFldName("");
        result.add(c);
        unsavedEdits.add(result.indexOf(c));
        fireTableDataChanged();
    }

    public static boolean saveCandi(int index) {
        if (!result.isEmpty()) {
            Candidate c = result.get(index);
            String surname = c.getFldSurname();
            String name = c.getFldName();
            if (surname.isEmpty() || name.isEmpty()) {
                return false;
            } else {
                DBManager.em().persist(c);
                return true;
            }
        }
        return false;
    }

}
