package nodes;

import visitor.Visitor;

public class Sum implements Expression 
{
	public Expression left, right;

	public Sum(Expression left, Expression right) 
	{
		this.left = left;
		this.right = right;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
