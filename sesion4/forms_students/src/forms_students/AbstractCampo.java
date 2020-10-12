package forms_students;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractCampo implements Campo {

	private String etiqueta;
	public AbstractCampo(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	private String texto;
	@Override
	public String getString() {
		return texto;
	}


	@Override
	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;
		do {
			valido = true;
			try {
				System.out.print(etiqueta + ": ");
				texto = consola.readLine();

				valido = condicion(texto);
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valido);
	}

	public abstract boolean condicion(String texto);

}
