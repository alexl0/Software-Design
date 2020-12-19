package nodes;

import java.util.*;

import visitor.Visitor;

public class Program implements Node 
{
    public List<Statement> statements;
    
    public Program(List<Statement> program) 
    {
        this.statements = program;
    }

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
