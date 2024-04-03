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

}
