package ast;

public interface FormulaVisitor <Result, Argument> {
	Result visit(Formula formula, Argument argument);
}
