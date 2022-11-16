package co.javatt;
class hi extends Thread{
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("hi");
			try {
				Thread.sleep(1000);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class multithrd extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("hello world!...");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class join extends Thread {
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("joing the");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class multitheard{
	public static void main(String args[]) {
		Thread t1 = new multithrd();
		Thread t2 = new hi();
		Thread t3 = new join();
		int i = 0;
		System.out.println("Hello World);
		t2.start();
		try {
			t1.join();
			Thread.sleep(10);
		} catch(Exception e) {
			e.printStackTrace();
		}
		t1.start();
		t3.start();
		
	}
}
