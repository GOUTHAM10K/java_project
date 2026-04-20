import java.util.*;

// Room Class
class Room {
    private int roomNumber;
    private boolean isBooked;
    private String customerName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
        this.customerName = "";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom(String name) {
        isBooked = true;
        customerName = name;
    }

    public void checkout() {
        isBooked = false;
        customerName = "";
    }

    public void display() {
        if (isBooked) {
            System.out.println("Room " + roomNumber + " - Booked by " + customerName);
        } else {
            System.out.println("Room " + roomNumber + " - Available");
        }
    }
}

// Hotel Class
class Hotel {
    private ArrayList<Room> rooms;

    public Hotel(int size) {
        rooms = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            rooms.add(new Room(i));
        }
    }

    public void showRooms() {
        for (Room r : rooms) {
            r.display();
        }
    }

    public void bookRoom(int roomNo, String name) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNo) {
                if (!r.isBooked()) {
                    r.bookRoom(name);
                    System.out.println("Room booked successfully!");
                } else {
                    System.out.println("Room already booked!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }

    public void checkoutRoom(int roomNo) {
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNo) {
                if (r.isBooked()) {
                    r.checkout();
                    System.out.println("Checked out successfully!");
                } else {
                    System.out.println("Room already free!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }
}

// Main Class
public class HotelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel(5);

        while (true) {
            System.out.println("\n===== HOTEL MENU =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Checkout Room");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    hotel.showRooms();
                    break;

                case 2:
                    System.out.print("Enter room number: ");
                    int rno = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    hotel.bookRoom(rno, name);
                    break;

                case 3:
                    System.out.print("Enter room number: ");
                    int cr = sc.nextInt();

                    hotel.checkoutRoom(cr);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
