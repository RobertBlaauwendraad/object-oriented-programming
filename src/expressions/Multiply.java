package expressions;

import java.util.Map;

public class Multiply extends TwoArgExpr {
	public Multiply(Expression expression1, Expression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}

	@Override
	public String toString() {
		return "(" + expression1 + "*" + expression2 + ")";
	}

	@Override
	public double eval(Map<String, Double> env) {
		return expression1.eval(env) * expression2.eval(env);
	}

	@Override
	public Expression partialEval() {
		if (this.getConstantValue() != null) {
			return new Constant(this.getConstantValue());
		} else if (
			expression1.getConstantValue() != null && expression1.getConstantValue().equals(0.0) ||
			expression2.getConstantValue() != null && expression2.getConstantValue().equals(0.0)
		) {
			return new Constant(0);
		} else {
			return new Multiply(expression1.partialEval(), expression2.partialEval());
		}
	}

	@Override
	public Double getConstantValue() {
		if (expression1 instanceof Constant && expression2 instanceof Constant) {
			return expression1.getConstantValue() * expression2.getConstantValue();
		} else {
			return null;
		}
	}
}
