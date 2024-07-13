package ast;

import java.util.function.BinaryOperator;

public enum BinOp implements BinaryOperator<Boolean> {
	And ("/\\", (aBoolean, aBoolean2) -> aBoolean && aBoolean2, 2),
	Or ("\\/", (aBoolean, aBoolean2) -> aBoolean || aBoolean2, 3),
	Implication("=>", (aBoolean, aBoolean2) -> !aBoolean || aBoolean2, 4);

	public final String string;
	private final BinaryOperator <Boolean> binOp;
	private final Integer precedence;

	BinOp(String string, BinaryOperator<Boolean> binOp, Integer precedence) {
		this.string = string;
		this.binOp = binOp;
		this.precedence = precedence;
	}

	public Integer getPrecedence() {
		return precedence;
	}

	@Override
	public Boolean apply(Boolean aBoolean, Boolean aBoolean2) {
		return binOp.apply(aBoolean, aBoolean2);
	}
}
