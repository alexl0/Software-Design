package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public class Assignment implements Statement {
	public Variable variable;
	public Expression expression;

	public Assignment(Variable variable, Expression expression) {
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
