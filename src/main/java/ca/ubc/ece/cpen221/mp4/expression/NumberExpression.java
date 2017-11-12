package ca.ubc.ece.cpen221.mp4.expression;

public class NumberExpression implements Expression{

		//  constructor takes arguments/data doubles
		//	store data in private member variable
		//	eval return input string converted to double
		//	new numberexpression
	
	double number;
	
	public NumberExpression (double input) {
			this.number = input;
		}
			
	@Override
	public double eval() {
		// TODO Auto-generated method stub
		return number;
	}
	
	@Override
	public String toString() {
		// cast double from eval method to string
		return String.valueOf(number);
	}
		
	

}
