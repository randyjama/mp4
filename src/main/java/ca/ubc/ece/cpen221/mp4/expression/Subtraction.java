package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

public class Subtraction implements BinaryOperator{

	/* (non-Javadoc)
	 * @see ca.ubc.ece.cpen221.mp4.operator.BinaryOperator#apply(double, double)
	 * function version implementing subtraction
	 */
	@Override
	public double apply(double arg1, double arg2) {
		// TODO Auto-generated method stub
		double result = arg1 - arg2;
		
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String representation = "-";
		return representation;
	}


}
