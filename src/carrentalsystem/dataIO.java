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
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;

public class dataIO {

    final static String BOOKING_FILE = "src/carrentalsystem/data/Booking.txt";
    final static String CAR_FILE = "src/carrentalsystem/data/Car.txt";
    final static String USER_FILE = "src/carrentalsystem/data/User.txt";
    final static String RETURN_FILE = "src/carrentalsystem/data/Return.txt";

    public static String GET_USER_FILE() {
        return USER_FILE;
    }

    public static String GET_CAR_FILE() {
        return CAR_FILE;
    }

    public static String GET_BOOKING_FILE() {
        return BOOKING_FILE;
    }

    public static String GET_RETURN_FILE() {
        return RETURN_FILE;
    }
    
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
    /*
     * Booking.txt - number of Lines = 9
     * 1 - Booking ID
     * 2 - Car ID
     * 3 - Email 
     * 4 - Start Date
     * 5 - End Date
     * 6 - Status
     * 7 - Payment Status 
     * 8 - car plate
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

    public static int rowNumber (int data, int checkData, String fileName, int numberOfLines) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % numberOfLines == checkData && Integer.parseInt(line) == data) {
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

    public static int[] bookingId (int checkData ,String fileName, int NumberOfLines) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            int[] bookingID = new int[DatabaseManager.getTotalLines(fileName)/NumberOfLines];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % NumberOfLines == checkData) {
                    bookingID[lineNumber/NumberOfLines] = Integer.parseInt(line);
                }
                lineNumber++;
            }

            if (bookingID.length == 0) {
                bookingID = new int[1];
                bookingID[0] = 0; 
                return bookingID;
            }

            return bookingID;
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

    public static LocalDate readDate(int rNumber, String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber == rNumber) {
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    return LocalDate.parse(line, dateFormatter);
                }
                lineNumber++;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
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

    public static void writeData (LocalDate date, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(date + "\n");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeData (Date data, String fileName) {
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

    public static void overWriteData(int data, int rowNumber, String fileName) {
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

    private static int returnNumberOfType(String type, String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            int count = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % 7 == 5 && line.equals(type)) {
                    count++;
                }
                lineNumber++;
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int[] returnCarId (String type, String fileName) {
        int length = returnNumberOfType(type, fileName);
        if (length == 0) {
            return null;
        }
        int[] carID = new int[length];
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lineNumber = 1;
            int index = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % 7 == 5 && line.equals(type)) {
                    carID[index] = Integer.parseInt(readData(lineNumber - 4, fileName));
                    index++;
                }
                lineNumber++;
            }
            return carID;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void deleteRow(int rowNumber, String fileName) {
        try {
            File inputFile = new File(fileName);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            int lineNumber = 1;

            while ((currentLine = reader.readLine()) != null) {
                if (lineNumber != rowNumber) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
                lineNumber++;
            }

            writer.close();
            reader.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
