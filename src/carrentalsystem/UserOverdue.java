/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import javax.swing.ImageIcon;
import java.awt.Image;

public class UserOverdue extends javax.swing.JFrame {

    static User.customer user;

    public UserOverdue(User.customer user) {
        UserOverdue.user = user;
        initComponents();
    
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/logo.jpeg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        TitleImage.setIcon(new ImageIcon(scaledImage));

        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/carrentalsystem/img/backButton.png"));
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        backButton.setIcon(new ImageIcon(scaledImage2));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageSwitch.switchPage(UserOverdue.this, new CustomerDashboard(user));
            }
        }); 

        ImageIcon imageIcon3 = new ImageIcon(getClass().getResource("/carrentalsystem/img/financial_2.png"));
        Image scaledImage3 = imageIcon3.getImage().getScaledInstance(227, 227, Image.SCALE_SMOOTH);
        FinancialButton.setIcon(new ImageIcon(scaledImage3));

        FinancialButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageSwitch.switchPage(UserOverdue.this, new UserPayment(user));
            }
        }); 

        ImageIcon imageIcon4 = new ImageIcon(getClass().getResource("/carrentalsystem/img/overdue_icon.png"));
        Image scaledImage4 = imageIcon4.getImage().getScaledInstance(227, 227, Image.SCALE_SMOOTH);
        OverdueButton.setIcon(new ImageIcon(scaledImage4));

        OverdueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageSwitch.switchPage(UserOverdue.this, new OverduePayment(user));
            }
        }); 
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        FinancialButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        OverdueButton = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TitleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TitleImage = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        BookingMenu = new javax.swing.JMenu();
        rentCarButton = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        PaymentMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        BookingConfirmationMenu = new javax.swing.JMenuItem();
        ViewBookingsMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AccountSettingsMenu = new javax.swing.JMenuItem();
        LogoutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(6, 26, 35));

        FinancialButton.setText("jLabel2");
        FinancialButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Financial");

        OverdueButton.setText("jLabel3");
        OverdueButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Overdue");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(FinancialButton, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(OverdueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(295, 295, 295))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(OverdueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FinancialButton, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        TitleText.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        TitleText.setText("Panda Car System");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 2, 18)); // NOI18N
        jLabel1.setText("Panda Car, World Trustable Car Rental App.");

        TitleImage.setText("");

        backButton.setText("");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(TitleText))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(6, 26, 35));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        BookingMenu.setForeground(new java.awt.Color(255, 255, 255));
        BookingMenu.setText("Services");

        rentCarButton.setBackground(new java.awt.Color(6, 26, 35));
        rentCarButton.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        rentCarButton.setForeground(new java.awt.Color(255, 255, 255));
        rentCarButton.setText("Rent a Car");
        rentCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentCarButtonActionPerformed(evt);
            }
        });
        BookingMenu.add(rentCarButton);

        jMenuBar1.add(BookingMenu);

        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Finance");

        PaymentMenu.setBackground(new java.awt.Color(6, 26, 35));
        PaymentMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        PaymentMenu.setForeground(new java.awt.Color(255, 255, 255));
        PaymentMenu.setText("Payment");
        PaymentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentMenuActionPerformed(evt);
            }
        });
        jMenu1.add(PaymentMenu);

        jMenuBar1.add(jMenu1);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Bookings");

        BookingConfirmationMenu.setBackground(new java.awt.Color(6, 26, 35));
        BookingConfirmationMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BookingConfirmationMenu.setForeground(new java.awt.Color(255, 255, 255));
        BookingConfirmationMenu.setText("Booking Confirmation");
        BookingConfirmationMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingConfirmationMenuActionPerformed(evt);
            }
        });
        jMenu3.add(BookingConfirmationMenu);

        ViewBookingsMenu.setBackground(new java.awt.Color(6, 26, 35));
        ViewBookingsMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ViewBookingsMenu.setForeground(new java.awt.Color(255, 255, 255));
        ViewBookingsMenu.setText("View Bookings");
        ViewBookingsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewBookingsMenuActionPerformed(evt);
            }
        });
        jMenu3.add(ViewBookingsMenu);

        jMenuBar1.add(jMenu3);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Settings");

        AccountSettingsMenu.setBackground(new java.awt.Color(6, 26, 35));
        AccountSettingsMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        AccountSettingsMenu.setForeground(new java.awt.Color(255, 255, 255));
        AccountSettingsMenu.setText("Account Settings");
        AccountSettingsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountSettingsMenuActionPerformed(evt);
            }
        });
        jMenu2.add(AccountSettingsMenu);

        LogoutMenu.setBackground(new java.awt.Color(6, 26, 35));
        LogoutMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        LogoutMenu.setForeground(new java.awt.Color(255, 255, 255));
        LogoutMenu.setText("Logout");
        LogoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuActionPerformed(evt);
            }
        });
        jMenu2.add(LogoutMenu);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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

    private void rentCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentCarButtonActionPerformed
        pageSwitch.switchPage(this, new ChooseCarType(user));
    }//GEN-LAST:event_rentCarButtonActionPerformed

    private void PaymentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMenuActionPerformed
        pageSwitch.switchPage(this, new UserPayment(user));
    }//GEN-LAST:event_PaymentMenuActionPerformed

    private void BookingConfirmationMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingConfirmationMenuActionPerformed
        pageSwitch.switchPage(this, new BookingConfirmation(user));
    }//GEN-LAST:event_BookingConfirmationMenuActionPerformed

    private void ViewBookingsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewBookingsMenuActionPerformed
        pageSwitch.switchPage(this, new CheckBooking(user));
    }//GEN-LAST:event_ViewBookingsMenuActionPerformed

    private void AccountSettingsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountSettingsMenuActionPerformed
        pageSwitch.switchPage(this, new manageOwnAccount(user));
    }//GEN-LAST:event_AccountSettingsMenuActionPerformed

    private void LogoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuActionPerformed
        pageSwitch.switchPage(this, new Login());
    }//GEN-LAST:event_LogoutMenuActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(UserOverdue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(UserOverdue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(UserOverdue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(UserOverdue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UserOverdue().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AccountSettingsMenu;
    private javax.swing.JMenuItem BookingConfirmationMenu;
    private javax.swing.JMenu BookingMenu;
    private javax.swing.JLabel FinancialButton;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JLabel OverdueButton;
    private javax.swing.JMenuItem PaymentMenu;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JLabel TitleText;
    private javax.swing.JMenuItem ViewBookingsMenu;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem rentCarButton;
    // End of variables declaration//GEN-END:variables
}
