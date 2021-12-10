/*In some cases we need a perticular part of the code should be perform synchronous 
behaviour then we can use synchronized blocks*/
package com.balaji.multithreading;

class FathersAccount{
	double currentBalance;
	void deposit(double amount) {
		System.out.println(Thread.currentThread().getName()+ " deposited "
				+ amount+ "in FathersAccount");
		currentBalance+= amount;
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			System.out.println("Thread Interrupted");
		}
		System.out.println("Current Balance in Fathers Account"+ currentBalance);
		System.out.println();
	}
}

class Children extends Thread{
	FathersAccount fatherAccount;
	double amount;
	Children(FathersAccount fatherAccount, double amount){
		this.fatherAccount= fatherAccount;
		this.amount= amount;
	}
	public void run() {
		synchronized (fatherAccount) {
			fatherAccount.deposit(amount);
		}
	}
}

public class Banking {
	public static void main(String[] args) {
		FathersAccount fatherAccount= new FathersAccount();
		Children thread1= new Children(fatherAccount, 1000);
		thread1.start();
		Children thread2= new Children(fatherAccount, 2000);
		thread2.start();
		Children thread3= new Children(fatherAccount, 3000);
		thread3.start();
	}
}
