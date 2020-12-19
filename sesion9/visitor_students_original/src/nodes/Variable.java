package nodes;

import visitor.Visitor;

public class Variable implements Expression 
{
	public String name;

	public Variable(String name) 
	{
		this.name = name;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
