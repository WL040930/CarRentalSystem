package carrentalsystem;

import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class BookingConfirmation extends javax.swing.JFrame {

    private static User.customer user;
    private final JPanel bookingContainer;
    int bookingId;
    final String CAR_FILE = dataIO.CAR_FILE;

    public BookingConfirmation(User.customer user) {
        BookingConfirmation.user = user;
        initComponents();

        List<Booking> bookings = DatabaseManager.getSpecificBookings(user.getEmail());

        // Create a panel to hold the booking panels vertically
        bookingContainer = new JPanel();
        bookingContainer.setLayout(new BoxLayout(bookingContainer, BoxLayout.Y_AXIS));

        // Create and add BookingPanel for each booking
        for (Booking booking : bookings) {
            BookingPanel bookingPanel = new BookingPanel(booking, this); // Pass this instance of BookingConfirmation
            bookingContainer.add(bookingPanel);
        }

        // Add the booking container panel to the scroll pane
        ScrollPanel.setViewportView(bookingContainer);
        ScrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        ScrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ScrollPanel = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        carBookedField = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        startDateField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        EndDateField = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalDurationField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalPaymentField = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        statusField = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        paymentStatusField = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        carPlateField = new javax.swing.JLabel();
        RejectButton = new javax.swing.JButton();
        AcceptButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Booking Notification");

        jLabel2.setText("Car Booked: ");

        carBookedField.setText("");

        jLabel3.setText("Start Date: ");

        startDateField.setText("");

        jLabel4.setText("End Date: ");

        EndDateField.setText("");

        jLabel5.setText("Total Duration: ");

        totalDurationField.setText("");

        jLabel6.setText("Total Payment: ");

        totalPaymentField.setText("");

        jLabel7.setText("Status: ");

        statusField.setText("");

        jLabel8.setText("Payment Status: ");

        paymentStatusField.setText("");

        jLabel9.setText("Car Plate: ");

        carPlateField.setText("");

        RejectButton.setText("Reject");
        RejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejectButtonActionPerformed(evt);
            }
        });

        AcceptButton.setText("Accept");
        AcceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcceptButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(carBookedField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(startDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(EndDateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(RejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalDurationField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carPlateField, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(paymentStatusField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carBookedField)
                            .addComponent(totalPaymentField))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startDateField)
                            .addComponent(statusField))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EndDateField)
                            .addComponent(paymentStatusField))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalDurationField)
                            .addComponent(carPlateField))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RejectButton)
                            .addComponent(AcceptButton))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Method to refresh the ScrollPanel with updated booking data
    private void refreshScrollPanel() {
        bookingContainer.removeAll(); // Remove all components from bookingContainer

        List<Booking> updatedBookings = DatabaseManager.getSpecificBookings(user.getEmail());

        // Create and add BookingPanel for each updated booking
        for (Booking booking : updatedBookings) {
            BookingPanel bookingPanel = new BookingPanel(booking, this);
            bookingContainer.add(bookingPanel);
        }

        // Update the layout of bookingContainer
        bookingContainer.revalidate();
        bookingContainer.repaint();
    }

    private void RejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RejectButtonActionPerformed
        if (!String.valueOf(bookingId).isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to reject this booking?");
            if (confirm == JOptionPane.YES_OPTION) {
                int rowNumberOfBookingId = dataIO.rowNumber(bookingId, 1, dataIO.BOOKING_FILE, 9);
                int rowChange = rowNumberOfBookingId + 5; 
                dataIO.overWriteData("Rejected", rowChange, dataIO.BOOKING_FILE);
                carBookedField.setText("");
                startDateField.setText("");
                EndDateField.setText("");
                totalDurationField.setText("");
                totalPaymentField.setText("");
                statusField.setText("");
                paymentStatusField.setText("");
                carPlateField.setText("");
                refreshScrollPanel();

            } 
        }
    }//GEN-LAST:event_RejectButtonActionPerformed

    private void AcceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcceptButtonActionPerformed
        if (!String.valueOf(bookingId).isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to accept this booking?");
            if (confirm == JOptionPane.YES_OPTION) {
                int rowNumberOfBookingId = dataIO.rowNumber(bookingId, 1, dataIO.BOOKING_FILE, 9);
                int rowChange = rowNumberOfBookingId + 5; 
                dataIO.overWriteData("Accepted", rowChange, dataIO.BOOKING_FILE);
                carBookedField.setText("");
                startDateField.setText("");
                EndDateField.setText("");
                totalDurationField.setText("");
                totalPaymentField.setText("");
                statusField.setText("");
                paymentStatusField.setText("");
                carPlateField.setText("");
                refreshScrollPanel();

            } 
        }
    }//GEN-LAST:event_AcceptButtonActionPerformed

    public void displayBookingDetails(Booking booking) {
        bookingId = booking.getBookingId();
        int carId = booking.getCarId();
        LocalDate startDate = booking.getStartDate();
        LocalDate endDate = booking.getEndDate();

        int rowNumberOfCar = dataIO.rowNumber(carId, 1, CAR_FILE, 7);
        String carName = dataIO.readData(rowNumberOfCar + 1, CAR_FILE); 

        int totalDuration = (int) (endDate.toEpochDay() - startDate.toEpochDay());
        int totalPayment = totalDuration * Integer.parseInt(dataIO.readData(rowNumberOfCar + 3, CAR_FILE)); 

        carBookedField.setText(String.valueOf(carName));
        startDateField.setText(startDate.toString());
        EndDateField.setText(endDate.toString());
        totalDurationField.setText(String.valueOf(totalDuration));
        totalPaymentField.setText(String.valueOf(totalPayment));
        statusField.setText(booking.getStatus());
        paymentStatusField.setText(booking.getPaymentStatus());
        carPlateField.setText(booking.getCarPlate());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookingConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BookingConfirmation(user).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptButton;
    private javax.swing.JLabel EndDateField;
    private javax.swing.JButton RejectButton;
    private javax.swing.JScrollPane ScrollPanel;
    private javax.swing.JLabel carBookedField;
    private javax.swing.JLabel carPlateField;
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel paymentStatusField;
    private javax.swing.JLabel startDateField;
    private javax.swing.JLabel statusField;
    private javax.swing.JLabel totalDurationField;
    private javax.swing.JLabel totalPaymentField;
    // End of variables declaration//GEN-END:variables
}
