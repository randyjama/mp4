package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

public class Negation implements UnaryOperator {

	/* (non-Javadoc)
	 * @see ca.ubc.ece.cpen221.mp4.operator.UnaryOperator#apply(double)
	 * function version implementing negation
	 * 
	 * @param arg beware that double arg will be cast to an int to use
	 * negateExact function from java.lang.Math
	 */
	@Override
	public double apply(double arg) {
		// TODO Auto-generated method stub
		double result = Math.negateExact((int) arg);
				
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String representation = "~";
		return representation;
	}


}

