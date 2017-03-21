/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import db.DBManager;
import dbentity.Candidate;
import dbentity.ElectoralPeriphery;
import dbentity.PoliticalParty;
import gui.utilities.UtilFuncs;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import tablemodels.DiaxeirisiTableModel;

/**
 *
 * @author Nikos
 */
public class Diaxeirisi extends javax.swing.JDialog {

    /**
     * Creates new form JDialogTest
     */
    public Diaxeirisi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        jTable1.getTableHeader().setReorderingAllowed(false);

        setLocationByPlatform(true);
        setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Periphery = new javax.swing.JLabel();
        jLabel_PParties = new javax.swing.JLabel();
        jComboBox_Periphery = new javax.swing.JComboBox<>();
        jComboBox_PParties = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_AddCandi = new javax.swing.JButton();
        jButton_SaveChanges = new javax.swing.JButton();
        jButton_DeleteCandi = new javax.swing.JButton();
        jButton_DeleteAll = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel_Diaxeirisi_Titlos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Διαχείρηση Υποψηφίων");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel_Periphery.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Periphery.setText("Εκλογική Περιφέρεια:");

        jLabel_PParties.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_PParties.setText("Κόμμα:");

        jComboBox_Periphery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Επιλέξτε εκλογική περιφέρεια)", "Α΄ΑΘΗΝΩΝ", "Β΄ ΑΘΗΝΩΝ", "ΝΟΜΟΥ ΑΤΤΙΚΗΣ", "Α΄ ΠΕΙΡΑΙΩΣ", "Β΄ ΠΕΙΡΑΙΩΣ", "ΝΟΜΟΥ ΑΙΤΩΛΟΑΚΑΡΝΑΝΙΑΣ", "ΝΟΜΟΥ ΑΡΓΟΛΙΔΟΣ", "ΝΟΜΟΥ ΑΡΚΑΔΙΑΣ", "ΝΟΜΟΥ ΑΡΤΗΣ", "ΝΟΜΟΥ ΑΧΑΪΑΣ", "ΝΟΜΟΥ ΒΟΙΩΤΙΑΣ", "ΝΟΜΟΥ ΓΡΕΒΕΝΩΝ", "ΝΟΜΟΥ ΔΡΑΜΑΣ", "ΝΟΜΟΥ ΔΩΔΕΚΑΝΗΣΟΥ", "ΝΟΜΟΥ ΕΒΡΟΥ", "ΝΟΜΟΥ ΕΥΒΟΙΑΣ", "ΝΟΜΟΥ ΕΥΡΥΤΑΝΙΑΣ", "ΝΟΜΟΥ ΖΑΚΥΝΘΟΥ", "ΝΟΜΟΥ ΗΛΕΙΑΣ", "ΝΟΜΟΥ ΗΜΑΘΙΑΣ", "ΝΟΜΟΥ ΗΡΑΚΛΕΙΟΥ", "ΝΟΜΟΥ ΘΕΣΠΡΩΤΙΑΣ", "Α΄ ΘΕΣΣΑΛΟΝΙΚΗΣ", "Β΄ ΘΕΣΣΑΛΟΝΙΚΗΣ", "ΝΟΜΟΥ ΙΩΑΝΝΙΝΩΝ", "ΝΟΜΟΥ ΚΑΒΑΛΑΣ", "ΝΟΜΟΥ ΚΑΡΔΙΤΣΗΣ", "ΝΟΜΟΥ ΚΑΣΤΟΡΙΑΣ", "ΝΟΜΟΥ ΚΕΡΚΥΡΑΣ", "ΝΟΜΟΥ ΚΕΦΑΛΛΗΝΙΑΣ", "ΝΟΜΟΥ ΚΙΛΚΙΣ", "ΝΟΜΟΥ ΚΟΖΑΝΗΣ ", "ΝΟΜΟΥ ΚΟΡΙΝΘΙΑΣ ", "ΝΟΜΟΥ ΚΥΚΛΑΔΩΝ ", "ΝΟΜΟΥ ΛΑΚΩΝΙΑΣ", "ΝΟΜΟΥ ΛΑΡΙΣΗΣ ", "ΝΟΜΟΥ ΛΑΣΙΘΙΟΥ ", "ΝΟΜΟΥ ΛΕΣΒΟΥ", "ΝΟΜΟΥ ΛΕΥΚΑΔΟΣ ", "ΝΟΜΟΥ ΜΑΓΝΗΣΙΑΣ ", "ΝΟΜΟΥ  ΜΕΣΣΗΝΙΑΣ", "ΝΟΜΟΥ ΞΑΝΘΗΣ ", "ΝΟΜΟΥ ΠΕΛΛΗΣ", "ΝΟΜΟΥ ΠΙΕΡΙΑΣ", "ΝΟΜΟΥ ΠΡΕΒΕΖΗΣ ", "ΝΟΜΟΥ ΡΕΘΥΜΝΗΣ ", "ΝΟΜΟΥ ΡΟΔΟΠΗΣ", "ΝΟΜΟΥ ΣΑΜΟΥ", "ΝΟΜΟΥ ΣΕΡΡΩΝ ", "ΝΟΜΟΥ ΤΡΙΚΑΛΩΝ", "ΝΟΜΟΥ ΦΘΙΩΤΙΔΟΣ ", "ΝΟΜΟΥ ΦΛΩΡΙΝΗΣ ", "ΝΟΜΟΥ ΦΩΚΙΔΟΣ", "ΝΟΜΟΥ ΧΑΛΚΙΔΙΚΗΣ ", "ΝΟΜΟΥ ΧΑΝΙΩΝ", "ΝΟΜΟΥ ΧΙΟΥ" }));
        jComboBox_Periphery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PeripheryActionPerformed(evt);
            }
        });

        jComboBox_PParties.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Επιλέξτε κόμμα)", "ΓΑΛΑΖΙΟΙ", "ΚΟΚΚΙΝΟΙ", "ΛΕΥΚΟΙ", "ΜΑΥΡΟΙ", "ΠΡΑΣΙΝΟΙ" }));
        jComboBox_PParties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PPartiesActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(dtb);
        jTable1.setCellSelectionEnabled(true);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowSorter(null);
        jTable1.setSelectionBackground(new java.awt.Color(57, 144, 216));
        jScrollPane1.setViewportView(jTable1);

        jButton_AddCandi.setText("Δημιουργία");
        jButton_AddCandi.setMaximumSize(new java.awt.Dimension(91, 23));
        jButton_AddCandi.setMinimumSize(new java.awt.Dimension(91, 23));
        jButton_AddCandi.setPreferredSize(new java.awt.Dimension(91, 23));
        jButton_AddCandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddCandiActionPerformed(evt);
            }
        });

        jButton_SaveChanges.setText("Αποθήκευση Αλλαγών");
        jButton_SaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SaveChangesActionPerformed(evt);
            }
        });

        jButton_DeleteCandi.setText("Διαγραφή");
        jButton_DeleteCandi.setMaximumSize(new java.awt.Dimension(91, 23));
        jButton_DeleteCandi.setMinimumSize(new java.awt.Dimension(91, 23));
        jButton_DeleteCandi.setPreferredSize(new java.awt.Dimension(91, 23));
        jButton_DeleteCandi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteCandiActionPerformed(evt);
            }
        });

        jButton_DeleteAll.setText("Διαγραφή Όλων");
        jButton_DeleteAll.setMaximumSize(new java.awt.Dimension(91, 23));
        jButton_DeleteAll.setMinimumSize(new java.awt.Dimension(91, 23));
        jButton_DeleteAll.setPreferredSize(new java.awt.Dimension(91, 23));
        jButton_DeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_PParties)
                            .addComponent(jLabel_Periphery))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_Periphery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_PParties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jButton_AddCandi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_SaveChanges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_DeleteCandi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_DeleteAll, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Periphery)
                            .addComponent(jComboBox_Periphery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_PParties)
                            .addComponent(jComboBox_PParties, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_AddCandi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_SaveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_DeleteCandi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_DeleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLabel_Diaxeirisi_Titlos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_Diaxeirisi_Titlos.setForeground(new java.awt.Color(0, 102, 255));
        jLabel_Diaxeirisi_Titlos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Diaxeirisi_Titlos.setText("Διαχείρηση Υποψηφίων");
        jLabel_Diaxeirisi_Titlos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel_Diaxeirisi_Titlos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_PeripheryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox_PeripheryActionPerformed
    {//GEN-HEADEREND:event_jComboBox_PeripheryActionPerformed

        dtb.updateTable(getSelectedPeriphery(), getSelectedParty());
    }//GEN-LAST:event_jComboBox_PeripheryActionPerformed

    private void jComboBox_PPartiesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox_PPartiesActionPerformed
    {//GEN-HEADEREND:event_jComboBox_PPartiesActionPerformed
        dtb.updateTable(getSelectedPeriphery(), getSelectedParty());
    }//GEN-LAST:event_jComboBox_PPartiesActionPerformed

    private void jButton_AddCandiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton_AddCandiActionPerformed
    {//GEN-HEADEREND:event_jButton_AddCandiActionPerformed

        ElectoralPeriphery selectedPer = null;
        PoliticalParty selectedPar = null;
        Query q;
        int politicalPartyCount = 0;
        int selectedPerSeatsCount = 0;

        if (getSelectedParty().equals("(Επιλέξτε κόμμα)") || getSelectedPeriphery().equals("(Επιλέξτε εκλογική περιφέρεια)")) {

        } else {
            selectedPer = UtilFuncs.getPeripheryByName(getSelectedPeriphery());
            selectedPar = UtilFuncs.getPoliticalPartyByName(getSelectedParty());
        }

        if (selectedPer != null && selectedPar != null) {

            q = DBManager.em().createNativeQuery("SELECT COUNT(*) FROM TBL_CANDIDATE WHERE FK_POLITICAL_PARTY_ID = " + selectedPar.getPkPartyId().toString()
                    + "AND FK_ELECTORAL_PERIPHERY_ID = " + selectedPer.getPkElectoralPeripheryId().toString());
            politicalPartyCount = Integer.parseInt(q.getSingleResult().toString());

            selectedPerSeatsCount = selectedPer.getFldSeatsCount();
        }

        if (getSelectedParty().equals("(Επιλέξτε κόμμα)") || getSelectedPeriphery().equals("(Επιλέξτε εκλογική περιφέρεια)")) {
            String oPaneMsg = "Επιλέξτε εκλογική περιφέρεια και κόμμα για να εισάγετε υποψήφιο";
            String oPaneTitle = "Σφάλμα!";
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), oPaneMsg, oPaneTitle, JOptionPane.ERROR_MESSAGE);
        } else if (politicalPartyCount == selectedPerSeatsCount) {
            String oPaneMsg1 = "Δεν υπάρχει δυνατότητα εισαγωγής άλλου υποψηφίου.";
            String oPaneTitle1 = "Σφάλμα!";
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), oPaneMsg1, oPaneTitle1, JOptionPane.ERROR_MESSAGE);
        } else {
            ((DiaxeirisiTableModel) jTable1.getModel()).addRow();
        }
    }//GEN-LAST:event_jButton_AddCandiActionPerformed

    private void jButton_DeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteAllActionPerformed
        String oPaneMsg = "Είστε σίγουροι πως θέλετε να διαγράψετε όλους τους εμφανιζόμενους υποψηφίους;";
        String oPaneTitle = "Διαγραφή όλων;";

        if (JOptionPane.showConfirmDialog(UtilFuncs.getDialogOwnerFrame(), oPaneMsg, oPaneTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
            ((DiaxeirisiTableModel) jTable1.getModel()).removeAllDisplayed();
        }
    }//GEN-LAST:event_jButton_DeleteAllActionPerformed

    private void jButton_SaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SaveChangesActionPerformed
        List<Integer> errorIndex = new ArrayList<>();
        List<Integer> savedEdits = new ArrayList<>();
        List<Integer> nameExistsInd = new ArrayList<>();
        
        if (!DiaxeirisiTableModel.unsavedEdits.isEmpty()) {
            try {
                DBManager.em().getTransaction().begin();
            } catch (Exception e) {

            }
            for (int i : DiaxeirisiTableModel.unsavedEdits) {
                int rVal = DiaxeirisiTableModel.saveCandi(i);
                switch (rVal) {
                    case -1:
                        errorIndex.add(i);
                        break;
                    case -2:
                        nameExistsInd.add(i);
                        break;
                    default:
                        savedEdits.add(i);
                        break;
                }
            }

            if (!savedEdits.isEmpty()) {
                DBManager.em().getTransaction().commit();
                try {
                    DBManager.em().getTransaction().begin();
                } catch (Exception e) {

                }
                DiaxeirisiTableModel.unsavedEdits.removeAll(savedEdits);
                savedEdits.clear();
            }

            if (!errorIndex.isEmpty()) {
                String inputError = "Τα πεδία \"Επώνυμο\" και \"Όνομα\" δεν μπορούν να είναι κενά για καμία εγγραφή\n"
                        + "Οι κενές εγγραφές δεν αποθηκεύτηκαν";
                String inputErrorTitle = "Σφάλμα εισόδου";
                JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), inputError, inputErrorTitle, JOptionPane.ERROR_MESSAGE);
                errorIndex.clear();
            }
            
            if (!nameExistsInd.isEmpty()) {
                String inputError = "Τα ονοματεπώνυμα: ";
                String inputErrorTitle = "Σφάλμα εισόδου";
                
                for (int i : nameExistsInd) {
                    Candidate c = DiaxeirisiTableModel.result.get(i);
                    inputError += "\n" + c.getFldSurname();
                    inputError += " " + c.getFldName();
                }
                
                inputError += "\nείναι ήδη καταχωρημένα.";
                
                JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), inputError, inputErrorTitle, JOptionPane.ERROR_MESSAGE);
            }
        } else {
            String error = "Δεν υπάρχουν μη αποθηκευμένες αλλαγές.";
            String errorTitle = "Σφάλμα";
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), error, errorTitle, JOptionPane.ERROR_MESSAGE);
        }

        if (DBManager.em().getTransaction().isActive()) {
            DBManager.em().getTransaction().commit();
        }
    }//GEN-LAST:event_jButton_SaveChangesActionPerformed

    private void jButton_DeleteCandiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteCandiActionPerformed
        String oPaneMsg = "Είστε σίγουροι πως θέλετε να διαγράψετε τους επιλεγμένους υποψηφίους;";
        String oPaneTitle = "Διαγραφή;";

        if (JOptionPane.showConfirmDialog(UtilFuncs.getDialogOwnerFrame(), oPaneMsg, oPaneTitle, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
            int[] selectedRows = jTable1.getSelectedRows();

            ((DiaxeirisiTableModel) jTable1.getModel()).removeValueAt(selectedRows);
        }
    }//GEN-LAST:event_jButton_DeleteCandiActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DBManager.destroy();
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddCandi;
    private javax.swing.JButton jButton_DeleteAll;
    private javax.swing.JButton jButton_DeleteCandi;
    private javax.swing.JButton jButton_SaveChanges;
    private static javax.swing.JComboBox<String> jComboBox_PParties;
    private static javax.swing.JComboBox<String> jComboBox_Periphery;
    private javax.swing.JLabel jLabel_Diaxeirisi_Titlos;
    private javax.swing.JLabel jLabel_PParties;
    private javax.swing.JLabel jLabel_Periphery;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private final DiaxeirisiTableModel dtb = new DiaxeirisiTableModel();

    public static String getSelectedPeriphery() {
        return (String) jComboBox_Periphery.getSelectedItem();
    }

    public static String getSelectedParty() {
        return (String) jComboBox_PParties.getSelectedItem();
    }

}
