/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PetOwner.Adoption;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.PetOwnerUserAccount;
import Business.UserAccount.UserAccount;
import Business.Utilities;
import Business.WorkQueue.Adoption.AdoptionRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shaoy
 */
public class ViewAdoptionRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewAdoptionRequestJPanel
     */
    private EcoSystem business;
    private JPanel userProcessContainer;
    private PetOwnerUserAccount account;
    private Enterprise enterprise;

    public ViewAdoptionRequestJPanel(JPanel userProcessContainer, EcoSystem business, Enterprise enterprise, PetOwnerUserAccount account) {
        initComponents();
        this.business = business;
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        popCombo();
    }

    public void popTable(String result) {
        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);
        if (result.equals("Incoming")) {
            for (AdoptionRequest ar : account.getAdoptionRequestQueue().getAdoptionRequestList()) {
                if (ar.getReceiver() == account) {
                    Object row[] = new Object[5];
                    row[0] = ar;
                    row[1] = ar.getPet();
                    row[2] = Utilities.dateToString(ar.getRequestDate());
                    row[3] = ar.getStatus();
                    row[4] = ar.getSender();
                    dtm.addRow(row);
                }
            }
        } else {
            for (AdoptionRequest ar : account.getAdoptionRequestQueue().getAdoptionRequestList()) {
                if (ar.getSender() == account) {
                    Object row[] = new Object[5];
                    row[0] = ar;
                    row[1] = ar.getPet();
                    row[2] = Utilities.dateToString(ar.getRequestDate());
                    row[3] = ar.getStatus();
                    row[4] = ar.getReceiver();
                    dtm.addRow(row);
                }
            }
        }
    }

    public void popCombo() {
        cmbDir.removeAllItems();
        cmbDir.addItem("Incoming");
        cmbDir.addItem("Out");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        cmbDir = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResponse = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Animal", "Date", "Status", "Sender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRequest);

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel1.setText("View Adoption Requests");

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        cmbDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDirActionPerformed(evt);
            }
        });

        txtResponse.setEditable(false);
        txtResponse.setColumns(20);
        txtResponse.setRows(5);
        jScrollPane2.setViewportView(txtResponse);

        jLabel2.setText("Response");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(jLabel1))
                            .addComponent(cmbDir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 261, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(cmbDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(btnView))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDirActionPerformed
        // TODO add your handling code here:
        String result = (String) cmbDir.getSelectedItem();
       if(result!=null) popTable(result);
    }//GEN-LAST:event_cmbDirActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int srow = tblRequest.getSelectedRow();
        String result = (String) cmbDir.getSelectedItem();
        if (srow >= 0) {
            AdoptionRequest ar = (AdoptionRequest) tblRequest.getValueAt(srow, 0);
            if (result.equals("Incoming")) {
                ProcessAdoptionRequestJPanel processAdoptionRequestJPanel = new ProcessAdoptionRequestJPanel(userProcessContainer, ar, account);
                if (!ar.getStatus().equals(WorkRequest.Status.Pending.getValue())) {
                    processAdoptionRequestJPanel.disableInput();
                }
                userProcessContainer.add("processAdoptionRequestJPanel", processAdoptionRequestJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            } else {
                txtResponse.setText(ar.getRespond());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!");
        }
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<String> cmbDir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTextArea txtResponse;
    // End of variables declaration//GEN-END:variables
}