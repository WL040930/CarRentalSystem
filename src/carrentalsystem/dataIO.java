/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class dataIO {
    
    // read user data from User.txt
    /*
     * The number parameter is used to determine which line to read from the User.txt file.
     * 1 - Username
     * 2 - Email
     * 3 - Password
     * 4 - Role
    */
    public static String readUserDetails(int number, String fileName, int numberOfLines) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % numberOfLines == number) {
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

    // calculate row number based on given data
    /*
     * 1 - Username
     * 2 - Email
     * 3 - Password
     * 4 - Role
    */
    public static int rowNumber (String data, int checkData, String fileName, int numberOfLines) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % numberOfLines == checkData && line.equals(data)) {
                    return lineNumber;
                }
                lineNumber++;
            }
            return -1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Read data based on row number 
    public static String readData(int rNumber, String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber == rNumber) {
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

    // write data in text file
    public static void writeData(String[] array, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            for (String data : array) {
                fileWriter.write(data + "\n");
            }
            fileWriter.write("\n");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // overwrite a data in text file
    public static void overWriteData(String data, int rowNumber, String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            StringBuilder updatedContent = new StringBuilder(); // To hold updated file content
    
            // Read each line from the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
    
                if (lineNumber == rowNumber) {
                    // Replace the line with new data
                    updatedContent.append(data).append("\n"); // Append new data with a newline
                } else {
                    // Keep the existing line
                    updatedContent.append(line).append("\n"); // Append the existing line with a newline
                }
    
                lineNumber++; // Increment line number
            }
    
            // Write updated content back to the file
            try (FileWriter fileWriter = new FileWriter(fileName)) {
                fileWriter.write(updatedContent.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public static void main(String[] args) {
    //     overWriteData("adminusername", 1, "User.txt");
    // }
}
