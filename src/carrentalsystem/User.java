/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;

import java.io.File;
import java.util.Scanner;

public class User {

    /* Start of Attributes */
    private String name;
    private String email;
    private String password;
    private String role; 
    /* End of Attributes */



    /* Start of Constructor */
    public User() {}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    /* End of Constructor */



    /* Start of Getters */
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
    /* End of Getters */



    /* Start of Setters */
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
    /* End of Setters */



    /* Start of Methods */
    // function to validate the username 
    public static boolean validateUsername(String username) {
        return username.length() >= 6;
    }

    // function to validate the email
    public static boolean validateEmail (String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    // function to validate the password
    public static boolean validatePassword(String password) {
        return password.length() >= 8;
    }

    // function to check whether the email is unique
    public static boolean isEmailUnique(String email) {
        try (Scanner scanner = new Scanner(new File(dataIO.USER_FILE))) {
            int lineNumber = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (lineNumber % 5 == 2 && line.equals(email)) {
                    return false;
                }
                lineNumber++;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* End of Methods */
    // public static void main(String[] args) {
    //     System.out.println(isEmailUnique("admin"));
    // }


    /* Admin class inheritance */
    public class admin extends User {
        public admin(String name, String email, String password) {
            super(name, email, password);
        }

        public admin(String name, String email, String password, String role) {
            super(name, email, password, role);
        }

        public void setAdmin() {
            this.setRole("admin");
        }

    }
    /* End of admin class inheritance */


    /* Customer class inheritance */
    public class customer extends User {
        public customer(String name, String email, String password) {
            super(name, email, password);
        }

        public customer(String name, String email, String password, String role) {
            super(name, email, password, role);
        }

        public void setCustomer() {
            this.setRole("customer");
        }

    }

}
