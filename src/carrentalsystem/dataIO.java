/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.UUID;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class dataIO {
    
    // calculate row number based on given data
    /*
     * User.txt - number of Lines = 5
     * 1 - Username
     * 2 - Email
     * 3 - Password
     * 4 - Role
    */
    /*
     * Car.txt - number of Lines = 7 
     * 1 - Car ID
     * 2 - Car Name
     * 3 - seats number
     * 4 - price 
     * 5 - Car type
     * 6 - image path
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

    public static int[] carID (int checkData ,String fileName, int NumberOfLines) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            int[] carID = new int[DatabaseManager.getTotalLines(fileName)/NumberOfLines];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % NumberOfLines == checkData) {
                    carID[lineNumber/NumberOfLines] = Integer.parseInt(line);
                }
                lineNumber++;
            }

            if (carID.length == 0) {
                carID = new int[1];
                carID[0] = 0; 
                return carID;
            }

            return carID;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

    public static void writeData(String data, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(data + "\n");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeData (int data, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(data + "\n");
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

    public static String moveFile(File sourceFile, String destinationDirectory) {
        String fileName = sourceFile.getName();
        String uniqueName = generateUniqueName(fileName);

        try {
            Path sourcePath = sourceFile.toPath();
            Path destinationPath = Path.of(destinationDirectory, uniqueName);

            Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            return uniqueName;
        } catch (IOException e) {
            System.err.println("Error moving file: " + e.getMessage());
            return null;
        }
    }

    static String generateUniqueName(String originalFileName) {
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueID = UUID.randomUUID().toString();
        return uniqueID + fileExtension;
    }

}
