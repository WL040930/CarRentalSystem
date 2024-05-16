/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

public class Return {
    
    private int bookingId;
    private String returnStatus; 
    private String returnDate;

    public Return() {
    }

    public Return(int bookingId, String returnStatus, String returnDate) {
        this.bookingId = bookingId;
        this.returnStatus = returnStatus;
        this.returnDate = returnDate;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

}
