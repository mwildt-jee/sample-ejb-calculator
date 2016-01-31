package de.hsw.ejb.sample.app.client;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import de.hsw.ejb.sample.calulator.RecordingCalculatorRemote;

public class RemoteCalculatorMain {
	
	public static void main(String args[]) throws NamingException{
		
		/*
		 * create InitialContext with params from jndi.properties
		 */
		InitialContext ic = new InitialContext();
		
		/*
		 * obtain 2 calculator-instances 
		 */
		String name = "java:global/sample-ejb-calculator/sample-ejb-calculatorEJB/RecordingCalculator";
		RecordingCalculatorRemote calculator1 = (RecordingCalculatorRemote) ic.lookup(name);
		RecordingCalculatorRemote calculator2 = (RecordingCalculatorRemote) ic.lookup(name);
		
		/*
		 * use calculator1
		 */
		for(String op : calculator1.getProtocol()){
			System.out.println("Operation c1 " + op);
		}
		System.out.println("add 1 c1");
		int result1 = calculator1.add(1);
		for(String op : calculator1.getProtocol()){
			System.out.println("Operation c1 " + op);
		}
		/*
		 * use calculator2
		 */
		System.out.println("add 1 c2");
		int result2 = calculator2.add(1);
		for(String op : calculator2.getProtocol()){
			System.out.println("Operation c2 " + op);
		}
	}
	


}
