package expressions;

import java.util.Map;

public class Negate extends OneArgExpr {
	public Negate(Expression expression) {
		this.expression = expression;
	}

	@Override
	public String toString() {
		return "-" + expression;
	}

	@Override
	public double eval(Map<String, Double> env) {
		return -this.expression.eval(env);
	}

	@Override
	public Expression partialEval() {
		if (this.getConstantValue() != null) {
			return new Constant(this.getConstantValue());
		} else {
			return new Negate(expression.partialEval());
		}
	}

	@Override
	public Double getConstantValue() {
		if (this.expression instanceof Constant) {
			return -expression.getConstantValue();
		} else {
			return null;
		}
	}
}
