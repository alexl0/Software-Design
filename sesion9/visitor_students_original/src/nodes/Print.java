package nodes;

import visitor.Visitor;

public class Print implements Statement 
{
	public Expression expression;

	public Print(Expression expression) 
	{
		this.expression = expression;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
