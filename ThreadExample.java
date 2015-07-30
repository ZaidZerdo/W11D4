package examples;

public class ThreadExample {

	public static void main(String[] args) {
//		System.out.println(Runtime.getRuntime().availableProcessors());
		
		Thread t = new Thread(new MyThread());
//		t.setDaemon(true);
		t.start();
		System.out.println("********************************");
	}
	
	static class MyThread implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println("Nema pauze.");
				
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
