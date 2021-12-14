package com.balaji.multithreading;

public class ThreadGroups {

	public static void main(String[] args) {
		ThreadGroup readingThreads= new ThreadGroup("ReadingThreadGroup");
		for(int i=1; i<=3; i++) {
			Read readThread= new Read(readingThreads, "Thread-"+i);
			readThread.start();
		}
		ThreadGroup writingThreads= new ThreadGroup("WritingThreadGroup");
		for(int i=4; i<=6; i++) {
			Write writeThread= new Write(writingThreads, "Thread-"+i);
			writeThread.start();
		}
		ThreadGroup coordinatingThreads= new ThreadGroup("CoordinatingThreadGroup");
		Write coThread1= new Write(coordinatingThreads, "coThread1");
		Write coThread2= new Write(coordinatingThreads, "coThread2");
		Write coThread3= new Write(coordinatingThreads, "coThread3");
		coThread3.setPriority(9);
		coThread1.start();
		coThread2.start();
		coThread3.start();
		
		new Thread() {
			public void run() {
				System.out.println("I am Annonumous Thread");
			};
		}.start();
		
		new Thread(coordinatingThreads, "AnnoiTwo") {
			public void run() {
				System.out.println("I Balaji in  " + Thread.currentThread().getThreadGroup().getName());
			};
		}.start();
	}
}


class Read extends Thread{
	
	Read(ThreadGroup tg, String name){
		super(tg, name);
	}
	@Override
	public void run() {
		System.out.println("I am "+ Thread.currentThread().getName() +"I belong to "+ Thread.currentThread().getThreadGroup().getName());
		System.out.println("I am running.");
	}
}

class Write extends Thread{
	Write(ThreadGroup tg, String name){
		super(tg, name);
	}
	
	@Override
	public void run() {
		System.out.println("I am "+ Thread.currentThread().getName() +"I belong to "+ Thread.currentThread().getThreadGroup().getName());
		System.out.println("I am running.");
	}
}