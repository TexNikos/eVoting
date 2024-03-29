/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import IO.ElectionResults;
import IO.XMLElectionResults;
import db.DBManager;
import dbentity.Candidate;
import dbentity.ElectoralPeriphery;
import dbentity.PoliticalParty;
import gui.utilities.UtilFuncs;
import java.io.File;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.lang3.StringUtils;
import threadedmethods.CastVote;

/**
 *
 * @author Nikos
 */
public class Prosomoiwsi extends javax.swing.JDialog {

    /**
     * Creates new form Prosomoiwsi
     */
    public Prosomoiwsi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel_VoteChance = new javax.swing.JLabel();
        jLabel_BlankChance = new javax.swing.JLabel();
        jLabel_InvalidChance = new javax.swing.JLabel();
        jTextField_VoteChance = new javax.swing.JTextField();
        jTextField_BlankChance = new javax.swing.JTextField();
        jTextField_InvalidChance = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jButton_BeginEmu = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jButton_DisplayStats = new javax.swing.JButton();
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jButton_ExportXML = new javax.swing.JButton();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jButton_Exit = new javax.swing.JButton();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Προσομοίωση Εκλογικής Διαδικασίας");
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(2, 0));

        jLabel_VoteChance.setText("Πιθανότητα προσέλευσης ψηφοφόρου (ποσοστό %):");

        jLabel_BlankChance.setText("Πιθανότητα λευκής ψήφου (ποσοστό %):");

        jLabel_InvalidChance.setText("Πιθανότητα άκυρης ψήφου (ποσοστό %):");

        jTextField_VoteChance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_VoteChance.setText("0");
        jTextField_VoteChance.setMaximumSize(new java.awt.Dimension(40, 28));
        jTextField_VoteChance.setMinimumSize(new java.awt.Dimension(40, 28));
        jTextField_VoteChance.setPreferredSize(new java.awt.Dimension(40, 28));

        jTextField_BlankChance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_BlankChance.setText("0");
        jTextField_BlankChance.setMaximumSize(new java.awt.Dimension(40, 28));
        jTextField_BlankChance.setMinimumSize(new java.awt.Dimension(40, 28));
        jTextField_BlankChance.setPreferredSize(new java.awt.Dimension(40, 28));

        jTextField_InvalidChance.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_InvalidChance.setText("0");
        jTextField_InvalidChance.setMaximumSize(new java.awt.Dimension(40, 28));
        jTextField_InvalidChance.setMinimumSize(new java.awt.Dimension(40, 28));
        jTextField_InvalidChance.setPreferredSize(new java.awt.Dimension(40, 28));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_InvalidChance)
                    .addComponent(jLabel_BlankChance)
                    .addComponent(jLabel_VoteChance))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_VoteChance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_BlankChance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_InvalidChance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_VoteChance)
                    .addComponent(jTextField_VoteChance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_BlankChance)
                    .addComponent(jTextField_BlankChance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_InvalidChance)
                    .addComponent(jTextField_InvalidChance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(6, 3));
        jPanel3.add(filler1);
        jPanel3.add(filler2);
        jPanel3.add(filler3);
        jPanel3.add(filler4);

        jButton_BeginEmu.setText("Έναρξη Προσομοίωσης");
        jButton_BeginEmu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BeginEmuActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_BeginEmu);
        jPanel3.add(filler5);
        jPanel3.add(filler6);

        jButton_DisplayStats.setText("Εμφάνιση Στατιστικών");
        jButton_DisplayStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DisplayStatsActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_DisplayStats);
        jPanel3.add(filler9);
        jPanel3.add(filler7);

        jButton_ExportXML.setText("Εξαγωγή Αποτελεσμάτων σε XML");
        jButton_ExportXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExportXMLActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_ExportXML);
        jPanel3.add(filler8);
        jPanel3.add(filler10);

        jButton_Exit.setText("Έξοδος");
        jButton_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExitActionPerformed(evt);
            }
        });
        jPanel3.add(jButton_Exit);
        jPanel3.add(filler11);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExitActionPerformed
        dispose();
        DBManager.destroy();
    }//GEN-LAST:event_jButton_ExitActionPerformed

    private void jButton_BeginEmuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BeginEmuActionPerformed
        DBManager.create();
        Query q = DBManager.em().createNativeQuery("SELECT COUNT(*) FROM TBL_CANDIDATE");
        int rs = (int) q.getSingleResult();

        if (rs != 0) {
            ProgressWindow pw = new ProgressWindow(UtilFuncs.getDialogOwnerFrame(), true);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    float voteChance = 0.0f;
                    float blankChance = 0.0f;
                    float invalidChance = 0.0f;
                    String inputError = "Οι πιθανότητες πρέπει να είναι θετικοί αριθμοί από το 0.0 έως το 100";
                    String inputErrorTitle = "Σφάλμα εισόδου";

                    try {
                        voteChance = Float.parseFloat(jTextField_VoteChance.getText()) / 100f;
                        blankChance = Float.parseFloat(jTextField_BlankChance.getText()) / 100f;
                        invalidChance = Float.parseFloat(jTextField_InvalidChance.getText()) / 100f;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), inputError, inputErrorTitle, JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    boolean voteChanceInRange = (voteChance >= 0f && voteChance <= 1f);
                    boolean blankChanceInRange = (blankChance >= 0f && blankChance <= 1f);
                    boolean invalidChanceInRange = (invalidChance >= 0f && invalidChance <= 1f);
                    boolean blankInvalidSumInRange = blankChance + invalidChance <= 1f;

                    if (!(voteChanceInRange && blankChanceInRange && invalidChanceInRange && blankInvalidSumInRange)) {
                        JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), inputError, inputErrorTitle, JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    try {
                        DBManager.create();
                        try {
                            DBManager.em().getTransaction().begin();
                        } catch (Exception e) {

                        }
                        DBManager.em().createQuery("DELETE FROM Vote").executeUpdate();
                        DBManager.em().getTransaction().commit();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), "Error connecting to the database."
                                + "\nMake sure the Java DB Server is running and try again.\n\n", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            pw.setVisible(true);
                        }
                    });

                    TypedQuery<ElectoralPeriphery> tQuery = DBManager.em().createNamedQuery("ElectoralPeriphery.findAll", ElectoralPeriphery.class);
                    List<ElectoralPeriphery> results = tQuery.getResultList();

                    int nThreads = 0;
                    for (ElectoralPeriphery ep : results) {
                        if (!ep.getCandidateCollection().isEmpty()) {
                            nThreads++;
                        }
                    }
                    ExecutorService executor = Executors.newFixedThreadPool(nThreads);

                    for (ElectoralPeriphery ep : results) {
                        if (!ep.getCandidateCollection().isEmpty()) {
                            Runnable worker = new CastVote(ep, voteChance, blankChance, invalidChance);

                            executor.execute(worker);
                        }
                    }

                    executor.shutdown();

                    //Wait until all threads are finished
                    while (!executor.isTerminated()) {

                    }
                    pw.dispose();
                    JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), "Η προσομοίωση ολοκληρώθηκε επιτυχώς", "Ολοκληρώθηκε", JOptionPane.INFORMATION_MESSAGE);
                }

            }).start();
        } else {
            String oPaneMsg = "Δεν υπάρχουν καταχωρημένοι υποψήφιοι.\n Η προσομοίωση δεν θα εκτελεστεί.";
            String oPaneTitle = "Σφάλμα εισόδου";
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), oPaneMsg, oPaneTitle, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton_BeginEmuActionPerformed

    private void jButton_DisplayStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DisplayStatsActionPerformed
        try {
            new DisplayStats(UtilFuncs.getDialogOwnerFrame(), true).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), "Error connecting to the database."
                    + "\nMake sure the Java DB Server is running and try again.\n\n", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_DisplayStatsActionPerformed

    private void jButton_ExportXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExportXMLActionPerformed
        DBManager.create();
        TypedQuery<ElectoralPeriphery> tQuery = DBManager.em().createNamedQuery("ElectoralPeriphery.findAll", ElectoralPeriphery.class);

        List<ElectoralPeriphery> perWithVotes = new ArrayList<>();

        for (ElectoralPeriphery ep : tQuery.getResultList()) {
            if (ep.getVoteCollection().size() > 0) {
                perWithVotes.add(ep);
            }
        }

        ElectionResults district = new XMLElectionResults();

        for (ElectoralPeriphery ep : perWithVotes) {

            TypedQuery<PoliticalParty> tQ2 = DBManager.em().createNamedQuery("PoliticalParty.findAll", PoliticalParty.class);
            List<PoliticalParty> pParty = tQ2.getResultList();

            ElectionResults resultsOfParties = new XMLElectionResults();

            for (PoliticalParty pp : pParty) {

                ElectionResults candidatesOfParty = new XMLElectionResults();
                TypedQuery<Candidate> tQ3 = DBManager.em().createNamedQuery("Candidate.findByElectPerAndPolParty", Candidate.class);
                tQ3.setParameter("fkElectoralPeripheryId", ep);
                tQ3.setParameter("fkPoliticalPartyId", pp);
                List<Candidate> candies = tQ3.getResultList();

                for (Candidate c : candies) {
                    DecimalFormat percentage = new DecimalFormat("0.00%");
                    String peripheryPercentage = percentage.format((float) c.getVoteCollection().size() / ep.getVoteCollection().size());
                    String partyPercentage = percentage.format((float) c.getVoteCollection().size() / pp.getVoteCollection().size());
                    candidatesOfParty.put(c.getFldSurname(), c.getVoteCollection().size() + ", " + partyPercentage + ", " + peripheryPercentage);
                }
                resultsOfParties.put(pp.getFldTitle(), candidatesOfParty);
            }
            district.put(StringUtils.deleteWhitespace(ep.getFldName()), resultsOfParties);
        }

        String xml = ((XMLElectionResults) district).toXML();

        JFileChooser fileChooser = new JFileChooser();

        FileFilter xmlFilter = new FileNameExtensionFilter("eXtensible Markup Language Files (.xml)", ".xml");

        fileChooser.setFileFilter(xmlFilter);

        int rVal = fileChooser.showSaveDialog(UtilFuncs.getDialogOwnerFrame());
        if (rVal == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getPath();
            File f;
            if (path.endsWith(".xml")) {
                f = new File(path);
            } else {
                f = new File(path + ".xml");
            }
            try {
                f.createNewFile();
                try {
                    PrintWriter pr = new PrintWriter(f);
                    pr.write(xml);
                    pr.close();
                } catch (Exception e) {

                }
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_jButton_ExportXMLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    private javax.swing.JButton jButton_BeginEmu;
    private javax.swing.JButton jButton_DisplayStats;
    private javax.swing.JButton jButton_Exit;
    private javax.swing.JButton jButton_ExportXML;
    private javax.swing.JLabel jLabel_BlankChance;
    private javax.swing.JLabel jLabel_InvalidChance;
    private javax.swing.JLabel jLabel_VoteChance;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField_BlankChance;
    private javax.swing.JTextField jTextField_InvalidChance;
    private javax.swing.JTextField jTextField_VoteChance;
    // End of variables declaration//GEN-END:variables
}
