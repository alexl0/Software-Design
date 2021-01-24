package interpreter.visitor;

public interface Visitor {
	void visitAssignment();

	void visitDivision();

	void visitIntegerLiteral();

	void visitPrint();

	void visitProduct();

	void visitProgram();

	void visitRead();

	void visitSum();

	void visitVariable();
}
