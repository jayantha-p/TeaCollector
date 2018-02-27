/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeaCollector;




import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author jayantha
 */
public class MainPage extends javax.swing.JFrame {

    /**
     * Creates new form mainPage
     */
    public MainPage() {
        initComponents();
        
        lbl_userName.setText(LoginUI.login_user);
        lbl_date.setText(LoginUI.date);
        
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                java.util.Date d = new java.util.Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                lbl_time.setText(s.format(d));
            }
        }).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_teaPkt = new javax.swing.JButton();
        btn_ferti = new javax.swing.JButton();
        btn_advns = new javax.swing.JButton();
        btn_supp = new javax.swing.JButton();
        btn_setting = new javax.swing.JButton();
        btn_dailyRcod = new javax.swing.JButton();
        lbl_userName = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();
        btn_supp1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(950, 650));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jLabel1.setText("User Login As : ");

        btn_teaPkt.setText("Tea Packet");
        btn_teaPkt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_teaPkt.setMaximumSize(new java.awt.Dimension(115, 25));
        btn_teaPkt.setMinimumSize(new java.awt.Dimension(115, 25));
        btn_teaPkt.setPreferredSize(new java.awt.Dimension(115, 25));
        btn_teaPkt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_teaPktMouseClicked(evt);
            }
        });

        btn_ferti.setText("Fertilizer");
        btn_ferti.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ferti.setMaximumSize(new java.awt.Dimension(115, 25));
        btn_ferti.setMinimumSize(new java.awt.Dimension(115, 25));
        btn_ferti.setPreferredSize(new java.awt.Dimension(115, 25));
        btn_ferti.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_fertiMouseClicked(evt);
            }
        });

        btn_advns.setText("Advance");
        btn_advns.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_advns.setMaximumSize(new java.awt.Dimension(115, 25));
        btn_advns.setMinimumSize(new java.awt.Dimension(115, 25));
        btn_advns.setPreferredSize(new java.awt.Dimension(115, 25));
        btn_advns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_advnsMouseClicked(evt);
            }
        });

        btn_supp.setText("Sallary sheet");
        btn_supp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_supp.setMaximumSize(new java.awt.Dimension(115, 25));
        btn_supp.setMinimumSize(new java.awt.Dimension(115, 25));
        btn_supp.setPreferredSize(new java.awt.Dimension(115, 25));

        btn_setting.setText("Settings");
        btn_setting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_setting.setMaximumSize(new java.awt.Dimension(115, 25));
        btn_setting.setMinimumSize(new java.awt.Dimension(115, 25));
        btn_setting.setPreferredSize(new java.awt.Dimension(115, 25));

        btn_dailyRcod.setText("Add Daily Recode");
        btn_dailyRcod.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dailyRcod.setMaximumSize(new java.awt.Dimension(115, 25));
        btn_dailyRcod.setMinimumSize(new java.awt.Dimension(115, 25));
        btn_dailyRcod.setPreferredSize(new java.awt.Dimension(115, 25));
        btn_dailyRcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dailyRcodActionPerformed(evt);
            }
        });

        lbl_userName.setText("user Name");

        lbl_date.setText("0000-00-00");

        lbl_time.setText("00:00");

        btn_supp1.setText("Supplier");
        btn_supp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_supp1.setMaximumSize(new java.awt.Dimension(115, 25));
        btn_supp1.setMinimumSize(new java.awt.Dimension(115, 25));
        btn_supp1.setPreferredSize(new java.awt.Dimension(115, 25));
        btn_supp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_supp1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_setting, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(btn_advns, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(btn_teaPkt, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                            .addComponent(btn_supp1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(216, 216, 216)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_dailyRcod, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(btn_ferti, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(btn_supp, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_userName))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_date)
                                .addGap(36, 36, 36)
                                .addComponent(lbl_time)))))
                .addContainerGap(374, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_userName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_date)
                    .addComponent(lbl_time))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_dailyRcod, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_supp1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_ferti, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(btn_teaPkt, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_advns, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btn_setting, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
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

    private void btn_dailyRcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dailyRcodActionPerformed
        DailyRecords adr = new DailyRecords();
        adr.setIconImage(this.getIconImage());
        adr.setVisible(true);
    }//GEN-LAST:event_btn_dailyRcodActionPerformed

    private void btn_teaPktMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_teaPktMouseClicked
        Tea_packet tp = new Tea_packet();
        tp.setIconImage(this.getIconImage());
        tp.setVisible(true);
    }//GEN-LAST:event_btn_teaPktMouseClicked

    private void btn_fertiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_fertiMouseClicked
        FertilizerUI ferti = new FertilizerUI();
        ferti.setIconImage(this.getIconImage());
        ferti.setVisible(true);
    }//GEN-LAST:event_btn_fertiMouseClicked

    private void btn_advnsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_advnsMouseClicked
        AdvanceUI adv = new AdvanceUI();
        adv.setIconImage(this.getIconImage());
        adv.setVisible(true);
    }//GEN-LAST:event_btn_advnsMouseClicked

    private void btn_supp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_supp1MouseClicked
        Supplier sup = new Supplier();
        sup.setIconImage(this.getIconImage());
        sup.setVisible(true);
    }//GEN-LAST:event_btn_supp1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_advns;
    private javax.swing.JButton btn_dailyRcod;
    private javax.swing.JButton btn_ferti;
    private javax.swing.JButton btn_setting;
    private javax.swing.JButton btn_supp;
    private javax.swing.JButton btn_supp1;
    private javax.swing.JButton btn_teaPkt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JLabel lbl_userName;
    // End of variables declaration//GEN-END:variables

}
