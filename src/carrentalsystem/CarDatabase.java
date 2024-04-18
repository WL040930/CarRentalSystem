/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarDatabase extends javax.swing.JFrame {

    static User.admin user;
    File selectedFile;
    DefaultTableModel model;
    String imageID;
    final String fileLocation = dataIO.GET_CAR_FILE();

    public CarDatabase(User.admin user) {
        CarDatabase.user = user;
        initComponents();
        setResizable(false);

        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        CarTable.setModel(model);

        List<Car> car = DatabaseManager.getAllCars();
        populateCarTable(car);
        CarTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = CarTable.getSelectedRow();
                    if (selectedRow != -1) { 
                        // Get data from the selected row
                        String carID = CarTable.getValueAt(selectedRow, 0).toString();
                        String carName = CarTable.getValueAt(selectedRow, 1).toString();
                        String numberofSeats = CarTable.getValueAt(selectedRow, 2).toString();
                        String CarType = CarTable.getValueAt(selectedRow, 3).toString();
                        String CarPrice = CarTable.getValueAt(selectedRow, 4).toString();

                        // Display data in the text fields
                        CarIdText.setText(carID);
                        CarNameField.setText(carName);
                        CarSeatsField.setText(numberofSeats);
                        CarTypeComboBox.setSelectedItem(CarType);
                        CarPriceField.setText(CarPrice);

                        imageID = CarIdText.getText();
                        
                        int rowNumberOfCarID = dataIO.rowNumber(imageID, 1, fileLocation, 7);
                        
                        String imageFilePath = dataIO.readData(rowNumberOfCarID + 5, fileLocation);
        
                        imageField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrentalsystem/img/" + imageFilePath)));
                    }
                }
            }
        });

        SelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser
                JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
                // Show open dialog to select a file
                int returnValue = fileChooser.showOpenDialog(null);
        
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // Get the selected file
                    selectedFile = fileChooser.getSelectedFile(); 
                } else {
                    
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
        CarTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        imageField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CarNameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CarPriceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CarSeatsField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CarTypeComboBox = new javax.swing.JComboBox<>();
        NumberOfBookings = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        SelectButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        CarIdText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(CarTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Car Database");

        jLabel2.setText("Picture:");

        jLabel4.setText("Car Name:");

        CarNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarNameFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Car Price:");

        CarPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarPriceFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Number of Seats");

        CarSeatsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarSeatsFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Car type:");

        CarTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy Car", "Compact Car", "Luxury Car", "Vans" }));
        CarTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarTypeComboBoxActionPerformed(evt);
            }
        });

        NumberOfBookings.setText(" ");

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        SelectButton.setText("Upload");
        SelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Car ID:");

        CarIdText.setText(" ");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Services");

        jMenuItem5.setText("Add New Car");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Database");

        jMenuItem3.setText("User Database");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem6.setText("Car Database");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Settings");

        jMenuItem1.setText("Account Settings");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(SelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(imageField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(CarNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(CarSeatsField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CarPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CarIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NumberOfBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CarTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(SelectButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel7))
                                        .addGap(4, 4, 4)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(CarNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CarTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(CarSeatsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(NumberOfBookings)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CarIdText)))
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CarPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(imageField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SaveButton)
                        .addGap(120, 120, 120))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    File image;
    String carType, uniqueName;
    int price;
    String carName;
    int carSeats;

    private boolean validateFile (File file) {
        if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".jpeg")){
            return true;
        }
        return false;
    }

    private void CarTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                
        carType = CarTypeComboBox.getSelectedItem().toString();
        switch (carType) {
            case "Economy Car":
                carType = "Economy";
                break;
            case "Compact Car":
                carType = "Compact";
                break;
            case "Luxury Car":
                carType = "Luxury";
                break;
            case "Vans":
                carType = "Vans";
                break;
        }
    }

    private void CarSeatsFieldActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            carSeats = Integer.parseInt(CarSeatsField.getText());
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., show error message)
            JOptionPane.showMessageDialog(null, "Please enter a valid number for seats.");
            CarSeatsField.setText(""); // Clear the field
        }
    }
    
    private void CarPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            price = Integer.parseInt(CarPriceField.getText());
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., show error message)
            JOptionPane.showMessageDialog(null, "Please enter a valid price.");
            CarPriceField.setText(""); // Clear the field
        }
    }
    

    private void populateCarTable(List<Car> Car) {
        model.setRowCount(0); // Clear existing table data
        model.setColumnCount(0); // Reset column count

        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // This causes all cells to be non-editable
                return false;
            }
        };
        model.addColumn("Car ID");
        model.addColumn("Car Name");
        model.addColumn("Number of Seats");
        model.addColumn("Car Type");
        model.addColumn("Price");
    
        for (Car Tcar : Car) {
            int carId = Tcar.getCarID();
            String name = Tcar.getCarName();
            int numberOfSeats = Tcar.getSeatsNumber();
            String carType = Tcar.getCarType();
            int price = Tcar.getPrice();
    
    
            // Add row to table model with correct role displayed
            model.addRow(new Object[]{carId, name, numberOfSeats, carType, price});
        }
    
        CarTable.setModel(model);
    
        // // Allow row selection
        // CarTable.setRowSelectionAllowed(true);
    
        // // Ensure that cell selection is disabled
        // CarTable.setCellSelectionEnabled(false);
        // CarTable.setColumnSelectionAllowed(false);
    }

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        CarNameFieldActionPerformed(evt);
        CarSeatsFieldActionPerformed(evt);
        CarPriceFieldActionPerformed(evt);
        CarTypeComboBoxActionPerformed(evt);
        fileChooserActionPerformed(evt);

        if (imageID != null ) {
            int rowCarID = dataIO.rowNumber(imageID, 1, fileLocation, 7);
            if (price >= 0 && carSeats >= 0) {
                if (image == null) {
                    dataIO.overWriteData(carName, rowCarID + 1, fileLocation);
                    dataIO.overWriteData(carSeats, rowCarID + 2, fileLocation);
                    dataIO.overWriteData(price, rowCarID + 3, fileLocation);
                    dataIO.overWriteData(carType, rowCarID + 4, fileLocation);
                } else {
                    if (validateFile(image)) {
                        dataIO.overWriteData(carName, rowCarID + 1, fileLocation);
                        dataIO.overWriteData(carSeats, rowCarID + 2, fileLocation);
                        dataIO.overWriteData(price, rowCarID + 3, fileLocation);
                        dataIO.overWriteData(carType, rowCarID + 4, fileLocation);
        
                        if (image.exists()) {
                            uniqueName = dataIO.moveFile(image, "src/carrentalsystem/img/");
                        }
                        
                        dataIO.overWriteData(uniqueName, rowCarID + 5, fileLocation);
                    
                    } else {
                        messageHandling.incorrectImage();
                    }
                }
    
                refreshCarTable();
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid price and number of seats");
                CarPriceField.setText("");
                CarSeatsField.setText("");
            }
        }
        

        
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {}

    private void refreshCarTable() {
        List<Car> car = DatabaseManager.getAllCars();
        populateCarTable(car);
    }

    private void CarNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarNameFieldActionPerformed
        carName = CarNameField.getText();
    }//GEN-LAST:event_CarNameFieldActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedFile != null) {
            image = selectedFile;
        }
    }
    






    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        pageSwitch.switchPage(this, new AddNewCar(user));
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        pageSwitch.switchPage(this, new UserDatabase(user));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        pageSwitch.switchPage(this, new manageOwnAccount(user));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(CarDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarDatabase(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarIdText;
    private javax.swing.JTextField CarNameField;
    private javax.swing.JTextField CarPriceField;
    private javax.swing.JTextField CarSeatsField;
    private javax.swing.JTable CarTable;
    private javax.swing.JComboBox<String> CarTypeComboBox;
    private javax.swing.JLabel NumberOfBookings;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SelectButton;
    private javax.swing.JLabel imageField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
