package com.michael.assignment3;

public class Bank {
	
	double balance;
	
	public Bank() {
		this.balance = 0;
	}
	
	public double deposit(double amount) {
		this.balance += amount;
		return this.balance;
	}
	
	public double withdrawal(double amount) {
		if(this.balance >= amount) {
			this.balance -= amount;
			return this.balance;
		}
		System.out.println("Insufficient Funds");
		return this.balance;
	}
}
