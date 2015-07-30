package examples;

public class ExampleSync {

	public static Integer djelioc = 5;
	
	public static void main(String[] args) {
		Thread t1 = new Thread1();
		Thread t2 = new Thread2();
		
		t1.start();
		t2.start();
	}

	static class Thread1 extends Thread {
		
		@Override
		public void run() {
			while (true) {
				synchronized (djelioc) {
					if (djelioc != 0) {
						System.out.println(5 / djelioc);
					}
				}
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	static class Thread2 extends Thread {
		
		@Override
		public void run() {
			while (true) {
				synchronized (djelioc) {				
					if (djelioc == 0) {
						djelioc = 5;
					} else if (djelioc == 5) {
						djelioc = 0;
					}
				}	
				
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
