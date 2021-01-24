package spreadsheet.model;

import util.table.Table;

public class Spreadsheet {
	// Estructura de datos interna utilizada para representar la hoja de cálculo
	private Table<Cell> table = new Table<>();

	/**
	 * Devuelve la celda de la dirección especificada. Este método siempre devolverá
	 * un objeto celda (salvo que el parámetro no se corresponda con una dirección
	 * de celda válida), ya que, en caso de no existir ninguna celda en la posición
	 * indicada, se crea y se devuelve en este momento.
	 * 
	 * <p>
	 * Las direcciones de celdas se representan en el formato habitual de las hojas
	 * de cálculo, con una o varias letras que indican la columna, seguidas de un
	 * número que representa la fila. Por ejemplo, "A1" representaría la celda de la
	 * columna 1, fila 1; "C2" la de la tercera columna y segunda fila; etcétera.
	 * 
	 * <p>
	 * Si el parámetro recibido no se corresponde con una dirección de celda válida
	 * se lanzará una excepción {@code IllegalArgumentException}.
	 * 
	 * @param cellAddress una cadena de texto que representa una dirección de celda
	 *                    en el formato habitual (A1, C3, etcétera)
	 * @return la celda existente enla dirección especificada, si la hubiere, o la
	 *         nueva celda creada en caso de que sea la primera vez que se accede a
	 *         dicha dirección de celda
	 */
	public Cell getCell(String cellAddress) {
		Cell cell = table.getCell(cellAddress);
		if (cell == null) {
			// En esta versión inicial necesitamos pasarle a la celda una referencia
			// una referencia a la hoja de cálculo, para que las fórmulas puedan
			// obtener los valores de las referencias a celdas que tienen como
			// parámetros. Dependiendo de cómo lo resolváis, es posible que esto no
			// sea necesario. Ésta es, en todo caso, la única línea de esta clase
			// que podríais necesitar cambiar en vuestra solución, si asignáis esa
			// responsabilidad a otra clase distinta de Cell.
			cell = new Cell(this, cellAddress);
			table.addCell(cellAddress, cell);
		}
		return cell;
	}

	/**
	 * Devuelve una representación textual de esta hoja de cálculo. Para ello
	 * muestra únicamente las celdas existentes (las que se hayan creado mediante
	 * llamadas al método {@code getCell} de esta clase. Cada fila se muestra en una
	 * línea aparte, ordenadas por el índice de fila (primero la 1, luego la 2...),
	 * mediante el texto "Fila {nº de fila}: " seguido de las celdas de esa fila,
	 * ordenadas a su vez por el índice de columna (A, B, C...) y separadas entre sí
	 * por una coma seguida de un espacio en blanco.
	 * 
	 * <p>
	 * La información mostrada de cada celda individual es el resultado de llamar al
	 * método {@code toString} del objeto {@code Cell} de cada celda de esa fila.
	 * 
	 * <p>
	 * Por ejemplo:
	 * 
	 * <pre>
	 *	Fila 1: A1=4, B1=8, C1=6, D1=-1 [=MIN(A1; A3; C3)]
	 *	Fila 2: A2=8 [=SUMA(B1; C3; D5)], D2=4 [=MAX(A1; A3; C3)]
	 * </pre>
	 * 
	 * @return una cadena de texto que representa todas las celdas que existen
	 *         actualmente en la hoja de cálculo, ordenadas por filas y columnas
	 */
	@Override
	public String toString() {
		return table.toString();
	}

	// Los siguientes métodos, aunque complejos, por el formato de presentación
	// escogido, están bien como están (y en esta clase). No tenéis que hacer
	// nada con ellos.

	/**
	 * Devuelve una cadena representando los valores de esta hoja de cálculo en
	 * formato tabular. Las celdas vacías (no creadas aún mediante una llamada a
	 * {@code getCell} se muestran en blanco. Cada celda ocupa 7 caracteres de ancho
	 * más los dos de los bordes laterales.
	 * 
	 * @return una cadena que simula una representación de esta hoja de cálculo, en
	 *         modo texto, como si fuera una tabla gráfica, con los bordes entre
	 *         celdas representados mediante caracteres de texto
	 */
	public String printTabularData() {
		int numberOfColumns = table.getNumberOfColumns();
		StringBuilder result = new StringBuilder();
		result.append(printHeader()); // la cabecera con los nombres de columnas
		for (int row = 1; row <= table.getNumberOfRows(); row++) {
			// el borde superior de la fila
			result.append(printRowBorder(numberOfColumns));
			// la primera columna es el número de la fila actual
			result.append(String.format("\n|  %2d   ", row));
			for (int column = 1; column <= numberOfColumns; column++) {
				result.append(printCellValue(row, column)); // cada celda de esta fila
			}
			result.append("|\n");
		}
		// el borde inferior de la tabla
		result.append(printRowBorder(numberOfColumns));
		return result.toString();
	}

	/*
	 * Método auxiliar que imprime, en formato tabular, la fila superior de la tabla
	 * con los nombres de las columnas de esta hoja de cálculo (A, B...).
	 */
	private String printHeader() {
		StringBuilder result = new StringBuilder();
		result.append("        ");
		for (int column = 1; column <= table.getNumberOfColumns(); column++) {
			result.append("+-------");
		}
		result.append("+\n");
		result.append("        ");
		for (int column = 1; column <= table.getNumberOfColumns(); column++) {
			result.append(String.format("|  %2s   ", Table.getColumnIndexAsLetter(column)));
		}
		result.append("|\n");
		return result.toString();
	}

	/*
	 * Devuelve una cadena que pretende simular, en modo texto, el borde de una fila
	 * cuando esta hoja de cálculo se imprime como una tabla. Cada celda es de 7
	 * caracteres de ancho, más los dos de los bordes laterales. Así, por ejemplo,
	 * para 5 columnas, este método devolvería un objeto String con el siguiente
	 * valor:
	 * 
	 * "+-------+-------+-------+-------+-------+-------+-------+"
	 * 
	 */
	private String printRowBorder(int numberOfColumns) {
		StringBuilder result = new StringBuilder();
		for (int column = 0; column <= numberOfColumns; column++) {
			result.append("+-------");
		}
		result.append("+");
		return result.toString();
	}

	/*
	 * Otro método auxiliar de printTabularData que genera la cadena adecuada para
	 * representar como una celda de una tabla el valor de la celda especificada,
	 * como un número entero alineado a la derecha de la celda, o bien una celda
	 * vacía (siete espacios en blanco, más el borde izquierdo) en caso de que dicha
	 * celda no exista en la hoja de cálculo.
	 * 
	 * Ejemplos:
	 * 
	 * "|    -12 " "|      5 " "|        "
	 */
	private String printCellValue(int row, int column) {
		if (table.hasCell(row, column))
			return String.format("|%6d ", table.getCell(row, column).getValue());
		return "|       ";
	}
}
