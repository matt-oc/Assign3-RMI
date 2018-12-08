package view;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;


/**
 * The ClientGUI class of the RMI Calculator application
 * 
 * 
 * @author Matthew O'Connor
 * @version 20/11/2018 
 * BSc Applied Computing Year 4
 */

public class ClientGUI {

	public JFrame frmClient;
	public JTextField inputTextField;
	public JButton submitButton, zeroButton, addButton, threeButton, 
	twoButton, oneButton, minusButton, sixButton, fiveButton, fourButton, multiplyButton,
	nineButton, eightButton, sevenButton, divideButton, clearButton;
	public JTextArea sysMsgArea = new JTextArea();
	public JScrollPane j = new JScrollPane(sysMsgArea);
	private Font font1 = new Font("SansSerif", Font.BOLD, 17);


	/**
	 * Create the application.
	 */
	public ClientGUI() {
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClient = new JFrame();
		frmClient.setTitle("Client");
		frmClient.getContentPane().setBackground(UIManager.getColor("textHighlight"));
		frmClient.setBackground(new Color(51, 102, 153));
		frmClient.setBounds(100, 100, 450, 413);
		frmClient.setLocationRelativeTo(null);
		frmClient.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmClient.getContentPane().setLayout(null);
		
		inputTextField = new JTextField();
		inputTextField.setFont(font1);
		inputTextField.setText("");
		inputTextField.setToolTipText("");
		inputTextField.setBounds(6, 6, 438, 53);
		inputTextField.setEditable(false);
		inputTextField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		frmClient.getContentPane().add(inputTextField);
		inputTextField.setColumns(20);
		 // always scroll to new information in message area
		DefaultCaret caret = (DefaultCaret)sysMsgArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		

		j.setBounds(6, 297, 438, 88);
		frmClient.getContentPane().add(j);
		
		JLabel lblSystemMessages = new JLabel("System Messages");
		lblSystemMessages.setBounds(164, 279, 153, 16);
		frmClient.getContentPane().add(lblSystemMessages);
		
		sysMsgArea.setEditable(false);
		
		divideButton = new JButton("/");
		divideButton.setBounds(6, 71, 91, 38);
		frmClient.getContentPane().add(divideButton);
		
		sevenButton = new JButton("7");
		sevenButton.setBounds(129, 71, 97, 38);
		frmClient.getContentPane().add(sevenButton);
		
		eightButton = new JButton("8");
		eightButton.setBounds(238, 71, 97, 38);
		frmClient.getContentPane().add(eightButton);
		
		nineButton = new JButton("9");
		nineButton.setBounds(347, 71, 97, 38);
		frmClient.getContentPane().add(nineButton);
		
		multiplyButton = new JButton("*");
		multiplyButton.setBounds(6, 112, 91, 38);
		frmClient.getContentPane().add(multiplyButton);
		
		fourButton = new JButton("4");
		fourButton.setBounds(129, 112, 97, 38);
		frmClient.getContentPane().add(fourButton);
		
		fiveButton = new JButton("5");
		fiveButton.setBounds(238, 112, 97, 38);
		frmClient.getContentPane().add(fiveButton);
		
		sixButton = new JButton("6");
		sixButton.setBounds(347, 112, 97, 38);
		frmClient.getContentPane().add(sixButton);
		
		minusButton = new JButton("-");
		minusButton.setBounds(6, 153, 91, 38);
		frmClient.getContentPane().add(minusButton);
		
		oneButton = new JButton("1");
		oneButton.setBounds(129, 153, 97, 38);
		frmClient.getContentPane().add(oneButton);
		
		twoButton = new JButton("2");
		twoButton.setBounds(238, 153, 97, 38);
		frmClient.getContentPane().add(twoButton);
		
		threeButton = new JButton("3");
		threeButton.setBounds(347, 153, 97, 38);
		frmClient.getContentPane().add(threeButton);
		
		addButton = new JButton("+");
		addButton.setBounds(6, 194, 91, 38);
		frmClient.getContentPane().add(addButton);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(238, 194, 206, 38);
		frmClient.getContentPane().add(submitButton);
		
		zeroButton = new JButton("0");
		zeroButton.setBackground(UIManager.getColor("Button.background"));
		zeroButton.setBounds(129, 194, 97, 38);
		frmClient.getContentPane().add(zeroButton);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(287, 244, 117, 29);
		frmClient.getContentPane().add(clearButton);
		
		frmClient.setVisible(true);
	}
}
