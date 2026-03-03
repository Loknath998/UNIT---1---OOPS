import java.util.Scanner;

abstract class BankAccount {
    protected double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    abstract void performTransaction(double amount);
}

class DepositTransaction extends BankAccount {
    DepositTransaction(double balance) {
        super(balance);
    }

    void performTransaction(double amount) {
        balance += amount;
        System.out.println("Deposit Successful");
        System.out.println("Current Balance: " + balance);
    }
}

class WithdrawTransaction extends BankAccount {
    WithdrawTransaction(double balance) {
        super(balance);
    }

    void performTransaction(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful");
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}

class BalanceEnquiry extends BankAccount {
    BalanceEnquiry(double balance) {
        super(balance);
    }

    void performTransaction(double amount) {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter initial balance:");
        double currentBalance = sc.nextDouble();

        while (true) {
            System.out.println("\n--- Select Transaction ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Enquiry");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            BankAccount account = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dAmt = sc.nextDouble();
                    account = new DepositTransaction(currentBalance);
                    account.performTransaction(dAmt);
                    currentBalance = account.balance;
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wAmt = sc.nextDouble();
                    account = new WithdrawTransaction(currentBalance);
                    account.performTransaction(wAmt);
                    currentBalance = account.balance;
                    break;

                case 3:
                    account = new BalanceEnquiry(currentBalance);
                    account.performTransaction(0);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
