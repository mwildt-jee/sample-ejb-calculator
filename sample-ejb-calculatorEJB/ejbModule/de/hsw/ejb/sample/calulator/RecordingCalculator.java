package de.hsw.ejb.sample.calulator;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import de.hsw.ejb.sample.calulator.exception.CaclulatorException;

@Stateful
@Remote(RecordingCalculatorRemote.class)
public class RecordingCalculator implements RecordingCalculatorRemote {

	@EJB CalculatorRemote calc;
	
	int value;
	List<String> protocol = new LinkedList<String>();
	
	public RecordingCalculator(){
		this(0);
	}
	
	public RecordingCalculator(int value){
		this.value = value;
		System.out.println(String.format("RecordingCalculator >> constructor(%d) [id = %s]" ,value, System.identityHashCode(this)));
		addToProtocol("Initialize with %d", value);
	}
	
	private void addToProtocol(String template, Object ... values){
		this.protocol.add(String.format(template, values));
	}
	
	@Override
	public int add(int a){
		System.out.println(String.format("RecordingCalculator %s >> add %d to %d",System.identityHashCode(this), value, a));
		int tmp = calc.add(value, a);
		addToProtocol("%d + %d = %d", value, a, tmp);
		value = tmp;
		return value;
	}
	
	@Override
	public int multiply(int a){
		System.out.println(String.format("RecordingCalculator %s >> multipy %d with %d",System.identityHashCode(this), value, a));
		int tmp = calc.multiply(value, a);
		addToProtocol("%d * %d = %d", value, a, tmp);
		value = tmp;
		return value;
	}
	
	@Override
	public int divide(int a) throws CaclulatorException{
		System.out.println(String.format("RecordingCalculator %s >> divide %d by %d",System.identityHashCode(this), value, a));
		int tmp = calc.divide(value, a);
		addToProtocol("%d : %d = %d", value, a, tmp);
		value = tmp;
		return value;
	}
	
	@Override
	public List<String> getProtocol(){
		System.out.println(String.format("RecordingCalculator %s >> getProtocol", System.identityHashCode(this)));
		return protocol;
	}

	@Override
	public int getValue() {
		return this.value;
	}
	
}
