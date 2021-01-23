package forms_students.campos;

import forms_students.AbstractCampo;

public class CodigoDeProducto extends AbstractCampo {

	public CodigoDeProducto(String etiqueta) {
		super(etiqueta);
	}

	@Override
	public boolean condicion(String texto) {
		return texto.length() == 4;
	}

}
