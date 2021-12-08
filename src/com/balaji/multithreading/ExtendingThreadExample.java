package com.balaji.multithreading;

class Count extends Thread{
	Count(){
		super("My Extending Thread");
		System.out.println("My Thread Created"+ this);
		start();
	}
	
	@Override
	public void run() {
		try {
			for(int i= 0; i< 10; i++) {
				System.out.println("Printing the count "+ i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("My Thread Interruped");
		}
		System.out.println("My Thread run is over");
	}
}

public class ExtendingThreadExample {

	public static void main(String[] args) {
		Count cnt= new Count();
		try {
			while (cnt.isAlive()) {
				System.out.println("Main Thread will be alive till the child thread alive");
				Thread.sleep(1500);
			}
		} catch (InterruptedException e) {
			System.out.println("Main Thread interrupted");
		}
		System.out.println("Main Thread's run is over");
	}
}
