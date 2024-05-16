/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.io.File;
import java.io.IOException;

public class FileCreation {

    public void userFile() {
        // Create a new text file called "Car.txt"
        String filePath = "src/carrentalsystem/data/Booking.txt";
        File file = new File(filePath);
        
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public void carFile() {
        // Create a new text file called "Car.txt"
        String filePath = "src/carrentalsystem/data/Car.txt";
        File file = new File(filePath);
        
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public void bookingFile() {
        // Create a new text file called "Car.txt"
        String filePath = "src/carrentalsystem/data/Booking.txt";
        File file = new File(filePath);

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public void returnFile() {
        // Create a new text file called "Car.txt"
        String filePath = "src/carrentalsystem/data/Return.txt";
        File file = new File(filePath);

        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

}
