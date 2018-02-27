
package TeaCollector;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.text.SimpleDateFormat;


public class LoginUI extends javax.swing.JFrame {
    
    static Connection conn = null;
    ResultSet RS = null;
    PreparedStatement PST = null;
    
    public LoginUI() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icon.png"))); 
        conn = MysqlCon.ConnectDB();
        showDate();
        showTime();
    }
    
    void showDate(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        lbl_date.setText(s.format(d));
        date = s.format(d);
    }
    public void showTime(){
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

        main_jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_UserName = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        btn_Login = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_Reset = new javax.swing.JButton();
        btn_ForgotPw = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_CreateAcc = new javax.swing.JButton();
        lbl_date = new javax.swing.JLabel();
        lbl_time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Janaka Tea Collector");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setName("mainFrame"); // NOI18N

        main_jPanel.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Wel Come");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("User Name : ");

        jLabel4.setText("Password : ");

        btn_Login.setText("Login");
        btn_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Login.setMaximumSize(new java.awt.Dimension(60, 25));
        btn_Login.setMinimumSize(new java.awt.Dimension(60, 25));
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("please enter valid entries for both fields");

        btn_Reset.setText("Reset");
        btn_Reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_UserName, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(txt_Password)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btn_ForgotPw.setText("click here");
        btn_ForgotPw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setText("Forgotten account?");

        jLabel7.setText("create Account");

        btn_CreateAcc.setText("click here");
        btn_CreateAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CreateAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CreateAccMouseClicked(evt);
            }
        });

        lbl_date.setText("0000-00-00");

        lbl_time.setText("00:00");

        javax.swing.GroupLayout main_jPanelLayout = new javax.swing.GroupLayout(main_jPanel);
        main_jPanel.setLayout(main_jPanelLayout);
        main_jPanelLayout.setHorizontalGroup(
            main_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_jPanelLayout.createSequentialGroup()
                .addGroup(main_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(main_jPanelLayout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(main_jPanelLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(main_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(main_jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(btn_ForgotPw))
                            .addGroup(main_jPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(btn_CreateAcc))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(main_jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_date, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_time)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        main_jPanelLayout.setVerticalGroup(
            main_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(main_jPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(main_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btn_ForgotPw))
                .addGap(18, 18, 18)
                .addGroup(main_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btn_CreateAcc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(main_jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_date)
                    .addComponent(lbl_time))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        try{
            String sql="select * from login where username=? and password=?";
            PST=conn.prepareStatement(sql);
            PST.setString(1, txt_UserName.getText());
            PST.setString(2, txt_Password.getText());
            RS=PST.executeQuery();
            
            if(RS.next()){
                //JOptionPane.showMessageDialog(null, "Username And Password are correct");
                System.out.println("Username And Password are correct");
                login_user=txt_UserName.getText();
                this.dispose();
                MainPage mp = new MainPage();
                mp.setIconImage(this.getIconImage());                
                mp.setVisible(true);
                
            }else{
                JOptionPane.showMessageDialog(null, "Username And Password are not valid");
                txt_Password.setText("");
                txt_UserName.setText("");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void btn_CreateAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CreateAccMouseClicked
        
        Registation reg = new Registation();
        reg.setVisible(true);
        reg.setIconImage(this.getIconImage());
        reg.setTitle(this.getTitle());
    }//GEN-LAST:event_btn_CreateAccMouseClicked

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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
        
        //ImageIcon img = new ImageIcon("Images/1.ico");
        //mainf.setIconImage(img.getImage());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CreateAcc;
    private javax.swing.JButton btn_ForgotPw;
    private javax.swing.JButton btn_Login;
    private javax.swing.JButton btn_Reset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_time;
    private javax.swing.JPanel main_jPanel;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_UserName;
    // End of variables declaration//GEN-END:variables
    public static String login_user;
    public static String date;

}
