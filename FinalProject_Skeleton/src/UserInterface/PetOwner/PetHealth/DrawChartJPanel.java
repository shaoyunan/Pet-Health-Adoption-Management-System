/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PetOwner.PetHealth;

import Business.Animal.Pet.Pet;
import Business.Organization.Organization;
import Business.Organization.PetOwnerOrganization;
import Business.UserAccount.PetOwnerUserAccount;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author shaoy
 */
public class DrawChartJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DrawChartJPanel
     */
    private JPanel userProcessContainer;
    private PetOwnerOrganization org;
    private PetOwnerUserAccount account;
    
    public DrawChartJPanel(JPanel userProcessContainer, Organization organization, PetOwnerUserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.org = (PetOwnerOrganization)organization;
        this.account = account;
        fillCombo();
    }

    private void fillCombo(){
        cmbPet.removeAllItems();
        for(Pet pet : account.getPetDirectory().getPetList()){
            cmbPet.addItem(pet);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        drawjPanel = new javax.swing.JPanel();
        cmbPet = new javax.swing.JComboBox();
        btnPulse = new javax.swing.JButton();

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout drawjPanelLayout = new javax.swing.GroupLayout(drawjPanel);
        drawjPanel.setLayout(drawjPanelLayout);
        drawjPanelLayout.setHorizontalGroup(
            drawjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        drawjPanelLayout.setVerticalGroup(
            drawjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        cmbPet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnPulse.setText("Pulse");
        btnPulse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPulseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbPet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 567, Short.MAX_VALUE)
                        .addComponent(btnPulse)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPulse))
                .addGap(19, 19, 19)
                .addComponent(drawjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPulseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPulseActionPerformed
        // TODO add your handling code here:
        Pet pet = (Pet)cmbPet.getSelectedItem();
        try {
            XYSeriesCollection dataset = new XYSeriesCollection();
            XYSeries series = new XYSeries(pet.getName());
            for(int i=1; i<13;i++){
                series.add(i, pet.getPetHealthInfo().getAvgByMonth(i));
            }
            dataset.addSeries(series);
            JFreeChart chart = ChartFactory.createXYLineChart("Avg Pulse by Month", "Month", "Avg Pulse", dataset, PlotOrientation.VERTICAL,true, false, false);
            XYPlot plot = (XYPlot) chart.getPlot();
            //plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {2}"));
            //plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}={1}({2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance()));
            ChartPanel cpanel = new ChartPanel(chart);
            drawjPanel.removeAll();
            drawjPanel.setLayout(new BorderLayout());
            drawjPanel.add(cpanel, BorderLayout.CENTER);
            drawjPanel.validate();
            drawjPanel.repaint();
        } catch (Exception e) {
            throw e;
        }
    }//GEN-LAST:event_btnPulseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPulse;
    private javax.swing.JComboBox cmbPet;
    private javax.swing.JPanel drawjPanel;
    // End of variables declaration//GEN-END:variables
}
