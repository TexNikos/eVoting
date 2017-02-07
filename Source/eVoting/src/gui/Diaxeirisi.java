/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.utilities.UtilFuncs;
import tablemodels.DiaxeirisiTableModel;

/**
 *
 * @author Nikos
 */
public class Diaxeirisi extends javax.swing.JDialog
{

    /**
     * Creates new form JDialogTest
     */
    public Diaxeirisi(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Diaxeirisi_Titlos = new javax.swing.JLabel();
        jLabel_Periphery = new javax.swing.JLabel();
        jLabel_PParties = new javax.swing.JLabel();
        jComboBox_Periphery = new javax.swing.JComboBox<>();
        jComboBox_PParties = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton_AddCandi = new javax.swing.JButton();
        jButton_EditCandi = new javax.swing.JButton();
        jButton_DeleteCandi = new javax.swing.JButton();
        jButton_DeleteCandi1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel_Diaxeirisi_Titlos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_Diaxeirisi_Titlos.setForeground(new java.awt.Color(0, 102, 255));
        jLabel_Diaxeirisi_Titlos.setText("Διαχείρηση Υποψηφίων");

        jLabel_Periphery.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_Periphery.setText("Εκλογική Περιφέρεια:");

        jLabel_PParties.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel_PParties.setText("Κόμμα:");

        jComboBox_Periphery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Επιλέξτε εκλογική περιφέρεια)", "Α΄ΑΘΗΝΩΝ", "Β΄ ΑΘΗΝΩΝ", "ΝΟΜΟΥ ΑΤΤΙΚΗΣ", "Α΄ ΠΕΙΡΑΙΩΣ", "Β΄ ΠΕΙΡΑΙΩΣ", "ΝΟΜΟΥ ΑΙΤΩΛΟΑΚΑΡΝΑΝΙΑΣ", "ΝΟΜΟΥ ΑΡΓΟΛΙΔΟΣ", "ΝΟΜΟΥ ΑΡΚΑΔΙΑΣ", "ΝΟΜΟΥ ΑΡΤΗΣ", "ΝΟΜΟΥ ΑΧΑΪΑΣ", "ΝΟΜΟΥ ΒΟΙΩΤΙΑΣ", "ΝΟΜΟΥ ΓΡΕΒΕΝΩΝ", "ΝΟΜΟΥ ΔΡΑΜΑΣ", "ΝΟΜΟΥ ΔΩΔΕΚΑΝΗΣΟΥ", "ΝΟΜΟΥ ΕΒΡΟΥ", "ΝΟΜΟΥ ΕΥΒΟΙΑΣ", "ΝΟΜΟΥ ΕΥΡΥΤΑΝΙΑΣ", "ΝΟΜΟΥ ΖΑΚΥΝΘΟΥ", "ΝΟΜΟΥ ΗΛΕΙΑΣ", "ΝΟΜΟΥ ΗΜΑΘΙΑΣ", "ΝΟΜΟΥ ΗΡΑΚΛΕΙΟΥ", "ΝΟΜΟΥ ΘΕΣΠΡΩΤΙΑΣ", "Α΄ ΘΕΣΣΑΛΟΝΙΚΗΣ", "Β΄ ΘΕΣΣΑΛΟΝΙΚΗΣ", "ΝΟΜΟΥ ΙΩΑΝΝΙΝΩΝ", "ΝΟΜΟΥ ΚΑΒΑΛΑΣ", "ΝΟΜΟΥ ΚΑΡΔΙΤΣΗΣ", "ΝΟΜΟΥ ΚΑΣΤΟΡΙΑΣ", "ΝΟΜΟΥ ΚΕΡΚΥΡΑΣ", "ΝΟΜΟΥ ΚΕΦΑΛΛΗΝΙΑΣ", "ΝΟΜΟΥ ΚΙΛΚΙΣ", "ΝΟΜΟΥ ΚΟΖΑΝΗΣ ", "ΝΟΜΟΥ ΚΟΡΙΝΘΙΑΣ ", "ΝΟΜΟΥ ΚΥΚΛΑΔΩΝ ", "ΝΟΜΟΥ ΛΑΚΩΝΙΑΣ", "ΝΟΜΟΥ ΛΑΡΙΣΗΣ ", "ΝΟΜΟΥ ΛΑΣΙΘΙΟΥ ", "ΝΟΜΟΥ ΛΕΣΒΟΥ", "ΝΟΜΟΥ ΛΕΥΚΑΔΟΣ ", "ΝΟΜΟΥ ΜΑΓΝΗΣΙΑΣ ", "ΝΟΜΟΥ  ΜΕΣΣΗΝΙΑΣ", "ΝΟΜΟΥ ΞΑΝΘΗΣ ", "ΝΟΜΟΥ ΠΕΛΛΗΣ", "ΝΟΜΟΥ ΠΙΕΡΙΑΣ", "ΝΟΜΟΥ ΠΡΕΒΕΖΗΣ ", "ΝΟΜΟΥ ΡΕΘΥΜΝΗΣ ", "ΝΟΜΟΥ ΡΟΔΟΠΗΣ", "ΝΟΜΟΥ ΣΑΜΟΥ", "ΝΟΜΟΥ ΣΕΡΡΩΝ ", "ΝΟΜΟΥ ΤΡΙΚΑΛΩΝ", "ΝΟΜΟΥ ΦΘΙΩΤΙΔΟΣ ", "ΝΟΜΟΥ ΦΛΩΡΙΝΗΣ ", "ΝΟΜΟΥ ΦΩΚΙΔΟΣ", "ΝΟΜΟΥ ΧΑΛΚΙΔΙΚΗΣ ", "ΝΟΜΟΥ ΧΑΝΙΩΝ", "ΝΟΜΟΥ ΧΙΟΥ" }));
        jComboBox_Periphery.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox_PeripheryActionPerformed(evt);
            }
        });

        jComboBox_PParties.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "(Επιλέξτε κόμμα)", "ΓΑΛΑΖΙΟΙ", "ΚΟΚΚΙΝΟΙ", "ΛΕΥΚΟΙ", "ΜΑΥΡΟΙ", "ΠΡΑΣΙΝΟΙ" }));
        jComboBox_PParties.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox_PPartiesActionPerformed(evt);
            }
        });

        jTable1.setModel(dtb);
        jScrollPane1.setViewportView(jTable1);

        jButton_AddCandi.setText("Προσθήκη");
        jButton_AddCandi.setMaximumSize(new java.awt.Dimension(91, 23));
        jButton_AddCandi.setMinimumSize(new java.awt.Dimension(91, 23));
        jButton_AddCandi.setPreferredSize(new java.awt.Dimension(91, 23));
        jButton_AddCandi.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton_AddCandiActionPerformed(evt);
            }
        });

        jButton_EditCandi.setText("Επεξεργασία");

        jButton_DeleteCandi.setText("Διαγραφή");
        jButton_DeleteCandi.setMaximumSize(new java.awt.Dimension(91, 23));
        jButton_DeleteCandi.setMinimumSize(new java.awt.Dimension(91, 23));
        jButton_DeleteCandi.setPreferredSize(new java.awt.Dimension(91, 23));

        jButton_DeleteCandi1.setText("Έξοδος");
        jButton_DeleteCandi1.setMaximumSize(new java.awt.Dimension(91, 23));
        jButton_DeleteCandi1.setMinimumSize(new java.awt.Dimension(91, 23));
        jButton_DeleteCandi1.setPreferredSize(new java.awt.Dimension(91, 23));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel_Diaxeirisi_Titlos, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
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
                        .addComponent(jButton_EditCandi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_DeleteCandi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_DeleteCandi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_Diaxeirisi_Titlos, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                        .addComponent(jButton_EditCandi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_DeleteCandi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_DeleteCandi1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_PeripheryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox_PeripheryActionPerformed
    {//GEN-HEADEREND:event_jComboBox_PeripheryActionPerformed

        dtb.updateTable(jComboBox_Periphery.getSelectedItem().toString(), jComboBox_PParties.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox_PeripheryActionPerformed

    private void jComboBox_PPartiesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox_PPartiesActionPerformed
    {//GEN-HEADEREND:event_jComboBox_PPartiesActionPerformed
        dtb.updateTable(jComboBox_Periphery.getSelectedItem().toString(), jComboBox_PParties.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox_PPartiesActionPerformed

    private void jButton_AddCandiActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton_AddCandiActionPerformed
    {//GEN-HEADEREND:event_jButton_AddCandiActionPerformed
        Prosthiki pros = new Prosthiki(UtilFuncs.getDialogOwnerFrame(), true);
        pros.setVisible(true);
    }//GEN-LAST:event_jButton_AddCandiActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AddCandi;
    private javax.swing.JButton jButton_DeleteCandi;
    private javax.swing.JButton jButton_DeleteCandi1;
    private javax.swing.JButton jButton_EditCandi;
    private javax.swing.JComboBox<String> jComboBox_PParties;
    private javax.swing.JComboBox<String> jComboBox_Periphery;
    private javax.swing.JLabel jLabel_Diaxeirisi_Titlos;
    private javax.swing.JLabel jLabel_PParties;
    private javax.swing.JLabel jLabel_Periphery;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private DiaxeirisiTableModel dtb = new DiaxeirisiTableModel();

}
