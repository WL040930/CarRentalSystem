/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package carrentalsystem;

public class CarRentalSystem {

    public static void main(String[] args) {

        // check if database exists
        FileCreation fileCreation = new FileCreation();
        fileCreation.userFile();
        fileCreation.carFile();
        fileCreation.bookingFile();
        fileCreation.returnFile();

        Login login = new Login();
        login.setVisible(true);
    }
}
