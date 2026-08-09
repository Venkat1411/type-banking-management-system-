import java.util.Scanner;

public class ATM {
    private double balance = 5000;
    private int pin = 1234;
    Scanner sc = new Scanner(System.in);

    public void checkPin() {
        System.out.print("Enter your PIN: ");
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            showMenu();
        } else {
            System.out.println("Wrong PIN! Access Denied.");
        }
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Welcome to ATM ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: checkBalance(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: System.out.println("Thank you! Visit Again."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println("Your Balance is: Rs. " + balance);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Rs. " + amount + " Deposited Successfully");
            checkBalance();
        } else {
            System.out.println("Invalid Amount");
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient Balance!");
        } else if (amount <= 0) {
            System.out.println("Invalid Amount");
        } else {
            balance = balance - amount;
            System.out.println("Rs. " + amount + " Withdrawn Successfully");
            checkBalance();
        }
    }

    public static void main(String[] args) {
        ATM atmObject = new ATM();
        atmObject.checkPin();
    }
}
