package spreadsheet.model;

public class Cell 
{
	private String address;
	private Spreadsheet spreadsheet;
	
	private int value;	
	private String formula;
	
	/**
	 * Crea una celda con la dirección especificada. Es también necesario (al
	 * menos, en esta versión inicial que se os entrega) asignarle una
	 * referencia a la hoja de calcula a la que pertenece para que esta celda
	 * pueda resolver las referencias a celdas en las fórmulas y obtener así el
	 * valor de éstas.
	 * 
	 * @param spreadsheet la hoja de cálculo a la que pertenece esta celda
	 * @param address una cadena de texto con la dirección de la celda a crear,
	 *        en el formato habitual de las hojas de cálculo (A1, C3, etcétera),
	 *        donde las letras representan la columna y el número la fila de la
	 *        celda
	 */
	public Cell(Spreadsheet spreadsheet, String address)
	{
		assert spreadsheet != null : "La referencia a la hoja de cálculo no puede ser nula";
		assert address != null && !address.isEmpty() : "Se necesita la dirección de la celda a crear";
		this.spreadsheet = spreadsheet;
		this.address = address.toUpperCase();
	}

	/**
	 * Devuelve la dirección de esta celda. La dirección de una celda identifica
	 * la posición de ésta en la hoja de cálculo, y está formada por la combinación
	 * de una o varias letras representando la <i>columna</i> y un número que
	 * representa la <i>fila</i> (por ejemplo, C4, D8, AAB111, etcétera).
	 *  
	 * @return una cadena de texto representando la posición de esta celda en la
	 *         hoja de cálculo
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * Devuelve el valor numérico de esta celda. Puede ser el valor introducido
	 * tal cual en la celda, como un número, por el usuario, o bien el resultado
	 * de evaluar la fórmula correspondiente. 
	 * 
	 * @return un número entero con el valor de esta celda
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Asigna un valor literal a esta celda. Nótese que, al hacerlo, estamos
	 * sobreescribiendo cualquier otro contenido que tuviese previamente la
	 * celda, lo que quiere decir que, en caso de que esta celda contuviese una
	 * fórmula, ésta se eliminará.
	 * 
	 * @param value el nuevo valor entero de la celda
	 */
	public void setValue(int value)
	{
		this.value = value;
		this.formula = null;
	}
	
	/**
	 * Establece la fórmula especificada como contenido de esta celda y actualiza
	 * el valor de la celda.
	 * 
	 * @param formulaText una cadena de texto que debe representar una fórmula
	 *        válida (en caso contrario se lanzará una excepción {@code
	 *        IllegalArgumentException)
	 */
	public void setFormula(String formulaText)
	{
		if (spreadsheet == null)
			throw new IllegalStateException("No se asignó a la celda una referencia a la hoja de cálculo");
		
		// Si no tiene lista de parámetros tiene que ser una referencia a una celda
		if (formulaText.indexOf("(") == -1) {
			this.value = spreadsheet.getCell(formulaText).getValue();
			this.formula = formulaText;
			return;
		}
		
		if (!formulaText.endsWith(")"))
			throw new IllegalArgumentException("Fórmula inválida: falta el paréntesis de cierre: " + formula);

		// Separa el nombre de la fórmula, sin espacios y en mayúsculas
		String name = formulaText.substring(0, formulaText.indexOf("(")).trim().toUpperCase();
		// Analiza la lista de parámetros y crea un array de cadenas con ellos
		String[] arguments = formulaText.substring(formulaText.indexOf("(") + 1, formulaText.length() - 1).split(";");
		for (int i = 0; i < arguments.length; i++) {
			arguments[i] = arguments[i].trim().toUpperCase();
		}
		
		if (arguments.length < 2)
			throw new IllegalArgumentException("Todas las fórmulas (salvo las referencias a celdas) necesitan al menos dos parámetros");
		
		// Normaliza la representación textual de la fórmula
		this.formula = name + "(";
		for (int i = 0; i < arguments.length; i++) {
			this.formula += arguments[i];
			if (i < arguments.length - 1)
				this.formula += "; "; 
		}
		this.formula += ")";
		
		if (name.equals("SUMA")) {
			this.value = 0;
			for (String arg: arguments) {
				this.value = this.value + spreadsheet.getCell(arg).getValue();
			}			
		} else if (name.equals("PRODUCTO")) {
			this.value = 1;
			for (String arg: arguments) {
				this.value = this.value + spreadsheet.getCell(arg).getValue();
			}				
		} else {
			throw new IllegalArgumentException("Fórmula desconocida: " + name);			
		}
	}
	
	/**
	 * Devuelve una representación textual de esta celda. Dicho valor consiste
	 * en una cadena con el siguiente formato:
	 * 
	 * <pre>
	 * 	{dirección}={valor} [={fórmula}]
	 * </pre>
	 * 
	 * <p>Donde {dirección} es la dirección de la celda, {valor} su valor numérico
	 * (el que se le haya introducido o el resultado de evaluar su fórmula, según
	 * corresponda) y {fórmula} una representación textual normalizada de la
	 * fórmula (nombre en mayúsculas y sin espacios, paréntesis sin espacios,
	 * referencias a celdas también en mayúsculas y separadas por punto y coma
	 * más exactamente un espacio en blanco). Ejemplos:
	 * 
	 * <pre>
	 * 	Celda A1=3
	 * 	Celda A2=3 [=A1]
	 * 	Celda B5=6 [=SUMA(A1; A2)]
	 * </pre>
	 */
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		result.append(address + "=");
		result.append(value);
		if (formula != null)
			result.append(" [=" + formula + "]");
		return result.toString();
	}
	
}
