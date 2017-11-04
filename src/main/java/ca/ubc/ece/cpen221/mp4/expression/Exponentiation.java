package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;

public class Exponentiation implements BinaryOperator {

	/* (non-Javadoc)
	 * @see ca.ubc.ece.cpen221.mp4.operator.BinaryOperator#apply(double, double)
	 * function version implementing exponents of form x^n
	 * 
	 * @param arg1 Base number x 
	 * @param arg2 Exponent number n
	 */
	@Override
	public double apply(double arg1, double arg2) {
		// TODO Auto-generated method stub
		double result = Math.pow(arg1, arg2);
		
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String representation = "^";
		return representation;
	}
	
}
