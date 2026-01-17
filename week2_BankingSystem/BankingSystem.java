import java.io.*;
import java.util.*;

public class BankingSystem {

    /* ACCOUNT CLASS */
    static class Account implements Serializable {
        protected int accountNumber;
        protected String accountHolder;
        protected double balance;

        public Account(int accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance = balance + amount;
        }

        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance = balance - amount;
                return true;
            }
            return false;
        }

        public void display() {
            System.out.println("Account Number : " + accountNumber);
            System.out.println("Account Holder : " + accountHolder);
            System.out.println("Balance        : " + balance);
        }
    }

    /* SAVINGS ACCOUNT CLASS USING INHERITANCE */
    static class SavingsAccount extends Account {

        public SavingsAccount(int accountNumber, String accountHolder, double balance) {
            super(accountNumber, accountHolder, balance);
        }

        public void addInterest() {
            balance = balance + (balance * 0.04);
        }
    }

    /* MAIN BANKING LOGIC */
    static final String FILE_NAME = "accounts.dat";
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = loadAccounts();

    public static void main(String[] args) {

        while (true) {
            System.out.println("BANK MENU");
            System.out.println("1 Create Account");
            System.out.println("2 Deposit");
            System.out.println("3 Withdraw");
            System.out.println("4 Check Balance");
            System.out.println("5 Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    saveAccounts();
                    System.out.println("Thank you for using the Bank");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /* FUNCTIONS */

    static void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        accounts.add(new SavingsAccount(accNo, name, 0));
        System.out.println("Account Created Successfully");
    }

    static void deposit() {
        Account acc = findAccount();
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            acc.deposit(sc.nextDouble());
            System.out.println("Amount Deposited Successfully");
        }
    }

    static void withdraw() {
        Account acc = findAccount();
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            if (acc.withdraw(sc.nextDouble())) {
                System.out.println("Withdrawal Successful");
            } else {
                System.out.println("Insufficient Balance");
            }
        }
    }

    static void checkBalance() {
        Account acc = findAccount();
        if (acc != null) {
            acc.display();
        }
    }

    static Account findAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        System.out.println("Account Not Found");
        return null;
    }

    /* FILE HANDLING */

    static void saveAccounts() {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(accounts);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    static ArrayList<Account> loadAccounts() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));
            ArrayList<Account> list =
                    (ArrayList<Account>) ois.readObject();
            ois.close();
            return list;
        } catch (Exception e) {
            return new ArrayList<Account>();
        }
    }
}
