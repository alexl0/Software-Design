package nodes;

import visitor.Visitor;

public class IntegerLiteral implements Expression 
{
	public String value;

	public IntegerLiteral(String value) 
	{
		this.value = value;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
