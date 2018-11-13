import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

/**
 * The ServerGUI class of the RMI Calculator application
 * 
 * 
 * @author Matthew O'Connor
 * @version 12/10/2018 
 * BSc Applied Computing Year 4
 */

public class ServerGUI {
	// variables
	public JFrame frmServer = new JFrame();
	public JTextArea messages = new JTextArea();
	public JScrollPane scroll = new JScrollPane(messages);


	/**
	 * Create the application.
	 */
	public ServerGUI() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServer.getContentPane().setBackground(new Color(255, 204, 204));
		frmServer.setTitle("Server");
		frmServer.setBounds(100, 100, 450, 300);
		frmServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServer.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("System Messages:");
		lblNewLabel.setBounds(169, 6, 127, 16);
		frmServer.getContentPane().add(lblNewLabel);

		messages.setEditable(false);
		messages.setWrapStyleWord(true);
		messages.setLineWrap(true);
		scroll.setBounds(34, 34, 384, 222);
		frmServer.getContentPane().add(scroll);
		frmServer.setVisible(true);
	}

}
