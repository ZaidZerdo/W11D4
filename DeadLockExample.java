package examples;

public class DeadLockExample {

	private static Integer obj1 = 1;
	private static Integer obj2 = 2;

	// ArrayList vs Vector
	public static void main(String[] args) {
		Thread t1 = new Thread1();
		Thread t2 = new Thread2();

		t1.start();
		t2.start();
	}

	static class Thread1 extends Thread {

		@Override
		public void run() {
			synchronized (obj1) {
				System.out.println("T1: Ja sad drzim obj1.");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				synchronized (obj2) {
					System.out.println("T1: Ja sad drzim obj2.");
				}
			}

		}
	}

	static class Thread2 extends Thread {

		@Override
		public void run() {
			synchronized (obj2) {
				System.out.println("T2: Ja drzim obj2.");

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				synchronized (obj1) {
					System.out.println("T2: Ja drzim obj1.");
				}
			}

		}
	}

}
