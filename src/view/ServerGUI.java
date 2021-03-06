package view;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import controller.CalculatorClient;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frmServer.setBounds(100, 100, 450, 313);
		frmServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServer.getContentPane().setLayout(null);
		frmServer.setLocationByPlatform(true);

		JLabel lblNewLabel = new JLabel("System Messages:");
		lblNewLabel.setBounds(169, 6, 127, 16);
		frmServer.getContentPane().add(lblNewLabel);
		
		 // always scroll to new information in message area
		DefaultCaret caret = (DefaultCaret)messages.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		messages.setEditable(false);
		messages.setWrapStyleWord(true);
		messages.setLineWrap(true);
		scroll.setBounds(34, 34, 384, 222);
		frmServer.getContentPane().add(scroll);
		
		JButton btnNewClient = new JButton("Start New Client");
		btnNewClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				CalculatorClient.main(null);
				messages.append("New Client instance started \n");
				}
				catch (Exception er) {
					System.out.println("New Client exception: " + er);
				}
			}
		});
		btnNewClient.setBounds(169, 256, 127, 29);
		frmServer.getContentPane().add(btnNewClient);
		frmServer.setVisible(true);
	}
}
