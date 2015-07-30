package examples;

public class PriorityExample {

	public static void main(String[] args) {
		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
//		t2.setPriority(Thread.NORM_PRIORITY + 4);
		
		t1.start();
		t2.start();
	}
	
	static class Thread1 extends Thread {
		
		@Override
		public void run() {
			while (true) {
				System.out.println("1");
			}
		}
		
	}
	
	static class Thread2 extends Thread {
		
		@Override
		public void run() {
			while (true) {
				System.out.println("2");
			}
		}
		
	}

}
