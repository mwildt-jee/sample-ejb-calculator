package de.hsw.ejb.sample.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.hsw.ejb.sample.calulator.RecordingCalculatorRemote;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException.DivisionByZeroException;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException.DivisionWithRestException;

/**
 * Servlet implementation class CalculatorAction
 */
@WebServlet("/RecordingCalculatorAction")
public class RecordingCalculatorAction extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("recording-calculator.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RecordingCalculatorAction >> doPost");
		try {
			RecordingCalculatorRemote calculator = (RecordingCalculatorRemote) request.getSession().getAttribute("calculator");
			
			int oldValue = calculator.getValue();
			int value = Integer.parseInt(request.getParameter("value"));
			
			System.out.println("value = " + value);
		
			switch(request.getParameter("submit")){
				case "add" : {
					int r = calculator.add(value);
					request.setAttribute("calculatorResponse", String.format("Result: %d + %d = %d", value, oldValue, r));
				} break;
				case "multiply" : {
					int r = calculator.multiply(value);
					request.setAttribute("calculatorResponse", String.format("Result: %d * %d = %d", value, oldValue, r));
				} break;
				case "divide" : {
					try{
						int r = calculator.divide(value);
						request.setAttribute("calculatorResponse", String.format("Result: %d : %d = %d", value, oldValue, r));
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
		javax.servlet.RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/recording-calculator.jsp");
		dispatcher.forward(request,response);
	}

}
