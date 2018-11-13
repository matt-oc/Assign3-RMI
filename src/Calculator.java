import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The Remote Calculator class of the RMI Calculator App
 * 
 * 
 * @author Matthew O'Connor
 * @version 19/11/2018 
 * BSc Applied Computing Year 4
 */

public interface Calculator extends Remote {
	String add(int x, int y) throws RemoteException;


	String subtract(int x, int y) throws RemoteException;


	String divide(int x, int y) throws RemoteException;


	String multiply(int x, int y) throws RemoteException;
}