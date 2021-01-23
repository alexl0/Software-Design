package nodes;

import visitor.Visitor;

public interface Node {
	void accept(Visitor v);
}
