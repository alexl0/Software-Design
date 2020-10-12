package forms_students.campos;

import forms_students.AbstractCampo;

public class CodigoPostal extends AbstractCampo{

	public CodigoPostal(String etiqueta) {
		super(etiqueta);
	}

	@Override
	public boolean condicion(String texto) {
		for (char ch : texto.toCharArray())
			if (!Character.isDigit(ch))
				return false;
		return texto.length()==5;
	}
}
