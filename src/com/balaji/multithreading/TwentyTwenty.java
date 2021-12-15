package com.balaji.multithreading;

public class TwentyTwenty {

	public static void main(String[] args) {
		Hitter dhoni= new Hitter("Dhoni");
		Hitter yuvi= new Hitter("Yuvi");
		
		try {
			Thread.sleep(1000);
			dhoni.stopHitting();
			System.out.println("Dhoni Hitting stopped");
			Thread.sleep(1000);
			dhoni.startHitting();
			System.out.println("Dhoni Hitting Started");
			yuvi.stopHitting();
			System.out.println(yuvi.hitterName +" Stopped Hitting");
			yuvi.startHitting();
			System.out.println(yuvi.hitterName +" Started Hitting");
		} catch (InterruptedException e) {
			System.out.println("Twenty Twenty Cancelled");
		}
		try {
			System.out.println("Waiting for match to finish");
			dhoni.hitter.join();
			yuvi.hitter.join();
		} catch (InterruptedException e) {
			System.out.println("Twenty Twenty Cancelled");
		}
		
		System.out.println("Twenty Twenty innings completed");
	}

}

class Hitter implements Runnable{
	
	String hitterName;
	Thread hitter;
	boolean takeRest;
	
	Hitter(String hitterName){
		this.hitterName= hitterName;
		hitter= new Thread(this, hitterName);
		System.out.println("Hitter padded up and ready: "+ hitter);
		takeRest= false;
		hitter.start();
	}

	@Override
	public void run() {
		try {
			for (int i = 20; i >0; i--) {
				System.out.println(hitterName+ " : "+ i);
				Thread.sleep(200);
				synchronized (this) {
					while(takeRest) {
						wait();
					}
				}
				
			}
		} catch (InterruptedException e) {
			System.out.println(hitterName+ "interrupted");
		}
		System.out.println(hitterName+ "done Hitting");
	}
	
	synchronized void stopHitting() {
		takeRest= true;
	}
	
	synchronized void startHitting() {
		takeRest= false;
		notify();
	}
	
}