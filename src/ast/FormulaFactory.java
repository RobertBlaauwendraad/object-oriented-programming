package ast;

import java.util.Map;

public class FormulaFactory {

	public static Formula atom(String atomId) {
		return new Atom(atomId);
	}

	public static Formula and(Formula leftOp, Formula rightOp) {
		return new BinaryOperator(BinOp.And, leftOp, rightOp);
	}

	public static Formula or(Formula leftOp, Formula rightOp) {
		return new BinaryOperator(BinOp.Or, leftOp, rightOp);
	}

	public static Formula implies(Formula leftOp, Formula rightOp) {
		return new BinaryOperator(BinOp.Implication, leftOp, rightOp);
	}

	public static Formula not(Formula notOp) {
		return new Not(notOp);
	}

	public static final Formula TRUE = new Constant(true);

	public static final Formula FALSE = new Constant(false);

	public static String prettyPrint(Formula f) {
		PrintVisitor printVisitor = new PrintVisitor();
		printVisitor.visit(f, f.getPrecedence());
		return printVisitor.getString();
	}

	public static Boolean evaluate(Formula f, Map<String,Boolean> env) {
		return new EvaluateVisitor().visit(f, env);
	}
}
