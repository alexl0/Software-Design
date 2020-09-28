import java.io.*;
import java.util.*;

public class Interpreter
{
	private static List<String[]> instructions = new ArrayList<>();
	private static int ip = 0;

	private static int[] memory = new int[1024];

	private static int[] stack = new int[32];
	private static int sp = 0;

	public static void main(String[] args) throws Exception 
	{
		BufferedReader file = new BufferedReader(new FileReader("factorial.txt"));

		String line;
		while ((line = file.readLine()) != null)
			loadSentence(line);
		file.close();

		executeProgram();
	}

	private static void executeProgram() 
	{
		while (ip < instructions.size()) {
			String[] sentence = instructions.get(ip);

			if (sentence[0].equals("push")) {
				push(Integer.parseInt(sentence[1]));
				ip++;
			} else if (sentence[0].equals("add")) {
				push(pop() + pop());
				ip++;
			} else if (sentence[0].equals("sub")) {
				int b = pop();
				int a = pop();
				push(a - b);
				ip++;
			} else if (sentence[0].equals("mul")) {
				push(pop() * pop());
				ip++;
			} else if (sentence[0].equals("jmp")) {
				ip = Integer.parseInt(sentence[1]);
			} else if (sentence[0].equals("jmpg")) {
				int b = pop();
				int a = pop();
				if (a > b)
					ip = Integer.parseInt(sentence[1]);
				else
					ip++;
			} else if (sentence[0].equals("load")) {
				int address = pop();
				push(memory[address]);
				ip++;
			} else if (sentence[0].equals("store")) {
				int value = pop();
				int address = pop();
				memory[address] = value;
				ip++;
			} else if (sentence[0].equals("input")) {
				System.out.println("Escriba un entero:");
				push(readValue());
				ip++;
			} else if (sentence[0].equals("output")) {
				System.out.println(pop());
				ip++;
			}
		}
	}

	private static final boolean TRACE = false;

	/**
	 * Da igual que haya una clase para cada tipo de instruccion.
	 * Sí, es igual que el problema de la figura, y circulo, rectangulo y triangulo que heredan de figura, tiene que haber una clase para cada subtipo.
	 * Pero si hacemos una clase para cada tipo de instruccion lo único que estaríamos haciendo es coger la lógica condicional de la que hay que deshacerse
	 * y que ahora está en executeProgram(), y transladarla al loadSentence(), puesto que habría que hacer:
	 * 		if(tokens[0]=="push")
	 * 			instructions.add(new InstructionPush(tokens[1]);
	 * 		if(tokens[0]=="jmp")
	 * 			instructions.add(new InstructionJmp(tokens[1]);
	 * 		...
	 * 		...
	 * 		...
	 * Por lo que no nos estaríamos librando del problema de tener que comprobar si es una entre
	 * un montón de instrucciones, y si hay 1000 instrucciones, hacer 1000 comprobaciones para el caso de la
	 * instrucción número 1000.
	 * 
	 * No se me ocurre una manera de que no haya que hacer tantos if else como número de instrucciones haya.
	 * 
	 * @param line
	 */
	private static void loadSentence(String line) 
	{
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		if (TRACE) {
			for (String token : tokens)
				System.out.println("*" + token + "*");
		}
		instructions.add(tokens);
	}

	static void push(int value) 
	{
		stack[sp] = value;
		sp++;
	}

	static int pop() 
	{
		sp--;
		return stack[sp];
	}

	@SuppressWarnings("resource")
	static int readValue() 
	{
		return new Scanner(System.in).nextInt();
	}
}
