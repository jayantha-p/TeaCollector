package TeaCollector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.DailyRecord;
import entity.Supplier;
import java.util.List;
import javax.persistence.Persistence;
import jpaControls.DailyRecordJpaController;
import jpaControls.SupplierJpaController;

public class DailyRecords extends javax.swing.JFrame {

    Connection conn = LoginUI.conn;
    ResultSet RS = null;
    PreparedStatement PST = null;
    String time;

    DailyRecordJpaController dailyRecordJpaController = new DailyRecordJpaController(Persistence.createEntityManagerFactory("TeaCollectorPU"));
    SupplierJpaController supplierJpaController = new SupplierJpaController(Persistence.createEntityManagerFactory("TeaCollectorPU"));

    public DailyRecords() {
        initComponents();
        txt_date.setText(LoginUI.date);
        showRecordInTableOne();

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                java.util.Date d = new java.util.Date();
                SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
                time = s.format(d);
            }
        }).start();
    }

    public void showRecordInTableOne() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<DailyRecord> list = dailyRecordJpaController.findDailyRecordEntities();

        DefaultTableModel model = (DefaultTableModel) tbl_showRecord.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getRecordID();
            row[1] = list.get(i).getSupplierID().getId();
            row[2] = list.get(i).getSupplierID().getName();
            row[3] = simpleDateFormat.format(list.get(i).getDate());
            row[4] = list.get(i).getTotalAmount();
            row[5] = list.get(i).getCutAmount();
            row[6] = list.get(i).getFinalAmount();

            model.addRow(row);

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_showRecord = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        txt_final = new javax.swing.JTextField();
        txt_cut = new javax.swing.JTextField();
        txt_tot = new javax.swing.JTextField();
        txt_date = new javax.swing.JTextField();
        lbl_supName = new javax.swing.JLabel();
        txt_supID = new javax.swing.JTextField();
        lbl_recordID = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_serchRecord = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_tot_tab2 = new javax.swing.JTextField();
        txt_cut_tab2 = new javax.swing.JTextField();
        txt_final_tab2 = new javax.swing.JTextField();
        btn_update_tab2 = new javax.swing.JButton();
        btn_delete_tab2 = new javax.swing.JButton();
        btn_Search = new javax.swing.JButton();
        date_4 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 650));

        jLabel6.setFont(new java.awt.Font("Andalus", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Daily Record");

        tbl_showRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Record No", "Sup. ID", "Sup. Name", "Date", "Total Amount", "Cut", "Final Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_showRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_showRecordMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_showRecord);

        jLabel14.setText("Supplier ID");

        jLabel15.setText("Supplier Name");

        jLabel16.setText("Date");

        jLabel17.setText("Total Amount");

        jLabel18.setText("Cut");

        jLabel19.setText("Final Amount");

        btn_delete.setText("Delete");
        btn_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deleteMouseClicked(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        txt_cut.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cutFocusLost(evt);
            }
        });

        lbl_supName.setText("- - -");

        txt_supID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_supIDFocusLost(evt);
            }
        });

        lbl_recordID.setText("0");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("This Table show only to day record");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(454, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(112, 112, 112))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel16)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18)
                                .addComponent(jLabel19)
                                .addComponent(jLabel15))
                            .addGap(42, 42, 42)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_final, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cut, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_supID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_supName)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(lbl_recordID)))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addContainerGap(486, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(txt_supID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(lbl_supName))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(txt_date, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txt_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(txt_cut, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19)
                                .addComponent(txt_final, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(64, 64, 64)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(53, 53, 53)
                            .addComponent(lbl_recordID)))
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Record Deatails", jPanel2);

        jLabel1.setText("Suppiler ID :");

        jLabel2.setText("Date :");

        jLabel3.setText("Date Range - Day 01 : ");

        jLabel4.setText("Day 02 : ");

        tbl_serchRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier ID", "Supplier Name", "Date", "Total (KG)", "Cut (KG)", "Final (KG)", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_serchRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_serchRecordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_serchRecord);
        if (tbl_serchRecord.getColumnModel().getColumnCount() > 0) {
            tbl_serchRecord.getColumnModel().getColumn(6).setPreferredWidth(2);
        }

        jLabel5.setText("Date : ");

        jLabel8.setText("Total (KG) : ");

        jLabel9.setText("Cut (KG) : ");

        jLabel10.setText("Final (KG) : ");

        btn_update_tab2.setText("Update");
        btn_update_tab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update_tab2ActionPerformed(evt);
            }
        });

        btn_delete_tab2.setText("Delete");
        btn_delete_tab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete_tab2ActionPerformed(evt);
            }
        });

        btn_Search.setText("Search");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        date_4.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(178, 178, 178)
                                .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(date_4, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_tot_tab2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cut_tab2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_final_tab2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(btn_update_tab2)
                                .addGap(38, 38, 38)
                                .addComponent(btn_delete_tab2)))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4)))
                    .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txt_tot_tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(txt_cut_tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txt_final_tab2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_update_tab2)
                        .addComponent(btn_delete_tab2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(2, 2, 2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Record", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(297, 297, 297))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_showRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_showRecordMouseClicked
        // Display selected row in text field
        int i = tbl_showRecord.getSelectedRow();
        TableModel model = tbl_showRecord.getModel();
        lbl_recordID.setText(model.getValueAt(i, 0).toString());

        txt_supID.setText(model.getValueAt(i, 1).toString());
        lbl_supName.setText(model.getValueAt(i, 2).toString());
        txt_date.setText(model.getValueAt(i, 3).toString());
        txt_tot.setText(model.getValueAt(i, 4).toString());
        txt_cut.setText(model.getValueAt(i, 5).toString());
        txt_final.setText(model.getValueAt(i, 6).toString());
    }//GEN-LAST:event_tbl_showRecordMouseClicked

    private void btn_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deleteMouseClicked
        try {
            dailyRecordJpaController.destroy(Integer.parseInt(lbl_recordID.getText()));

            showRecordInTableOne();

            JOptionPane.showMessageDialog(null, "Deleted !");
            lbl_supName.setText("- - -");
            txt_supID.setText("");
            txt_tot.setText("");
            txt_cut.setText("");
            txt_final.setText("");
            lbl_recordID.setText("");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_deleteMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed

        try {           
            DailyRecord dailyRecord = dailyRecordJpaController.findDailyRecord(Integer.parseInt(lbl_recordID.getText()));
            
            dailyRecord.setSupplierID(supplierJpaController.findSupplier(Integer.parseInt(txt_supID.getText())));
            dailyRecord.setDate(Date.valueOf(txt_date.getText()));
            dailyRecord.setTotalAmount(Integer.parseInt(txt_tot.getText()));
            dailyRecord.setCutAmount(Integer.parseInt(txt_cut.getText()));
            dailyRecord.setFinalAmount(Integer.parseInt(txt_final.getText()));

            dailyRecordJpaController.edit(dailyRecord);

            showRecordInTableOne();

            JOptionPane.showMessageDialog(null, "Updated !");
            lbl_supName.setText("- - -");
            txt_supID.setText("");
            txt_tot.setText("");
            txt_cut.setText("");
            txt_final.setText("");            
            lbl_recordID.setText("");


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "cant Updated !");
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed

        try {

            DailyRecord dailyRecord = new DailyRecord();
            dailyRecord.setSupplierID(supplierJpaController.findSupplier(Integer.parseInt(txt_supID.getText())));
            dailyRecord.setDate(Date.valueOf(txt_date.getText()));
            dailyRecord.setTotalAmount(Integer.parseInt(txt_tot.getText()));
            dailyRecord.setCutAmount(Integer.parseInt(txt_cut.getText()));
            dailyRecord.setFinalAmount(Integer.parseInt(txt_final.getText()));

            dailyRecordJpaController.create(dailyRecord);

            lbl_supName.setText("- - -");
            txt_supID.setText("");
            txt_tot.setText("");
            txt_cut.setText("");
            txt_final.setText("");

            showRecordInTableOne();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_cutFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cutFocusLost

        int tot = Integer.parseInt(txt_tot.getText());
        int cut = Integer.parseInt(txt_cut.getText());
        txt_final.setText(Integer.toString(tot - cut));
    }//GEN-LAST:event_txt_cutFocusLost

    private void txt_supIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_supIDFocusLost
        if (!txt_supID.getText().equals("")) {

            int id = Integer.parseInt(txt_supID.getText());

            try {
                Supplier findSupplier = supplierJpaController.findSupplier(id);
                
                lbl_supName.setText(findSupplier.getName());
                
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Enter valid Supplier ID");
                lbl_supName.setText("");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_txt_supIDFocusLost

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed

        List<DailyRecord> findDailyRecordEntities = dailyRecordJpaController.findDailyRecordEntities();

        System.out.println(findDailyRecordEntities);
        DefaultTableModel model = (DefaultTableModel) tbl_serchRecord.getModel();
        model.setRowCount(0);   //referesh jTable data
        Object[] row = new Object[8];

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < findDailyRecordEntities.size(); i++) {

            row[0] = findDailyRecordEntities.get(i).getSupplierID().getId();
            row[1] = findDailyRecordEntities.get(i).getSupplierID().getName();
            row[2] = simpleDateFormat.format(findDailyRecordEntities.get(i).getDate());
            row[3] = findDailyRecordEntities.get(i).getTotalAmount();
            row[4] = findDailyRecordEntities.get(i).getCutAmount();
            row[5] = findDailyRecordEntities.get(i).getFinalAmount();
            
            row[6] = findDailyRecordEntities.get(i).getRecordID(); // no disply.. use for update and delete

            model.addRow(row);

        }


    }//GEN-LAST:event_btn_SearchActionPerformed

    private void tbl_serchRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_serchRecordMouseClicked
        // Display selected row in text field
        
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int i = tbl_serchRecord.getSelectedRow();
        TableModel model = tbl_serchRecord.getModel();
        
        date_4.setDate(Date.valueOf(simpleDateFormat.format(Date.valueOf(model.getValueAt(i, 2).toString()))));
        txt_tot_tab2.setText(model.getValueAt(i, 3).toString());
        txt_cut_tab2.setText(model.getValueAt(i, 4).toString());
        txt_final_tab2.setText(model.getValueAt(i, 5).toString());
        
        serchTableRecordId = Integer.parseInt(model.getValueAt(i, 7).toString()) ;

    }//GEN-LAST:event_tbl_serchRecordMouseClicked

    private void btn_delete_tab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete_tab2ActionPerformed
        if (serchTableRecordId!=0){
            try {
                dailyRecordJpaController.destroy(serchTableRecordId);
                JOptionPane.showMessageDialog(null, "Record Delete!");
                btn_SearchActionPerformed(null);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "canot delete error "+ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "SOmthing error.. Record id = 0");
        }
    }//GEN-LAST:event_btn_delete_tab2ActionPerformed

    private void btn_update_tab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update_tab2ActionPerformed
        if (serchTableRecordId!=0){
            try {
                DailyRecord dailyRecord = dailyRecordJpaController.findDailyRecord(serchTableRecordId);
                System.out.println(dailyRecord);
                dailyRecord.setDate(date_4.getDate());
                dailyRecord.setTotalAmount(Integer.parseInt(txt_tot_tab2.getText()));
                dailyRecord.setCutAmount(Integer.parseInt(txt_cut_tab2.getText()));
                dailyRecord.setFinalAmount(Integer.parseInt(txt_final_tab2.getText()));
                
                dailyRecordJpaController.edit(dailyRecord);  
                JOptionPane.showMessageDialog(null, "Record Update!");
                btn_SearchActionPerformed(null);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "can't Update error "+ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Somthing error.. Record id = 0");
        }
    }//GEN-LAST:event_btn_update_tab2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DailyRecords().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_delete_tab2;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_update_tab2;
    private com.toedter.calendar.JDateChooser date_4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_recordID;
    private javax.swing.JLabel lbl_supName;
    private javax.swing.JTable tbl_serchRecord;
    private javax.swing.JTable tbl_showRecord;
    private javax.swing.JTextField txt_cut;
    private javax.swing.JTextField txt_cut_tab2;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_final;
    private javax.swing.JTextField txt_final_tab2;
    private javax.swing.JTextField txt_supID;
    private javax.swing.JTextField txt_tot;
    private javax.swing.JTextField txt_tot_tab2;
    // End of variables declaration//GEN-END:variables
    private int serchTableRecordId = 0;
}
