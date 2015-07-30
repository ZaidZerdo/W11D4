package examples;

public class VolatileExample {

	private static volatile int counter = 0;
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread1());
		Thread t2 = new Thread(new Thread2());
		t1.start();
		t2.start();
	}
	
	// Ovaj Thread ceka da se promijeni counter!
	// Kad se promijeni, isprinta nesto.
	static class Thread1 implements Runnable {
		@Override
		public void run() {
			int local = counter;
			while (local < 10) {
				if (local != counter) {
					System.out.println("T1: " + counter);
					local = counter;
				}
			}
		}
	}
	
	// Svakih 2 sekunde poveca counter za 1.
	static class Thread2 implements Runnable {
		@Override
		public void run() {
			while (counter < 10) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				counter++;
				System.out.println("T2: " + counter);
			}
		}
	}

}
