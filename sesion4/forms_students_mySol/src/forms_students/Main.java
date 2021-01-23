package forms_students;

import forms_students.campos.CampoNumero;
import forms_students.campos.CampoPredefinido;
import forms_students.campos.CampoTexto;
import forms_students.campos.CodigoDeProducto;
import forms_students.campos.CodigoDePromocion;
import forms_students.campos.CodigoPostal;
import forms_students.campos.Edad;
import forms_students.campos.Sueldo;
import forms_students.campos.Ubicacion;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new CampoTexto("Nombre"));
		formulario.addCampo(new CampoTexto("Apellido"));
		formulario.addCampo(new CampoNumero("Telefono"));
		formulario.addCampo(new CampoPredefinido("Ciudad", "Santander", "Oviedo", "Cadiz"));

		// Deberes
		formulario.addCampo(new CodigoDeProducto("Codigo de producto"));
		formulario.addCampo(new CodigoPostal("Codigo postal"));
		formulario.addCampo(new Edad("Edad"));
		formulario.addCampo(new Sueldo("Sueldo"));
		formulario.addCampo(new Ubicacion("Ubicacion"));
		formulario.addCampo(new CodigoDePromocion("Codigo de promocion"));

		formulario.PideDatos();
	}
}
