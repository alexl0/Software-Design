package interpreter.ast.nodes;

import visitor.Visitor;

public interface Node
{
	Object accept(Visitor v, Object param);
}
