package forms_students.campos;

import forms_students.AbstractCampo;

public class Ubicacion extends AbstractCampo {

	public Ubicacion(String etiqueta) {
		super(etiqueta);
	}

	@Override
	public boolean condicion(String texto) {
		boolean iscp=true;
		for (char ch : texto.toCharArray())
			if (!Character.isDigit(ch))
				iscp=false;
		return iscp? texto.length()==5 : texto.toLowerCase()=="Santander" || texto.toLowerCase()=="Cadiz";
	}

}
