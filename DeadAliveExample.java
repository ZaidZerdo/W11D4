package examples;

public class DeadAliveExample {

	public static void main(String[] args) {
		Thread t = new MyThread();
		
		t.start();		
		System.out.println(t.isAlive()); // true
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(t.isAlive()); // false
	}

	static class MyThread extends Thread {
		
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("Emina");
			}
		}
		
	}
}
