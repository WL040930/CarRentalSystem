/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package carrentalsystem;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarPanel extends javax.swing.JPanel {

    int carId; 
    private final Car car; 
    private final ViewCar viewCar;
    private static CarPanel lastClickedPanel;

    public CarPanel(Car car, ViewCar viewCar) {
        this.car = car;
        this.viewCar = viewCar;
        initComponents();
        displayCarInfo();
        addClickListener(); 
    }

    private void displayCarInfo() {
        carId = car.getCarID();
        int row = dataIO.rowNumber(carId, 1, dataIO.CAR_FILE, 7);
        String carName = dataIO.readData(row + 1, dataIO.CAR_FILE);
        String carSeats = dataIO.readData(row + 2, dataIO.CAR_FILE);
        String carPrice = dataIO.readData(row + 3, dataIO.CAR_FILE);
        String carType = dataIO.readData(row + 4, dataIO.CAR_FILE);
        String image = dataIO.readData(row + 5, dataIO.CAR_FILE);
        
        CarNameField.setText(carName);
        CarSeatsField.setText(carSeats);
        CarPriceField.setText(carPrice);
        CarTypeField.setText(carType);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/" + image));
        Image scaledImage = imageIcon.getImage().getScaledInstance(87, 87, Image.SCALE_SMOOTH);
        pictureField.setIcon(new ImageIcon(scaledImage));
    }

    private void addClickListener() {
        // Add mouse listener to handle click events
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle click event here
                handleCarPanelClick();

            }
        });
    }

    private void handleCarPanelClick() {
        // Pass the booking information to BookingConfirmation
        viewCar.displayCarInfo(car);
        if (viewCar.carId == car.getCarID()) {
            setBackground(Color.LIGHT_GRAY);
            jPanel1.setBackground(new Color(6, 26, 35));
            setTextColor(Color.WHITE);
            if (lastClickedPanel != null && lastClickedPanel != this) {
                lastClickedPanel.setBackground(Color.WHITE); 
                lastClickedPanel.jPanel1.setBackground(new Color(242,242,242));
                lastClickedPanel.setTextColor(Color.BLACK);
            }

            lastClickedPanel = this;
        }
    }

    private void setTextColor(Color color) {
        CarNameText.setForeground(color);
        CarNameField.setForeground(color);
        CarPriceText.setForeground(color);
        CarPriceField.setForeground(color);
        CarSeatsText.setForeground(color);
        CarSeatsField.setForeground(color);
        CarTypeText.setForeground(color);
        CarTypeField.setForeground(color);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pictureField = new javax.swing.JLabel();
        CarNameText = new javax.swing.JLabel();
        CarNameField = new javax.swing.JLabel();
        CarPriceText = new javax.swing.JLabel();
        CarPriceField = new javax.swing.JLabel();
        CarSeatsText = new javax.swing.JLabel();
        CarSeatsField = new javax.swing.JLabel();
        CarTypeText = new javax.swing.JLabel();
        CarTypeField = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pictureField.setText("");

        CarNameText.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        CarNameText.setText("Car Name");

        CarNameField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CarNameField.setText("");

        CarPriceText.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        CarPriceText.setText("Car Price:");

        CarPriceField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CarPriceField.setText("");

        CarSeatsText.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        CarSeatsText.setText("Car Seats");

        CarSeatsField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CarSeatsField.setText("");

        CarTypeText.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        CarTypeText.setText("Car Type:");

        CarTypeField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        CarTypeField.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(pictureField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CarNameText)
                    .addComponent(CarPriceText)
                    .addComponent(CarSeatsText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CarTypeText))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CarNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(CarPriceField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CarSeatsField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CarTypeField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarNameText)
                    .addComponent(CarNameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarPriceText)
                    .addComponent(CarPriceField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarSeatsText)
                    .addComponent(CarSeatsField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarTypeText)
                    .addComponent(CarTypeField))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarNameField;
    private javax.swing.JLabel CarNameText;
    private javax.swing.JLabel CarPriceField;
    private javax.swing.JLabel CarPriceText;
    private javax.swing.JLabel CarSeatsField;
    private javax.swing.JLabel CarSeatsText;
    private javax.swing.JLabel CarTypeField;
    private javax.swing.JLabel CarTypeText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pictureField;
    // End of variables declaration//GEN-END:variables

}
