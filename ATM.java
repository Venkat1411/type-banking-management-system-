import java.util.Scanner;
import java.util.InputMismatchException;

class ATM {
    // 1. ENCAPSULATION: private variables - data hiding
    private double balance;
    private int pin;
    private Scanner sc;

    // 2. CONSTRUCTOR: to initialize data
    public ATM() {
        this.balance = 1000.0; // opening balance
        this.pin = 1234;
        this.sc = new Scanner(System.in);
    }

    // 3. PIN VALIDATION with 3 attempts logic
    public boolean validatePin() {
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            try {
                int enteredPin = sc.nextInt();
                if (enteredPin == pin) {
                    System.out.println("PIN Verified Successfully!");
                    return true;
                } else {
                    attempts--;
                    System.out.println("Wrong PIN! Attempts left: " + attempts);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.next(); // clear wrong input
                attempts--;
            }
        }
        System.out.println("Card Blocked! Too many wrong attempts.");
        return false;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: Rs. " + balance);
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: ");
        try {
            double amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Invalid amount! Enter positive value.");
            } else {
                balance += amount;
                System.out.println("Rs. " + amount + " deposited. New Balance: " + balance);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount entered!");
            sc.next();
        }
    }

    public void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        try {
            double amount = sc.nextDouble();
            if (amount <= 0) {
                System.out.println("Invalid amount!");
            } else if (amount > balance) {
                System.out.println("Insufficient Balance! Your balance is: " + balance);
            } else {
                balance -= amount;
                System.out.println("Rs. " + amount + " withdrawn. Remaining: " + balance);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid amount entered!");
            sc.next();
        }
    }

    // Menu driven logic
    public void showMenu() {
        if (!validatePin()) return;

        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Choose option: ");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: checkBalance(); break;
                    case 2: deposit(); break;
                    case 3: withdraw(); break;
                    case 4: System.out.println("Thank you! Visit Again."); return;
                    default: System.out.println("Invalid Choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter valid option (1-4)");
                sc.next();
            }
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM(); // OBJECT creation
        atm.showMenu();
    }
}
