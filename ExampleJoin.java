package examples;

public class ExampleJoin {

	public static void main(String[] args) {
		Thread t = new MyThread();
		t.start();
		
//		try {
//			t.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("End of main");
	}
	
	static class MyThread extends Thread {
		
		@Override
		public void run() {
			Thread t = new MyThread2();
			t.start();
			try {
				t.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (int i = 0; i < 10; i++) {
				System.out.println(i);
				
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	static class MyThread2 extends Thread {
		@Override
		public void run() {
			while (true) {
				System.out.println("Ajla");
				
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
