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
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.JTableHeader;

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
                        String CarPrice = CarTable.getValueAt(selectedRow, 4).toString();

                        int rowNumberOfId = dataIO.rowNumber(carID, 1, dataIO.CAR_FILE, 7);
                        String CarType = dataIO.readData(rowNumberOfId + 4, dataIO.CAR_FILE); 

                        if (!CarType.equals("Vans")) {
                            CarType = CarType + " Car";
                        }

                        // Display data in the text fields
                        CarIdText.setText(carID);
                        CarNameField.setText(carName);
                        CarSeatsField.setText(numberofSeats);
                        CarTypeComboBox.setSelectedItem(CarType);
                        CarPriceField.setText(CarPrice);

                        imageID = CarIdText.getText();
                        
                        int rowNumberOfCarID = dataIO.rowNumber(imageID, 1, fileLocation, 7);
                        
                        String imageFilePath = dataIO.readData(rowNumberOfCarID + 5, fileLocation);
        
                        // Load the image from the specified file path
                        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/" + imageFilePath));
                        Image originalImage = originalIcon.getImage();

                        // Desired width and height for the scaled image
                        int scaledWidth = 200;  
                        int scaledHeight = 200; 

                        // Create a scaled version of the image
                        Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

                        // Create a new ImageIcon from the scaled image
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);

                        // Set the scaled ImageIcon to the JLabel (imageField)
                        imageField.setIcon(scaledIcon);
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
                    
                    try {
                        // Read the selected image file into a BufferedImage
                        BufferedImage originalImage = ImageIO.read(selectedFile);
                    
                        // Desired width and height for the scaled image
                        int scaledWidth = 200;  // Set your desired width
                        int scaledHeight = 150; // Set your desired height
                    
                        // Scale the BufferedImage to the desired dimensions
                        Image scaledImage = originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
                    
                        // Create a new ImageIcon from the scaled Image
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                    
                        // Set the scaled ImageIcon to the JLabel (imageField)
                        imageField.setIcon(scaledIcon);
                    } catch (IOException ex) {
                        // Handle exception if the file cannot be read or does not exist
                        ex.printStackTrace();  // You might want to handle this more gracefully in your application
                    }
                } 
            }
        });     
        
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/carrentalsystem/img/backButton.png"));
        Image scaledImage2 = imageIcon2.getImage().getScaledInstance(43, 43, Image.SCALE_SMOOTH);
        backButton.setIcon(new ImageIcon(scaledImage2));

        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pageSwitch.switchPage(CarDatabase.this, new DatabasePage(user));
            }
        }); 

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/logo.jpeg"));
        Image scaledImage = imageIcon.getImage().getScaledInstance(43, 43, Image.SCALE_SMOOTH);
        TitleImage.setIcon(new ImageIcon(scaledImage));

        
        JTableHeader header = CarTable.getTableHeader();
        header.setFont(new Font("Bahnschrift", Font.BOLD, 14));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(6, 26, 35)); // Dark background color
        header.setReorderingAllowed(false); // Disable column reordering
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CarTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        CarPriceField = new javax.swing.JTextField();
        CarIdText = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CarNameField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SelectButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        imageField = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        SaveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CarTypeComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        CarSeatsField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        TitleImage = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Car Database");

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

        jPanel2.setBackground(new java.awt.Color(6, 26, 35));

        CarPriceField.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        CarPriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarPriceFieldActionPerformed(evt);
            }
        });

        CarIdText.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        CarIdText.setForeground(new java.awt.Color(255, 255, 255));
        CarIdText.setText("");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Car Price: (Per Day)");

        CarNameField.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        CarNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarNameFieldActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Car ID:");

        SelectButton.setText("Upload");
        SelectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Car Name:");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        SaveButton.setBackground(new java.awt.Color(255, 255, 254));
        SaveButton.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Picture:");

        CarTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy Car", "Compact Car", "Luxury Car", "Vans" }));
        CarTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarTypeComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Car Type:");

        CarSeatsField.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        CarSeatsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarSeatsFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Number of Seats");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SelectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CarPriceField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CarNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CarSeatsField, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CarTypeComboBox, 0, 146, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarIdText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CarNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CarTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CarIdText)
                                    .addComponent(CarPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CarSeatsField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(SelectButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imageField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(SaveButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backButton.setText("");
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        TitleImage.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TitleImage, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(664, 664, 664)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(TitleImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    }
    
    private void CarPriceFieldActionPerformed(java.awt.event.ActionEvent evt) {

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
    
    }

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        CarNameFieldActionPerformed(evt);
        CarSeatsFieldActionPerformed(evt);
        CarPriceFieldActionPerformed(evt);
        CarTypeComboBoxActionPerformed(evt);
        fileChooserActionPerformed(evt);

        try {
            price = Integer.parseInt(CarPriceField.getText());
            if (price < 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid price.");
                CarPriceField.setText(""); // Clear the field
                return;
            }
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., show error message)
            JOptionPane.showMessageDialog(null, "Please enter a valid price.");
            CarPriceField.setText(""); // Clear the field
            return;
        }

        try {
            carSeats = Integer.parseInt(CarSeatsField.getText());
            if (carSeats < 0) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number of seats.");
                CarSeatsField.setText(""); // Clear the field
                return;
            }
        } catch (NumberFormatException e) {
            // Handle invalid input (e.g., show error message)
            JOptionPane.showMessageDialog(null, "Please enter a valid number for seats.");
            CarSeatsField.setText(""); // Clear the field
        }

        if (!carName.isEmpty() && carSeats >= 0 && price >= 0 && carType != null){
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
        } else {
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
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

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {
        if (selectedFile != null) {
            image = selectedFile;
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
    private javax.swing.JMenuItem BookingMenu;
    private javax.swing.JLabel CarIdText;
    private javax.swing.JTextField CarNameField;
    private javax.swing.JTextField CarPriceField;
    private javax.swing.JTextField CarSeatsField;
    private javax.swing.JTable CarTable;
    private javax.swing.JComboBox<String> CarTypeComboBox;
    private javax.swing.JMenuItem ConfirmationMessageMenu;
    private javax.swing.JMenu FinanceButton;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JMenuItem PaymentManagementMenu;
    private javax.swing.JMenuItem SalesReportMenu;
    private javax.swing.JButton SaveButton;
    private javax.swing.JButton SelectButton;
    private javax.swing.JLabel TitleImage;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel imageField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
