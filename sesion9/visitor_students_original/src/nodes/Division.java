package nodes;

import visitor.Visitor;

public class Division implements Expression {
	public Expression left, right;

	public Division(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
