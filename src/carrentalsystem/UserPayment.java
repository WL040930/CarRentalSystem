/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import java.time.LocalDate;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserPayment extends javax.swing.JFrame {

    static User.customer user;
    String selection = "Paid"; 
    int bookingid = -1; 
    int row; 
    private final JPanel bookingContainer;

    public UserPayment(User.customer user) {
        UserPayment.user = user;
        initComponents();
        setResizable(false);
        Paid.setSelected(true);

        List<Booking> bookings = DatabaseManager.getSpecificBookingsForUser(selection, user.getEmail()); 
    
        bookingContainer = new JPanel();
        bookingContainer.setLayout(new BoxLayout(bookingContainer, BoxLayout.Y_AXIS));

        for (Booking booking : bookings) {
            BookingPanel bookingPanel = new BookingPanel(booking, this);
            bookingContainer.add(bookingPanel);
        }

        ScrollPanel.setViewportView(bookingContainer);
        ScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    

        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/carrentalsystem/img/backButton.png"));
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        backButton.setIcon(new ImageIcon(scaledImage2));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageSwitch.switchPage(UserPayment.this, new CustomerDashboard(user));
            }
        }); 

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/logo.jpeg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        TitleImage.setIcon(new ImageIcon(scaledImage));
    }

    public void displayBookingDetails(Booking booking) {
        bookingid = booking.getBookingId();
        row = dataIO.rowNumber(bookingid, 1, dataIO.BOOKING_FILE, 9); 
        String carId = dataIO.readData(row + 1, dataIO.BOOKING_FILE); 
        int rowInCar = dataIO.rowNumber(carId, 1, dataIO.CAR_FILE, 7);

        String carName = dataIO.readData(rowInCar + 1, dataIO.CAR_FILE);
        String price = dataIO.readData(rowInCar + 3, dataIO.CAR_FILE);
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();

        BookedCarField.setText(carName);
        PerDayPriceField.setText("RM " + price);
        StartDateFIeld.setText(startDate.toString());
        EndDateField.setText(endDate.toString());

        int priceInt = Integer.parseInt(price);
        int days = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        int total = priceInt * days;
        TotalPaymentField.setText("RM " + Integer.toString(total));

        String paymentStatus = booking.getPaymentStatus();

        if (paymentStatus.equals("Paid")) {
            PayButton.setText("Paid");
            PayButton.setBackground(Color.GREEN);
            PayButton.setEnabled(false); 
        } else if (paymentStatus.equals("Unpaid")) {
            PayButton.setText("Pay");
            PayButton.setBackground(Color.RED);
            PayButton.setEnabled(true);
        } else if (paymentStatus.equals("Pending")) {
            PayButton.setText("Pending");
            PayButton.setBackground(Color.ORANGE);
            PayButton.setEnabled(false);
        }
        
    }

    private void refreshBookings() {
        List<Booking> bookings = DatabaseManager.getSpecificBookingsForUser(selection, user.getEmail());
        
        bookingContainer.removeAll();

        for (Booking booking : bookings) {
            BookingPanel bookingPanel = new BookingPanel(booking, this);
            bookingContainer.add(bookingPanel);
        }

        bookingContainer.revalidate();
        bookingContainer.repaint();
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
        Paid = new javax.swing.JRadioButton();
        Unpaid = new javax.swing.JRadioButton();
        Pending = new javax.swing.JRadioButton();
        backButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BookedCarField = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PerDayPriceField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        StartDateFIeld = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        EndDateField = new javax.swing.JLabel();
        PayButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TotalPaymentField = new javax.swing.JLabel();
        ScrollPanel = new javax.swing.JScrollPane();
        TitleImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
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

        Paid.setBackground(new java.awt.Color(6, 26, 35));
        Paid.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        Paid.setForeground(new java.awt.Color(255, 255, 255));
        Paid.setText("Paid");
        Paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaidActionPerformed(evt);
            }
        });

        Unpaid.setBackground(new java.awt.Color(6, 26, 35));
        Unpaid.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        Unpaid.setForeground(new java.awt.Color(255, 255, 255));
        Unpaid.setText("Unpaid");
        Unpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnpaidActionPerformed(evt);
            }
        });

        Pending.setBackground(new java.awt.Color(6, 26, 35));
        Pending.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        Pending.setForeground(new java.awt.Color(255, 255, 255));
        Pending.setText("Pending");
        Pending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendingActionPerformed(evt);
            }
        });

        backButton.setText("");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Booked Car: ");

        BookedCarField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BookedCarField.setForeground(new java.awt.Color(255, 255, 255));
        BookedCarField.setText("");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price: (Per Day)");

        PerDayPriceField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        PerDayPriceField.setForeground(new java.awt.Color(255, 255, 255));
        PerDayPriceField.setText("");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Start Date: ");

        StartDateFIeld.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        StartDateFIeld.setForeground(new java.awt.Color(255, 255, 255));
        StartDateFIeld.setText("");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("End Date:");

        EndDateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        EndDateField.setForeground(new java.awt.Color(255, 255, 255));
        EndDateField.setText("");

        PayButton.setBackground(new java.awt.Color(255, 255, 254));
        PayButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        PayButton.setText("Pay");
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Payment: ");

        TotalPaymentField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TotalPaymentField.setForeground(new java.awt.Color(255, 255, 255));
        TotalPaymentField.setText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Pending, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Unpaid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Paid, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(BookedCarField, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(StartDateFIeld, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalPaymentField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(PerDayPriceField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EndDateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Paid)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Unpaid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pending)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookedCarField)
                    .addComponent(PerDayPriceField))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartDateFIeld)
                    .addComponent(EndDateField))
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalPaymentField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PayButton)
                .addGap(40, 40, 40))
        );

        TitleImage.setText("");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setText("Payment Checking");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
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

    private void PaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaidActionPerformed
        selection = "Paid"; 
        Unpaid.setSelected(false);
        Pending.setSelected(false);
        refreshBookings();
    }//GEN-LAST:event_PaidActionPerformed

    private void UnpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnpaidActionPerformed
        selection = "Unpaid"; 
        Paid.setSelected(false);
        Pending.setSelected(false);
        refreshBookings();
    }//GEN-LAST:event_UnpaidActionPerformed

    private void PendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PendingActionPerformed
        selection = "Pending"; 
        Paid.setSelected(false);
        Unpaid.setSelected(false);
        refreshBookings();
    }//GEN-LAST:event_PendingActionPerformed

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayButtonActionPerformed
        if (bookingid != -1) {
            dataIO.overWriteData("Pending", row + 6, dataIO.BOOKING_FILE);
            PayButton.setText("Pending");
            PayButton.setBackground(Color.ORANGE);
            PayButton.setEnabled(false);
            refreshBookings();
            JOptionPane.showMessageDialog(null, "Admin will review your payment soon.");
        } else {
            JOptionPane.showMessageDialog(null, "Please select a booking to pay for.");
        }
    }//GEN-LAST:event_PayButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(UserPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(UserPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(UserPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(UserPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new UserPayment(user).setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AccountSettingsMenu;
    private javax.swing.JLabel BookedCarField;
    private javax.swing.JMenuItem BookingConfirmationMenu;
    private javax.swing.JMenu BookingMenu;
    private javax.swing.JLabel EndDateField;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JRadioButton Paid;
    private javax.swing.JButton PayButton;
    private javax.swing.JMenuItem PaymentMenu;
    private javax.swing.JRadioButton Pending;
    private javax.swing.JLabel PerDayPriceField;
    private javax.swing.JScrollPane ScrollPanel;
    private javax.swing.JLabel StartDateFIeld;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JLabel TotalPaymentField;
    private javax.swing.JRadioButton Unpaid;
    private javax.swing.JMenuItem ViewBookingsMenu;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem rentCarButton;
    // End of variables declaration//GEN-END:variables
}