package carrentalsystem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BookingPanel extends JPanel {

    private final Booking booking;

    public BookingPanel(Booking booking) {
        this.booking = booking;
        initComponents();
        displayBookingInfo();
    }

    private void initComponents() {
        // Set preferred size for the panel
        this.setPreferredSize(new Dimension(400, 120));

        // Set background color
        this.setBackground(Color.white);

        // Create a custom border with padding and margins
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10), // Outer padding (top, left, bottom, right)
                BorderFactory.createLineBorder(Color.black)        // Inner border color
        );
        this.setBorder(border);

        // Set layout for the panel
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
    }

    private void displayBookingInfo() {
        GroupLayout layout = (GroupLayout) this.getLayout();

        // Add booking information labels
        JLabel bookingIdLabel = new JLabel("Booking ID: " + booking.getBookingId());
        JLabel customerNameLabel = new JLabel("Customer Name: " + booking.getEmail());
        JLabel carModelLabel = new JLabel("Car Model: " + booking.getCarId());
        JLabel startDateLabel = new JLabel("Start Date: " + booking.getStartDate());
        JLabel endDateLabel = new JLabel("End Date: " + booking.getEndDate());

        // Add components to the horizontal group
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(bookingIdLabel)
                                .addComponent(customerNameLabel)
                                .addComponent(carModelLabel)
                                .addComponent(startDateLabel)
                                .addComponent(endDateLabel))
        );

        // Add components to the vertical group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(bookingIdLabel)
                        .addComponent(customerNameLabel)
                        .addComponent(carModelLabel)
                        .addComponent(startDateLabel)
                        .addComponent(endDateLabel)
        );
    }
}
