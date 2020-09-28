/**
 * Solamente se hacen las conversiones cuando hace falta, es decir:
 * cuando me piden farenheit o celsius y lo que hay guardado en memoria no está bien, entonces se calcula
 * 
 * Ventaja: menos conversiones
 * Desventaja: utiliza más memoria
 * 
 * Lo IMPORTANTE es que el main no cambia, a las aplicaciones (Application.java) no les afectan los cambios
 * que hacemos, no tocames en ningún otro sitio que en esta clase (Temperatura.java)
 * 
 * Mientras no cambie el nombre de los 4 métodos, los cambios en la implementación no afectan a Application.java
 * 
 */
public class Temperatura {

	private double celsius;
	private double fahrenheit;

	private boolean celsiusOk;
	private boolean fahrenheitOk;

	public Temperatura(double celsius) {
		setCelsius(celsius);
	}

	public double getCelsius() {
		if (celsiusOk)
			return celsius;
		celsiusOk = true;
		return celsius = (fahrenheit - 32) / 1.8;
	}

	public double getFahrenheit() {
		if (fahrenheitOk)
			return fahrenheit;
		fahrenheitOk = true;
		return fahrenheit = celsius * 1.8 + 32;
	}

	public void setCelsius(double temp) {
		celsius = temp;
		celsiusOk = true;
		fahrenheitOk = false;
	}

	public void setFahrenheit(double temp) {
		fahrenheit = temp;
		fahrenheitOk = true;
		celsiusOk = false;
	} 

}
