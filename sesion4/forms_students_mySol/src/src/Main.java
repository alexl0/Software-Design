package src;

import validators.IsDigit;
import validators.CampoPredefinido;
import validators.GreaterThan;
import validators.IsText;
import validators.LessThan;
import validators.TalLongitud;
import validators.composite.CheckAll;
import validators.composite.CheckAny;

public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre", new IsText()));
		formulario.addCampo(new Campo("Apellido", new IsText()));
		formulario.addCampo(new Campo("Telefono", new IsDigit()));
		formulario.addCampo(new Campo("Ciudad", new CampoPredefinido("Ciudad", "Santander", "Oviedo", "Cadiz")));

		formulario.addCampo(new Campo("CodigoProducto", new TalLongitud(4)));
		formulario.addCampo(new Campo("CodigoPostal", new CheckAll(new IsDigit(), new TalLongitud(5))));
		formulario.addCampo(new Campo("Edad", new CheckAll(new IsDigit(), new GreaterThan(18))));
		formulario.addCampo(new Campo("Sueldo", new CheckAll(new IsDigit(), new GreaterThan(800), new LessThan(1200))));
		formulario.addCampo(new Campo("Ubicacion", new CheckAny(new CampoPredefinido("Ciudad", "Santander", "Oviedo", "Cadiz"), new CheckAll(new IsDigit(), new TalLongitud(5)))));
		formulario.addCampo(new Campo("CodigoPromo", new CheckAny(new IsText(), new CheckAll(new IsDigit(), new TalLongitud(3)))));
		
		formulario.PideDatos();
	}
}
