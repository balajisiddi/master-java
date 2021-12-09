/* When we use static synchronized for a method and use that in the
 *  multithreaded environment the objects of the thread class can be accessed
 *  one at a time. The threads can't access this block paralelly.
 *  
 *  No two objects shouldn't execute a method at the same time. Then we should go for
 *  static synchronization  
 */
package com.balaji.multithreading;

public class ATMTransaction {

	public static void main(String[] args) {
		/*
		 * creating multiple threads in the for loop for the class AccountHolder which
		 * is extending the Thread class to create thread and using the static
		 * synchronized block code from ATMCenter class
		 */
		for(int i=0; i<4; i++) {
			AccountHolder t= new AccountHolder();
			t.setName("Person" + i);
			t.start();
		}
	}

}

class ATMCenter{
	/*
	 * this synchronized method is defined with static so the action performed on
	 * this will wait for the other thead's action to complete within the same
	 * object
	 */	 static synchronized void userAction() {
		System.out.println(Thread.currentThread().getName() + " Entered");
		System.out.println("Performed Transaction");
		try {
			Thread.sleep(400);
		} catch (Exception e) {
			System.out.println("Thread Interrupted");
		}
		System.out.println(Thread.currentThread().getName()+ "Transaction Completed");
		System.out.println(Thread.currentThread().getName()+ "Leaving......");
		System.out.println("-------------------------------------------");
	}
}

class AccountHolder extends Thread{
//	ATMCenter s= new ATMCenter();//if the synchronized method is not static
	@Override
	public void run() {
//		s.userAction();
		ATMCenter.userAction();
	}
}