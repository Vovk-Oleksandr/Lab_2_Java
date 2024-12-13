// абстрактний клас Vehicle
abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;

    // конструктор для ініціалізації полів
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // абстрактні методи, які повинні реалізувати нащадки
    public abstract void start();
    public abstract void stop();
}

// інтерфейс Refuelable
interface Refuelable {
    void refuel();
}

// клас Car, наслідується від Vehicle та реалізує Refuelable
class Car extends Vehicle implements Refuelable {
    public Car(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void start() {
        System.out.println("Car " + make + " " + model + " is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Car " + make + " " + model + " has stopped.");
    }

    @Override
    public void refuel() {
        System.out.println("Car " + make + " " + model + " is being refueled.");
    }
}

// клас Bike, наслідується від Vehicle
class Bike extends Vehicle {
    public Bike(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void start() {
        System.out.println("Bike " + make + " " + model + " is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Bike " + make + " " + model + " has stopped.");
    }
}

// клас Truck, наслідується від Vehicle та реалізує Refuelable
class Truck extends Vehicle implements Refuelable {
    public Truck(String make, String model, int year) {
        super(make, model, year);
    }

    @Override
    public void start() {
        System.out.println("Truck " + make + " " + model + " is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Truck " + make + " " + model + " has stopped.");
    }

    @Override
    public void refuel() {
        System.out.println("Truck " + make + " " + model + " is being refueled.");
    }
}

// основний клас програми
public class MainOne {
    public static void main(String[] args) {
        // створюємо об'єкти транспортних засобів
        Vehicle car = new Car("Toyota", "Corolla", 2020);
        Vehicle bike = new Bike("Yamaha", "MT-07", 2019);
        Vehicle truck = new Truck("Volvo", "FH16", 2021);

        // виконуємо дії з кожним транспортним засобом
        car.start();
        car.stop();
        if (car instanceof Refuelable) {
            ((Refuelable) car).refuel();
        }

        bike.start();
        bike.stop();

        truck.start();
        truck.stop();
        if (truck instanceof Refuelable) {
            ((Refuelable) truck).refuel();
        }
    }
}
