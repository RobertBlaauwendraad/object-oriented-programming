package expressions;

import java.util.Map;

public abstract class TwoArgExpr implements Expression {
	protected Expression expression1;
	protected Expression expression2;

	@Override
	public double eval(Map<String, Double> env) {
		return 0;
	}

	@Override
	public Expression partialEval() {
		return null;
	}
}
