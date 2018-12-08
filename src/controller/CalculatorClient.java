package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import model.Calculator;
import view.ClientGUI;

/**
 * The CalculatorClient class of the RMI Calculator application
 * 
 * 
 * @author Matthew O'Connor
 * @version 20/11/2018 
 * BSc Applied Computing Year 4
 */

public class CalculatorClient {
	// variables
	private String result = "";
	private ClientGUI gui;
	private String preOp = "";  // numbers before operator
	private String postOp = ""; // numbers after operator
	private String opValue = ""; // operator
	private static Calculator obj = null;


	// Constructor
	public CalculatorClient() {
		gui = new ClientGUI();
		addEventListeners();
		gui.sysMsgArea.append("Client running, enter calculation... \n");
	}


	/**
	 * 
	 * Main Method
	 */
	public static void main(String args[]) {
		new CalculatorClient();
	}


	/**
	 * 
	 * Handle a number input
	 * 6 numbers max before operator and 6 after
	 */
	public void numberInput(String no) {
		if (preOp.length() < 7 && opValue.isEmpty()) {
			gui.inputTextField.setText(preOp + no);
			preOp += no;
		}
		else if (postOp.length() < 7 && !opValue.isEmpty()) {
			postOp += no;
			gui.inputTextField.setText(preOp + opValue + postOp);
		}
	}


	/**
	 * 
	 * Handle an operator input
	 */
	public void operatorInput(String oper) {
		if (preOp.length() > 0 && opValue.isEmpty()) { 
			gui.inputTextField.setText(preOp + oper);
			opValue = oper;
		}
		else if (!opValue.isEmpty()) { // ensure only one operator
			gui.sysMsgArea.append("Only one operator allowed \n");
		}
		else {
			gui.sysMsgArea.append("Enter a number before an operator \n");
		}
	}


	/**
	 * 
	 * Clear values
	 */
	public void clear() {
		preOp = "";
		postOp = "";
		opValue = "";
	}


	/**
	 * 
	 * Handle connection for each operator
	 */
	public void connect(String value) {
		try {
			obj = (Calculator) Naming.lookup("//" + "localhost" + "/Calculator");
			switch (value) {
			// case depending on operator
			case "add":
				result = obj.add(Integer.parseInt(preOp), Integer.parseInt(postOp));
				gui.sysMsgArea.append(Integer.parseInt(preOp) + " + " + Integer.parseInt(postOp) + "\n");
				break;
			case "subtract":
				result = obj.subtract(Integer.parseInt(preOp), Integer.parseInt(postOp));
				gui.sysMsgArea.append(Integer.parseInt(preOp) + " - " + Integer.parseInt(postOp) + "\n");
				break;
			case "multiply":
				result = obj.multiply(Integer.parseInt(preOp), Integer.parseInt(postOp));
				gui.sysMsgArea.append(Integer.parseInt(preOp) + " * " + Integer.parseInt(postOp) + "\n");
				break;
			case "divide":
				result = obj.divide(Integer.parseInt(preOp), Integer.parseInt(postOp));
				gui.sysMsgArea.append(Integer.parseInt(preOp) + " / " + Integer.parseInt(postOp) + "\n");
				break;
			}
			gui.sysMsgArea.append("Result from the RMI-server was: " + result + "\n");
			gui.inputTextField.setText(result);
			clear(); // allow for subsequent calculation to be done right away

		}
		catch (RemoteException | MalformedURLException | NotBoundException e) {
			gui.sysMsgArea.append("Error:" + e.getMessage() + "\n");
			e.printStackTrace();
		}
	}


	/**
	 * 
	 * Add event listeners to each button
	 */
	public void addEventListeners() {
		// submit button
		gui.submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit(opValue);
			}
		});

		// clear button
		gui.clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				gui.inputTextField.setText("");
			}
		});

		// one button
		gui.oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("1");
			}
		});

		// two button
		gui.twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("2");
			}
		});

		// three button
		gui.threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("3");
			}
		});

		// four button
		gui.fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("4");
			}
		});

		// five button
		gui.fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("5");
			}
		});

		// six button
		gui.sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("6");
			}
		});

		// seven button
		gui.sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("7");
			}
		});

		// eight button
		gui.eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("8");
			}
		});

		// nine button
		gui.nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("9");
			}
		});

		// zero button
		gui.zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberInput("0");
			}
		});

		// add button
		gui.addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorInput("+");
			}
		});

		// subtract button
		gui.minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorInput("-");
			}
		});

		// multiply button
		gui.multiplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorInput("*");
			}
		});

		// divide button
		gui.divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operatorInput("/");
			}
		});
	}


	/**
	 * 
	 * Submit to server. Operator is passed and used to determine switch case
	 */
	public void submit(String operator) {
		// Ensure we have at least two numbers and an operator
		if (!preOp.isEmpty() && !postOp.isEmpty() && !opValue.isEmpty()) {
			gui.sysMsgArea.append("Message to server: ");

			// case depending on operator
			switch (operator) {
			case "+":
				connect("add");
				break;
			case "*":
				connect("multiply");
				break;
			case "-":
				connect("subtract");
				break;
			case "/":
				connect("divide");
				break;
			}
		}
		else {
			gui.sysMsgArea.append("At least two numbers are required!! \n");
		}
	}
}