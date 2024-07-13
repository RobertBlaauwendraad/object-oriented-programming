package expressions;

import java.util.Map;

public class Add extends TwoArgExpr {
	public Add(Expression expression1, Expression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}

	@Override
	public String toString() {
		return "(" + expression1 + "+" + expression2 + ")";
	}

	@Override
	public double eval(Map<String, Double> env) {
		return expression1.eval(env) + expression2.eval(env);
	}

	@Override
	public Expression partialEval() {
		if (this.getConstantValue() != null) {
			return new Constant(this.getConstantValue());
		} else if (expression1.getConstantValue() != null && expression1.getConstantValue().equals(0.0)) {
			return expression2.partialEval();
		} else if (expression2.getConstantValue() != null && expression2.getConstantValue().equals(0.0)) {
			return expression1.partialEval();
		}
		else {
			return new Add(expression1.partialEval(), expression2.partialEval());
		}
	}

	@Override
	public Double getConstantValue() {
		if (expression1 instanceof Constant && expression2 instanceof Constant) {
			return expression1.getConstantValue() + expression2.getConstantValue();
		} else {
			return null;
		}
	}
}
