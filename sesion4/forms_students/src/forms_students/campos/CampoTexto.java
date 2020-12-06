package forms_students.campos;

import forms_students.AbstractCampo;

public class CampoTexto extends AbstractCampo {

	public CampoTexto(String etiqueta) {
		super(etiqueta);
	}

	@Override
	public boolean condicion(String texto) {
		for (char ch : texto.toCharArray())
			if (!Character.isLetter(ch))
				return false;
		return true;
	}

}
