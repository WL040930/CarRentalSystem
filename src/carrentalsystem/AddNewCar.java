/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carrentalsystem;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.ImageIcon;
import java.awt.Image; 
import java.awt.Color;
import javax.swing.BorderFactory;

public class AddNewCar extends javax.swing.JFrame {

    static User.admin user;
    File selectedFile;

    public AddNewCar(User.admin user) {
        initComponents();
        setResizable(false);
        AddNewCar.user = user;
        

        SelectButton.addActionListener((ActionEvent e) -> {
            // Create a file chooser
            JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            
            // Show open dialog to select a file
            int returnValue = fileChooser.showOpenDialog(null);
            
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                // Get the selected file
                selectedFile = fileChooser.getSelectedFile();
                
                // Display the file path in a text field or label (e.g., filePathField)
                filePathField.setText(selectedFile.getName());

                ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                Image scaledImage = imageIcon.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
                displayImageField.setIcon(new ImageIcon(scaledImage));
            } else {
                // User cancelled the operation
                filePathField.setText("No file selected");
            }
        });        

        SelectButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        SelectButton.setOpaque(true); // Ensure button background is visible

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/logo.jpeg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        TitleImage.setIcon(new ImageIcon(scaledImage));

        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/carrentalsystem/img/backButton.png"));
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        backButton.setIcon(new ImageIcon(scaledImage2));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageSwitch.switchPage(AddNewCar.this, new ServicesPage(user));
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CarNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NumberOfSeatsField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PriceField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CarTypeComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        SelectButton = new javax.swing.JButton();
        filePathField = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        backButton = new javax.swing.JLabel();
        displayImageField = new javax.swing.JLabel();
        TitleImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 36)); // NOI18N
        jLabel1.setText("Add New Car");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setText("Car Name:");

        CarNameField.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        CarNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarNameFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setText("Number of Seats:");

        NumberOfSeatsField.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        NumberOfSeatsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfSeatsFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setText("Price per day:  (RM)");

        PriceField.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        PriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setText("Type of Car:");

        CarTypeComboBox.setBackground(new java.awt.Color(204, 204, 204));
        CarTypeComboBox.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        CarTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy Car", "Compact Car", "Luxury Car", "Vans"}));
        CarTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarTypeComboBoxActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(6, 26, 35));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Picture:");

        SelectButton.setBackground(new java.awt.Color(204, 204, 204));
        SelectButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        SelectButton.setText("Select");
        SelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtonActionPerformed(evt);
            }
        });

        filePathField.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        filePathField.setForeground(new java.awt.Color(255, 255, 255));
        filePathField.setText("No file is chosen.");

        AddButton.setBackground(new java.awt.Color(204, 204, 204));
        AddButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        displayImageField.setText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(SelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filePathField, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayImageField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filePathField))
                .addGap(18, 18, 18)
                .addComponent(displayImageField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        TitleImage.setText("");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 2, 14)); // NOI18N
        jLabel8.setText("Enter the Car Information Here! . ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NumberOfSeatsField)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CarTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PriceField)
                            .addComponent(CarNameField)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(185, 185, 185))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NumberOfSeatsField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CarTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int carID; 
    String carName;
    int seatsNumber;
    int price;
    String carType;
    String uniqueName;
    File image;
    final String fileLocation = "src/carrentalsystem/data/Car.txt"; 

    private boolean validateFile (File file) {
        if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".jpeg")){
            return true;
        }
        return false;
    }

    private int carID() {
        int[] tempData = dataIO.carID(1, fileLocation, 7);
        Arrays.sort(tempData);
        return tempData[tempData.length - 1] + 1;
    }

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        CarNameFieldActionPerformed(evt);
        NumberOfSeatsFieldActionPerformed(evt);
        CarTypeComboBoxActionPerformed(evt);
        fileChooserActionPerformed(evt);

        try {
            price = Integer.parseInt(PriceField.getText());
        } catch (NumberFormatException e) {
            messageHandling.incorrectPrice();
            PriceField.setText("");
            return;
        }

        try {
            seatsNumber = Integer.parseInt(NumberOfSeatsField.getText());
        } catch (NumberFormatException e) {
            messageHandling.incorrectSeats();
            NumberOfSeatsField.setText("");
            return; 
        }

        carID = carID();

        if (!carName.isEmpty() && carType != null) {
            if (seatsNumber > 0 && price > 0) {
                if (image == null) {
                    image = new File("src/carrentalsystem/img/defaultCar.png");
                }
                if (validateFile(image)) {
                    dataIO.writeData(carID, fileLocation);
                    dataIO.writeData(carName, fileLocation);
                    dataIO.writeData(seatsNumber, fileLocation);
                    dataIO.writeData(price, fileLocation);
                    dataIO.writeData(carType, fileLocation);

                    if (image.exists()) {
                        uniqueName = dataIO.moveFile(image, "src/carrentalsystem/img/");
                    } else {
                        uniqueName = "defaultCar.png";
                    }

                    dataIO.writeData(uniqueName, fileLocation);
                    
                    dataIO.writeData("", fileLocation);
                    JOptionPane.showMessageDialog(null, "Car added successfully");
                    
                    CarNameField.setText(null);
                    NumberOfSeatsField.setText(null);
                    PriceField.setText(null);
                    CarTypeComboBox.setSelectedIndex(0);
                    filePathField.setText("No file is chosen.");
                    displayImageField.setIcon(null);
                    
                } else {
                    messageHandling.incorrectImage();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please make sure price and number of seats are positive numbers.");
            }
        } else {
            messageHandling.incompletedData();
        }
        
    }

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedFile != null) {
            image = selectedFile;
        }
    }

    private void CarNameFieldActionPerformed(java.awt.event.ActionEvent evt) {
        carName = CarNameField.getText();
    }

    private void PriceFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }                                          

    private void NumberOfSeatsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberOfSeatsFieldActionPerformed

    }//GEN-LAST:event_NumberOfSeatsFieldActionPerformed

    private void CarTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarTypeComboBoxActionPerformed
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
    }//GEN-LAST:event_CarTypeComboBoxActionPerformed

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

    private void SelectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SelectButtonActionPerformed

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
    //         java.util.logging.Logger.getLogger(AddNewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(AddNewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(AddNewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(AddNewCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the form */
    //     java.awt.EventQueue.invokeLater(new Runnable() {
    //         public void run() {
    //             new AddNewCar(user).setVisible(true);
    //         }
    //     });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JMenuItem BookingMenu;
    private javax.swing.JTextField CarNameField;
    private javax.swing.JComboBox<String> CarTypeComboBox;
    private javax.swing.JMenuItem ConfirmationMessageMenu;
    private javax.swing.JMenu FinanceButton;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JTextField NumberOfSeatsField;
    private javax.swing.JMenuItem PaymentManagementMenu;
    private javax.swing.JTextField PriceField;
    private javax.swing.JMenuItem SalesReportMenu;
    private javax.swing.JButton SelectButton;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel displayImageField;
    private javax.swing.JLabel filePathField;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
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
    // End of variables declaration//GEN-END:variables
}
