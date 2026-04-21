import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManagement {

    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        list.add(new Student(id, name, marks));
        System.out.println("✅ Student added!");
    }

    // Delete Student
    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                list.remove(i);
                found = true;
                System.out.println("✅ Student deleted!");
                break;
            }
        }

        if (!found) {
            System.out.println("❌ Student not found!");
        }
    }

    // Search Student
    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.id == id) {
                System.out.println("Found: " + s.name + " | Marks: " + s.marks);
                return;
            }
        }

        System.out.println("❌ Student not found!");
    }

    // Sort by Marks
    static void sortStudents() {
        list.sort((a, b) -> b.marks - a.marks);

        System.out.println("\n--- Sorted Students (High to Low) ---");
        for (Student s : list) {
            System.out.println(s.id + " | " + s.name + " | " + s.marks);
        }
    }

    // View All Students
    static void viewStudents() {
        if (list.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\n--- Student List ---");
        for (Student s : list) {
            System.out.println(s.id + " | " + s.name + " | " + s.marks);
        }
    }

    // Main Menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Sort by Marks");
            System.out.println("5. View Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    sortStudents();
                    break;
                case 5:
                    viewStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}