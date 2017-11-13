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
import ca.ubc.ece.cpen221.mp4.expression.Division;
import ca.ubc.ece.cpen221.mp4.expression.Exponentiation;
import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.expression.Multiplication;
import ca.ubc.ece.cpen221.mp4.expression.Negation;
import ca.ubc.ece.cpen221.mp4.expression.NumberExpression;
import ca.ubc.ece.cpen221.mp4.expression.Subtraction;
import ca.ubc.ece.cpen221.mp4.expression.VariableExpression;
import ca.ubc.ece.cpen221.mp4.operator.Operator;
import ca.ubc.ece.cpen221.mp4.parser.CommandLineParser;
import ca.ubc.ece.cpen221.mp4.parser.ExpressionMaker;
import ca.ubc.ece.cpen221.mp4.parser.ExpressionParser;

// TODO you will need to import other packages that has code to test


public class SimpleCalculatorTest {

	// TODO Add more tests

	@Test
	public void test0() {
		
		Set<Operator> operatorSet = new HashSet<Operator>();

		// TODO add operators to operatorSet
		operatorSet.add(new Addition());
		operatorSet.add(new Subtraction());
		operatorSet.add(new Division());
		operatorSet.add(new Multiplication());
		operatorSet.add(new AbsoluteValue());
		operatorSet.add(new Negation());
		operatorSet.add(new Exponentiation());
		
/*
		ExpressionParser parser = new ExpressionParser(operatorSet, new ExpressionMaker());
		
		String expression = "x * x - 2";
		VariableExpression var = new VariableExpression("x");
		var.store(3);
		Expression exp = parser.parse(expression);
*/
		
		VariableExpression var = new VariableExpression("x");
		var.store(3);
		Expression exp = new BinaryExpression (new Subtraction(), 
				new BinaryExpression(new Multiplication(), var, var), 
				new NumberExpression(2));
		
		assertEquals(7, exp.eval(), 0.01);
	}

}