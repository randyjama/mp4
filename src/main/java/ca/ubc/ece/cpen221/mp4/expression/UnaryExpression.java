package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

public class UnaryExpression implements Expression{
	
	private UnaryOperator operator;
	private Expression operand;
	
	public UnaryExpression (UnaryOperator operator, Expression operand) {
		this.operator = operator;
		this.operand = operand;
	}
	
	@Override
	public double eval() {
		return operator.apply(operand.eval());
	}
	
	@Override
	public String toString() {
		return String.valueOf(operator.apply(operand.eval()));
	}

}
