/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;


public class CheckBooking extends javax.swing.JFrame {

    static User.customer user; 
    int bookingId = -1; 
    int rowNumberOfBookingId; 
    String selection = "All"; 
    private final JPanel bookingContainer;
    
    public CheckBooking(User.customer user) {
        CheckBooking.user = user; 
        initComponents();
        AllBookingsButton.setSelected(true);

        List<Booking> bookings = DatabaseManager.getSpecificBooking(user.getEmail(), selection);

        // Create a panel to hold the booking panels vertically
        bookingContainer = new JPanel();
        bookingContainer.setLayout(new BoxLayout(bookingContainer, BoxLayout.Y_AXIS));

        // Create and add BookingPanel for each booking
        for (Booking booking : bookings) {
            BookingPanel bookingPanel = new BookingPanel(booking, this, selection);
            bookingContainer.add(bookingPanel);
        }

        // Add the booking container panel to the scroll pane
        ScrollPanel.setViewportView(bookingContainer);
        ScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/carrentalsystem/img/backButton.png"));
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(54, 54, Image.SCALE_SMOOTH);
        backButton.setIcon(new ImageIcon(scaledImage2));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageSwitch.switchPage(CheckBooking.this, new UserBookingPage(user));
            }
        }); 

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/logo.jpeg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(66, 66, Image.SCALE_SMOOTH);
        TitleImage.setIcon(new ImageIcon(scaledImage));
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
        ScrollPanel = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        backButton = new javax.swing.JLabel();
        AllBookingsButton = new javax.swing.JRadioButton();
        UpcomingButton = new javax.swing.JRadioButton();
        PastBookingButton = new javax.swing.JRadioButton();
        DurationField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TotalPaymentField = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CarNameField = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        StatusField = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CarPlateField = new javax.swing.JLabel();
        PaymentStatusField = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PayButton = new javax.swing.JButton();
        StartDateField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EndDateField = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TitleImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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

        backButton.setText("");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setMaximumSize(new java.awt.Dimension(54, 54));
        backButton.setMinimumSize(new java.awt.Dimension(54, 54));
        backButton.setPreferredSize(new java.awt.Dimension(54, 54));

        AllBookingsButton.setBackground(new java.awt.Color(6, 26, 36));
        AllBookingsButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        AllBookingsButton.setForeground(new java.awt.Color(255, 255, 255));
        AllBookingsButton.setText("All Bookings");
        AllBookingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllBookingsButtonActionPerformed(evt);
            }
        });

        UpcomingButton.setBackground(new java.awt.Color(6, 26, 36));
        UpcomingButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        UpcomingButton.setForeground(new java.awt.Color(255, 255, 255));
        UpcomingButton.setText("Upcoming Bookings");
        UpcomingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpcomingButtonActionPerformed(evt);
            }
        });

        PastBookingButton.setBackground(new java.awt.Color(6, 26, 36));
        PastBookingButton.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        PastBookingButton.setForeground(new java.awt.Color(255, 255, 255));
        PastBookingButton.setText("Past Bookings");
        PastBookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PastBookingButtonActionPerformed(evt);
            }
        });

        DurationField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        DurationField.setForeground(new java.awt.Color(255, 255, 255));
        DurationField.setText("");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Payment: ");

        TotalPaymentField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        TotalPaymentField.setForeground(new java.awt.Color(255, 255, 255));
        TotalPaymentField.setText("");

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Car Booked: ");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Status: ");

        CarNameField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CarNameField.setForeground(new java.awt.Color(255, 255, 255));
        CarNameField.setText("");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Car Plate: ");

        StatusField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        StatusField.setForeground(new java.awt.Color(255, 255, 255));
        StatusField.setText("");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Payment Status: ");

        CarPlateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CarPlateField.setForeground(new java.awt.Color(255, 255, 255));
        CarPlateField.setText("");

        PaymentStatusField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        PaymentStatusField.setForeground(new java.awt.Color(255, 255, 255));
        PaymentStatusField.setText("");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Start Date: ");

        PayButton.setBackground(new java.awt.Color(255, 255, 254));
        PayButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        PayButton.setText("Pay");
        PayButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });

        StartDateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        StartDateField.setForeground(new java.awt.Color(255, 255, 255));
        StartDateField.setText("");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("End Date: ");

        EndDateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        EndDateField.setForeground(new java.awt.Color(255, 255, 255));
        EndDateField.setText("");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Duration: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AllBookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PastBookingButton)
                    .addComponent(UpcomingButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(StartDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EndDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CarNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CarPlateField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DurationField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StatusField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(PaymentStatusField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TotalPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(197, 197, 197)
                .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(AllBookingsButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UpcomingButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PastBookingButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TotalPaymentField)
                    .addComponent(CarNameField))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarPlateField)
                    .addComponent(StatusField))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartDateField)
                    .addComponent(EndDateField))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentStatusField)
                    .addComponent(DurationField))
                .addGap(29, 29, 29)
                .addComponent(PayButton)
                .addGap(19, 19, 19))
        );

        TitleImage.setText("");

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel9.setText("Booking Checking");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitleImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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

    private void refreshBookings() {
        List<Booking> bookings = DatabaseManager.getSpecificBooking(user.getEmail(), selection);
    
        // Clear existing booking panels from the container
        bookingContainer.removeAll();
    
        // Create and add BookingPanel for each booking based on the new selection
        for (Booking booking : bookings) {
            BookingPanel bookingPanel = new BookingPanel(booking, this, selection);
            bookingContainer.add(bookingPanel);
        }
    
        // Revalidate and repaint the booking container to reflect changes
        bookingContainer.revalidate();
        bookingContainer.repaint();
    }
    
    private void PastBookingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PastBookingButtonActionPerformed
        selection = "Past";
        UpcomingButton.setSelected(false);
        AllBookingsButton.setSelected(false);
        refreshBookings(); // Refresh bookings display based on selection
    }//GEN-LAST:event_PastBookingButtonActionPerformed
    
    private void UpcomingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpcomingButtonActionPerformed
        selection = "Upcoming";
        PastBookingButton.setSelected(false);
        AllBookingsButton.setSelected(false);
        refreshBookings(); // Refresh bookings display based on selection
    }//GEN-LAST:event_UpcomingButtonActionPerformed
    
    private void AllBookingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllBookingsButtonActionPerformed
        selection = "All";
        UpcomingButton.setSelected(false);
        PastBookingButton.setSelected(false);
        refreshBookings(); // Refresh bookings display based on selection
    }//GEN-LAST:event_AllBookingsButtonActionPerformed

    private void rentCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentCarButtonActionPerformed
        pageSwitch.switchPage(this, new ChooseCarType(user));
    }//GEN-LAST:event_rentCarButtonActionPerformed

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

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String message;
    
        if (bookingId == -1) {
            message = "Please select a booking to pay.";
        } else if (!dataIO.readData(rowNumberOfBookingId + 5, dataIO.BOOKING_FILE).equals("Accepted")) {
            message = "Payment cannot be made until the admin approves the booking.";
        } else {
            dataIO.overWriteData("Pending", rowNumberOfBookingId + 6 , dataIO.BOOKING_FILE);
            message = "Payment Status will be changed once the admin approves the payment.";
            PaymentStatusField.setText("Pending");
            PayButton.setText("Pending");
            PayButton.setBackground(Color.ORANGE);
            PayButton.setEnabled(false);
            refreshBookings();
        }
    
        JOptionPane pane = new JOptionPane(message, JOptionPane.INFORMATION_MESSAGE);
    
        // Create a JDialog to hold the JOptionPane
        JDialog dialog = pane.createDialog("Payment Status");
    
        // Set up a Timer to close the dialog after 3 seconds
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Close the dialog
            }
        });
    
        timer.setRepeats(false); // Only execute once
        timer.start();
    
        // Show the dialog
        dialog.setVisible(true);
    }
           
    
    public void displayBookingDetails(Booking booking) {
        bookingId = booking.getBookingId();
        rowNumberOfBookingId = dataIO.rowNumber(bookingId, 1, dataIO.BOOKING_FILE, 9); 
        int carId = booking.getCarId();
        int rowNumberOfCar = dataIO.rowNumber(carId, 1, dataIO.CAR_FILE, 7); 

        String carName = dataIO.readData(rowNumberOfCar + 1, dataIO.CAR_FILE); 
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();
        int totalDuration = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        String carPlate = booking.getCarPlate();
        String status = booking.getStatus();
        String paymentStatus = booking.getPaymentStatus();
        int totalPayment = totalDuration * Integer.parseInt(dataIO.readData(rowNumberOfCar + 3, dataIO.CAR_FILE));

        CarNameField.setText(carName);
        CarPlateField.setText(carPlate);
        StartDateField.setText(startDate.toString());
        EndDateField.setText(endDate.toString());
        DurationField.setText(totalDuration + " days");
        StatusField.setText(status);
        PaymentStatusField.setText(paymentStatus);
        TotalPaymentField.setText("RM " + totalPayment);

        if (paymentStatus.equals("Paid") && status.equals("Accepted")) {
            PayButton.setText("Paid");
            PayButton.setBackground(Color.GREEN);
            PayButton.setEnabled(false);
        } else if (paymentStatus.equals("Unpaid") && status.equals("Accepted")) {
            PayButton.setText("Pay");
            PayButton.setBackground(Color.RED);
            PayButton.setEnabled(true);
        } else if (paymentStatus.equals("Pending") && status.equals("Accepted")) {
            PayButton.setText("Pending");
            PayButton.setBackground(Color.ORANGE);
            PayButton.setEnabled(false);
        } else {
            PayButton.setText("Waiting");
            PayButton.setBackground(Color.GRAY);
            PayButton.setEnabled(false);
        }

    }

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
            java.util.logging.Logger.getLogger(CheckBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckBooking(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AccountSettingsMenu;
    private javax.swing.JRadioButton AllBookingsButton;
    private javax.swing.JMenuItem BookingConfirmationMenu;
    private javax.swing.JMenu BookingMenu;
    private javax.swing.JLabel CarNameField;
    private javax.swing.JLabel CarPlateField;
    private javax.swing.JLabel DurationField;
    private javax.swing.JLabel EndDateField;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JRadioButton PastBookingButton;
    private javax.swing.JButton PayButton;
    private javax.swing.JMenuItem PaymentMenu;
    private javax.swing.JLabel PaymentStatusField;
    private javax.swing.JScrollPane ScrollPanel;
    private javax.swing.JLabel StartDateField;
    private javax.swing.JLabel StatusField;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JLabel TotalPaymentField;
    private javax.swing.JRadioButton UpcomingButton;
    private javax.swing.JMenuItem ViewBookingsMenu;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenuItem rentCarButton;
    // End of variables declaration//GEN-END:variables
}
