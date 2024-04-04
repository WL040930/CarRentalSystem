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
    /*
     * The number parameter is used to determine which line to read from the User.txt file.
     * 1 - Username
     * 2 - Email
     * 3 - Password
     * 4 - Role
    */
    public static String readUserDetails(int number) {
        try (Scanner scanner = new Scanner(new File("User.txt"))) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % 5 == number) {
                    return line;
                }
                lineNumber++;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // find data depending on the email (For login purpose)
     

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
