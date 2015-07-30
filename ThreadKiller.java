package examples;

public class ThreadKiller {

	public static void main(String[] args) {
		Thread t = new Thread(new MyThread());
		
		t.start();
		
		while (true) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			t.interrupt();
		}
	}

	static class MyThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println("Kristina place.");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println("Probudjen Thread");
				}
			}
		}
		
	}
}
