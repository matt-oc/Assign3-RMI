package controller;

/**
 * The Main class of the RMI Calculator applicaion
 * 
 * 
 * @author Matthew O'Connor
 * @version 12/10/2018 
 * BSc Applied Computing Year 4
 */

public class App {

	/**
	 * Run method to start server and one sample client
	 * 
	 */
	public void run() {

		// Thread with slight delay to make sure server is running before starting sample client
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}

				// start Client
				CalculatorClient.main(null);
			}
		}.start();

		// start Server
		CalculatorServer.main(null);
	}


	/**
	 * Main Method
	 * 
	 */
	public static void main(String[] args) {
		App start = new App();
		try {
			start.run();
		}
		catch (Exception e) {
			System.out.println("Error Starting app: " + e);
		}
		while (true);
	}
}