package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

public class AbsoluteValue implements UnaryOperator {

	/* (non-Javadoc)
	 * @see ca.ubc.ece.cpen221.mp4.operator.UnaryOperator#apply(double)
	 * function version implementing negation
	 */
	@Override
	public double apply(double arg) {
		// TODO Auto-generated method stub
		double result = Math.abs(arg);
				
		return result;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String representation = "abs";
		return representation;
	}


}

