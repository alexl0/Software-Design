package visitor;

import interpreter.ast.nodes.Assignment;
import interpreter.ast.nodes.Division;
import interpreter.ast.nodes.Expression;
import interpreter.ast.nodes.IntegerLiteral;
import interpreter.ast.nodes.Print;
import interpreter.ast.nodes.Product;
import interpreter.ast.nodes.Program;
import interpreter.ast.nodes.Read;
import interpreter.ast.nodes.Statement;
import interpreter.ast.nodes.Sum;
import interpreter.ast.nodes.Variable;

public interface Visitor {
	public Object visit(Assignment p, Object param);
	public Object visit(Division p, Object param);
	public Object visit(Expression p, Object param);
	public Object visit(IntegerLiteral p, Object param);
	public Object visit(Print p, Object param);
	public Object visit(Product p, Object param);
	public Object visit(Program p, Object param);
	public Object visit(Read p, Object param);
	public Object visit(Statement p, Object param);
	public Object visit(Sum p, Object param);
	public Object visit(Variable p, Object param);
	//public Object visit(Node p, Object param);
}
