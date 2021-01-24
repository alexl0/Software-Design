package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public class Read implements Statement {
	public Variable variable;

	public Read(Variable variable) {
		this.variable = variable;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
