public class Car {

    // class instance variables
    private int yearOfProduction;
    private String brandName;
    private String registrationPlate;
    private String color;


    // 1st usage: This is used to refer to current class instance variable
    Car( int yearOfProduction, String brandName, String registrationPlate, String color) {

        this.yearOfProduction = yearOfProduction;
        this.brandName = brandName;
        this.registrationPlate = registrationPlate;
        this.color = color;

    }



    public void printCar() {
        this.printYear();
        this.printBrand();
        this.printReg();
        this.printColor();
    }

    // 2nd usage: to invoke the current class method
    // Compiler does this automatically

    public void printYear() {
        System.out.println("Year of production: " + yearOfProduction);
    }

    public void printBrand() {
        System.out.println("Brand name: " + brandName);

    }

    public void printReg() {
        System.out.println("Registration Plate: " + registrationPlate);

    }

    public void printColor() {
        System.out.println("Color: " + color);

    }

    // 3rd usage: to invoke the current class constructor

    Car(String registrationPlate) {
        this.registrationPlate = registrationPlate;
    }

    Car(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    Car(String registrationPlate, int yearOfProduction) {

    }

    Car(String color, int yearOfProduction, String brandName) {

    }

    Car(int yearOfProduction,String brandName, String registrationPlate) {
        this(registrationPlate);
        this.yearOfProduction = yearOfProduction;
        this.brandName = brandName;

    }


    // 4th usage: This keyword can be passed as a method argument

    // this method was called upon 'thirdCar'
    public void printCarThatIsUsingThisMethod() {
        printThisCar(this);
        // printThisCar(thirdCar);
    }

    public void printThisCar(Car car) {
        System.out.println("Year of production: " + car.yearOfProduction);
        System.out.println("Brand name: " + car.brandName);
        System.out.println("Registration plates: " + car.registrationPlate);
        System.out.println("Color: " + car.color);
    }

    // 5th usage: this can be passed inside of a constructor

    Car() {
        this.yearOfProduction = 20202020;
        // in here, we sent the fourthCar
        Car newCar = new Car(this);
    }

    public Car(Car car) {
        this.yearOfProduction = car.yearOfProduction;
        System.out.println("New car year of production!");
        car.printYear();
    }


    // 6th usage: return current class instance variable


    Car getCar() {
        return this;
    }

    public void printInstance() {
        System.out.println(this);
    }








    public static void main(String[] args) {
        Car car = new Car(1999, "BMW","DB3903", "BLUE");
        car.printCar();

        System.out.println(); // new line

        Car secondCar = new Car(2000,"Mercedes","HY5502");
        secondCar.printCar();

        System.out.println(); // new line

        Car thirdCar = new Car(2020,"Tesla","BB1234", "YELLOW");
        thirdCar.printCarThatIsUsingThisMethod();
        thirdCar.printThisCar(thirdCar);

        System.out.println(); // new line

        Car fourthCar = new Car();

        System.out.println(); // new line

        Car fifthCar = new Car(2019,"Volvo", "BY1230","RED");
        System.out.println(fifthCar.getCar());
        fifthCar.printInstance();

        fifthCar.printCar();
        fifthCar.getCar().printCar();


    }
}
