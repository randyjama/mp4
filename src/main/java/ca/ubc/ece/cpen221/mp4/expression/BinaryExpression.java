package ca.ubc.ece.cpen221.mp4.expression;

import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

public class BinaryExpression implements Expression{
	
	private BinaryOperator operator;
	private Expression operand1;
	private Expression operand2;
	
	public BinaryExpression (BinaryOperator operator, Expression operand1, Expression operand2) {
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	@Override
	public double eval() {
		return operator.apply(operand1.eval(), operand2.eval());
	}
	
	@Override
	public String toString() {
		return String.valueOf(operator.apply(operand1.eval(), operand2.eval()));
	}

}
