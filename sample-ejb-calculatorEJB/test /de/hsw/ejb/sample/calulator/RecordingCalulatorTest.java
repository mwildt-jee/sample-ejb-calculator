package de.hsw.ejb.sample.calulator;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsw.ejb.sample.calulator.exception.CaclulatorException;

public class RecordingCalulatorTest {

	
	
	
	@Test
	public void testDefaultConstructor(){
		RecordingCalculator c = new RecordingCalculator();
		assertEquals(0, c.getValue());
		assertEquals(1, c.getProtocol().size());
		assertEquals("Initialize with 0", c.getProtocol().get(0));
	}
	
	@Test
	public void testValueConstructor(){
		RecordingCalculator c = new RecordingCalculator(99);
		assertEquals(99, c.getValue());
		assertEquals(1, c.getProtocol().size());
		assertEquals("Initialize with 99", c.getProtocol().get(0));
	}
	
	@Test
	public void testAdd(){
		RecordingCalculator c = new RecordingCalculator(10);
		c.calc = new Calculator();
		assertEquals(20, c.add(10));
		assertEquals(20, c.getValue());
		assertEquals(2, c.getProtocol().size());
		assertEquals("10 + 10 = 20", c.getProtocol().get(1));
	}
	
	@Test
	public void testMultiply(){
		RecordingCalculator c = new RecordingCalculator(10);
		c.calc = new Calculator();
		assertEquals(100, c.multiply(10));
		assertEquals(100, c.getValue());
		assertEquals(2, c.getProtocol().size());
		assertEquals("10 * 10 = 100", c.getProtocol().get(1));
	}
	
	@Test
	public void testDivide() throws CaclulatorException{
		RecordingCalculator c = new RecordingCalculator(10);
		c.calc = new Calculator();
		assertEquals(1, c.divide(10));
		assertEquals(1, c.getValue());
		assertEquals(2, c.getProtocol().size());
		assertEquals("10 : 10 = 1", c.getProtocol().get(1));
	}
	
}
