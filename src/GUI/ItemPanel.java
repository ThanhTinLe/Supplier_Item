/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ItemDAO;
import DAO.SupplierDAO;
import DTO.ItemDTO;
import DTO.SupplierDTO;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ray Khum
 */
public class ItemPanel extends javax.swing.JPanel {

    /**
     * Creates new form ItemPanel
     */
    boolean saveForUpdate = true;

    public ItemPanel() {
        initComponents();
        loadItem();
        loadsuppler();
        enableFalse();
        txtCheckBox.setSelected(true);
    }

    void enableFalse() {
        txtItemCode.setEnabled(false);
        txtItemName.setEnabled(false);
        cbxSupplier.setEnabled(false);
        txtUnit.setEnabled(false);
        txtPrice.setEnabled(false);
        txtCheckBox.setEnabled(false);
    }

    void loadItem() {
        Vector data = new Vector();
        Vector header = ItemDAO.getColumNames();
        Vector<ItemDTO> list = ItemDAO.getItem();
        Vector<SupplierDTO> list2 = SupplierDAO.getSupplier();
        for (ItemDTO itemDTO : list) {
            Vector row = new Vector();
            row.add(itemDTO.getItemCode());
            row.add(itemDTO.getItemName());
            for (SupplierDTO supplierDTO : list2) {
                if (supplierDTO.getCode().equalsIgnoreCase(itemDTO.getSupcode())) {
                    row.add(supplierDTO.getCode() + "-" + supplierDTO.getName());
                }
            }
            row.add(itemDTO.getUnit());
            row.add(itemDTO.getPrice());
            row.add(itemDTO.isSupplying());
            data.add(row);
        }

        //lay model dang chua trong contril table
        DefaultTableModel model = (DefaultTableModel) tblItem.getModel();
        model.setDataVector(data, header);
    }

    static void loadsuppler() {
        Vector<SupplierDTO> supDTO = SupplierDAO.getSupplier();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (SupplierDTO supplierDTO : supDTO) {
            model.addElement(supplierDTO.getCode() + "-" + supplierDTO.getName());
        }
        cbxSupplier.setModel(model);
    }

    boolean checkCode() {
        Vector<ItemDTO> check = ItemDAO.getItem();
        for (int i = 0; i < check.size(); i++) {
            if (check.get(i).getItemCode().equals(txtItemCode.getText())) {
                return true;
            }
        }
        return false;
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
        tblItem = new javax.swing.JTable();
        jlable1 = new javax.swing.JLabel();
        jlabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtItemCode = new javax.swing.JTextField();
        txtItemName = new javax.swing.JTextField();
        cbxSupplier = new javax.swing.JComboBox<>();
        txtUnit = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtCheckBox = new javax.swing.JCheckBox();
        btnAddNew = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Supplier", "Unit", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItem);

        jlable1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlable1.setText("Item Code");

        jlabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jlabel2.setText("Item Name");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("Supplier");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setText("Unit");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel5.setText("Price");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel6.setText("Supplying");

        txtUnit.setToolTipText("");

        btnAddNew.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnAddNew.setText("Add New");
        btnAddNew.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewActionPerformed(evt);
            }
        });

        BtnSave.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        BtnSave.setText("Save");
        BtnSave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtItemCode)
                            .addComponent(txtItemName)
                            .addComponent(cbxSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUnit)
                            .addComponent(txtPrice)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCheckBox)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtItemCode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jlable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtItemName, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jlabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUnit, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemMouseClicked
        // TODO add your handling code here:
        int pos = tblItem.getSelectedRow();
        if (pos >= 0) {
            txtItemCode.setText((String) tblItem.getValueAt(pos, 0));
            txtItemName.setText((String) tblItem.getValueAt(pos, 1));
            cbxSupplier.setSelectedItem(tblItem.getValueAt(pos, 2));
            txtUnit.setText((String) tblItem.getValueAt(pos, 3));
            String s = String.valueOf(tblItem.getValueAt(pos, 4));
            txtPrice.setText(s);
            Vector<ItemDTO> list1 = ItemDAO.getItem();
            for (int i = 0; i < list1.size(); i++) {
                if (pos == i) {
                    boolean b = list1.get(i).isSupplying();
                    if (b != false) {
                        txtCheckBox.setSelected(true);
                    } else {
                        txtCheckBox.setSelected(false);
                    }
                }
            }
            saveForUpdate = true;
            txtItemCode.setEnabled(false);
            txtItemName.setEnabled(true);
            cbxSupplier.setEnabled(true);
            txtUnit.setEnabled(true);
            txtPrice.setEnabled(true);
            txtCheckBox.setEnabled(true);
            BtnSave.setEnabled(true);
        }
    }//GEN-LAST:event_tblItemMouseClicked

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        // TODO add your handling code here:
        String code = txtItemCode.getText();
        String name = txtItemName.getText();
        String unit = txtUnit.getText();
        float price = -1;

        boolean Supplying;
        if (txtCheckBox.isSelected()) {
            Supplying = true;
        } else {
            Supplying = false;
        }
        String supCode = null;
        int index = cbxSupplier.getSelectedIndex();
        Vector<SupplierDTO> sup = SupplierDAO.getSupplier();
        for (int i = 0; i < sup.size(); i++) {
            if (index == i) {
                supCode = sup.get(i).getCode();
            }
        }

        try {
            if (saveForUpdate != true) {
                if (txtItemCode.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "code is empty");
                } else if (!txtItemCode.getText().matches("I[0-9][0-9]")) {
                    JOptionPane.showMessageDialog(null, "code is not correct format is Ixx with x is a digi");
                } else if (checkCode() != false) {
                    JOptionPane.showMessageDialog(null, "code is exist");
                } else if (txtItemName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "name is empty");
                } else if (txtItemName.getText().length() > 50) {
                    JOptionPane.showMessageDialog(null, "name is less than 50 character");
                } else if (txtUnit.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Unit is empty");
                } else if (txtUnit.getText().length() > 50) {
                    JOptionPane.showMessageDialog(null, "Unit is less than 50 character");
                } else if (txtPrice.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "price is empty");
                } else {
                    try {
                        price = Float.parseFloat(txtPrice.getText());
                        if (price > 0) {
                            if (ItemDAO.saveItem(code, name, unit, price, Supplying, supCode) != 0) {
                                JOptionPane.showMessageDialog(null, "Added");
                                loadItem();
                                txtItemCode.setEnabled(true);
                                saveForUpdate = false;
                                txtItemCode.setText("");
                                txtItemName.setText("");
                                cbxSupplier.setSelectedIndex(0);
                                txtUnit.setText("");
                                txtPrice.setText("");
                                txtCheckBox.setSelected(false);
                                tblItem.clearSelection();
                                txtItemCode.setEnabled(true);
                                txtItemCode.requestFocus();
                                tblItem.setEnabled(true);
                                enableFalse();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "price > 0");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "price only digi");
                    }

                }
            } else {// save for update
                if (txtItemName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "name is empty");
                } else if (txtUnit.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Unit is empty");
                } else if (txtPrice.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "price is empty");
                } else {
                    try {
                        price = Float.parseFloat(txtPrice.getText());
                        if (price > 0) {
                            if (ItemDAO.updateItem(code, name, unit, price, Supplying, supCode) != 0) {
                                JOptionPane.showMessageDialog(null, "Updated");
                                loadItem();
                                txtItemCode.setEnabled(true);
                                saveForUpdate = true;
                                txtItemCode.setText("");
                                txtItemName.setText("");
                                cbxSupplier.setSelectedIndex(0);
                                txtUnit.setText("");
                                txtPrice.setText("");
                                txtCheckBox.setSelected(false);
                                tblItem.clearSelection();
                                txtItemCode.setEnabled(true);
                                enableFalse();
                                requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "price > 0");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "price only number");
                    }

                }
            }

        } catch (Exception e) {
            if (e.getMessage().contains("Cannot insert duplicate key")) {
                JOptionPane.showMessageDialog(null, "code bi trung");
                txtItemCode.setText("");
            }
        }

    }//GEN-LAST:event_BtnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        int pos = tblItem.getSelectedRow();
        if (pos >= 0 && pos < tblItem.getRowCount()) {
            if (JOptionPane.showConfirmDialog(null, "do you want to delete this") == 0) {
                ItemDAO.deleteItem((String) tblItem.getValueAt(pos, 0));
                JOptionPane.showMessageDialog(null, "Deleted");
                tblItem.setEnabled(true);
                saveForUpdate = false;
                loadItem();
                enableFalse();
            }
            txtItemCode.setText("");
            txtItemName.setText("");
            txtUnit.setText("");
            txtPrice.setText("");
            cbxSupplier.setSelectedIndex(0);
            tblItem.clearSelection();
            tblItem.setEnabled(true);
            txtCheckBox.setSelected(false);
            txtItemCode.setEnabled(false);
            saveForUpdate = false;
            enableFalse();
            tblItem.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Select a item you want to delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewActionPerformed
        // TODO add your handling code here:
        if (saveForUpdate != true || (txtItemCode.getText().isEmpty() && txtItemName.getText().isEmpty() && txtUnit.getText().isEmpty() && txtPrice.getText().isEmpty())) {
            saveForUpdate = false;
            txtItemCode.setText("");
            txtItemName.setText("");
            cbxSupplier.setSelectedIndex(0);
            txtUnit.setText("");
            txtPrice.setText("");
            txtCheckBox.setSelected(false);
            tblItem.clearSelection();
            txtItemCode.setEnabled(true);
            txtItemCode.requestFocus();
            txtItemCode.setEnabled(true);
            txtItemName.setEnabled(true);
            cbxSupplier.setEnabled(true);
            txtUnit.setEnabled(true);
            txtPrice.setEnabled(true);
            txtCheckBox.setEnabled(true);
            txtCheckBox.setSelected(true);
            txtItemCode.requestFocus();
        } else {
            if (JOptionPane.showConfirmDialog(null, "you want to save this") == 0) {
                BtnSaveActionPerformed(null);
                saveForUpdate = false;
                txtItemCode.setText("");
                txtItemName.setText("");
                cbxSupplier.setSelectedIndex(0);
                txtUnit.setText("");
                txtPrice.setText("");
                txtCheckBox.setSelected(false);
                tblItem.clearSelection();
                txtItemCode.setEnabled(true);
                txtItemCode.requestFocus();
                txtItemCode.setEnabled(true);
                txtItemName.setEnabled(true);
                cbxSupplier.setEnabled(true);
                txtUnit.setEnabled(true);
                txtPrice.setEnabled(true);
                txtCheckBox.setEnabled(true);
                txtCheckBox.setSelected(true);
                txtItemCode.requestFocus();
            } else {
                saveForUpdate = false;
                txtItemCode.setText("");
                txtItemName.setText("");
                cbxSupplier.setSelectedIndex(0);
                txtUnit.setText("");
                txtPrice.setText("");
                txtCheckBox.setSelected(false);
                tblItem.clearSelection();
                txtItemCode.setEnabled(true);
                txtItemCode.setEnabled(true);
                txtItemName.setEnabled(true);
                cbxSupplier.setEnabled(true);
                txtUnit.setEnabled(true);
                txtPrice.setEnabled(true);
                txtCheckBox.setEnabled(true);
                BtnSave.setEnabled(true);
                txtCheckBox.setSelected(true);
                txtItemCode.requestFocus();
            }
        }
    }//GEN-LAST:event_btnAddNewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnSave;
    private javax.swing.JButton btnAddNew;
    private javax.swing.JButton btnDelete;
    public static javax.swing.JComboBox<String> cbxSupplier;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlable1;
    public static javax.swing.JTable tblItem;
    private javax.swing.JCheckBox txtCheckBox;
    private javax.swing.JTextField txtItemCode;
    private javax.swing.JTextField txtItemName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtUnit;
    // End of variables declaration//GEN-END:variables
}
