/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import java.awt.Image;
import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.util.List;

public class ReturnCar extends javax.swing.JFrame {

    static User.customer user;
    private final JPanel bookingContainer;
    int bookingId;

    public ReturnCar(User.customer user) {
        ReturnCar.user = user;
        initComponents();
        setResizable(false); 

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/logo.jpeg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        TitleImage.setIcon(new ImageIcon(scaledImage));

        List<Return> returnList = DatabaseManager.getReturnDetails(user.getEmail());

        bookingContainer = new JPanel();
        bookingContainer.setLayout(new BoxLayout(bookingContainer, BoxLayout.Y_AXIS));

        // Create and add BookingPanel for each booking
        for (Return r : returnList) {
            BookingPanel bookingPanel = new BookingPanel(r, this);
            bookingContainer.add(bookingPanel);
        }

        ScrollPanel.setViewportView(bookingContainer);
        ScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
    }

    public void displayReturnDetails(Return returnobj) {
        bookingId = returnobj.getBookingId();
        System.out.println("Booking ID: " + bookingId);
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
        TitleImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ScrollPanel = new javax.swing.JScrollPane();
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

        TitleImage.setText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Return Car");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(ReturnCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnCar(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AccountSettingsMenu;
    private javax.swing.JMenuItem BookingConfirmationMenu;
    private javax.swing.JMenu BookingMenu;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JMenuItem PaymentMenu;
    private javax.swing.JScrollPane ScrollPanel;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JMenuItem ViewBookingsMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem rentCarButton;
    // End of variables declaration//GEN-END:variables
}
