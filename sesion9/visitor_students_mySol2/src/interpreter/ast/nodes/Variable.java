package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public class Variable implements Expression {
	public String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
