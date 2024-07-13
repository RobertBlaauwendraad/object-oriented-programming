package ast;

import java.util.Map;

public class BinaryOperator implements Formula {
	private final BinOp operator;
	private final Formula leftFormula;
	private final Formula rightFormula;

	public BinaryOperator(BinOp operator, Formula leftFormula, Formula rightFormula) {
		this.operator = operator;
		this.leftFormula = leftFormula;
		this.rightFormula = rightFormula;
	}

	@Override
	public <Result, Argument> Result accept(FormulaVisitor<Result, Argument> visitor, Argument argument) {
		return visitor.visit(this, argument);
	}

	@Override
	public Integer getPrecedence() {
		return this.operator.getPrecedence();
	}

	@Override
	public Boolean getBool(Map<String, Boolean> env) {
		return operator.apply(leftFormula.getBool(env), rightFormula.getBool(env));
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if (this.getPrecedence() <= leftFormula.getPrecedence()) {
			stringBuilder.append("(").append(leftFormula).append(")");
		} else {
			stringBuilder.append(leftFormula);
		}
		stringBuilder.append(operator.string);
		if (this.getPrecedence() <= rightFormula.getPrecedence()) {
			stringBuilder.append("(").append(rightFormula).append(")");
		} else {
			stringBuilder.append(rightFormula);
		}
		return stringBuilder.toString();
	}
}
