package de.hsw.ejb.sample.app.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.hsw.ejb.sample.calulator.CalculatorRemote;

/**
 * Baut eine Verbindung zu dem lokalen EBJ-Container (localhost) auf und nutzt verschiedene Referenzen auf ein 
 * CalculatorRemote-Interface
 * 
 * @author Malte Wildt
 */
public class CalculatorMain {
	
	public static void main(String args[]) throws NamingException{
		
		/*
		 * create Initial Context with Params from jndi.properties
		 */
		InitialContext ic = new InitialContext();
		
		/*
		 * obtain calculator Instance 
		 */
		String name = "java:global/sample-ejb-calculator/sample-ejb-calculatorEJB/Calculator";
		CalculatorRemote calculator = (CalculatorRemote) ic.lookup(name);
		
		/*
		 * use calculator1
		 */
		System.out.println("C1 : add 1 to 2");
		
		int result = calculator.add(1, 2);
		assert result == 3;
		System.out.println("1 + 2 = 3");
		
		/*
		 * obtain a second calculator 
		 */
		CalculatorRemote calculator2 = (CalculatorRemote) ic.lookup(name);
		
		System.out.println("C1 : add 1 to 2");
		
		result = calculator2.add(2, 3);
		assert result == 5;
		System.out.println("2 + 3 = 5");
		
	}

}
