package visitor;

import nodes.Assignment;
import nodes.Division;
import nodes.IntegerLiteral;
import nodes.Print;
import nodes.Product;
import nodes.Program;
import nodes.Read;
import nodes.Sum;
import nodes.Variable;

public interface Visitor {
	void visit(Program p);
	void visit(Assignment p);
	void visit(Division p);
	void visit(IntegerLiteral p);
	void visit(Print p);
	void visit(Product p);
	void visit(Read p);
	void visit(Variable p);
	void visit(Sum p);
}
