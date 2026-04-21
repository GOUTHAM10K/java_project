import java.util.*;

class Passenger {
    int seatNo;
    String name;

    Passenger(int seatNo, String name) {
        this.seatNo = seatNo;
        this.name = name;
    }
}

public class RailwayReservation {

    static final int TOTAL_SEATS = 5;
    static ArrayList<Passenger> bookedList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Book Ticket
    public static void bookTicket() {
        if (bookedList.size() >= TOTAL_SEATS) {
            System.out.println("❌ No seats available!");
            return;
        }

        System.out.print("Enter passenger name: ");
        String name = sc.next();

        int seatNo = bookedList.size() + 1;
        bookedList.add(new Passenger(seatNo, name));

        System.out.println("✅ Ticket booked successfully!");
        System.out.println("Seat No: " + seatNo + " | Name: " + name);
    }

    // Cancel Ticket
    public static void cancelTicket() {
        System.out.print("Enter seat number to cancel: ");
        int seat = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < bookedList.size(); i++) {
            if (bookedList.get(i).seatNo == seat) {
                bookedList.remove(i);
                found = true;
                System.out.println("✅ Ticket cancelled successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Invalid seat number!");
        }

        // Reassign seat numbers
        for (int i = 0; i < bookedList.size(); i++) {
            bookedList.get(i).seatNo = i + 1;
        }
    }

    // View Seats
    public static void viewSeats() {
        System.out.println("\n--- Seat Status ---");

        if (bookedList.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Passenger p : bookedList) {
                System.out.println("Seat " + p.seatNo + " -> " + p.name);
            }
        }

        System.out.println("Available Seats: " + (TOTAL_SEATS - bookedList.size()));
    }

    // Main Menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Railway Reservation System =====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Seats");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    viewSeats();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}
