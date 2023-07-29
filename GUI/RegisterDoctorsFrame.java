/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sanjeevaniapp.gui;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.swing.JOptionPane;
import sanjeevaniapp.dao.DoctorsDAO;
import sanjeevaniapp.dao.EmpDAO;
import sanjeevaniapp.dao.UserDAO;
import sanjeevaniapp.pojo.DoctorPojo;
import sanjeevaniapp.pojo.User;
import sanjeevaniapp.pojo.UserPojo;
import sanjeevaniapp.utility.PasswordEncryption;

/**
 *
 * @author pc
 */
public class RegisterDoctorsFrame extends javax.swing.JFrame {
 
  private Map<String,String>unRegDocList;
   private String logId,selEmpId,selEmpName;
   private String pwd1,pwd2;
   private String contactNo,emailId,qualification,specialist;
    public RegisterDoctorsFrame() {
        initComponents();
         super.setLocationRelativeTo(null);
       
        unRegDocList=new HashMap<>();
        loadDoctorDetails();
        genNewDocId();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlabelimageholder = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogout1 = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPwd1 = new javax.swing.JPasswordField();
        txtPwd2 = new javax.swing.JPasswordField();
        jcGender = new javax.swing.JComboBox<>();
        txtLoginId = new javax.swing.JTextField();
        txtDoctorName = new javax.swing.JTextField();
        jcEmployeeId = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDoctorId = new javax.swing.JTextField();
        txtContactNo = new javax.swing.JTextField();
        txtQualification = new javax.swing.JTextField();
        txtSpecialist = new javax.swing.JTextField();
        txtEmailId = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Sanjeevani Application");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 460, -1));

        jlabelimageholder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sanjeevaniapp/icons/HomePageBG1.jpg"))); // NOI18N
        jlabelimageholder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jlabelimageholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 390));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sanjeevaniapp/icons/images (2).jpg"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 400, 230, -1));

        btnLogout1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogout1.setForeground(new java.awt.Color(0, 153, 153));
        btnLogout1.setText("Logout");
        btnLogout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogout1ActionPerformed(evt);
            }
        });
        jPanel5.add(btnLogout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 660, 100, -1));

        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(0, 153, 153));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 630, 170, -1));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 153, 153));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel5.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 660, 110, -1));

        jPanel2.setBackground(new java.awt.Color(240, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Employee ID");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Doctor Name");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Login ID");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Password");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Retype Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Gender");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));
        jPanel2.add(txtPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 100, -1));
        jPanel2.add(txtPwd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 100, -1));

        jcGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        jPanel2.add(jcGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 100, -1));
        jPanel2.add(txtLoginId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 100, -1));
        jPanel2.add(txtDoctorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 100, -1));

        jcEmployeeId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcEmployeeIdActionPerformed(evt);
            }
        });
        jPanel2.add(jcEmployeeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 100, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Doctor Id");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Contact no.");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Qualification");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, 14));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Specialist");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Email ID");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        txtDoctorId.setEditable(false);
        jPanel2.add(txtDoctorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 100, -1));
        jPanel2.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 100, -1));
        jPanel2.add(txtQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 100, -1));
        jPanel2.add(txtSpecialist, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 100, -1));
        jPanel2.add(txtEmailId, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 100, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Add Doctors Details");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, -1));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 680, 280));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogout1ActionPerformed
        ManageDoctorsFrame fr = new ManageDoctorsFrame();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogout1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ManageDoctorsFrame fr = new ManageDoctorsFrame();
        fr.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
     if(validateInputs()==false){
         JOptionPane.showMessageDialog(null, "Please input all the fields");
         return;
     }
     String passwordValid=matchPassword();
     if(passwordValid!=null){
         JOptionPane.showMessageDialog(null, passwordValid);
         return;
     }
     if(isContactNoValid()==false){
         JOptionPane.showMessageDialog(null, "Invalid mobile no");
         return;
     }
     try{
         DoctorPojo doc=new DoctorPojo();
         doc.setDoctorId(txtDoctorId.getText());
         doc.setDoctorName(selEmpName);
         doc.setEmailId(emailId);
         doc.setGender(jcGender.getSelectedItem().toString());
         doc.setContactNo(contactNo);
         doc.setQualification(qualification);
         doc.setSpecialist(specialist);
         UserPojo user=new UserPojo();
         user.setLoginId(logId);
         String encPassword=new String(PasswordEncryption.getEncryptedPassword(pwd1));
         user.setPassword(encPassword);
         user.setUserName(selEmpName);
         user.setUserType("DOCTOR");
         boolean result1=DoctorsDAO.addDoctor(doc);
         boolean result2=UserDAO.addUser(user);
         if(result1==true && result2==true){
             JOptionPane.showMessageDialog(null, "Doctor successfully registered!");
             clearAll();
             return;
         }
        JOptionPane.showMessageDialog(null, "Registration unsuccessful!"); 
        return; 
                 
     }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in DB:"+ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

   /* private void jcEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEmployeeIdActionPerformed
       if(jcEmployeeId.getSelectedIndex()==-1)
        return;
    selEmpId=jcEmployeeId.getSelectedItem().toString();
    selEmpName=unRegDocList.get(selEmpId);
    txtDoctorName.setText(selEmpName);
        
    }//GEN-LAST:event_btnRegisterActionPerformed
*/
    private void jcEmployeeIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcEmployeeIdActionPerformed
                  
if(jcEmployeeId.getSelectedIndex()==-1)
        return;
    selEmpId=jcEmployeeId.getSelectedItem().toString();
    selEmpName=unRegDocList.get(selEmpId);
    txtDoctorName.setText(selEmpName);

    }//GEN-LAST:event_jcEmployeeIdActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterDoctorsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterDoctorsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterDoctorsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterDoctorsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterDoctorsFrame().setVisible(true);
            }
        });
    }
 private void loadDoctorDetails() {
        try{
            unRegDocList=EmpDAO.getUnRegisteredDoctors();
            Set <String> empIdSet=unRegDocList.keySet();
            for(String empId:empIdSet){
                jcEmployeeId.addItem(empId);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in DB:"+ex);
            ex.printStackTrace();
        }
    }

    private void genNewDocId() {
        try{
            String docId=DoctorsDAO.getNewDocId();
            txtDoctorId.setText(docId);
            }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error in DB:"+ex);
            ex.printStackTrace();
        }
    }
 
  private boolean validateInputs(){
      this.logId=this.txtLoginId.getText().trim();
      char[] p1=this.txtPwd1.getPassword();
      char[] p2=this.txtPwd2.getPassword();
      this.contactNo=txtContactNo.getText().trim();
      this.qualification=txtQualification.getText().trim();
      this.emailId=txtEmailId.getText().trim();
      this.specialist=txtSpecialist.getText().trim();
      if(logId.isEmpty()||p1.length==0||p2.length==0||contactNo.isEmpty()||qualification.isEmpty()||emailId.isEmpty()||specialist.isEmpty())
          return false;
      pwd1=new String(p1);
      pwd2=new String(p2);
      return true;
      
  }
  private String matchPassword(){
     pwd1=pwd1.trim();
     pwd2=pwd2.trim();
     if(pwd1.length()<3 || pwd2.length()<3)
         return "Passwords must be of atleast 3 characters in length";
     if(pwd1.equals(pwd2)==false)
         return "Passwords do not match";
     return null;
  }
  private boolean isContactNoValid(){
      char[]mob=contactNo.toCharArray();
      for(char ch:mob){
          if(Character.isDigit(ch)==false)
              return false;
      }
      if(contactNo.length()==10)
            return true;
      return false;
  }
  private void clearAll(){
      txtLoginId.setText("");
      this.txtContactNo.setText("");
      this.txtDoctorId.setText("");
      this.txtEmailId.setText("");
      this.txtPwd1.setText("");
      this.txtPwd2.setText("");
      this.txtQualification.setText("");
      this.txtSpecialist.setText("");
      this.unRegDocList.remove(selEmpId);
      this.jcEmployeeId.removeItem(selEmpId);
      if(unRegDocList.size()==0){
          JOptionPane.showMessageDialog(null,"All doctors registered!");
          ManageDoctorsFrame manageDoc=new ManageDoctorsFrame();
          manageDoc.setVisible(true);
          this.dispose();
      }
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnLogout1;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> jcEmployeeId;
    private javax.swing.JComboBox<String> jcGender;
    private javax.swing.JLabel jlabelimageholder;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtDoctorId;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtEmailId;
    private javax.swing.JTextField txtLoginId;
    private javax.swing.JPasswordField txtPwd1;
    private javax.swing.JPasswordField txtPwd2;
    private javax.swing.JTextField txtQualification;
    private javax.swing.JTextField txtSpecialist;
    // End of variables declaration//GEN-END:variables
}