package forms_students.campos;

import forms_students.AbstractCampo;

public class CampoPredefinido extends AbstractCampo {

	private String[] valores;

	public CampoPredefinido(String etiqueta, String... valores) {
		super(etiqueta);
		this.valores = valores;
	}

	@Override
	public boolean condicion(String texto) {
		for (String valor : valores)
			if (texto.toLowerCase().equals(valor.toLowerCase()))
				return true;
		return false;
	}

}
