/**
 * Student Database Management System (Password Recovery Form)
 * Date : 09.09.19
 * Last Modified: 19.09.19
 */
package Database;

import static Encryption.AESEncryption.decrypt;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Random;
import javax.mail.MessagingException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Fahim
 */
public class recoverPassword extends javax.swing.JFrame {

    /**
     * Creates new form recoverPassword
     */
    
    String user, phoneNumber, emailAddress, verificationNumber;
    private final String secretKey = "I have now secret.";
    private boolean showMessage = false, errorPhone = false, errorEmail = false;
    public recoverPassword(String user) {
        initComponents();
        this.user = user;
        
    }
    private String adminUser = "";
    public recoverPassword(String user, String adminUser) {
        this.user = user;
        this.adminUser = adminUser;
        initComponents();
    }
    
    public static int getRandomNumber(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
       
    public recoverPassword() {
        initComponents();
    }
    
    private void initForm(String user){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse?serverTimezone=EST5EDT", "root", "");
                String sql = "SELECT * FROM `user_info` WHERE `User_name` = '"+user+"'";
                PreparedStatement p = conn.prepareStatement(sql);
                ResultSet rs = p.executeQuery();
                if(rs.next()){
                    phoneNumber = decrypt(rs.getString("Phone"), secretKey) ;
                    emailAddress = decrypt(rs.getString("Email"), secretKey) ;
                }
        }catch(Exception ex){ JOptionPane.showMessageDialog(this,ex); } 
        verificationNumber = String.valueOf(getRandomNumber(10000000, 99999999));
        try {
            JavaMail.sendMail(emailAddress, user, verificationNumber);
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(this,"Please Check your Internet connection.");
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

        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        cancel = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        verify = new javax.swing.JTextField();
        phoneError = new javax.swing.JLabel();
        emailError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Verity yourself");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Verify It's you");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Phone:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Email:");

        email.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        email.setForeground(new java.awt.Color(204, 204, 204));
        email.setText("Enter Email address");
        email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFocusLost(evt);
            }
        });

        phone.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        phone.setForeground(new java.awt.Color(204, 204, 204));
        phone.setText("Enter Phome number");
        phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneFocusLost(evt);
            }
        });
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneKeyPressed(evt);
            }
        });

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

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Verification code:");

        verify.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        verify.setForeground(new java.awt.Color(204, 204, 204));
        verify.setText("Enter verification code");
        verify.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                verifyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                verifyFocusLost(evt);
            }
        });

        phoneError.setForeground(new java.awt.Color(255, 0, 0));
        phoneError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        emailError.setForeground(new java.awt.Color(255, 0, 0));
        emailError.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(email)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(verify)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailError, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verify, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusGained
        // TODO add your handling code here:
        if(email.getText().trim().equals("Enter Email address")){
            email.setText("");
            email.setForeground(Color.black);
            email.setFont(new java.awt.Font("Tahoma", 1, 14));
        }                
    }//GEN-LAST:event_emailFocusGained
    void emailFocusLost(){
        if(email.getText().trim().equals("")){
            email.setText("Enter Email address");
            email.setForeground(new Color(204,204,204));
            email.setFont(new java.awt.Font("Tahoma", 3, 14));
        }
    }
    private void emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFocusLost
        // TODO add your handling code here:
        emailFocusLost();
        if(!(email.getText().trim().equals("")) && !(email.getText().trim().equals("Enter Email address"))){
            if (!(email.getText().contains("@gmail.com")) && !(email.getText().contains("@yahoo.com")) && !(email.getText().contains("@outlook.com"))) {
                
                emailError.setText("Invalid Email.");
                errorEmail = true;
            }
            else { emailError.setText(" "); errorEmail = false; }
        }
        else { emailError.setText(" "); errorEmail = false; }
    }//GEN-LAST:event_emailFocusLost

    private void phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneFocusGained
        // TODO add your handling code here:
        if(phone.getText().trim().equals("Enter Phome number")){
            phone.setText("");
            phone.setForeground(Color.black);
            phone.setFont(new java.awt.Font("Tahoma", 1, 14));
        }
        if(!showMessage){
            JOptionPane.showMessageDialog(this, user +  " A email has been send to your email address with \n"
                + "a verification code.\nPlease enter the code here.","Information", JOptionPane.INFORMATION_MESSAGE);
            showMessage = true;
            initForm(user);
        }
    }//GEN-LAST:event_phoneFocusGained
    void phoneFocusLost(){
        if(phone.getText().trim().equals("")){
            phone.setText("Enter Phome number");
            phone.setForeground(new Color(204,204,204));
            phone.setFont(new java.awt.Font("Tahoma", 3, 14));
        }
    }
    private void phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneFocusLost
        // TODO add your handling code here:
        phoneFocusLost();
        if(!(phone.getText().trim().equals("Enter Phome number")) && !(phone.getText().trim().equals(""))){
            if (!(phone.getText().contains("017")) && !(phone.getText().contains("019")) && !(phone.getText().contains("018")) && !(phone.getText().contains("016")) && !(phone.getText().contains("015")) && !(phone.getText().contains("014")) && !(phone.getText().contains("013"))){
                phoneError.setText("Invalid phone number.");
                errorPhone = true;
            }
            else if(phone.getText().length() != 11 ){ phoneError.setText("Invalid phone number."); errorPhone = true; }
            else { phoneError.setText(" "); errorPhone = false;}
        }
    }//GEN-LAST:event_phoneFocusLost
    
    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:  
        if(adminUser.equals("yes")){
            new homepage(user, adminUser).setVisible(true);
            dispose();
        }
        else{
            new Login_2().setVisible(true);
            dispose();
        }        
    }//GEN-LAST:event_cancelActionPerformed
    
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:        
        if(phone.getText().equals("Enter Phome number") || email.getText().equals("Enter Email address")){
            JOptionPane.showMessageDialog(this,"You haven't filled all the fields.", "Failure", JOptionPane.ERROR_MESSAGE);
        }
        else{            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (this, "Are you sure you want to submit?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                if(phone.getText().trim().equals(phoneNumber) && email.getText().trim().equals(emailAddress) && verify.getText().trim().equals(verificationNumber)){
                    if(adminUser.equals("yes")){
                        JOptionPane.showMessageDialog(this, "Now you may enter.","Verification Successful.", JOptionPane.INFORMATION_MESSAGE);
                        new UserHomepage(user, adminUser).setVisible(true);
                        dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "You can change your password now.","Verification Successful.", JOptionPane.INFORMATION_MESSAGE);
                        new updatePassword(user).setVisible(true);
                        dispose();
                    }                    
                }
                else{ JOptionPane.showMessageDialog(this,"Your answer doesn't match.", "Verification Unsuccessful", JOptionPane.ERROR_MESSAGE); }                            
            }
        }
        
    }//GEN-LAST:event_submitActionPerformed

    private void verifyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_verifyFocusGained
        // TODO add your handling code here:
        if(verify.getText().trim().equals("Enter verification code")){
            verify.setText("");
            verify.setForeground(Color.black);
            verify.setFont(new java.awt.Font("Tahoma", 1, 14));
        }
    }//GEN-LAST:event_verifyFocusGained
    private void email1FocusLost(){
        if(verify.getText().trim().equals("")){
            verify.setText("Enter verification code");
            verify.setForeground(new Color(204,204,204));
            verify.setFont(new java.awt.Font("Tahoma", 3, 14));
        }
    }
    private void verifyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_verifyFocusLost
        // TODO add your handling code here:
        email1FocusLost();
    }//GEN-LAST:event_verifyFocusLost

    private void phoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            if(phone.getText().length() < 13) {   phoneError.setText(""); errorPhone = false; return;  }
        }
        if(!(phone.getText().equals(""))){  
            if(phone.getText().length() > 10) { phoneError.setText("Max limit over."); errorPhone = true; }  
            else { 
                try{     
                    long i = Integer.parseInt(phone.getText());
                    phoneError.setText("");
                    errorPhone = false;
                }catch(Exception e){ phoneError.setText("Invalid phone number."); errorPhone = true; }           
            }
        }
        
    }//GEN-LAST:event_phoneKeyPressed

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
            java.util.logging.Logger.getLogger(recoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recoverPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recoverPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField email;
    private javax.swing.JLabel emailError;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel phoneError;
    private javax.swing.JButton submit;
    private javax.swing.JTextField verify;
    // End of variables declaration//GEN-END:variables
}