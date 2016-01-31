package de.hsw.ejb.sample.calulator;

import de.hsw.ejb.sample.calulator.exception.CaclulatorException;

public interface CalculatorRemote {

	public abstract int add(int a, int b);

	public abstract int multiply(int a, int b);

	public abstract int divide(int a, int b) throws CaclulatorException;

}