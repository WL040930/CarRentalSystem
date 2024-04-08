/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static final String USER_FILE = "src/carrentalsystem/data/User.txt";
    private static final int NUMBER_OF_LINES_PER_USER = 5;

    private static final String CAR_FILE = "src/carrentalsystem/data/Car.txt";
    private static final int NUMBER_OF_LINES_PER_CAR = 7;

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
    
        try {
            int totalLines = getTotalLines(USER_FILE);
            int numberOfUsers = totalLines / NUMBER_OF_LINES_PER_USER;
    
            for (int i = 0; i < numberOfUsers; i++) {
                int lineNumber = i * NUMBER_OF_LINES_PER_USER + 1; // Start line number for current user
                String name = dataIO.readData(lineNumber, USER_FILE);
                String email = dataIO.readData(lineNumber + 1, USER_FILE);
                String password = dataIO.readData(lineNumber + 2, USER_FILE);
                String role = dataIO.readData(lineNumber + 3, USER_FILE);
    
                User user;
                if (role.equals("admin")) {
                    user = new User().new admin(name, email, password, role); 
                } else {
                    user = new User().new customer(name, email, password, role);
                }
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return users;
    }

    public static List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
    
        try {
            int totalLines = getTotalLines(CAR_FILE);
            int numberOfCars = totalLines / NUMBER_OF_LINES_PER_CAR;
    
            for (int i = 0; i < numberOfCars; i++) {
                int lineNumber = i * NUMBER_OF_LINES_PER_CAR + 1; // Start line number for current car
                
                int carID = Integer.parseInt(dataIO.readData(lineNumber, CAR_FILE));
                String carName = dataIO.readData(lineNumber + 1, CAR_FILE);
                int seats = Integer.parseInt(dataIO.readData(lineNumber + 2, CAR_FILE));
                int price = Integer.parseInt(dataIO.readData(lineNumber + 3, CAR_FILE));
                String carType = dataIO.readData(lineNumber + 4, CAR_FILE);
    
                Car car = new Car(carID, carName, seats, carType, price);
                cars.add(car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static List<Car> getSpecificCarsType(String Type) {
        List<Car> cars = new ArrayList<>();
    
        try {
            int totalLines = getTotalLines(CAR_FILE);
            int numberOfCars = totalLines / NUMBER_OF_LINES_PER_CAR;
    
            for (int i = 0; i < numberOfCars; i++) {
                int lineNumber = i * NUMBER_OF_LINES_PER_CAR + 1; // Start line number for current car
                
                int carID = Integer.parseInt(dataIO.readData(lineNumber, CAR_FILE));
                String carName = dataIO.readData(lineNumber + 1, CAR_FILE);
                int seats = Integer.parseInt(dataIO.readData(lineNumber + 2, CAR_FILE));
                int price = Integer.parseInt(dataIO.readData(lineNumber + 3, CAR_FILE));
                String carType = dataIO.readData(lineNumber + 4, CAR_FILE);
    
                if (carType.equals(Type)) {
                    Car car = new Car(carID, carName, seats, carType, price);
                    cars.add(car);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

    public static int getTotalLines(String fileName) {
        int totalLines = 0;
        try {
            java.io.FileReader fr = new java.io.FileReader(fileName);
            java.io.LineNumberReader lnr = new java.io.LineNumberReader(fr);
            while (lnr.readLine() != null) {
                totalLines++;
            }
            lnr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return totalLines;
    }

}
