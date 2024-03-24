import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            System.out.println("Invalid amount for deposit.");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount for withdrawal.");
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double amount) {
        if (bankAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.checkBalance());
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    public void deposit(double amount) {
        if (bankAccount.deposit(amount)) {
            System.out.println("Deposit successful. New balance: " + bankAccount.checkBalance());
        } else {
            System.out.println("Deposit failed.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + bankAccount.checkBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        ATM atm = new ATM(bankAccount);

        Scanner scanner = new Scanner(System.in);
        char choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case '2':
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case '3':
                    atm.checkBalance();
                    break;
                case '4':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != '4');

        scanner.close();
    }
}

