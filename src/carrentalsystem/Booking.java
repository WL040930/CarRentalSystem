/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.time.LocalDate;

public class Booking {

    /* Declaration of variables */
    private int bookingId;
    private int carId; 
    private String email; 
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; 
    private String paymentStatus;
    private String carPlate; 
    /* End of Declaration of variables */

    /*
    
        status can be defined in: 
        1. Pending - meaning that the user has send the booking requsts to the admin
        2. Waiting - meaning that the admin has sent the booking confirmation message to user
        3. Cancel - meaning that the admin has rejected the booking requests of user
        4. Accepted - meaning the user has accepted the booking confirmation message from admin 
        5. Rejected - meaning the user has rejected the booking cofirmation message from admin
    
    */

    /*
    
        paymentStatus can be defined in: 
        1. Paid - meaning that the user has paid the booking amount
        2. Pending - waiting for the admin to approve the payment
        3. Unpaid - meaning that the user has not paid the booking amount

    */

    /* Constructor */
    public Booking () {}

    public Booking (int bookingId, int carId, String email, LocalDate startDate, LocalDate endDate, String status, String paymentStatus) {
        this.bookingId = bookingId;
        this.carId = carId;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.paymentStatus = paymentStatus;
    }

    public Booking (int bookingId, int carId, String email, LocalDate startDate, LocalDate endDate, String status, String paymentStatus, String carPlate) {
        this.bookingId = bookingId;
        this.carId = carId;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.paymentStatus = paymentStatus;
        this.carPlate = carPlate;
    }
    /* End of Constructor */

    /* Getters */
    public int getBookingId() {
        return bookingId;
    }

    public int getCarId() {
        return carId;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getCarPlate() {
        return carPlate;
    }
    /* End of Getters */

    /* Setters */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }
    /* End of Setters */


}
