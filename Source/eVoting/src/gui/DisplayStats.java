/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import db.DBManager;
import dbentity.PoliticalParty;
import dbentity.Vote;
import gui.utilities.UtilFuncs;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import tablemodels.DisplayStatsTableModel;

/**
 *
 * @author Nikos
 */
public class DisplayStats extends javax.swing.JDialog {

    /**
     * Creates new form DisplayStats
     *
     * @param parent
     * @param modal
     */
    public DisplayStats(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        pie = makePie(getSelectedPeriphery());

        setLocationByPlatform(true);

    }

    /**
     * Pie chart construction function
     */
    private JFreeChart makePie(String periphery) {
        JFreeChart chart = ChartFactory.createPieChart(periphery, dataset);
        chart.setTitle(periphery);
        StandardPieSectionLabelGenerator labelMaker = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("#0"), new DecimalFormat("0.00%"));
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(labelMaker);
        plot.setLabelFont(new Font(Font.SANS_SERIF, Font.BOLD, 11));
        plot.setLabelLinkStyle(PieLabelLinkStyle.QUAD_CURVE);
        JPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(jPanel4.getSize());
        jPanel4.add(chartPanel);
        jPanel4.getParent().validate();

        return chart;
    }

    private void updatePie(String title) {
        pie.setTitle(title);
    }

    private void setPieData(String currentPer) {

        int voteCount = 0;
        dstm.tableContents.clear();
        
        if (currentPer.equals("ΟΛΕΣ ΟΙ ΠΕΡΙΦΕΡΕΙΕΣ")) {

            for (PoliticalParty pp : allParties) {

                TypedQuery<Vote> tQuery2 = DBManager.em().createNamedQuery("Vote.findValidByPar", Vote.class);
                tQuery2.setParameter("fkPoliticalPartyId", pp);
                List<Vote> votes = tQuery2.getResultList();

                dataset.setValue(pp.getFldTitle(), votes.size());
                Object[] tableRow = {pp.getFldTitle(), votes.size(), ""};
                dstm.tableContents.add(tableRow);
                voteCount += votes.size();
            }

            TypedQuery<Vote> tQuery2 = DBManager.em().createNamedQuery("Vote.findByFldIsBlank", Vote.class);
            tQuery2.setParameter("fldIsBlank", true);

            List<Vote> votes = tQuery2.getResultList();
            dataset.setValue("ΛΕΥΚΑ", votes.size());
            Object[] tableRow = {"ΛΕΥΚΑ", votes.size(), ""};
            dstm.tableContents.add(tableRow.clone());
            voteCount += votes.size();

            tQuery2 = DBManager.em().createNamedQuery("Vote.findByFldIsInvalid", Vote.class);
            tQuery2.setParameter("fldIsInvalid", true);

            votes = tQuery2.getResultList();
            dataset.setValue("ΑΚΥΡΑ", votes.size());

            tableRow[0] = "ΑΚΥΡΑ";
            tableRow[1] = votes.size();
            tableRow[2] = "";
            dstm.tableContents.add(tableRow);
            voteCount += votes.size();

            for (Object[] oa : dstm.tableContents) {
                oa[2] = percentage.format((int) oa[1] / (float) voteCount);
            }

            dstm.fireTableDataChanged();

        } else {

            for (PoliticalParty pp : allParties) {

                TypedQuery<Vote> tQuery2 = DBManager.em().createNamedQuery("Vote.findValidByPerPar", Vote.class);
                tQuery2.setParameter("fkElectoralPeripheryId", UtilFuncs.getPeripheryByName(currentPer));
                tQuery2.setParameter("fkPoliticalPartyId", pp);
                List<Vote> votes = tQuery2.getResultList();

                dataset.setValue(pp.getFldTitle(), votes.size());
                Object[] tableRow = {pp.getFldTitle(), votes.size(), ""};
                dstm.tableContents.add(tableRow);
                voteCount += votes.size();
            }

            TypedQuery<Vote> tQuery2 = DBManager.em().createNamedQuery("Vote.findByPerBlank", Vote.class);
            tQuery2.setParameter("fkElectoralPeripheryId", UtilFuncs.getPeripheryByName(currentPer));
            List<Vote> votes = tQuery2.getResultList();
            dataset.setValue("ΛΕΥΚΑ", votes.size());
            Object[] tableRow = {"ΛΕΥΚΑ", votes.size(), ""};
            dstm.tableContents.add(tableRow.clone());
            voteCount += votes.size();

            TypedQuery<Vote> tQuery3 = DBManager.em().createNamedQuery("Vote.findByPerInvalid", Vote.class);
            tQuery3.setParameter("fkElectoralPeripheryId", UtilFuncs.getPeripheryByName(currentPer));
            votes = tQuery3.getResultList();
            dataset.setValue("ΑΚΥΡΑ", votes.size());
            tableRow[0] = "ΑΚΥΡΑ";
            tableRow[1] = votes.size();
            tableRow[2] = "";
            dstm.tableContents.add(tableRow);
            voteCount += votes.size();

            for (Object[] oa : dstm.tableContents) {
                oa[2] = percentage.format((int) oa[1] / (float) voteCount);
            }

            dstm.fireTableDataChanged();
        }

        updatePie(currentPer);
    }

    /**
     * Dataset initialization so that it can display something when the window
     * is first opened
     */
    private void initializePieData() {
        setPieData("ΟΛΕΣ ΟΙ ΠΕΡΙΦΕΡΕΙΕΣ");
    }

    /**
     * Combo box text grab utility
     *
     * @return
     */
    public String getSelectedPeriphery() {
        return (String) jComboBox_Periphery.getSelectedItem();
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
        jComboBox_Periphery = new javax.swing.JComboBox<>();
        jLabel_Periphery = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Εμφάνιση Στατιστικών");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(867, 70));

        jComboBox_Periphery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ΟΛΕΣ ΟΙ ΠΕΡΙΦΕΡΕΙΕΣ", "Α΄ΑΘΗΝΩΝ", "Β΄ ΑΘΗΝΩΝ", "ΝΟΜΟΥ ΑΤΤΙΚΗΣ", "Α΄ ΠΕΙΡΑΙΩΣ", "Β΄ ΠΕΙΡΑΙΩΣ", "ΝΟΜΟΥ ΑΙΤΩΛΟΑΚΑΡΝΑΝΙΑΣ", "ΝΟΜΟΥ ΑΡΓΟΛΙΔΟΣ", "ΝΟΜΟΥ ΑΡΚΑΔΙΑΣ", "ΝΟΜΟΥ ΑΡΤΗΣ", "ΝΟΜΟΥ ΑΧΑΪΑΣ", "ΝΟΜΟΥ ΒΟΙΩΤΙΑΣ", "ΝΟΜΟΥ ΓΡΕΒΕΝΩΝ", "ΝΟΜΟΥ ΔΡΑΜΑΣ", "ΝΟΜΟΥ ΔΩΔΕΚΑΝΗΣΟΥ", "ΝΟΜΟΥ ΕΒΡΟΥ", "ΝΟΜΟΥ ΕΥΒΟΙΑΣ", "ΝΟΜΟΥ ΕΥΡΥΤΑΝΙΑΣ", "ΝΟΜΟΥ ΖΑΚΥΝΘΟΥ", "ΝΟΜΟΥ ΗΛΕΙΑΣ", "ΝΟΜΟΥ ΗΜΑΘΙΑΣ", "ΝΟΜΟΥ ΗΡΑΚΛΕΙΟΥ", "ΝΟΜΟΥ ΘΕΣΠΡΩΤΙΑΣ", "Α΄ ΘΕΣΣΑΛΟΝΙΚΗΣ", "Β΄ ΘΕΣΣΑΛΟΝΙΚΗΣ", "ΝΟΜΟΥ ΙΩΑΝΝΙΝΩΝ", "ΝΟΜΟΥ ΚΑΒΑΛΑΣ", "ΝΟΜΟΥ ΚΑΡΔΙΤΣΗΣ", "ΝΟΜΟΥ ΚΑΣΤΟΡΙΑΣ", "ΝΟΜΟΥ ΚΕΡΚΥΡΑΣ", "ΝΟΜΟΥ ΚΕΦΑΛΛΗΝΙΑΣ", "ΝΟΜΟΥ ΚΙΛΚΙΣ", "ΝΟΜΟΥ ΚΟΖΑΝΗΣ ", "ΝΟΜΟΥ ΚΟΡΙΝΘΙΑΣ ", "ΝΟΜΟΥ ΚΥΚΛΑΔΩΝ ", "ΝΟΜΟΥ ΛΑΚΩΝΙΑΣ", "ΝΟΜΟΥ ΛΑΡΙΣΗΣ ", "ΝΟΜΟΥ ΛΑΣΙΘΙΟΥ ", "ΝΟΜΟΥ ΛΕΣΒΟΥ", "ΝΟΜΟΥ ΛΕΥΚΑΔΟΣ ", "ΝΟΜΟΥ ΜΑΓΝΗΣΙΑΣ ", "ΝΟΜΟΥ  ΜΕΣΣΗΝΙΑΣ", "ΝΟΜΟΥ ΞΑΝΘΗΣ ", "ΝΟΜΟΥ ΠΕΛΛΗΣ", "ΝΟΜΟΥ ΠΙΕΡΙΑΣ", "ΝΟΜΟΥ ΠΡΕΒΕΖΗΣ ", "ΝΟΜΟΥ ΡΕΘΥΜΝΗΣ ", "ΝΟΜΟΥ ΡΟΔΟΠΗΣ", "ΝΟΜΟΥ ΣΑΜΟΥ", "ΝΟΜΟΥ ΣΕΡΡΩΝ ", "ΝΟΜΟΥ ΤΡΙΚΑΛΩΝ", "ΝΟΜΟΥ ΦΘΙΩΤΙΔΟΣ ", "ΝΟΜΟΥ ΦΛΩΡΙΝΗΣ ", "ΝΟΜΟΥ ΦΩΚΙΔΟΣ", "ΝΟΜΟΥ ΧΑΛΚΙΔΙΚΗΣ ", "ΝΟΜΟΥ ΧΑΝΙΩΝ", "ΝΟΜΟΥ ΧΙΟΥ" }));
        jComboBox_Periphery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PeripheryActionPerformed(evt);
            }
        });

        jLabel_Periphery.setText("Εκλογική Περιφέρεια");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel_Periphery)
                .addGap(18, 18, 18)
                .addComponent(jComboBox_Periphery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(426, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Periphery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_Periphery))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);

        jTable1.setModel(dstm);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_PeripheryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PeripheryActionPerformed

        dataset.clear();
        setPieData(getSelectedPeriphery());

    }//GEN-LAST:event_jComboBox_PeripheryActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DBManager.destroy();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DBManager.create();
        tQuery = DBManager.em().createNamedQuery("PoliticalParty.findAll", PoliticalParty.class);
        allParties = tQuery.getResultList();
        initializePieData();
        if (DatasetUtilities.isEmptyOrNull(dataset)) {
            String oPaneMsg1 = "Δεν υπάρχουν καταχωρημένοι ψήφοι.\n"
                    + "Τρέξτε την προσομοίωση και δοκιμάστε ξανά.";
            String oPaneTitle1 = "Σφάλμα!";
            JOptionPane.showMessageDialog(UtilFuncs.getDialogOwnerFrame(), oPaneMsg1, oPaneTitle1, JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }//GEN-LAST:event_formWindowOpened

    public static DefaultPieDataset dataset = new DefaultPieDataset();
    private TypedQuery<PoliticalParty> tQuery;
    private List<PoliticalParty> allParties;
    private final JFreeChart pie;
    private final DisplayStatsTableModel dstm = new DisplayStatsTableModel();
    DecimalFormat percentage = new DecimalFormat("0.00%");

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox_Periphery;
    private javax.swing.JLabel jLabel_Periphery;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
