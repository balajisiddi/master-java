package com.balaji.multithreading;

public class DeadLock {

	public static void main(String[] args) {
		Resource r1= new Resource();
		Resource r2= new Resource();
		UserOne thread1= new UserOne(r1, r2);
		thread1.start();
		UserTwo thread2= new UserTwo(r1, r2);
		thread2.start();
	}

}

class Resource{
	void status() {
		System.out.println(Thread.currentThread().getName()+ "is Handling");
	}
}

class UserOne extends Thread{
	Resource r1;
	Resource r2;
	UserOne(Resource r1, Resource r2){
		this.r1= r1;
		this.r2= r2;
	}
	public void run() {
		synchronized (r1) {
			System.out.println(Thread.currentThread().getName()+" is Holding r1");
			System.out.println(Thread.currentThread().getName()+" is waiting for r2");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (r2) {
				System.out.println(Thread.currentThread().getName()+" is Holding r1 and r2");
			}
		}
		System.out.println(Thread.currentThread().getName()+" Leaving");
		
	}
}

class UserTwo extends Thread{
	Resource r1;
	Resource r2;
	
	public UserTwo(Resource r1, Resource r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" is Holding r2");
		System.out.println(Thread.currentThread().getName()+" is waiting for r1");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (r1) {
			System.out.println(Thread.currentThread().getName()+" is Holding r2 and r1");
		}
	}
	
	
}