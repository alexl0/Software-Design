package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import validators.Validator;


public class Campo {

	private String etiqueta;
	private String texto;
	
	private Validator validator;
	
	public Campo(String etiqueta, Validator validator) {
		this.etiqueta = etiqueta;
		this.validator=validator;
	}
	
	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;
		do {
			valido = true;
			try {
				System.out.print(etiqueta + ": ");
				texto = consola.readLine();

				valido = validator.validate(texto);
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valido);
	}

	public String getString() {
		return texto;
	}

}
