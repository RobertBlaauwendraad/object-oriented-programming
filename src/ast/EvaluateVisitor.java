package ast;

import java.util.Map;

public class EvaluateVisitor implements FormulaVisitor<Boolean, Map<String, Boolean>> {

	@Override
	public Boolean visit(Formula formula, Map<String, Boolean> stringBooleanMap) {
		return formula.getBool(stringBooleanMap);
	}
}
