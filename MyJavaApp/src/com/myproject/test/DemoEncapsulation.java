package com.myproject.test;

class BankAccount {
   
	  double balance = 1000; // Encapsulated data

    // Public getter method
    public double getBalance() {
        return balance;
    }

    // Public setter method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void setBalance(double balance) {
		this.balance = balance;
	}

    
}

public class DemoEncapsulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        System.out.println("Invalid deposit amount:" + account.balance);
        account.deposit(1000); // Set balance using method
        System.out.println("Balance: " + account.getBalance()); // Access balance using method
    }
}
