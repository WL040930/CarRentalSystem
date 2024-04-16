/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.time.format.DateTimeFormatter;
import java.time.YearMonth;

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
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("MMMM, yyyy");
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

    public static String[] returnDate() {
        try (Scanner scanner = new Scanner(new File(dataIO.BOOKING_FILE))) {
            int lineNumber = 1;
            int linesPerRecord = 9;
            int recordCount = DatabaseManager.getTotalLines(dataIO.BOOKING_FILE) / linesPerRecord;

            String[] dates = new String[recordCount];
            int currentIndex = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % linesPerRecord == 4) {
                    dates[currentIndex++] = line;
                }
                lineNumber++;
            }

            if (currentIndex == 0) {
                return null; // No dates were read
            }

            // Trim the array to remove any null entries (if there are unused slots)
            return trimArray(dates, currentIndex);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Helper method to trim the array to the correct size
    private static String[] trimArray(String[] array, int size) {
        String[] trimmedArray = new String[size];
        System.arraycopy(array, 0, trimmedArray, 0, size);
        return trimmedArray;
    }

    public static String[] convertDates(String[] dateStrings) {
        if (dateStrings == null || dateStrings.length == 0) {
            return new String[0]; // Return an empty array if input is null or empty
        }

        Set<String> uniqueDates = new HashSet<>(); // Set to store unique formatted dates

        for (String dateString : dateStrings) {
            LocalDate date = LocalDate.parse(dateString, INPUT_FORMATTER);
            String formattedDate = date.format(OUTPUT_FORMATTER);
            uniqueDates.add(formattedDate); // Add formatted date to the set (automatically handles duplicates)
        }

        // Convert the set of unique dates back to an array
        String[] uniqueDatesArray = new String[uniqueDates.size()];
        uniqueDates.toArray(uniqueDatesArray);

        return uniqueDatesArray;
    }


    public static String[] convertDateRepeated(String[] dateStrings) {
        if (dateStrings == null || dateStrings.length == 0) {
            return new String[0]; // Return an empty array if input is null or empty
        }

        String[] convertedDates = new String[dateStrings.length];
        for (int i = 0; i < dateStrings.length; i++) {
            LocalDate date = LocalDate.parse(dateStrings[i], INPUT_FORMATTER);
            convertedDates[i] = date.format(OUTPUT_FORMATTER);
        }

        return convertedDates;
    }

    public static String returnFirstDay (String date) {
        // the date is given in format August, 2024
        String[] dateArray = date.split(", ");
        String month = dateArray[0];
        String year = dateArray[1];
        String firstDay = "1";
        String firstDate = firstDay + " " + month + " " + year;
        return firstDate;
    }

    public static String returnLastDay(String date) {
        // The date is given in format August, 2024
        String[] dateArray = date.split(", ");
        String month = dateArray[0];
        String year = dateArray[1];

        // Parse the month and year
        YearMonth yearMonth = YearMonth.parse(month + " " + year, DateTimeFormatter.ofPattern("MMMM yyyy"));

        // Get the last day of the month
        int lastDay = yearMonth.lengthOfMonth();

        // Format the last day as a string
        String lastDate = lastDay + " " + month + " " + year;
        return lastDate;
    }
    

}

