package interpreter.ast.nodes;

import java.util.*;

import interpreter.visitor.Visitor;

public class Program implements Node {
	public List<Statement> statements;

	public Program(List<Statement> program) {
		this.statements = program;
	}

	@Override
	public void accept(Visitor visitor) {
		for (Statement s : statements)
			s.accept(visitor);
	}
}
