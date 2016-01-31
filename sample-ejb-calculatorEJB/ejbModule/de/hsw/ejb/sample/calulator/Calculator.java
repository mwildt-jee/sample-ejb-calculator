package de.hsw.ejb.sample.calulator;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import de.hsw.ejb.sample.calulator.exception.CaclulatorException;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException.DivisionByZeroException;
import de.hsw.ejb.sample.calulator.exception.CaclulatorException.DivisionWithRestException;

@Stateless
@Remote(CalculatorRemote.class)
public class Calculator implements CalculatorRemote {

	public Calculator(){
		System.out.println(String.format("Calculator >> constructor() [id = %s]" ,System.identityHashCode(this)));
	}
	
	@Override
	public int add(int a, int b){
		System.out.println("Calculator " + System.identityHashCode(this) + " :: add " + b + " to " + a);
		return a + b;
	}
	
	@Override
	public int multiply(int a, int b){
		System.out.println("Calculator " + System.identityHashCode(this) + " :: multiply " + a + " with " + b);
		return a * b;
	}
	
	@Override
	public int divide (int a, int b) throws CaclulatorException {
		System.out.println("Calculator " + System.identityHashCode(this) + " :: divide " + a + " by " + b);
		if(b == 0){
			throw new DivisionByZeroException();
		}
		if(a % b != 0){
			throw new DivisionWithRestException();
		}
		return a / b;
	}
	
}
