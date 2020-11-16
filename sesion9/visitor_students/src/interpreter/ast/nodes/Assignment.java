package interpreter.ast.nodes;

import visitor.Visitor;

public class Assignment implements Statement 
{
	public Variable variable;
	public Expression expression;

	public Assignment(Variable variable, Expression expression) 
	{
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor v, Object param) {
		return v.visit(this, param);
	}
}
