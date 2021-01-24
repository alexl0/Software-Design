package interpreter;

import interpreter.parser.Parser;
import interpreter.instructions.factories.*;

public class Application {
	private Parser parser;

	public static void main(String[] args) throws Exception {
		new Application().run();
	}

	public void run() throws Exception {
		parser = new Parser();

		// registra todas las instrucciones de nuestro intérprete junto con el
		// objeto que se encarga de saber cómo crear cada una
		registerFactories();

		Interpreter interpreter = new Interpreter(parser.parse("factorial.txt"));
		interpreter.run();
	}

	private void registerFactories() {
		parser.registerFactory("PUSH", new PushFactory());
		parser.registerFactory("ADD", new AddFactory());
		parser.registerFactory("SUB", new SubFactory());
		parser.registerFactory("MUL", new MulFactory());
		parser.registerFactory("JMP", new JumpFactory());
		parser.registerFactory("JMPG", new JumpIfGreaterThanFactory());
		parser.registerFactory("LOAD", new LoadFactory());
		parser.registerFactory("STORE", new StoreFactory());
		parser.registerFactory("INPUT", new InputFactory());
		parser.registerFactory("OUTPUT", new OutputFactory());
	}
}
