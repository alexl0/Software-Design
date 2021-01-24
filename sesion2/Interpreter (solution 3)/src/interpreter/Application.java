package interpreter;

import interpreter.parser.Parser;

public class Application {
	private Parser parser;

	public static void main(String[] args) throws Exception {
		new Application().run();
	}

	public void run() throws Exception {
		parser = new Parser();

		Interpreter interpreter = new Interpreter(parser.parse("factorial.txt"));
		interpreter.run();
	}
}
