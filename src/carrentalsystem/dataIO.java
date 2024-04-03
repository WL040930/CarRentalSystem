/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class dataIO {
    
    /* User.txt */
    // read user data from User.txt
    public static void readUser() {
        try {
            File file = new File("User.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // write user data to User.txt
    public static void writeUser(String[] array) {
        try {
            FileWriter fileWriter = new FileWriter("User.txt");
            for (String data : array) {
                fileWriter.write(data + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /* End of User.txt */
}
