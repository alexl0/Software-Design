public class Application 
{
	public static void main(String[] args) 
	{
		Temperatura [] temperaturas = new Temperatura[100];

		// Toma de datos
		for (int i = 0; i < temperaturas.length; i++)
			temperaturas[i] = new Temperatura(leeSensorCelsius());

		// Cálculo con los datos en Celsius
		double mediaCelsius = 0;
		for (int i = 0; i < temperaturas.length; i++)
			mediaCelsius += temperaturas[i].getCelsius();
		mediaCelsius = mediaCelsius / temperaturas.length;
		System.out.println("La media en Celsius es: " + mediaCelsius);

		// Cálculo con los datos en Fahrenheit
		double mediaFahrenheit = 0;
		for (int i = 0; i < temperaturas.length; i++)
			mediaFahrenheit += temperaturas[i].getFahrenheit();
		mediaFahrenheit = mediaFahrenheit / temperaturas.length;
		System.out.println("La media en Fahrenheit es: " + mediaFahrenheit);

		// Otro cálculo con los datos en Fahrenheit
		double varianza = 0;
		for (int i = 0; i < temperaturas.length; i++)
			varianza += Math.pow((temperaturas[i].getFahrenheit()) - mediaFahrenheit, 2);
		varianza = varianza / temperaturas.length;
		System.out.println("La varianza en Fahrenheit es: " + varianza);
	}

	public static double leeSensorCelsius() 
	{
		return Math.random() * 30;
	}

	/*
	 * Salida
	 * La media en Celsius es: 15,4 ºC
	 * La media en Fahrenheit es: 59,6 ºF
	 * La varianza en Fahrenheit es: 261,6
	 */

}