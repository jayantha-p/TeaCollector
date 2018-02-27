/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeaCollector;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jpaControls.FertilizerRecordJpaController;
import jpaControls.SupplierJpaController;

import entity.FertilizerRecord;
import entity.Supplier;
import java.awt.event.MouseListener;

/**
 *
 * @author jayantha
 */
public class FertilizerUI extends javax.swing.JFrame {

    Connection conn = LoginUI.conn;
    ResultSet RS = null;
    FertilizerRecordJpaController fertilizerJpaController = new FertilizerRecordJpaController(Persistence.createEntityManagerFactory("TeaCollectorPU"));
    SupplierJpaController supplierJpaController = new SupplierJpaController(Persistence.createEntityManagerFactory("TeaCollectorPU"));

    public FertilizerUI() {
        initComponents();
        //date_date.setDate(Date.valueOf(LoginUI.date));
        loadTodayData_tblFertilizer();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_todayRecord = new javax.swing.JTable();
        btn_addTab1 = new javax.swing.JButton();
        btn_updateTab1 = new javax.swing.JButton();
        btn_deleteTab1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_supID = new javax.swing.JTextField();
        lbl_name = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        txt_NoOfMnt = new javax.swing.JTextField();
        date_date1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_fertilizerRecord = new javax.swing.JTable();
        txt_name = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_deleteTab2 = new javax.swing.JButton();
        btn_updateTab2 = new javax.swing.JButton();
        btn_addTab2 = new javax.swing.JButton();
        btn_serchAllTab2 = new javax.swing.JButton();
        date_date = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel6.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Fertilizer");

        tbl_todayRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier No", "Supplier Name", "Amount", "Date", "No of Month", "id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_todayRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_todayRecordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_todayRecord);

        btn_addTab1.setText("Add");
        btn_addTab1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTab1ActionPerformed(evt);
            }
        });

        btn_updateTab1.setText("Update");
        btn_updateTab1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_updateTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateTab1ActionPerformed(evt);
            }
        });

        btn_deleteTab1.setText("Delete");
        btn_deleteTab1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_deleteTab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteTab1ActionPerformed(evt);
            }
        });

        jLabel5.setText(" No Of Month :");

        jLabel4.setText("Date : ");

        jLabel3.setText("Amount : ");

        jLabel2.setText("Supplier Name : ");

        jLabel1.setText("Supplier No : ");

        txt_supID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_supIDFocusLost(evt);
            }
        });

        lbl_name.setText("- - -");

        date_date1.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_deleteTab1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_updateTab1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_addTab1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_NoOfMnt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_amount)
                            .addComponent(date_date1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5))
                    .addGap(27, 27, 27)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_name)
                        .addComponent(txt_supID, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(731, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(txt_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(date_date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_NoOfMnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_updateTab1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_deleteTab1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_addTab1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_supID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lbl_name))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel3)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel4)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addContainerGap(324, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Record   ", jPanel2);

        tbl_fertilizerRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Name", "Price (50KG)", "Valid From"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_fertilizerRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_fertilizerRecordMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_fertilizerRecord);

        jLabel9.setText("Valid from :");

        jLabel8.setText("Price :");

        jLabel7.setText("Name : ");

        btn_deleteTab2.setText("Delete");

        btn_updateTab2.setText("Update");

        btn_addTab2.setText("Add");
        btn_addTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTab2ActionPerformed(evt);
            }
        });

        btn_serchAllTab2.setText("Search All");
        btn_serchAllTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_serchAllTab2ActionPerformed(evt);
            }
        });

        date_date.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txt_price)
                            .addComponent(date_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_deleteTab2)
                        .addGap(36, 36, 36)
                        .addComponent(btn_updateTab2)
                        .addGap(34, 34, 34)
                        .addComponent(btn_addTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_serchAllTab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(date_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_deleteTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_updateTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btn_serchAllTab2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Details   ", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 925, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(28, 28, 28)
                .addComponent(jTabbedPane1)
                .addContainerGap())
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

    private void loadTodayData_tblFertilizer() {

        List<entity.FertilizerRecord> fertilizerEntities = fertilizerJpaController.findFertilizerRecordEntities();

        DefaultTableModel model = (DefaultTableModel) tbl_todayRecord.getModel();
        model.setRowCount(0);   //referesh jTable data
        Object[] row = new Object[6];

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < fertilizerEntities.size(); i++) {

            row[0] = fertilizerEntities.get(i).getSupplierId().getId();
            row[1] = fertilizerEntities.get(i).getSupplierId().getName();
            row[2] = fertilizerEntities.get(i).getAmount();
            row[3] = simpleDateFormat.format(fertilizerEntities.get(i).getDate());
            row[4] = fertilizerEntities.get(i).getNoOfMonth();
            row[5] = fertilizerEntities.get(i).getId();

            model.addRow(row);

        }
    }


    private void btn_addTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTab2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addTab2ActionPerformed

    private void btn_serchAllTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_serchAllTab2ActionPerformed

        List<entity.FertilizerRecord> fertilizerEntities = fertilizerJpaController.findFertilizerRecordEntities();

        DefaultTableModel model = (DefaultTableModel) tbl_fertilizerRecord.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < fertilizerEntities.size(); i++) {

            row[0] = fertilizerEntities.get(i).getId();
            row[1] = fertilizerEntities.get(i).getSupplierId();
            row[2] = fertilizerEntities.get(i).getAmount();
            row[3] = fertilizerEntities.get(i).getDate();

            model.addRow(row);

        }
    }//GEN-LAST:event_btn_serchAllTab2ActionPerformed

    private void txt_supIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_supIDFocusLost
        try {
            lbl_name.setText(supplierJpaController.findSupplier(Integer.parseInt(txt_supID.getText())).getName());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "enter valid ID --> " + e);
            lbl_name.setText("");
            txt_supID.setText("");
            txt_supID.grabFocus();
        }


    }//GEN-LAST:event_txt_supIDFocusLost

    private void btn_addTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTab1ActionPerformed

        if (txt_supID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Supplier ID");
            txt_supID.grabFocus();
        } else if (txt_amount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Amount of Fertilizer bags(50KG)..");
            txt_amount.grabFocus();
//        } else if (date_date.getDate().equals("")) {
//            JOptionPane.showMessageDialog(null, "Enter Date");
//            date_date1.grabFocus();
        } else if (txt_NoOfMnt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter Number Of Month..");
            txt_NoOfMnt.grabFocus();
        } else {

            FertilizerRecord fertilizer = new FertilizerRecord();
            fertilizer.setSupplierId(supplierJpaController.findSupplier(Integer.parseInt(txt_supID.getText())));
            fertilizer.setAmount(Integer.parseInt(txt_amount.getText()));
            fertilizer.setDate(date_date1.getDate());
            fertilizer.setNoOfMonth(Integer.parseInt(txt_NoOfMnt.getText()));

            fertilizerJpaController.create(fertilizer);
            JOptionPane.showMessageDialog(this, "Record Saved..");

            loadTodayData_tblFertilizer();
            txt_supID.setText("");
            lbl_name.setText("");
            txt_amount.setText("");
            txt_NoOfMnt.setText("");
        }

    }//GEN-LAST:event_btn_addTab1ActionPerformed

    private void btn_updateTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateTab1ActionPerformed
        if(fertilizerId!=0){
            FertilizerRecord fertilizer = fertilizerJpaController.findFertilizerRecord(fertilizerId);
            fertilizer.setSupplierId(supplierJpaController.findSupplier(Integer.parseInt(txt_supID.getText())));
            fertilizer.setAmount(Integer.parseInt(txt_amount.getText()));
            fertilizer.setDate(date_date1.getDate());
            fertilizer.setNoOfMonth(Integer.parseInt(txt_NoOfMnt.getText()));
            
            try {
                fertilizerJpaController.edit(fertilizer);
                fertilizerId = 0;
                txt_supID.setText("");
                txt_amount.setText("");
                date_date1.setDate(null);
                txt_NoOfMnt.setText("");
                lbl_name.setText("");
                JOptionPane.showMessageDialog(null, "Updated..");
                loadTodayData_tblFertilizer();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }            
        }else{
            JOptionPane.showMessageDialog(null, "fertilizer ID = 0");
        }
    }//GEN-LAST:event_btn_updateTab1ActionPerformed

    private void btn_deleteTab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteTab1ActionPerformed
        if(fertilizerId!=0){
            try {
                fertilizerJpaController.destroy(fertilizerId);
                fertilizerId = 0;
                txt_supID.setText("");
                txt_amount.setText("");
                date_date1.setDate(null);
                txt_NoOfMnt.setText("");
                lbl_name.setText("");
                JOptionPane.showMessageDialog(null, "Deleted..");
                loadTodayData_tblFertilizer();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }else{
            JOptionPane.showMessageDialog(null, "fertilizer ID = 0");
        }
    }//GEN-LAST:event_btn_deleteTab1ActionPerformed

    private void tbl_todayRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_todayRecordMouseClicked

        int i = tbl_todayRecord.getSelectedRow();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        TableModel model = tbl_todayRecord.getModel();

        txt_supID.setText(model.getValueAt(i, 0).toString());
        lbl_name.setText(model.getValueAt(i, 1).toString());
        txt_amount.setText(model.getValueAt(i, 2).toString());
        date_date1.setDate(Date.valueOf(simpleDateFormat.format(Date.valueOf(model.getValueAt(i, 3).toString()))));
        txt_NoOfMnt.setText(model.getValueAt(i, 4).toString());
        fertilizerId = (int) model.getValueAt(i, 5);

    }//GEN-LAST:event_tbl_todayRecordMouseClicked

    private void tbl_fertilizerRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_fertilizerRecordMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_fertilizerRecordMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FertilizerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FertilizerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FertilizerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FertilizerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FertilizerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addTab1;
    private javax.swing.JButton btn_addTab2;
    private javax.swing.JButton btn_deleteTab1;
    private javax.swing.JButton btn_deleteTab2;
    private javax.swing.JButton btn_serchAllTab2;
    private javax.swing.JButton btn_updateTab1;
    private javax.swing.JButton btn_updateTab2;
    private com.toedter.calendar.JDateChooser date_date;
    private com.toedter.calendar.JDateChooser date_date1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JTable tbl_fertilizerRecord;
    private javax.swing.JTable tbl_todayRecord;
    private javax.swing.JTextField txt_NoOfMnt;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_supID;
    // End of variables declaration//GEN-END:variables
    private int fertilizerId = 0;

 

}
