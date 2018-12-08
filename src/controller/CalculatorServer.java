package controller;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import model.Calculator;
import view.ServerGUI;

/**
 * The CalculatorServer class of the RMI Calculator application
 * 
 * 
 * @author Matthew O'Connor
 * @version 20/11/2018 
 * BSc Applied Computing Year 4
 */

public class CalculatorServer extends UnicastRemoteObject implements Calculator {

	private static final long serialVersionUID = 1L;
	private ServerGUI gui;


	public CalculatorServer() throws RemoteException {
		super();
		// new gui
		gui = new ServerGUI();
		gui.messages.append("Server started, Waiting for connection.... \n\n");
	}


	/**
	 * Method to add two numbers
	 */
	public String add(int x, int y) {
		getIP();
		// add messages to gui
		gui.messages.append("Invocation to Calculator was succesful! \n");
		gui.messages.append("Adding: " + x + "," + y + "\n");
		gui.messages.append("Result: " + (x + y) + "\n\n");
		return (String.valueOf(x + y)); // return result
	}


	/**
	 * Method to subtract two numbers
	 */
	public String subtract(int x, int y) {
		getIP();
		// add messages to gui
		gui.messages.append("Invocation to Calculator was succesful! \n");
		gui.messages.append("Subtracting: " + x + "," + y + "\n");
		gui.messages.append("Result: " + (x - y) + "\n\n");
		return (String.valueOf(x - y)); // return result
	}


	/**
	 * Method to multiply two numbers
	 */
	public String multiply(int x, int y) {
		getIP();
		// add messages to gui
		gui.messages.append("Invocation to Calculator was succesful! \n");
		gui.messages.append("Multiplying: " + x + "," + y + "\n");
		gui.messages.append("Result: " + ((long) x * y) + "\n\n");
		return (String.valueOf((long) x * y)); // return result
	}


	/**
	 * Method to divide two numbers
	 */
	public String divide(int x, int y) {
		getIP();
		// add messages to gui
		gui.messages.append("Invocation to Calculator was succesful! \n");
		gui.messages.append("Dividing: " + x + "," + y + "\n");
		gui.messages.append("Result: " + ((double) x / y) + "\n\n");
		return (String.valueOf((double) x / y)); // return result
	}


	/**
	 * Method to get ip of client
	 */
	public void getIP() {
		try {
			gui.messages.append("Request From: " + getClientHost() + "\n"); // display client I.P.
		}
		catch (Exception e) {
		}
	}


	public static void main(String args[]) {
		try {
			// Create an object of the CalculatorServer class.
			CalculatorServer obj = new CalculatorServer();
			// Bind this object instance to the name "Calculator".
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.rebind("Calculator", obj);

			System.out.println("Calculator bound in registry");
		}
		catch (Exception e) {
			System.out.println("CalculatorServer error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}