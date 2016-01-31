package de.hsw.ejb.sample.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.ejb.sample.calulator.CalculatorRemote;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException.DivisionByZeroException;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException.DivisionWithRestException;

/**
 * Servlet implementation class CalculatorAction
 */
@WebServlet("/CalculatorAction")
public class CalculatorAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	@EJB CalculatorRemote calculator;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("calculator.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int value1 = Integer.parseInt(request.getParameter("value1"));
			int value2 = Integer.parseInt(request.getParameter("value2"));
		
			switch(request.getParameter("submit")){
				case "add" : {
					int r = calculator.add(value1, value2);
					request.setAttribute("calculatorResponse", String.format("Result: %d + %d = %d", value1, value2, r));
				} break;
				case "multiply" : {
					int r = calculator.multiply(value1, value2);
					request.setAttribute("calculatorResponse", String.format("Result: %d * %d = %d", value1, value2, r));
				} break;
				case "divide" : {
					try{
						int r = calculator.divide(value1, value2);
						request.setAttribute("calculatorResponse", String.format("Result: %d : %d = %d", value1, value2, r));
					} catch(DivisionByZeroException e){
						request.setAttribute("calculatorResponse", String.format("Error: DivisionByZeroException"));
					} catch(DivisionWithRestException e){
						request.setAttribute("calculatorResponse", String.format("Error: DivisionWithRestException"));
					} catch (CaclulatorException e) {
						request.setAttribute("calculatorResponse", String.format("Error: CaclulatorException"));
					} 
				} break;
			}
		} catch (NumberFormatException e) {
			request.setAttribute("calculatorResponse", String.format("Error: NumberFormatException"));
		}
		javax.servlet.RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/calculator.jsp");
		dispatcher.forward(request,response);
	}

}
