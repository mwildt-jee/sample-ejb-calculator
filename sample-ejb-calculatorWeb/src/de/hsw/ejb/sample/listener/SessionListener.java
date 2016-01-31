package de.hsw.ejb.sample.listener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import de.hsw.ejb.sample.calulator.RecordingCalculatorRemote;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    		
    	try {
    		// http://docs.oracle.com/javaee/6/tutorial/doc/gipjf.html
    		InitialContext context = new InitialContext();
    		String name = "java:global/sample-ejb-calculator/sample-ejb-calculatorEJB/RecordingCalculator";
    		System.out.println("lookup " + name);
    		RecordingCalculatorRemote calculator = (RecordingCalculatorRemote) context.lookup(name);
			arg0.getSession().setAttribute("calculator",calculator);
		} catch (NamingException e) {
			e.printStackTrace();
		}
    	
    }

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}
	
}
