package forms_students.campos;

import forms_students.AbstractCampo;

public class CodigoDePromocion extends AbstractCampo {

	public CodigoDePromocion(String etiqueta) {
		super(etiqueta);
	}

	@Override
	public boolean condicion(String texto) {
		boolean isnum=true;
		for (char ch : texto.toCharArray())
			if (!Character.isDigit(ch))
				isnum=false;
		return isnum? texto.length()==3 : true;
	}

}
