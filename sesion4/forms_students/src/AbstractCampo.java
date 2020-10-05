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

				for (char ch : texto.toCharArray()) {
					if (!condicion(ch)) {
						valido = false;
						break;
					}
				}
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valido);
	}

	abstract boolean condicion(char ch);

}
