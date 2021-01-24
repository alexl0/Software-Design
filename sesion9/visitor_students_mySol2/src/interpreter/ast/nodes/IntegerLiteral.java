package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public class IntegerLiteral implements Expression {
	public String value;

	public IntegerLiteral(String value) {
		this.value = value;
	}

	@Override
	public void accept(Visitor visitor) {
		System.out.print(value);
	}
}
