/**
 * A simple command line parser for arithmetic expressions
 */
package ca.ubc.ece.cpen221.mp4.parser;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import ca.ubc.ece.cpen221.mp4.expression.AbsoluteValue;
import ca.ubc.ece.cpen221.mp4.expression.Addition;
import ca.ubc.ece.cpen221.mp4.expression.Division;
import ca.ubc.ece.cpen221.mp4.expression.Exponentiation;
import ca.ubc.ece.cpen221.mp4.expression.Expression;
import ca.ubc.ece.cpen221.mp4.expression.Multiplication;
import ca.ubc.ece.cpen221.mp4.expression.Negation;
import ca.ubc.ece.cpen221.mp4.expression.Subtraction;
import ca.ubc.ece.cpen221.mp4.operator.Operator;

/**
 * CommandLineParser - a command line calculator.
 * 
 * You will need to add any new Operators you create to the operatorSet or they
 * will not be usable in the command line calculator.
 *
 */
public class CommandLineParser {

	/**
	 * @param args
	 *            program arguments
	 */
	public static void main(String[] args) {

		Set<Operator> operatorSet = new HashSet<Operator>();

		// TODO add operators to operatorSet
		operatorSet.add(new Addition());
		operatorSet.add(new Subtraction());
		operatorSet.add(new Division());
		operatorSet.add(new Multiplication());
		operatorSet.add(new AbsoluteValue());
		operatorSet.add(new Negation());
		operatorSet.add(new Exponentiation());
		

		ExpressionParser parser = new ExpressionParser(operatorSet, new ExpressionMaker());

		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Enter an expression");
			String expression = scanner.nextLine();
			try {
				Expression exp = parser.parse(expression);
				System.out.println("Result: " + exp.eval());
			} catch (Exception e) {
				System.out.println("Input format not accepted. Please try again.");
			}
		} while (true);

	}

}
