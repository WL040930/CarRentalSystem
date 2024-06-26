/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Image;
import java.util.List;
import java.awt.Color;
import java.awt.Font;



public class AdminOverduePayment extends javax.swing.JFrame {

    static User.admin user;
    DefaultTableModel model; 
    int bookingId = -1; 

    public AdminOverduePayment(User.admin user) {
        AdminOverduePayment.user = user;
        initComponents();
        setResizable(false);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/logo.jpeg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(73, 73, Image.SCALE_SMOOTH);
        TitleImage.setIcon(new ImageIcon(scaledImage));

        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/carrentalsystem/img/backButton.png"));
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        backButton.setIcon(new ImageIcon(scaledImage2));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageSwitch.switchPage(AdminOverduePayment.this, new FinancePage(user));
            }
        }); 

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };


        List<Return> overduePayment = DatabaseManager.getReturnDetail("Pending"); 
        populatePaymentTable(overduePayment);
        PaymentTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = PaymentTable.getSelectedRow();
                    if (selectedRow != -1) { 
                        bookingId = (int) PaymentTable.getValueAt(selectedRow, 0);
                        String bookedCar = (String) PaymentTable.getValueAt(selectedRow, 1);
                        String email = (String) PaymentTable.getValueAt(selectedRow, 2);
                        String overduePrice = (String) PaymentTable.getValueAt(selectedRow, 3);

                        BookedCarField.setText(bookedCar);
                        emailField.setText(email);
                        overduePaymentField.setText(overduePrice);
                        
                    }
                }
            }
        });

        JTableHeader header = PaymentTable.getTableHeader();
        header.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(6, 26, 35)); // Dark background color
        header.setReorderingAllowed(false); // Disable column reordering

    }

    private void populatePaymentTable(List<Return> returns) {
        model.setRowCount(0); 
        model.setColumnCount(0); 

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
        model.addColumn("Overdue Payment");
    
        for (Return returnonj : returns) {
            int bookingId = returnonj.getBookingId();
            int rowNumberInReturn = dataIO.rowNumber(bookingId, 1, dataIO.RETURN_FILE, 4); 
            String overdue = dataIO.readData(rowNumberInReturn + 2, dataIO.RETURN_FILE);
            
            int rowInBooking = dataIO.rowNumber(bookingId, 1, dataIO.BOOKING_FILE, 9); 
            String email = dataIO.readData(rowInBooking + 2, dataIO.BOOKING_FILE);
            int carId = Integer.parseInt(dataIO.readData(rowInBooking + 1, dataIO.BOOKING_FILE));

            int rowInCar = dataIO.rowNumber(Integer.toString(carId), 1, dataIO.CAR_FILE, 7);
            String carName = dataIO.readData(rowInCar + 1, dataIO.CAR_FILE);

            model.addRow(new Object[]{bookingId, carName, email, overdue});
        }
    
        PaymentTable.setModel(model);
    
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PaymentTable = new javax.swing.JTable();
        TitleImage = new javax.swing.JLabel();
        ApproveButton = new javax.swing.JButton();
        RejectButton = new javax.swing.JButton();
        backButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BookedCarField = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        emailField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        overduePaymentField = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        ConfirmationMessageMenu = new javax.swing.JMenuItem();
        FinanceButton = new javax.swing.JMenu();
        PaymentManagementMenu = new javax.swing.JMenuItem();
        SalesReportMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        BookingMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        LogoutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(6, 26, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Overdue Payment");

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

        TitleImage.setText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        ApproveButton.setBackground(new java.awt.Color(6, 26, 35));
        ApproveButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        ApproveButton.setForeground(new java.awt.Color(255, 255, 255));
        ApproveButton.setText("Approve");
        ApproveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ApproveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApproveButtonActionPerformed(evt);
            }
        });

        RejectButton.setBackground(new java.awt.Color(6, 26, 35));
        RejectButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        RejectButton.setForeground(new java.awt.Color(255, 255, 255));
        RejectButton.setText("Reject");
        RejectButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RejectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RejectButtonActionPerformed(evt);
            }
        });

        backButton.setText("");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setText("Booked Car:");

        BookedCarField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BookedCarField.setText("");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setText("Email Address:");

        emailField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        emailField.setText("");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setText("Overdue: ");

        overduePaymentField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        overduePaymentField.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(RejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(ApproveButton)
                        .addGap(83, 83, 83))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(BookedCarField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(overduePaymentField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BookedCarField)
                    .addComponent(overduePaymentField))
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RejectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ApproveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jMenuBar1.setBackground(new java.awt.Color(6, 26, 35));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu4.setForeground(new java.awt.Color(255, 255, 255));
        jMenu4.setText("Services");

        jMenuItem5.setBackground(new java.awt.Color(6, 26, 35));
        jMenuItem5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jMenuItem5.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem5.setText("Add New Car");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        ConfirmationMessageMenu.setBackground(new java.awt.Color(6, 26, 35));
        ConfirmationMessageMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        ConfirmationMessageMenu.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmationMessageMenu.setText("Booking Management");
        ConfirmationMessageMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmationMessageMenuActionPerformed(evt);
            }
        });
        jMenu4.add(ConfirmationMessageMenu);

        jMenuBar1.add(jMenu4);

        FinanceButton.setForeground(new java.awt.Color(255, 255, 255));
        FinanceButton.setText("Finance");

        PaymentManagementMenu.setBackground(new java.awt.Color(6, 26, 35));
        PaymentManagementMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        PaymentManagementMenu.setForeground(new java.awt.Color(255, 255, 255));
        PaymentManagementMenu.setText("Payment Management");
        PaymentManagementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentManagementMenuActionPerformed(evt);
            }
        });
        FinanceButton.add(PaymentManagementMenu);

        SalesReportMenu.setBackground(new java.awt.Color(6, 26, 35));
        SalesReportMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        SalesReportMenu.setForeground(new java.awt.Color(255, 255, 255));
        SalesReportMenu.setText("Sales Reports");
        SalesReportMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesReportMenuActionPerformed(evt);
            }
        });
        FinanceButton.add(SalesReportMenu);

        jMenuBar1.add(FinanceButton);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Database");

        jMenuItem3.setBackground(new java.awt.Color(6, 26, 35));
        jMenuItem3.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jMenuItem3.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem3.setText("User Database");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem6.setBackground(new java.awt.Color(6, 26, 35));
        jMenuItem6.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jMenuItem6.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem6.setText("Car Database");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        BookingMenu.setBackground(new java.awt.Color(6, 26, 35));
        BookingMenu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BookingMenu.setForeground(new java.awt.Color(255, 255, 255));
        BookingMenu.setText("Booking Database");
        BookingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingMenuActionPerformed(evt);
            }
        });
        jMenu3.add(BookingMenu);

        jMenuBar1.add(jMenu3);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Settings");

        jMenuItem1.setBackground(new java.awt.Color(6, 26, 35));
        jMenuItem1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Account Settings");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

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

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        pageSwitch.switchPage(this, new AddNewCar(user));
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void ConfirmationMessageMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmationMessageMenuActionPerformed
        pageSwitch.switchPage(this, new BookingManagement(user));
    }//GEN-LAST:event_ConfirmationMessageMenuActionPerformed

    private void PaymentManagementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentManagementMenuActionPerformed
        pageSwitch.switchPage(this, new ManagePayment(user));
    }//GEN-LAST:event_PaymentManagementMenuActionPerformed

    private void SalesReportMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesReportMenuActionPerformed
        pageSwitch.switchPage(this, new ChooseTime(user));
    }//GEN-LAST:event_SalesReportMenuActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        pageSwitch.switchPage(this, new UserDatabase(user));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        pageSwitch.switchPage(this, new CarDatabase(user));
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void BookingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingMenuActionPerformed
        pageSwitch.switchPage(this, new BookingDatabase(user));
    }//GEN-LAST:event_BookingMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        pageSwitch.switchPage(this, new manageOwnAccount(user));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void LogoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuActionPerformed
        int dialogResult = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Warning", javax.swing.JOptionPane.YES_NO_OPTION);
        if (dialogResult == javax.swing.JOptionPane.YES_OPTION) {
            pageSwitch.switchPage(this, new Login());
        }
    }//GEN-LAST:event_LogoutMenuActionPerformed

    private void RejectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RejectButtonActionPerformed
        if (bookingId == -1 ) {
            JOptionPane.showMessageDialog(this, "Please select a booking to reject");
            return;
        }

        int rowNumberInReturn = dataIO.rowNumber(bookingId, 1, dataIO.RETURN_FILE, 4);
        dataIO.overWriteData("Overdue", rowNumberInReturn + 1, dataIO.RETURN_FILE);

        JOptionPane.showMessageDialog(this, "Payment rejected");
        refreshPaymentTable();

    }//GEN-LAST:event_RejectButtonActionPerformed

    private void ApproveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApproveButtonActionPerformed
        if (bookingId == -1 ) {
            JOptionPane.showMessageDialog(this, "Please select a booking to reject");
            return;
        }

        int rowNumberInReturn = dataIO.rowNumber(bookingId, 1, dataIO.RETURN_FILE, 4);
        dataIO.overWriteData("Returned", rowNumberInReturn + 1, dataIO.RETURN_FILE);
        dataIO.overWriteData("Returned", rowNumberInReturn + 2, dataIO.RETURN_FILE);

        JOptionPane.showMessageDialog(this, "Payment approved");
        
        refreshPaymentTable();
    }

    private void refreshPaymentTable() {
        List<Return> overduePayment = DatabaseManager.getReturnDetail("Pending"); 
        populatePaymentTable(overduePayment);
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
    //         java.util.logging.Logger.getLogger(AdminOverduePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(AdminOverduePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(AdminOverduePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(AdminOverduePayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new AdminOverduePayment().setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ApproveButton;
    private javax.swing.JLabel BookedCarField;
    private javax.swing.JMenuItem BookingMenu;
    private javax.swing.JMenuItem ConfirmationMessageMenu;
    private javax.swing.JMenu FinanceButton;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JMenuItem PaymentManagementMenu;
    private javax.swing.JTable PaymentTable;
    private javax.swing.JButton RejectButton;
    private javax.swing.JMenuItem SalesReportMenu;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel emailField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel overduePaymentField;
    // End of variables declaration//GEN-END:variables
}
