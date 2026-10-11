import java.util.Scanner;

class Account {

    private String name;
    private String accountNo;
    private double balance;

    static int accountCount = 0;
    final double MIN_BALANCE = 500;

    Account(String name, String accountNo, double balance) {
        this.name = name;
        this.accountNo = accountNo;
        this.balance = balance;
        accountCount++;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Amount deposited: " + amount);
    }

    // Method overloading
    void deposit(double amount, String type) {
        balance = balance + amount;
        System.out.println(type + " deposit: " + amount);
    }

    void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            balance = balance - amount;
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Cannot withdraw.");
            System.out.println("Minimum balance should be Rs. " + MIN_BALANCE);
        }
    }

    void showBalance() {
        System.out.println("Current Balance: Rs. " + balance);
    }

    void showDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Name: " + name);
        System.out.println("Account No: " + accountNo);
        System.out.println("Balance: Rs. " + balance);
    }
}

public class BankAccount {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        String no = sc.next();

        System.out.print("Enter opening balance: ");
        double balance = sc.nextDouble();

        Account a = new Account(name, no, balance);

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        a.deposit(amount);

        System.out.print("Enter amount to withdraw: ");
        amount = sc.nextDouble();
        a.withdraw(amount);

        a.showBalance();
        a.showDetails();

        System.out.println("Total accounts created: " + Account.accountCount);

        sc.close();
    }
}