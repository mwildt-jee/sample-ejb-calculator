package de.hsw.ejb.sample.calulator;

import java.util.List;

import de.hsw.ejb.sample.calulator.exception.CaclulatorException;

public interface RecordingCalculatorRemote {

	int add(int a);

	int multiply(int a);
	
	int divide(int a) throws CaclulatorException;

	List<String> getProtocol();
	
	int getValue();

}