package ca.ubc.ece.cpen221.mp4.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp4.expression.AbsoluteValue;
import ca.ubc.ece.cpen221.mp4.expression.Addition;
import ca.ubc.ece.cpen221.mp4.expression.BinaryExpression;
import ca.ubc.ece.cpen221.mp4.expression.DerivativeExpression;
import ca.ubc.ece.cpen221.mp4.expression.Division;
import ca.ubc.ece.cpen221.mp4.expression.Exponentiation;
import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.expression.Multiplication;
import ca.ubc.ece.cpen221.mp4.expression.Negation;
import ca.ubc.ece.cpen221.mp4.expression.NumberExpression;
import ca.ubc.ece.cpen221.mp4.expression.Subtraction;
import ca.ubc.ece.cpen221.mp4.expression.UnaryExpression;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp4.operator.Operator;
import ca.ubc.ece.cpen221.mp4.parser.CommandLineParser;
import ca.ubc.ece.cpen221.mp4.parser.ExpressionMaker;
import ca.ubc.ece.cpen221.mp4.parser.ExpressionParser;

// TODO you will need to import other packages that has code to test

public class SimpleCalculatorTest {

	// TODO Add more tests

	// test function and derivative evaluations for a given independent variable
	// value
	@Test
	public void test0() {

		Set<Operator> operatorSet = new HashSet<Operator>();
		/*
		 * // TODO add operators to operatorSet operatorSet.add(new Addition());
		 * operatorSet.add(new Subtraction()); operatorSet.add(new Division());
		 * operatorSet.add(new Multiplication()); operatorSet.add(new AbsoluteValue());
		 * operatorSet.add(new Negation()); operatorSet.add(new Exponentiation());
		 */
		/*
		 * ExpressionParser parser = new ExpressionParser(operatorSet, new
		 * ExpressionMaker());
		 * 
		 * String expression = "x * x - 2"; VariableExpression var = new
		 * VariableExpression("x"); var.store(3); Expression exp =
		 * parser.parse(expression);
		 */

		// exp1 = x * x - 2
		VariableExpression var = new VariableExpression("x");
		var.store(3);
		Expression exp = new BinaryExpression(new Subtraction(), new BinaryExpression(new Multiplication(), var, var),
				new NumberExpression(2));

		// derv for exp1 = 2x
		DerivativeExpression derv = new DerivativeExpression(exp, var);
		System.out.println(derv.eval());

		assertEquals(7, exp.eval(), 0.01);
		assertEquals(6, derv.eval(), 0.01);

		// exp2 = x^3 + 5x^2
		var = new VariableExpression("x");
		var.store(2);
		exp = new BinaryExpression(new Addition(),
				new BinaryExpression(new Exponentiation(), var, new NumberExpression(3)),
				new BinaryExpression(new Multiplication(), new NumberExpression(5),
						new BinaryExpression(new Exponentiation(), var, new NumberExpression(2))));

		// derv for exp2 = 3x^2 + 10x
		DerivativeExpression derv2 = new DerivativeExpression(exp, var);
		System.out.println(derv2.eval());

		assertEquals(28, exp.eval(), 0.01);
		assertEquals(32, derv2.eval(), 0.01);

		System.out.println(derv2.toString());
	}

	@Test
	public void test1() {
		VariableExpression var = new VariableExpression("x");
		Expression exp = new BinaryExpression(new Subtraction(),
				new BinaryExpression(new Exponentiation(), var, new NumberExpression(2)),
				new BinaryExpression(new Addition(),
						new BinaryExpression(new Multiplication(), var, new NumberExpression(3)),
						new NumberExpression(2)));
		var.store(2.5);
		assertEquals(exp.eval(), 0.75, 0.001);
	}

	// test roots of function
	@Test
	public void test2() {

		// exp1 = x^2 - 3x + 2 (initially should be -2)
		VariableExpression var = new VariableExpression("x");
		Expression exp = new BinaryExpression(new Subtraction(),
				new BinaryExpression(new Exponentiation(), var, new NumberExpression(2)),
				new BinaryExpression(new Addition(),
						new BinaryExpression(new Multiplication(), var, new NumberExpression(3)),
						new NumberExpression(2)));

/*		Expression exp = new BinaryExpression(new Subtraction(),
				new BinaryExpression(new Multiplication(), var, var), 
				new BinaryExpression(new Addition(), 
						new BinaryExpression(new Multiplication(), var, new NumberExpression(3)), 
						new NumberExpression(2)));
*/		
		// derv for exp1 = 2x - 3
		DerivativeExpression derv = new DerivativeExpression(exp, var);

		// see if newtons method returns 1 or 2 for above fn
		assertEquals(2, derv.newtonsMethod(exp, var, 2.5, 0.0001), 0.001);
	}

}