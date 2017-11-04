package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;

public class Division implements BinaryOperator {

	/* (non-Javadoc)
	 * @see ca.ubc.ece.cpen221.mp4.operator.BinaryOperator#apply(double, double)
	 * function version implementing division
	 */
	@Override
	public double apply(double arg1, double arg2) {
		// TODO Auto-generated method stub
		double result = arg1 / arg2;
		
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String representation = "/";
		return representation;
	}
	
}
