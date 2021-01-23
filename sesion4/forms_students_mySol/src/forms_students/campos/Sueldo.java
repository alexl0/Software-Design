package forms_students.campos;

import forms_students.AbstractCampo;

public class Sueldo extends AbstractCampo {

	public Sueldo(String etiqueta) {
		super(etiqueta);
	}

	@Override
	public boolean condicion(String texto) {
		for (char ch : texto.toCharArray())
			if (!Character.isDigit(ch))
				return false;
		return Integer.parseInt(texto) >= 800 && Integer.parseInt(texto) <= 1200;
	}

}
