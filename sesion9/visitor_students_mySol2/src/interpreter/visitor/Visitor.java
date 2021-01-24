package interpreter.visitor;

import interpreter.ast.nodes.Assignment;
import interpreter.ast.nodes.Division;
import interpreter.ast.nodes.IntegerLiteral;
import interpreter.ast.nodes.Print;
import interpreter.ast.nodes.Product;
import interpreter.ast.nodes.Program;
import interpreter.ast.nodes.Read;
import interpreter.ast.nodes.Sum;
import interpreter.ast.nodes.Variable;

public interface Visitor {
	void visit(Assignment assignment);

	void visit(Division division);

	void visit(IntegerLiteral integerLiteral);

	void visit(Print print);

	void visit(Product product);

	void visit(Program program);

	void visit(Read read);

	void visit(Sum sum);

	void visit(Variable variable);
}
