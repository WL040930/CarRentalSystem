package carrentalsystem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BookingPanel extends javax.swing.JPanel {

    private final Booking booking;
    private Return returnInfo;
    private final BookingConfirmation bookingConfirmation;
    private final UserPayment userPayment;
    private final CheckBooking checkBooking;
    private final ReturnCar returnCar;
    private static BookingPanel lastClickedPanel;

    public BookingPanel(Return returnobj, ReturnCar returnCar) {
        this.booking = null;
        this.returnInfo = returnobj;
        this.bookingConfirmation = null;
        this.userPayment = null;
        this.checkBooking = null;
        this.returnCar = returnCar;
        initComponents();
        displayReturnInfo();
        addClickListenerForReturn();
    }

    private void addClickListenerForReturn() {
        // Add mouse listener to handle click events
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle click event here
                handleReturnPanelClick();
            }
        });
    }

    private void handleReturnPanelClick() {
        returnCar.displayReturnDetails(returnInfo);
        if (returnCar.bookingId == returnInfo.getBookingId()) {
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

    private void displayReturnInfo() {
        int bookingId = returnInfo.getBookingId();
        int row = dataIO.rowNumber(bookingId, 1, dataIO.BOOKING_FILE, 9);
        String carId = dataIO.readData(row + 1, dataIO.BOOKING_FILE);  
        int rowOfCar = dataIO.rowNumber(carId, 1, dataIO.CAR_FILE, 7); 
        String carName = dataIO.readData(rowOfCar + 1, dataIO.CAR_FILE);
        String image = dataIO.readData(rowOfCar + 5, dataIO.CAR_FILE);

        String startDate = dataIO.readData(row + 3, dataIO.BOOKING_FILE);
        String endDate = dataIO.readData(row + 4, dataIO.BOOKING_FILE);  

        BookingIdField.setText(String.valueOf(bookingId));
        StartDateField.setText(startDate); 
        EndDateField.setText(endDate); 
        BookedCarField.setText(carName);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/carrentalsystem/img/" + image));
        Image scaledImage = imageIcon.getImage().getScaledInstance(87, 87, Image.SCALE_SMOOTH);
        pictureField.setIcon(new ImageIcon(scaledImage));

    }

    public BookingPanel(Booking booking, BookingConfirmation bookingConfirmation) {
        this.booking = booking;
        this.bookingConfirmation = bookingConfirmation; 
        this.userPayment = null;
        this.checkBooking = null;
        this.returnCar = null;
        initComponents();
        displayBookingInfo();
        addClickListener(); 
    }

    private void displayBookingInfo() {
        int bookingId = booking.getBookingId();
        int row = dataIO.rowNumber(bookingId, 1, dataIO.BOOKING_FILE, 9);
        String carId = dataIO.readData(row + 1, dataIO.BOOKING_FILE);  
        int rowOfCar = dataIO.rowNumber(carId, 1, dataIO.CAR_FILE, 7); 
        String carName = dataIO.readData(rowOfCar + 1, dataIO.CAR_FILE);
        String image = dataIO.readData(rowOfCar + 5, dataIO.CAR_FILE);

        BookingIdField.setText(String.valueOf(bookingId));
        StartDateField.setText(booking.getStartDate().toString()); // Convert LocalDate to String
        EndDateField.setText(booking.getEndDate().toString()); // Convert LocalDate to String
        BookedCarField.setText(carName);

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
                handleBookingPanelClick();

            }
        });
    }

    private void handleBookingPanelClick() {
        // Pass the booking information to BookingConfirmation
        bookingConfirmation.displayBookingDetails(booking);
        if (bookingConfirmation.bookingId == booking.getBookingId()) {
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
        bookingIDText.setForeground(color);
        BookingIdField.setForeground(color);
        BookedCarText.setForeground(color);
        BookedCarField.setForeground(color);
        StartDateText.setForeground(color);
        StartDateField.setForeground(color);
        EndDateText.setForeground(color);
        EndDateField.setForeground(color);
    }

    public BookingPanel(Booking booking, CheckBooking checkBooking, String status) {
        this.booking = booking;
        this.userPayment = null;
        this.bookingConfirmation = null;
        this.checkBooking = checkBooking;
        this.returnCar = null;
        initComponents();
        displayBookingInfo();
        addClickListeners();
    }

    private void addClickListeners() {
        // Add mouse listener to handle click events
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle click event here
                handleBookingPanelClicks();
            }
        });
    }

    private void handleBookingPanelClicks() {
        checkBooking.displayBookingDetails(booking);
        if (checkBooking.bookingId == booking.getBookingId()) {
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

    public BookingPanel(Booking booking, UserPayment userPayment) {
        this.booking = booking;
        this.userPayment = userPayment;
        this.bookingConfirmation = null;
        this.checkBooking = null;
        this.returnCar = null;
        initComponents();
        displayBookingInfo();
        addClickListenersForPayment();
    }

    private void addClickListenersForPayment() {
        // Add mouse listener to handle click events
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle click event here
                handlePaymentPanelClicks();
            }
        });
    }

    private void handlePaymentPanelClicks() {
        userPayment.displayBookingDetails(booking);
        if (userPayment.bookingid == booking.getBookingId()) {
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
        bookingIDText = new javax.swing.JLabel();
        BookingIdField = new javax.swing.JLabel();
        BookedCarText = new javax.swing.JLabel();
        BookedCarField = new javax.swing.JLabel();
        StartDateText = new javax.swing.JLabel();
        StartDateField = new javax.swing.JLabel();
        EndDateText = new javax.swing.JLabel();
        EndDateField = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pictureField.setText("");

        bookingIDText.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        bookingIDText.setText("Booking ID: ");

        BookingIdField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BookingIdField.setText("");

        BookedCarText.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        BookedCarText.setText("Booked Car:");

        BookedCarField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        BookedCarField.setText("");

        StartDateText.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        StartDateText.setText("Start Date: ");

        StartDateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        StartDateField.setText("");

        EndDateText.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        EndDateText.setText("End Date: ");

        EndDateField.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        EndDateField.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(pictureField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookingIDText)
                    .addComponent(BookedCarText)
                    .addComponent(StartDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndDateText))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BookingIdField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(BookedCarField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StartDateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EndDateField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookingIDText)
                    .addComponent(BookingIdField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BookedCarText)
                    .addComponent(BookedCarField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StartDateText)
                    .addComponent(StartDateField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EndDateText)
                    .addComponent(EndDateField))
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
                .addContainerGap(30, Short.MAX_VALUE))
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
    private javax.swing.JLabel BookedCarField;
    private javax.swing.JLabel BookedCarText;
    private javax.swing.JLabel BookingIdField;
    private javax.swing.JLabel EndDateField;
    private javax.swing.JLabel EndDateText;
    private javax.swing.JLabel StartDateField;
    private javax.swing.JLabel StartDateText;
    private javax.swing.JLabel bookingIDText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pictureField;
    // End of variables declaration//GEN-END:variables
}
