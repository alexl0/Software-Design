import form.Field;
import form.Form;

import form.validation.*;
import form.validation.advanced.LengthValidator;
import form.validation.advanced.compare.GreaterThanValidator;
import form.validation.advanced.compare.LessThanValidator;
import form.validation.advanced.compound.AndValidator;
import form.validation.advanced.compound.OrValidator;
import form.validation.basic.PredefinedValidator;

public class Main {
	public static void main(String[] args) {
		Form form = new Form();

		form.addField(new Field("Nombre", Field.TEXT));
		form.addField(new Field("Apellidos", Field.TEXT));
		form.addField(new Field("Teléfono", Field.NUMBER));

		Validator cities = new PredefinedValidator("Santander", "Oviedo", "Cádiz");
		form.addField(new Field("Ciudad", cities));

		// Ampliación

		form.addField(new Field("Código de producto", new LengthValidator(4)));
		Validator postalCode = new AndValidator(Field.NUMBER, new LengthValidator(5));
		form.addField(new Field("Código postal", postalCode));
		form.addField(new Field("Edad", new GreaterThanValidator(18)));
		form.addField(
				new Field("Sueldo", new AndValidator(new GreaterThanValidator(800), new LessThanValidator(1200))));
		form.addField(new Field("Ubicación", new OrValidator(cities, postalCode)));
		form.addField(new Field("Código de promoción",
				new OrValidator(Field.TEXT, new AndValidator(Field.NUMBER, new LengthValidator(3)))));

		form.askUser();
	}
}
