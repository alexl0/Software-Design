package interpreter.visitor;

import interpreter.ast.nodes.Assignment;
import interpreter.ast.nodes.Division;
import interpreter.ast.nodes.IntegerLiteral;
import interpreter.ast.nodes.Print;
import interpreter.ast.nodes.Product;
import interpreter.ast.nodes.Program;
import interpreter.ast.nodes.Read;
import interpreter.ast.nodes.Statement;
import interpreter.ast.nodes.Sum;
import interpreter.ast.nodes.Variable;

public class PrintVisitor implements Visitor {

	@Override
	public void visit(Assignment assignment) {
		assignment.variable.accept(this);
		System.out.print(" = ");
		assignment.expression.accept(this);
		System.out.println(";");
	}

	@Override
	public void visit(Division division) {
		division.left.accept(this);
		System.out.print(" / ");
		division.right.accept(this);
	}

	@Override
	public void visit(IntegerLiteral integerLiteral) {
		System.out.print(integerLiteral.value);
	}

	@Override
	public void visit(Print print) {
		System.out.print("print ");
		print.expression.accept(this);
		System.out.println(";");
	}

	@Override
	public void visit(Product product) {
		product.left.accept(this);
		System.out.print(" * ");
		product.right.accept(this);
	}

	@Override
	public void visit(Program program) {
		for (Statement s : program.statements)
			s.accept(this);
	}

	@Override
	public void visit(Read read) {
		System.out.print("read ");
		read.variable.accept(this);
		System.out.println(";");
	}

	@Override
	public void visit(Sum sum) {
		sum.left.accept(this);
		System.out.print(" + ");
		sum.right.accept(this);
	}

	@Override
	public void visit(Variable variable) {
		System.out.print(variable.name);
	}

}
