package de.hsw.ejb.sample.action;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.ejb.sample.calulator.RecordingCalculatorRemote;

/**
 * Servlet implementation class RecordingCalculatorClearAction
 */
@WebServlet("/RecordingCalculatorClearAction")
public class RecordingCalculatorClearAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
    		// http://docs.oracle.com/javaee/6/tutorial/doc/gipjf.html
    		InitialContext context = new InitialContext();
    		String name = "java:global/sample-ejb-calculator/sample-ejb-calculatorEJB/RecordingCalculator";
    		System.out.println("lookup " + name);
    		RecordingCalculatorRemote calculator = (RecordingCalculatorRemote) context.lookup(name);
    		System.out.println("Value " + calculator.getValue());
    		request.getSession().setAttribute("calculator", calculator);
    		for(String p : calculator.getProtocol()){
    			System.out.println(p);
    		}
		} catch (NamingException e) { 
			e.printStackTrace();
		}
		response.sendRedirect("recording-calculator.jsp");
	}

}
