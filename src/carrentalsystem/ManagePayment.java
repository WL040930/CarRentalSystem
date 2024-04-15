/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;
import java.time.LocalDate;

public class ManagePayment extends javax.swing.JFrame {

    static User.admin user;
    int bookingId = -1; 
    int rowNumberInBooking;
    DefaultTableModel model; 

    public ManagePayment(User.admin user) {
        ManagePayment.user = user;
        initComponents();
        setResizable(false);

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<Booking> payment = DatabaseManager.getPayment("Pending");
        populatePaymentTable(payment);
        PaymentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = PaymentTable.getSelectedRow();
                    if (selectedRow != -1) { 
                        bookingId = (int) PaymentTable.getValueAt(selectedRow, 0);
                        rowNumberInBooking = dataIO.rowNumber(bookingId, 1, dataIO.BOOKING_FILE, 9);
                        String email = dataIO.readData(rowNumberInBooking + 2, dataIO.BOOKING_FILE);

                        LocalDate startDate = LocalDate.parse(dataIO.readData(rowNumberInBooking + 3, dataIO.BOOKING_FILE));
                        LocalDate endDate = LocalDate.parse(dataIO.readData(rowNumberInBooking + 4, dataIO.BOOKING_FILE));
                        int days = (int) (endDate.toEpochDay() - startDate.toEpochDay());
                        
                        BookingIdField.setText(Integer.toString(bookingId));
                        EmailField.setText(email);
                        StartDateField.setText(startDate.toString());
                        EndDateField.setText(endDate.toString());
                        DurationField.setText(Integer.toString(days));

                        int carId = Integer.parseInt(dataIO.readData(rowNumberInBooking + 1, dataIO.BOOKING_FILE));
                        int rowNumberInCar = dataIO.rowNumber(Integer.toString(carId), 1, dataIO.CAR_FILE, 7);
                        String carName = dataIO.readData(rowNumberInCar + 1, dataIO.CAR_FILE);
                        CarNameField.setText(carName);

                        int price = Integer.parseInt(dataIO.readData(rowNumberInCar + 3, dataIO.CAR_FILE));
                        TotalPaymentField.setText(Integer.toString(price * days));
                        
                    }
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        PaymentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        BookingIdField = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EmailField = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        CarNameField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        StartDateField = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        EndDateField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DurationField = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TotalPaymentField = new javax.swing.JLabel();
        PaidButton = new javax.swing.JButton();
        UnpaidButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PaymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(PaymentTable);

        jLabel1.setText("Booking ID: ");

        BookingIdField.setText("");

        jLabel2.setText("Email: ");

        EmailField.setText("");

        jLabel3.setText("Car Booked: ");

        CarNameField.setText("");

        jLabel4.setText("Start Date: ");

        StartDateField.setText("");

        jLabel5.setText("End Date: ");

        EndDateField.setText("");

        jLabel6.setText("Duration: ");

        DurationField.setText("");

        jLabel7.setText("Total Payment: ");

        TotalPaymentField.setText("");

        PaidButton.setText("Paid");
        PaidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaidButtonActionPerformed(evt);
            }
        });

        UnpaidButton.setText("Unpaid");
        UnpaidButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnpaidButtonActionPerformed(evt);
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
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BookingIdField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EmailField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(StartDateField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EndDateField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UnpaidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DurationField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(PaidButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TotalPaymentField, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BookingIdField)
                            .addComponent(CarNameField))
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EmailField)
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StartDateField)
                            .addComponent(DurationField))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EndDateField)
                            .addComponent(TotalPaymentField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PaidButton)
                            .addComponent(UnpaidButton))
                        .addGap(49, 49, 49))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UnpaidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnpaidButtonActionPerformed
        if (bookingId != -1) {
            dataIO.overWriteData("Unpaid",rowNumberInBooking + 6, dataIO.BOOKING_FILE);
            refreshPaymentTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a booking to mark as unpaid.");
        }
    }//GEN-LAST:event_UnpaidButtonActionPerformed

    private void PaidButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaidButtonActionPerformed
        if (bookingId != -1) {
            dataIO.overWriteData("Paid",rowNumberInBooking + 6, dataIO.BOOKING_FILE);
            refreshPaymentTable();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a booking to mark as paid.");
        }
    }//GEN-LAST:event_PaidButtonActionPerformed

    private void populatePaymentTable(List<Booking> bookings) {
        model.setRowCount(0); // Clear existing table data
        model.setColumnCount(0); // Reset column count

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // This causes all cells to be non-editable
                return false;
            }
        };
        model.addColumn("Booking ID");
        model.addColumn("Car Name");
        model.addColumn("User Email");
        model.addColumn("Payment Status");
    
        for (Booking booking : bookings) {
            int bookingId = booking.getBookingId();
            String paymentStatus = booking.getPaymentStatus();

            int rowNumberInBooking = dataIO.rowNumber(bookingId, 1, dataIO.BOOKING_FILE, 9);

            String carId = dataIO.readData(rowNumberInBooking + 1, dataIO.BOOKING_FILE); 
            int rowNumberInCar = dataIO.rowNumber(carId, 1, dataIO.CAR_FILE, 7);

            String carName = dataIO.readData(rowNumberInCar + 1, dataIO.CAR_FILE);

            String userEmail = dataIO.readData(rowNumberInBooking + 2, dataIO.BOOKING_FILE); 
    
    
            // Add row to table model with correct role displayed
            model.addRow(new Object[]{bookingId, carName, userEmail, paymentStatus});
        }
    
        PaymentTable.setModel(model);
    
        // Allow row selection
        PaymentTable.setRowSelectionAllowed(true);
    
        // Ensure that cell selection is disabled
        PaymentTable.setCellSelectionEnabled(false);
        PaymentTable.setColumnSelectionAllowed(false);
    }

    private void refreshPaymentTable() {
        List<Booking> payment = DatabaseManager.getPayment("Pending");
        populatePaymentTable(payment);
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
            java.util.logging.Logger.getLogger(ManagePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePayment(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookingIdField;
    private javax.swing.JLabel CarNameField;
    private javax.swing.JLabel DurationField;
    private javax.swing.JLabel EmailField;
    private javax.swing.JLabel EndDateField;
    private javax.swing.JButton PaidButton;
    private javax.swing.JTable PaymentTable;
    private javax.swing.JLabel StartDateField;
    private javax.swing.JLabel TotalPaymentField;
    private javax.swing.JButton UnpaidButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
