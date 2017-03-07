/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import db.DBManager;
import gui.utilities.UtilFuncs;
import javax.swing.JOptionPane;

/**
 *
 * @author Ηλίας
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrametest
     */
    public MainWindow() {
        initComponents();
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
        jLabel_icon = new javax.swing.JLabel();
        jButton_Diaxeirisi_ypopsifiwn = new javax.swing.JButton();
        jButton_Prosomoiwtis = new javax.swing.JButton();
        jButton_Exit = new javax.swing.JButton();
        jLabel_Epilogi = new javax.swing.JLabel();
        jLabel_MainTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("eVoting");

        jLabel_icon.setText("jLabel1");

        jButton_Diaxeirisi_ypopsifiwn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Diaxeirisi_ypopsifiwn.setText("1. Διαχείριση υποψηφίων");
        jButton_Diaxeirisi_ypopsifiwn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Diaxeirisi_ypopsifiwnActionPerformed(evt);
            }
        });

        jButton_Prosomoiwtis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Prosomoiwtis.setText("2. Προσομοιωτής εκλογικής διαδικασίας");
        jButton_Prosomoiwtis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ProsomoiwtisActionPerformed(evt);
            }
        });

        jButton_Exit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_Exit.setText("3. Έξοδος");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });

        jLabel_Epilogi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_Epilogi.setText("Παρακαλώ επιλέξτε:");

        jLabel_MainTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel_MainTitle.setForeground(new java.awt.Color(0, 0, 255));
        jLabel_MainTitle.setText("Hellenic eEvoting System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(jLabel_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_Diaxeirisi_ypopsifiwn)
                            .addComponent(jLabel_Epilogi)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jButton_Prosomoiwtis))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(jButton_Exit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addComponent(jLabel_MainTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel_MainTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_Epilogi)
                .addGap(18, 18, 18)
                .addComponent(jButton_Diaxeirisi_ypopsifiwn)
                .addGap(18, 18, 18)
                .addComponent(jButton_Prosomoiwtis)
                .addGap(18, 18, 18)
                .addComponent(jButton_Exit)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ProsomoiwtisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ProsomoiwtisActionPerformed
        new Prosomoiwsi(UtilFuncs.getDialogOwnerFrame(), true);
    }//GEN-LAST:event_jButton_ProsomoiwtisActionPerformed

    private void jButton_Diaxeirisi_ypopsifiwnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Diaxeirisi_ypopsifiwnActionPerformed
        try {
            new Diaxeirisi(UtilFuncs.getDialogOwnerFrame(), true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), "Error connecting to the database."
                    + "\nMake sure the Java DB Server is running and try again.\n\n", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_Diaxeirisi_ypopsifiwnActionPerformed

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        DBManager.destroy();
        dispose();
    }//GEN-LAST:event_jButton_ExitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Diaxeirisi_ypopsifiwn;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JButton jButton_Prosomoiwtis;
    private javax.swing.JLabel jLabel_Epilogi;
    private javax.swing.JLabel jLabel_MainTitle;
    private javax.swing.JLabel jLabel_icon;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
