package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public interface Node {
	void accept(Visitor visitor);
}
