/**
 * Student Database Management System (update password)
 * Date : 09.09.19
 */
package Database;

import static Encryption.AESEncryption.hashPassword;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Fahim
 */
public class updatePassword extends javax.swing.JFrame {

    /**
     * Creates new form updatePassword
     */
    String user;
    public updatePassword(String user) {
        initComponents();
        this.user = user;
    }
    
    public updatePassword() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        newPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        confirmPassword = new javax.swing.JPasswordField();
        showPassword1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create new password");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Create your new password");

        cancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Database/Icon_image/icons8-cancel-31.png"))); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Database/Icon_image/icons8-submit-progress-33.png"))); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText(" Create Password:");

        newPassword.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        newPassword.setForeground(new java.awt.Color(204, 204, 204));
        newPassword.setText("New password");
        newPassword.setEchoChar((char) 0);
        newPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                newPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                newPasswordFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Confirm password:");

        confirmPassword.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        confirmPassword.setForeground(new java.awt.Color(204, 204, 204));
        confirmPassword.setText("Confirm password");
        confirmPassword.setEchoChar((char) 0);
        confirmPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                confirmPasswordFocusLost(evt);
            }
        });

        showPassword1.setText("Show password");
        showPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassword1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(showPassword1)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showPassword1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        new Login_2().setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        if(newPassword.getPassword().equals("New password") || confirmPassword.getPassword().equals("Confirm password")){
            JOptionPane.showMessageDialog(this,"You haven't entered any password.", "Failure", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (this, "Are you sure you want to update your password?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");                
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse?serverTimezone=EST5EDT", "root", "");
                    
                    String query = "UPDATE `user_info` SET `Password`='"+hashPassword(String.valueOf(newPassword.getPassword()))+"' WHERE `User_name` = '"+user+"'";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(this,"Operation Successful.");
                    cancel.doClick();
                }catch(Exception ex){ JOptionPane.showMessageDialog(this,ex); }
            }
        }

    }//GEN-LAST:event_submitActionPerformed

    private void newPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordFocusGained
        // TODO add your handling code here:
        if(String.valueOf(newPassword.getPassword()).trim().equals("New password")) {
            newPassword.setText("");
            newPassword.setForeground(Color.black);
            newPassword.setEchoChar('\u25cf');
            newPassword.setFont(new java.awt.Font("Tahoma", 1, 14));
        }
    }//GEN-LAST:event_newPasswordFocusGained
    void newPasswordFocusLost(){
        if(String.valueOf(newPassword.getPassword()).trim().equals("")) {
            newPassword.setText("New password");
            newPassword.setForeground(new Color(204,204,204));
            newPassword.setEchoChar((char) 0);
            newPassword.setFont(new java.awt.Font("Tahoma", 3, 14));
        }
    }
    private void newPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_newPasswordFocusLost
        // TODO add your handling code here:
        newPasswordFocusLost();
    }//GEN-LAST:event_newPasswordFocusLost

    private void confirmPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPasswordFocusGained
        // TODO add your handling code here:
        if(String.valueOf(confirmPassword.getPassword()).trim().equals("Confirm password")) {
            confirmPassword.setText("");
            confirmPassword.setForeground(Color.black);
            confirmPassword.setEchoChar('\u25cf');
            confirmPassword.setFont(new java.awt.Font("Tahoma", 1, 14));
        }
    }//GEN-LAST:event_confirmPasswordFocusGained
    void confirmPasswordFocusLost(){
        if(String.valueOf(confirmPassword.getPassword()).trim().equals("")) {
            confirmPassword.setText("Confirm password");
            confirmPassword.setForeground(new Color(204,204,204));
            confirmPassword.setEchoChar((char) 0);
            confirmPassword.setFont(new java.awt.Font("Tahoma", 3, 14));
        }
    }
    private void confirmPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmPasswordFocusLost
        // TODO add your handling code here:
        confirmPasswordFocusLost();
    }//GEN-LAST:event_confirmPasswordFocusLost

    private void showPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassword1ActionPerformed
        // TODO add your handling code here:
        if(!(String.valueOf(newPassword.getPassword()).equals("New password")) && !(String.valueOf(confirmPassword.getPassword()).equals("Confirm password"))){
            if(showPassword1.isSelected()){
                newPassword.setEchoChar((char) 0);
                confirmPassword.setEchoChar((char) 0);
                newPassword.setFont(new java.awt.Font("Tahoma", 1, 14));
                confirmPassword.setFont(new java.awt.Font("Tahoma", 1, 14));
            }
            else{
                newPassword.setForeground(Color.black);
                confirmPassword.setForeground(Color.black);
                newPassword.setEchoChar('\u25cf');
                confirmPassword.setEchoChar('\u25cf');
                newPassword.setFont(new java.awt.Font("Tahoma", 1, 14));
                confirmPassword.setFont(new java.awt.Font("Tahoma", 1, 14));
            }
        }
    }//GEN-LAST:event_showPassword1ActionPerformed

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
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updatePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updatePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updatePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updatePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updatePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JCheckBox showPassword1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
