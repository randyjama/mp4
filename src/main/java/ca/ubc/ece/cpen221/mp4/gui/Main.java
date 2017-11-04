package ca.ubc.ece.cpen221.mp4.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import ca.ubc.ece.cpen221.mp4.expression.AbsoluteValue;
import ca.ubc.ece.cpen221.mp4.expression.Addition;
import ca.ubc.ece.cpen221.mp4.expression.Division;
import ca.ubc.ece.cpen221.mp4.expression.Exponentiation;
import ca.ubc.ece.cpen221.mp4.expression.Multiplication;
import ca.ubc.ece.cpen221.mp4.expression.Negation;
import ca.ubc.ece.cpen221.mp4.expression.Subtraction;
import ca.ubc.ece.cpen221.mp4.operator.BinaryOperator;
import ca.ubc.ece.cpen221.mp4.operator.Operator;
import ca.ubc.ece.cpen221.mp4.operator.UnaryOperator;

/**
 * Main - creates and runs a new Calculator GUI. 
 *
 */
public class Main {

	/**
	 * Runs the calculator GUI.
	 * 
	 * @param args arguments to the main function 
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> createAndShowSetupScreen());
	}
	
	private static void createAndShowSetupScreen() {
		List<Operator> operators = new ArrayList<>();
		
		// create all 7 instances of operators and append them to list of operators
		// for calculator constructor
		BinaryOperator add = new Addition();
		BinaryOperator sub = new Subtraction();
		BinaryOperator mult = new Multiplication();
		BinaryOperator div = new Division();
		BinaryOperator exp = new Exponentiation();
		UnaryOperator negate = new Negation();
		UnaryOperator abs = new AbsoluteValue();
		operators.add(add);
		operators.add(sub);
		operators.add(mult);
		operators.add(div);
		operators.add(exp);
		operators.add(negate);
		operators.add(abs);
		
		Calculator calculator = new Calculator(operators);
		calculator.launch();
	}

}