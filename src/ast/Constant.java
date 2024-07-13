package ast;

import java.util.Map;

public enum Constant implements Formula {
	True,
	False;

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
		return Boolean.parseBoolean(this.toString());
	}
}
