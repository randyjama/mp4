package ca.ubc.ece.cpen221.mp4.expression;

/**
 * DerivativeExpression - The derivative of specific function.
 *
 */
public class DerivativeExpression implements Expression {
	
	private Expression fn;
	private VariableExpression independentVar;
	private Expression derv;
	private double DELTA_X = 1e-9;
	
		
	/**
	 * Create an expression representing the derivative of the specified
	 * function with respect to the specified variable.
	 * 
	 * @param fn the function whose derivative this expression represents
	 * @param independentVar the variable with respect to which we're
	 * 		  differentiating
	 */
	public DerivativeExpression(Expression fn, 
					VariableExpression independentVar) {
		// TODO implement this constructor
		this.fn = fn;
		this.independentVar = independentVar;
		/*derv = new BinaryExpression (new Division(),
				new BinaryExpression (new Subtraction(), fnDelta, fn),
				new NumberExpression(DELTA_X));
		*/
	}
	
	@Override
	public double eval() {
		// TODO implement this method
		// f(x)
		double fx = fn.eval();
		
		// f(x+dx)
		independentVar.store(independentVar.eval() + DELTA_X);
		double fxdx = fn.eval();
		
		return (fxdx - fx)/DELTA_X; // derivative formula
	}
	
	@Override
	public String toString() {
		// TODO implement this method
		
		return null;
	}
	

}
