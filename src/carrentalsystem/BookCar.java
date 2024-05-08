/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import java.awt.Image;
import java.awt.print.Book;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class BookCar extends javax.swing.JFrame {

    /**
     * Creates new form BookCar
     */
    static User.customer user; 
    static Car car;
    int carId;
    int rowOfCarId; 
    final String readFileLocation = "src/carrentalsystem/data/Car.txt";
    final String writeFileLocation = "src/carrentalsystem/data/Booking.txt";

    public BookCar(User.customer user, Car car) {
        BookCar.user = user;
        BookCar.car = car;
        carId = car.getCarID();
        rowOfCarId = dataIO.rowNumber(carId, 1, readFileLocation, 7);
        initComponents();
        setResizable(false);

        String imageFilePath = dataIO.readData(rowOfCarId + 5, readFileLocation);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/" + imageFilePath));
        Image scaledImage = imageIcon.getImage().getScaledInstance(390, 390, Image.SCALE_SMOOTH);
        pictureField.setIcon(new ImageIcon(scaledImage));
        startDateField.setDateFormatString("dd/MM/yyyy");
        startDateField.getDateEditor().setEnabled(false);
        startDateField.getDateEditor().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    Date selectedDate = (Date) evt.getNewValue();
                    Date currentDate = new Date();
                    
                    if (selectedDate != null && selectedDate.before(currentDate)) {
                        // Check if the selected date is before the current date
                        JOptionPane.showMessageDialog(null, "You cannot select a date before today.");
                        startDateField.setDate(null);  // Set the start date field to null
                    }
                }
            }
        });
        

        EndDateField.setDateFormatString("dd/MM/yyyy");
        EndDateField.getDateEditor().setEnabled(false);

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
        pictureField = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        startDateField = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        EndDateField = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bookButton = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
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

        pictureField.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel2.setText(dataIO.readData(rowOfCarId + 1, readFileLocation));

        jPanel2.setBackground(new java.awt.Color(6, 26, 35));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("RM " +dataIO.readData(rowOfCarId + 3, readFileLocation));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Car Type:");

        String carTypes = dataIO.readData(rowOfCarId + 4, readFileLocation);
        if (carTypes != "Vans") {
            carTypes = carTypes + "Car";
        }
        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(carTypes);

        startDateField.setBackground(new java.awt.Color(255, 255, 254));
        startDateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Start Date:");

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("End Date:");

        EndDateField.setBackground(new java.awt.Color(255, 255, 254));
        EndDateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Number of Seats:");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(dataIO.readData(rowOfCarId + 2, readFileLocation));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Price:  (Per Day)");

        bookButton.setBackground(new java.awt.Color(255, 255, 254));
        bookButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        bookButton.setText("Book");
        bookButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });

        Cancel.setBackground(new java.awt.Color(255, 255, 254));
        Cancel.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        Cancel.setText("Cancel");
        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(188, 188, 188))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(EndDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)))))
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(bookButton)
                .addGap(18, 18, 18)
                .addComponent(Cancel)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pictureField, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pictureField, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        Date startDate = startDateField.getDate();
        Date endDate = EndDateField.getDate();
    
        if (startDate != null && endDate != null) {
            if (endDate.before(startDate)) {
                JOptionPane.showMessageDialog(this, "End date cannot be earlier than start date", "Invalid Date", JOptionPane.ERROR_MESSAGE);
                EndDateField.setDate(null); // Reset EndDateField
            } else {
                LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate localEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                long daysBetween = ChronoUnit.DAYS.between(localStartDate, localEndDate);
                int price = (int) (daysBetween * Integer.parseInt(dataIO.readData(rowOfCarId + 3, readFileLocation)));

                int choice = JOptionPane.showConfirmDialog(this, "Total Price is RM " + price + ". Confirm Booking?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dataIO.writeData(BookingId(), writeFileLocation); 
                    dataIO.writeData(car.getCarID(), writeFileLocation); 
                    dataIO.writeData(user.getEmail(), writeFileLocation);
                    dataIO.writeData(localStartDate, writeFileLocation);
                    dataIO.writeData(localEndDate, writeFileLocation);
                    dataIO.writeData("Pending", writeFileLocation);
                    dataIO.writeData("Unpaid", writeFileLocation);
                    dataIO.writeData("", writeFileLocation);
                    dataIO.writeData("", writeFileLocation);
                    JOptionPane.showMessageDialog(this, "Booking Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    Car newCar = new Car();
                    newCar.setCarType(car.getCarType());
                    pageSwitch.switchPage(this, new ViewCar(user, newCar));
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a start and end date", "Invalid Date", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bookButtonActionPerformed

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

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel the booking?", "Cancel Booking", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            Car cars = new Car(); 
            cars.setCarType(car.getCarType());
            pageSwitch.switchPage(this, new ViewCar(user, cars));
        }
    }//GEN-LAST:event_CancelActionPerformed

    private void PaymentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentMenuActionPerformed
        pageSwitch.switchPage(this, new UserPayment(user));
    }//GEN-LAST:event_PaymentMenuActionPerformed
    
    private int BookingId() {
        int[] tempData = dataIO.bookingId(1, writeFileLocation, 9);
        Arrays.sort(tempData);
        return tempData[tempData.length - 1] + 1;
    }

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
    //         java.util.logging.Logger.getLogger(BookCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(BookCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(BookCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(BookCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new BookCar(user, car).setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AccountSettingsMenu;
    private javax.swing.JMenuItem BookingConfirmationMenu;
    private javax.swing.JMenu BookingMenu;
    private javax.swing.JButton Cancel;
    private com.toedter.calendar.JDateChooser EndDateField;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JMenuItem PaymentMenu;
    private javax.swing.JMenuItem ViewBookingsMenu;
    private javax.swing.JButton bookButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel pictureField;
    private javax.swing.JMenuItem rentCarButton;
    private com.toedter.calendar.JDateChooser startDateField;
    // End of variables declaration//GEN-END:variables
}
