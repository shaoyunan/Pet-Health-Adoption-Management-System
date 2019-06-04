/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PetOwner.PetHealth;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.PetOwnerUserAccount;
import Business.WorkQueue.PetHealth.PetHealthWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.WorkQueue.WorkRequest.Status;
/**
 *
 * @author shaoy
 */
public class RequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestJPanel
     */
    private EcoSystem business;
    private JPanel userProcessContainer;
    private PetOwnerUserAccount account;
    private Enterprise enterprise;

    public RequestJPanel(JPanel userProcessContainer, EcoSystem business, Enterprise enterprise, PetOwnerUserAccount account) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        popCombo();
        //popTable();
    }

    private void popCombo(){
        cmbStatus.removeAllItems();
        cmbStatus.addItem(Status.Finished);
        cmbStatus.addItem(Status.Pending);
    }
    
    public void popTable(Status status) {
        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);

        for (WorkRequest r : account.getWorkQueue().getWorkRequestList()) {
            if (r instanceof PetHealthWorkRequest && r.getStatus().equals(status.getValue())) {
                PetHealthWorkRequest hr = (PetHealthWorkRequest)r;
                Object row[] = new Object[4];
                row[0] = hr;
                row[1] = hr.getPet();
                row[2] = hr.getReceiver().getPerson();
                row[3] = hr.getStatus();
                
                dtm.addRow(row);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RequestID", "Pet", "Doctor", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRequest);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel1.setText("View Pet Health Evaluation Requests");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreate)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 199, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(171, 171, 171))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnView)
                .addGap(109, 109, 109)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnCreate))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int srow = tblRequest.getSelectedRow();
        if (srow >= 0) {
            PetHealthWorkRequest w = (PetHealthWorkRequest) tblRequest.getValueAt(srow, 0);
            DetailsJPanel detailsJPanel = new DetailsJPanel(userProcessContainer, w);
            userProcessContainer.add("detailsJPanel", detailsJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        CreateRequestJPanel createRequestJPanelJPanel = new CreateRequestJPanel(userProcessContainer, business, enterprise, account);
        userProcessContainer.add("createRequestJPanel", createRequestJPanelJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
        Status status = (Status)cmbStatus.getSelectedItem();
        if(status!=null){
           popTable(status); 
        }
        
    }//GEN-LAST:event_cmbStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables
}
