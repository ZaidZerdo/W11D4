package examples;

public class ThreadShifts {

	public static int shift = 1;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new MyThread1());
		Thread t2 = new Thread(new MyThread2());
		
		t1.start();
		t2.start();
		
		while (true) {
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			shift = (shift == 1)? 2: 1;
		}
	}
	
	static class MyThread1 implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (shift == 1) {
					System.out.println("1: Ja sad radim.");
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	static class MyThread2 implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (shift == 2) {
					System.out.println("2: Ja sad radim.");
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
