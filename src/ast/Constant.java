package ast;

import java.util.Map;

public class Constant implements Formula {
	public final Boolean bool;

	public Constant(Boolean bool) {
		this.bool = bool;
	}

	@Override
	public <Result, Argument> Result accept(FormulaVisitor<Result, Argument> visitor, Argument argument) {
		return visitor.visit(this, argument);
	}

	@Override
	public Integer getPrecedence() {
		return 0;
	}

	@Override
	public Boolean getBool(Map<String, Boolean> env) {
		return this.bool;
	}

	@Override
	public String toString() {
		if (bool) {
			return "True";
		} else {
			return "False";
		}
	}
}
