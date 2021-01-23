package visitor;

import nodes.Assignment;
import nodes.Division;
import nodes.IntegerLiteral;
import nodes.Print;
import nodes.Product;
import nodes.Program;
import nodes.Read;
import nodes.Statement;
import nodes.Sum;
import nodes.Variable;

public class PrintVisitor implements Visitor {

	@Override
	public void visit(Program p) {
		for (Statement sent : p.statements)
			sent.accept(this);
	}

	@Override
	public void visit(Assignment p) {
		visit(p.variable);
		System.out.print(" = ");
		p.expression.accept(this);
		System.out.println(";");
	}

	@Override
	public void visit(Division p) {
		p.left.accept(this);
		System.out.print(" / ");
		p.right.accept(this);
	}

	@Override
	public void visit(IntegerLiteral p) {
		System.out.print(p.value);
	}

	@Override
	public void visit(Print p) {
		System.out.print("print ");
		p.expression.accept(this);
		System.out.println(";");
	}

	@Override
	public void visit(Product p) {
		p.left.accept(this);
		System.out.print(" * ");
		p.right.accept(this);
	}

	@Override
	public void visit(Read p) {
		System.out.print("read ");
		visit(p.variable);
		System.out.println(";");
	}

	@Override
	public void visit(Variable p) {
		System.out.print(p.name);
	}

	@Override
	public void visit(Sum p) {
		p.left.accept(this);
		System.out.print(" + ");
		p.right.accept(this);
	}

}
