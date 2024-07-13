package ast;

import java.util.Map;

public class Not implements Formula {
	private final Formula formula;

	public Not(Formula formula) {
		this.formula = formula;
	}

	public Formula getFormula() {
		return formula;
	}

	@Override
	public <Result, Argument> Result accept(FormulaVisitor<Result, Argument> visitor, Argument argument) {
		return visitor.visit(this, argument);
	}

	@Override
	public Integer getPrecedence() {
		return 1;
	}

	@Override
	public Boolean getBool(Map<String, Boolean> env) {
		return !formula.getBool(env);
	}

	@Override
	public String toString() {
		if (formula instanceof BinaryOperator) {
			return "!(" + formula + ")";
		}
		return "!" + formula;
	}
}
