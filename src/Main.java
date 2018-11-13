/**
 * The Main class of the RMI Calculator applicaion
 * 
 * 
 * @author Matthew O'Connor
 * @version 12/10/2018 
 * BSc Applied Computing Year 4
 */

public class Main {

	public CalculatorClient client;
	public CalculatorServer server;


	/**
	 * Create our instances
	 * 
	 */
	public void run() {

		// Thread with slight delay to make sure server is running before starting the client
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

		CalculatorServer.main(null);
	}


	/**
	 * Main Method
	 * 
	 */
	public static void main(String[] args) {
		Main start = new Main();
		start.run();
		while (true)
			;
	}
}