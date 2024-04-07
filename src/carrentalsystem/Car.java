/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrentalsystem;


public class Car {

    /* Declaration of variables */
    private String carID;
    private String carName;
    private int seatsNumber;
    private String carType; 
    private int price; 
    /* End of declaration of variables */
    

    /* Constructor */
    public Car() {

    }

    public Car(String carName, int seatsNumber, String carType, int price) {
        this.carName = carName;
        this.seatsNumber = seatsNumber;
        this.carType = carType;
        this.price = price;
    }

    public Car(String carID, String carName, int seatsNumber, String carType, int price) {
        this.carID = carID;
        this.carName = carName;
        this.seatsNumber = seatsNumber;
        this.carType = carType;
        this.price = price;
    }
    /* End of Constructor */


    /* Getters */
    public String getCarID() {
        return carID;
    }

    public String getCarName() {
        return carName;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public String getCarType() {
        return carType;
    }

    public int getPrice() {
        return price;
    }
    /* End of Getters */


    /* Setters */
    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    /* End of Setters */


    public static boolean validatePrice(int price) {
        return price > 0;
    }

    public static boolean validateSeatsNumber(int seatsNumber) {
        return seatsNumber > 0;
    }

    /* Economy car */
    public class EconomyCar extends Car {
        public EconomyCar() {
            super();
        }

        public EconomyCar(String carName, int seatsNumber, String carType, int price) {
            super(carName, seatsNumber, carType, price);
        }

        public EconomyCar(String carID, String carName, int seatsNumber, String carType, int price) {
            super(carID, carName, seatsNumber, carType, price);
        }

        public void setCarType() {
            super.setCarType("Economy");
        }
    }

    public class CompactCar extends Car {
        public CompactCar() {
            super();
        }

        public CompactCar(String carName, int seatsNumber, String carType, int price) {
            super(carName, seatsNumber, carType, price);
        }

        public CompactCar(String carID, String carName, int seatsNumber, String carType, int price) {
            super(carID, carName, seatsNumber, carType, price);
        }

        public void setCarType() {
            super.setCarType("Compact");
        }
    }


    public class LuxuryCar extends Car {
        public LuxuryCar() {
            super();
        }

        public LuxuryCar(String carName, int seatsNumber, String carType, int price) {
            super(carName, seatsNumber, carType, price);
        }

        public LuxuryCar(String carID, String carName, int seatsNumber, String carType, int price) {
            super(carID, carName, seatsNumber, carType, price);
        }

        public void setCarType() {
            super.setCarType("Luxury");
        }
    }


    public class Vans extends Car {
        public Vans() {
            super();
        }

        public Vans(String carName, int seatsNumber, String carType, int price) {
            super(carName, seatsNumber, carType, price);
        }

        public Vans(String carID, String carName, int seatsNumber, String carType, int price) {
            super(carID, carName, seatsNumber, carType, price);
        }

        public void setCarType() {
            super.setCarType("Vans");
        }
    }
    
}
