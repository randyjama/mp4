package ca.ubc.ece.cpen221.mp4.expression;

/**
 * DerivativeExpression - The derivative of specific function.
 *
 */
public class DerivativeExpression implements Expression {

	private Expression fn;
	private VariableExpression independentVar;
	private double DELTA_X = 1e-9;

	/**
	 * Create an expression representing the derivative of the specified function
	 * with respect to the specified variable.
	 * 
	 * @param fn
	 *            the function whose derivative this expression represents
	 * @param independentVar
	 *            the variable with respect to which we're differentiating
	 */
	public DerivativeExpression(Expression fn, VariableExpression independentVar) {
		// TODO implement this constructor
		this.fn = fn;
		this.independentVar = independentVar;
		/*
		 * derv = new BinaryExpression (new Division(), new BinaryExpression (new
		 * Subtraction(), fnDelta, fn), new NumberExpression(DELTA_X));
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

		return (fxdx - fx) / DELTA_X; // derivative formula
	}

	/*
	 * @return result shows the format: d/d<independent variable> <function>
	 */
	@Override
	public String toString() {
		// TODO implement this method
		String result = "d/d" + independentVar + " " + fn.toString();
		return result;
	}

	/**
	 * Returns a zero of the specified function using Newton's method with
	 * approxZero as the initial estimate.
	 * 
	 * @param fn
	 *            the function whose zero is to be found; must be convergent
	 * @param x
	 *            the independent variable of the function
	 * @param approxZero
	 *            initial approximation for the zero of the function
	 * @param tolerance
	 *            how close to zero the returned zero must be
	 * @return result a double containing one root of the function +/- given
	 *         tolerance
	 */
	public double newtonsMethod(Expression fn, VariableExpression x, 
			double approxZero, double tolerance) {
		DerivativeExpression derv = new DerivativeExpression(fn, x);
		x.store(approxZero); // x0
		System.out.println(fn.eval()); // debugging
		System.out.println(derv.eval()); // debugging
		
		// xn+1 = xn - f(xn)/f'(xn)
		while (Math.abs(fn.eval()) > tolerance) {
			approxZero = approxZero - fn.eval()/derv.eval();
			x.store(approxZero);
		}

		return approxZero;
	}
}

/*		
//base case
if (Math.abs(fn.eval()) <= tolerance) {
	return approxZero;
}
else {
	return newtonMethod (fn, x, approxZero, tolerance);
			approxZero - fn.eval()/derv.eval();
}
}
*/
