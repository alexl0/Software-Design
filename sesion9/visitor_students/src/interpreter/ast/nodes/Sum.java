package interpreter.ast.nodes;

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
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
