package de.hsw.ejb.sample.calulator;

import java.util.List;

import de.hsw.ejb.sample.calulator.exception.CaclulatorException;

/**
 * 
 * Ein Rechner für Ganzzahlige Berechnungen mit Protokolfunktion
 * 
 * @author Malte Wildt
 */
public interface RecordingCalculatorRemote {

	int add(int a);

	int multiply(int a);

	int divide(int a) throws CaclulatorException;

	/**
	 * Gibt eine Liste mit allen bisherigen Operationen des Rechners zurück
	 */
	List<String> getProtocol();

	int getValue();

}