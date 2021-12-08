package com.balaji.multithreading;

public class MyMultithread extends Thread {
	
	@Override
	public void run() {
		System.out.println("My Thread is in running state");
	}

	public static void main(String[] args) {
		MyMultithread obj= new MyMultithread();
		obj.start();
	}

}
