package interpreter;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interpreter.instructions.*;
import interpreter.instructions.factories.*;
import interpreter.parser.Parser;
import interpreter.parser.ParserException;

import org.junit.Before;
import org.junit.Test;

public class InterpreterTest 
{
	private Interpreter interpreter;
	private Parser parser;
	
	@Before
	public void setUp() throws Exception
	{
		parser = new Parser();
		registerFactories();
		interpreter = new Interpreter(parser.parse("factorial5.txt"));
	}
	
	private void registerFactories()
	{
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

	
	@Test
	public void testFactorial() throws ProgramException, IOException, ParserException 
	{
		interpreter.run();
		assertEquals(120, interpreter.getContext().pop());
	}
	
	@Test
	public void testEmptyStack() throws ProgramException
	{
		List<Instruction> program = new ArrayList<>();
		program.add(new Add());
		try {
			new Interpreter(program).run();
			fail("Se debería haber obtenido un error de ejecución de pila vacía");
		} catch (ProgramException e) {	
		}
		try {
			program = new ArrayList<>();
			program.add(new Push(5));
			program.add(new Add());
			new Interpreter(program).run();
			fail("Se debería haber obtenido un error de ejecución de pila vacía");
		} catch (ProgramException e) {			
		}
		program = new ArrayList<>();
		program.add(new Push(5));
		program.add(new Push(3));
		program.add(new Add());
		interpreter = new Interpreter(program);
		interpreter.run();
		assertEquals(8, interpreter.getContext().pop());
	}
	
	@Test
	public void testStackOverflow() throws ProgramException
	{
		List<Instruction> program = new ArrayList<>();
		for (int i = 0; i <= Context.STACK_SIZE; i ++) {
			program.add(new Push(i));			
		}
		try {
			new Interpreter(program).run();;
			fail("Se debería haber obtenido un error de desbordamiento de pila");
		} catch (ProgramException e) {	
		}
	}	
}