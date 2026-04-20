import java.util.*;

// Student Class
class Student {
    private int id;
    private String name;
    private int totalClasses;
    private int attendedClasses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    public int getId() {
        return id;
    }

    public void markAttendance(boolean present) {
        totalClasses++;
        if (present) {
            attendedClasses++;
        }
    }

    public double getPercentage() {
        if (totalClasses == 0) return 0;
        return (attendedClasses * 100.0) / totalClasses;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name);
        System.out.println("Attendance: " + attendedClasses + "/" + totalClasses);
        System.out.printf("Percentage: %.2f%%\n", getPercentage());

        if (getPercentage() < 75) {
            System.out.println("⚠️ Shortage of Attendance!");
        } else {
            System.out.println("✅ Attendance OK");
        }
        System.out.println("------------------------");
    }
}

// Main Class
public class AttendanceSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n===== ATTENDANCE MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    students.add(new Student(id, name));
                    System.out.println("Student added!");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }

                    for (Student s : students) {
                        System.out.print("Is " + s.getId() + " present? (1-Yes / 0-No): ");
                        int p = sc.nextInt();
                        s.markAttendance(p == 1);
                    }
                    System.out.println("Attendance marked!");
                    break;

                case 3:
                    if (students.isEmpty()) {
                        System.out.println("No data available.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
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
