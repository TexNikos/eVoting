/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import db.DBManager;
import dbentity.Candidate;
import dbentity.ElectoralPeriphery;
import dbentity.PoliticalParty;
import gui.Diaxeirisi;
import javax.persistence.TypedQuery;

/**
 *
 * @author Nikos
 */
public class DiaxeirisiTableModel extends AbstractTableModel {

    private static List<Candidate> result;
    private static TypedQuery<Candidate> query;

    private String[] columns = {"Επώνυμο", "Όνομα"};

    public DiaxeirisiTableModel() {
        DBManager.create();
        query = DBManager.em().createNamedQuery("Candidate.findAll", Candidate.class);
        result = query.getResultList();
    }

    public void updateTable(String periphery, String pParty) {

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

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0:
                result.get(rowIndex).setFldSurname((String) aValue);
                break;
            case 1:
                result.get(rowIndex).setFldName((String) aValue);
                break;
            default:
                break;
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
    
    public void removeValueAt(int index) {
        DBManager.em().getTransaction().begin();
        DBManager.em().remove(result.get(index));
        DBManager.em().getTransaction().commit();
        result.remove(index);
        fireTableDataChanged();
    }

    public void addRow() {
        Candidate c = new Candidate();
        c.setFkElectoralPeripheryId(getPeripheryByName(Diaxeirisi.getSelectedPeriphery()));
        c.setFkPoliticalPartyId(getPoliticalPartyByName(Diaxeirisi.getSelectedParty()));
        result.add(c);
        fireTableDataChanged();
    }
    
    public static void saveCandi(int index) {
        DBManager.em().persist(result.get(index));
    }

    private static ElectoralPeriphery getPeripheryByName(String peripheryName) {
        TypedQuery<ElectoralPeriphery> q = DBManager.em().createNamedQuery("ElectoralPeriphery.findByFldName", ElectoralPeriphery.class);
        q.setParameter("fldName", peripheryName);
        return q.getSingleResult();
    }

    private static PoliticalParty getPoliticalPartyByName(String party) {
        TypedQuery<PoliticalParty> q = DBManager.em().createNamedQuery("PoliticalParty.findByFldTitle", PoliticalParty.class);
        q.setParameter("fldTitle", party);
        return q.getSingleResult();
    }

}
