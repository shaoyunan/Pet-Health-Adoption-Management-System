/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Employee;

import Business.Animal.Pet.Pet;
import UserInterface.Employee.HomelessReport.ManageHomelessReportJPanel;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.Employee.Adoption.ManageAdoptionListJPanel;
import UserInterface.Employee.Adoption.ManageAdoptionRequestJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shaoy
 */
public class EmployeeWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmployeeWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem business;
    
    public EmployeeWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        lblName.setText("Welcome, "+account.getPerson().getName()+".");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHR = new javax.swing.JButton();
        btnMAL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMA = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        btnLAI = new javax.swing.JButton();

        btnHR.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        btnHR.setText("Manage Homeless Report");
        btnHR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHRActionPerformed(evt);
            }
        });

        btnMAL.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        btnMAL.setText("Manage Adoption Request");
        btnMAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMALActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel1.setText("Employee Work Area");

        btnMA.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        btnMA.setText("Manage Animal");
        btnMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMAActionPerformed(evt);
            }
        });

        lblName.setText("jLabel2");

        btnLAI.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        btnLAI.setText("List Adoption Information");
        btnLAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLAIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 276, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(jLabel1))
                        .addGap(284, 284, 284))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMAL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLAI))
                        .addGap(267, 267, 267))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblName)
                .addGap(117, 117, 117)
                .addComponent(btnMA)
                .addGap(18, 18, 18)
                .addComponent(btnLAI)
                .addGap(18, 18, 18)
                .addComponent(btnMAL)
                .addGap(18, 18, 18)
                .addComponent(btnHR)
                .addContainerGap(249, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHRActionPerformed
        // TODO add your handling code here:
        ManageHomelessReportJPanel manageHomelessReportJPanel = new ManageHomelessReportJPanel(userProcessContainer, business, organization, account);
        userProcessContainer.add("manageHomelessReportJPanel", manageHomelessReportJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnHRActionPerformed

    private void btnMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMAActionPerformed
        // TODO add your handling code here:
        ManageAnimalJPanel manageAnimalJPanel = new ManageAnimalJPanel(userProcessContainer, business, enterprise, organization, account);
        userProcessContainer.add("manageAnimalJPanel", manageAnimalJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMAActionPerformed

    private void btnMALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMALActionPerformed
        // TODO add your handling code here:
        ManageAdoptionRequestJPanel manageAdoptionRequestJPanel = new ManageAdoptionRequestJPanel(userProcessContainer, business, enterprise, organization, account);
        userProcessContainer.add("manageAdoptionRequestJPanel", manageAdoptionRequestJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMALActionPerformed

    private void btnLAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLAIActionPerformed
        // TODO add your handling code here:
        ManageAdoptionListJPanel manageAdoptionListJPanel = new ManageAdoptionListJPanel(userProcessContainer, business, enterprise, organization, account);
        userProcessContainer.add("manageAdoptionListJPanel", manageAdoptionListJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnLAIActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHR;
    private javax.swing.JButton btnLAI;
    private javax.swing.JButton btnMA;
    private javax.swing.JButton btnMAL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables
}
