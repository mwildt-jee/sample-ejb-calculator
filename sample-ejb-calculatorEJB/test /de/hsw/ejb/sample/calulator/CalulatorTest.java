package de.hsw.ejb.sample.calulator;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsw.ejb.sample.calulator.exception.CaclulatorException;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException.DivisionByZeroException;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException.DivisionWithRestException;

public class CalulatorTest {

	CalculatorRemote calc = new Calculator();
	
	@Test
	public void testAdd(){
		assertEquals(20, calc.add(10, 10));
		assertEquals(0, calc.add(10, -10));
	}
	
	@Test
	public void testMultiply(){
		assertEquals(100, calc.multiply(10, 10));
		assertEquals(0, calc.multiply(10, 0));
		assertEquals(-10, calc.multiply(10, -1));
	}
	
	@Test
	public void testDivide() throws CaclulatorException {
		assertEquals(1, calc.divide(10, 10));
		assertEquals(0, calc.divide(0, 10));
		assertEquals(2, calc.divide(6, 3));
	}
	
	@Test(expected=DivisionByZeroException.class)
	public void testDivideByZero() throws CaclulatorException {
		calc.divide(10, 0);
	}
	
	@Test(expected=DivisionWithRestException.class)
	public void testDivideWithRest() throws CaclulatorException {
		calc.divide(3, 6);
	}
	
}
