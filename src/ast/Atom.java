package ast;

import java.util.Map;

public class Atom implements Formula {
	private final String atom;

	public Atom(String atom) {
		this.atom = atom;
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
		return env.get(atom);
	}

	@Override
	public String toString() {
		return this.atom;
	}
}
