package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public class Division implements Expression {
	public Expression left, right;

	public Division(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void accept(Visitor visitor) {
		left.accept(visitor);
		System.out.print(" / ");
		right.accept(visitor);
	}

}
