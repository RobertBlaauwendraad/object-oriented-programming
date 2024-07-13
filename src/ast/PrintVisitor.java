package ast;

public class PrintVisitor implements FormulaVisitor<Object, Object>{
	private final StringBuilder stringBuilder = new StringBuilder();

	public String getString() {
		return stringBuilder.toString();
	}

	@Override
	public Object visit(Formula formula, Object o) {
		stringBuilder.append(formula);
		return null;
	}
}
