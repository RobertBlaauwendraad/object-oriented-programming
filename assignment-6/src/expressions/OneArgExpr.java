package expressions;

import java.util.Map;

public abstract class OneArgExpr implements Expression {
	protected Expression expression;
	@Override
	public double eval(Map<String, Double> env) {
		return 0;
	}

	@Override
	public Expression partialEval() {
		return null;
	}
}
