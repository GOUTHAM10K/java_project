import java.util.*;

// Base Class
class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }
}

// Customer Class
class Customer extends User {
    public Customer(String name) {
        super(name);
    }
}

// Driver Class
class Driver {
    private String name;
    private String car;
    private boolean available;

    public Driver(String name, String car) {
        this.name = name;
        this.car = car;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignRide() {
        available = false;
    }

    public void display() {
        System.out.println("Driver: " + name + ", Car: " + car);
    }
}

// Ride Class
class Ride {
    private Customer customer;
    private Driver driver;
    private double distance;
    private double fare;
    private int hour;

    public Ride(Customer customer, Driver driver, double distance, int hour) {
        this.customer = customer;
        this.driver = driver;
        this.distance = distance;
        this.hour = hour;
        this.fare = calculateFare();
    }

    private double calculateFare() {
        if (hour >= 22 || hour < 6) {
            return distance * 15; // Night pricing
        } else {
            return distance * 10; // Day pricing
        }
    }

    public void displayRide() {
        System.out.println("\n===== RIDE DETAILS =====");
        driver.display();
        System.out.println("Customer: " + customer.name);
        System.out.println("Distance: " + distance + " km");

        if (hour >= 22 || hour < 6) {
            System.out.println("Time: Night (Extra Charges Applied)");
        } else {
            System.out.println("Time: Day");
        }

        System.out.println("Total Fare: Rs." + fare);
    }
}

// Main Class
public class CabBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Drivers (only 5 available in shift)
        ArrayList<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Ravi", "Swift"));
        drivers.add(new Driver("Arjun", "i20"));
        drivers.add(new Driver("Kiran", "Innova"));
        drivers.add(new Driver("Rahul", "Dzire"));
        drivers.add(new Driver("Vijay", "Baleno"));

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        Customer customer = new Customer(name);

        int rideCount = 0;

        while (true) {

            if (rideCount >= 5) {
                System.out.println("\n❌ No drivers available (Shift completed)");
                break;
            }

            System.out.print("\nEnter distance (km): ");
            double distance = sc.nextDouble();

            System.out.print("Enter current hour (0-23): ");
            int hour = sc.nextInt();

            Driver assignedDriver = null;

            for (Driver d : drivers) {
                if (d.isAvailable()) {
                    assignedDriver = d;
                    d.assignRide();
                    break;
                }
            }

            if (assignedDriver != null) {
                Ride ride = new Ride(customer, assignedDriver, distance, hour);
                ride.displayRide();
                rideCount++;
            } else {
                System.out.println("No drivers available!");
            }

            System.out.print("\nDo you want to book another ride? (yes/no): ");
            sc.nextLine();
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        sc.close();
    }
}