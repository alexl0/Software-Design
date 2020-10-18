package logger;

import logger.clases.Clase1;

public class main {

	public static void main(String[] args) {
		Clase1.method1();
		System.out.println(Logger.getInstance().getString());
	}

}
