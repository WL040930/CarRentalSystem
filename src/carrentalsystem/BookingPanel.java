package carrentalsystem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookingPanel extends JPanel {

    private final Booking booking;
    private final BookingConfirmation bookingConfirmation;

    public BookingPanel(Booking booking, BookingConfirmation bookingConfirmation) {
        this.booking = booking;
        this.bookingConfirmation = bookingConfirmation; // Reference to the BookingConfirmation instance
        initComponents();
        displayBookingInfo();
        addClickListener(); // Add click listener to handle mouse clicks
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
        JLabel carPlateLabel = new JLabel("Car Plate: " + booking.getCarPlate());

        // Add components to the vertical group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(bookingIdLabel)
                        .addComponent(customerNameLabel)
                        .addComponent(carModelLabel)
                        .addComponent(carPlateLabel)
        );

        // Add components to the horizontal group
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(bookingIdLabel)
                        .addComponent(customerNameLabel)
                        .addComponent(carModelLabel)
                        .addComponent(carPlateLabel)
        );
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
    }
}
