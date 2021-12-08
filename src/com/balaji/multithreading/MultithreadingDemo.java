package com.balaji.multithreading;

public class MultithreadingDemo implements Runnable{

	@Override
	public void run() {
		System.out.println("My Thread is in running state");
	}
	public static void main(String[] args) {
		MultithreadingDemo obj= new MultithreadingDemo();
		Thread tobj= new Thread(obj);
		tobj.start();
	}

}
