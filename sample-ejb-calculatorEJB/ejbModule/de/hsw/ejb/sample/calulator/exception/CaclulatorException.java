package de.hsw.ejb.sample.calulator.exception;

public class CaclulatorException extends Exception {
	
	private static final long serialVersionUID = -3700287273499021433L;

	public static class DivisionByZeroException extends CaclulatorException{

		private static final long serialVersionUID = 8517345038287851147L;
		
	}
	
	public static class DivisionWithRestException extends CaclulatorException{

		private static final long serialVersionUID = 8517345038287851147L;
		
	}
	

}
