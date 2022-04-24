package expressions;

import java.util.Map;

public abstract class NoArgExpr implements Expression {
	@Override
	public double eval(Map<String, Double> env) {
		return 0;
	}

	@Override
	public Expression partialEval() {
		return null;
	}

	@Override
	public Double getConstantValue() {
		return Expression.super.getConstantValue();
	}
}
