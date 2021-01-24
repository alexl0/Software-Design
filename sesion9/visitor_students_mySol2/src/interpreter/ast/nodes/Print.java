package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public class Print implements Statement {
	public Expression expression;

	public Print(Expression expression) {
		this.expression = expression;
	}

	@Override
	public void accept(Visitor visitor) {
		System.out.print("print ");
		expression.accept(visitor);
		System.out.println(";");
	}
}
