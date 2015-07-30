package examples;

public class AnonExample {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (true) {
					System.out.println("Ognjen");
				}
			}
		});
		
		t.start();
	}

}
