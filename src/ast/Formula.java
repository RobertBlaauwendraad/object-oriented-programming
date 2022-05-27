package ast;

import java.util.Map;

public interface Formula {
	<Result, Argument> Result accept(FormulaVisitor<Result, Argument> visitor, Argument argument);
	Integer getPrecedence();
	Boolean getBool(Map<String, Boolean> env);
}
