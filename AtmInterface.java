package codesoft_q3;

import java.util.Scanner;

class UserBankAccount {
    private double balance;

    public UserBankAccount(double initialBalance) {
        this.balance = initialBalance;
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
        } else {
            return false;
        }
    }
}

class ATM {
    UserBankAccount ua;

    public ATM(UserBankAccount us) {
        this.ua = us;
    }

    public void withdraw(double amount) {
        if (ua.withdraw(amount)) {
            System.out.println("The withdrawal is done successfully");
        } else {
            System.out.println("The withdrawal is unsuccessful");
        }
    }

    public void deposit(double amount) {
        ua.deposit(amount);
        System.out.println("The deposit is successful. ");
    }

    public void checkBalance() {
        System.out.println("The updated balance is " + ua.getBalance());
    }
}

public class AtmInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserBankAccount nua = new UserBankAccount(1000);
        ATM at = new ATM(nua);
        String ans;
        System.out.println("__________Codsoft task 3______________");

        do {
            System.out.println("__________MAIN MENU______________");
            System.out.println("1) WITHDRAWAL");
            System.out.println("2) DEPOSIT");
            System.out.println("3) CHECKBALANCE");
            System.out.println("Enter your choice:");

            int n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Enter the amount to withdraw:");
                    double amt = sc.nextDouble();
                    at.withdraw(amt);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit:");
                    amt = sc.nextDouble();
                    at.deposit(amt);
                    break;
                case 3:
                    at.checkBalance();
                    break;
            }

            System.out.println("Do you want the menu again? (yes/no)");
            ans = sc.next();

        } while (ans.equalsIgnoreCase("yes"));

        sc.close();
    }
}