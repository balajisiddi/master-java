package com.balaji.multithreading;

public class InnerThreadComm {

	public static void main(String[] args) {
		final Customer c= new Customer();
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(1000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(1000);
			}
		}.start();
	}

}

class Customer{
	int amount= 10000;
	synchronized void withdraw(int amount) {
		System.out.println("Available Amount "+this.amount);
		System.out.println("Going to withdraw "+amount);
		if(this.amount< amount) {
			System.out.println("Insufficient funds waiting for deposit");
			try {
				wait();
			} catch (Exception e) {
				System.out.println("Interruption Occured");
			}
		}
		this.amount-= amount;
		System.out.println("Detected amount "+ amount);
		System.out.println("Balance amount "+this.amount);
	}
	
	synchronized void deposit(int amount) {
		System.out.println("Going to deposit "+amount);
		this.amount+= amount;
		System.out.println("Available Balance: "+this.amount);
		System.out.println("Transaction Completed");
		notify();
	}
}