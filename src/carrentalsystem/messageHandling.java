/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import javax.swing.JOptionPane;

public class messageHandling {
    
    public static void errorUsername() {
        JOptionPane.showMessageDialog(null, "Username must be at least 6 characters", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void errorPassword() {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void errorEmail() {
        JOptionPane.showMessageDialog(null, "Invalid email", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void repeatedEmail() {
        JOptionPane.showMessageDialog(null, "Email already exists", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectPassword() {
        JOptionPane.showMessageDialog(null, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectPrice() {
        JOptionPane.showMessageDialog(null, "Price must be a number", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectSeats() {
        JOptionPane.showMessageDialog(null, "Seats must be a number", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void emptyCarName() {
        JOptionPane.showMessageDialog(null, "Car name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
    }   

    public static void incorrectImage() {
        JOptionPane.showMessageDialog(null, "Image must be a .jpg file/.png file/.jpeg file", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void incorrectDataFormat() {
        JOptionPane.showMessageDialog(null, "Incorrect data format for price/seats number (only digit number is allowed.)", "Error", JOptionPane.ERROR_MESSAGE);
    
    }

    public static void incompletedData() {
        JOptionPane.showMessageDialog(null, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
