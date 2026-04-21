import java.util.*;

class Account {
    int accNo;
    String name;
    double balance;

    Account(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: " + amt);
    }

    void withdraw(double amt) {
        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: " + amt);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void display() {
        System.out.println(accNo + " | " + name + " | Balance: " + balance);
    }
}

public class BankSystem {
    static ArrayList<Account> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        list.add(new Account(1, "Ram", 1000));

        while (true) {
            System.out.println("\n1.Deposit 2.Withdraw 3.View 4.Exit");
            int ch = sc.nextInt();

            Account acc = list.get(0);

            switch (ch) {
                case 1:
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                    break;
                case 3:
                    acc.display();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}