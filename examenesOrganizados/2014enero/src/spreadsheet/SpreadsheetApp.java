package spreadsheet;

import spreadsheet.model.Spreadsheet;

public class SpreadsheetApp {
	public static void main(String[] args) {
		Spreadsheet ss = new Spreadsheet();

		// Primero, unos cuantos valores literales
		ss.getCell("A1").setValue(2);
		ss.getCell("C3").setValue(5);
		ss.getCell("A3").setValue(3);
		ss.getCell("B4").setValue(-1);
		ss.getCell("D5").setValue(-12);

		// Mostramos el estado actual de la hoja de cálculo
		System.out.println(ss);
		System.out.println(ss.printTabularData());

		// Ahora, añadimos unas pocas fórmulas
		ss.getCell("B1").setFormula("SUMA(A1; A3; C3)"); // 2 + 3 + 5 = 10
		ss.getCell("A2").setFormula("SUMA(B1; C3; D5)"); // 10 + 5 + (-12) = 3
		ss.getCell("C1").setFormula("A1"); // Es una referencia a una celda: 2
		ss.getCell("C4").setFormula("PRODUCTO(A2; C1)"); // 3 * 2 = 6

		// Volvemos a mostrar la hoja, con las fórmulas añadidas
		System.out.println(ss);
		System.out.println(ss.printTabularData());

		// Comprobamos que las fórmulas se actualicen automáticamente
		// cuando cambia el valor de alguna celda a la que hacen referencia
		ss.getCell("A1").setValue(4);

		System.out.println(ss);
		System.out.println(ss.printTabularData());

		// Probamos las nuevas funciones añadidas
		ss.getCell("D1").setFormula("MIN(A1; A3; C3)"); // 3
		ss.getCell("D2").setFormula("MAX(A1; A3; C3)"); // 5
		ss.getCell("D3").setFormula("MIN(A1; B1; C1; A2; A3; C4; B4; D5)"); // -12
		ss.getCell("D4").setFormula("MAX(A1; B1; C1; A2; A3; C4; B4; D5)"); // 20

		System.out.println(ss);
		System.out.println(ss.printTabularData());

		// Y comprobamos que siguen actualizándose correctamente
		ss.getCell("C3").setValue(1);
		ss.getCell("A3").setValue(7);

		System.out.println(ss);
		System.out.println(ss.printTabularData());

		// Por último, probamos a modificar una celda que tenía una fórmula
		// asignándole un valor, y viceversa
		ss.getCell("B1").setValue(8);
		ss.getCell("A3").setFormula("B4");
		ss.getCell("C1").setValue(6);
		ss.getCell("D5").setFormula("A3");

		System.out.println(ss);
		System.out.println(ss.printTabularData());

		/*
		 * El resultado final debe ser éste:
		 * 
		 * Fila 1: A1=4, B1=8, C1=6, D1=-1 [=MIN(A1; A3; C3)] Fila 2: A2=8 [=SUMA(B1;
		 * C3; D5)], D2=4 [=MAX(A1; A3; C3)] Fila 3: A3=-1 [=B4], C3=1, D3=-1 [=MIN(A1;
		 * B1; C1; A2; A3; C4; B4; D5)] Fila 4: B4=-1, C4=48 [=PRODUCTO(A2; C1)], D4=48
		 * [=MAX(A1; B1; C1; A2; A3; C4; B4; D5)] Fila 5: D5=-1 [=A3]
		 * +-------+-------+-------+-------+ | A | B | C | D |
		 * +-------+-------+-------+-------+-------+ | 1 | 4 | 8 | 6 | -1 |
		 * +-------+-------+-------+-------+-------+ | 2 | 8 | | | 4 |
		 * +-------+-------+-------+-------+-------+ | 3 | -1 | | 1 | -1 |
		 * +-------+-------+-------+-------+-------+ | 4 | | -1 | 48 | 48 |
		 * +-------+-------+-------+-------+-------+ | 5 | | | | -1 |
		 * +-------+-------+-------+-------+-------+
		 * 
		 */
	}
}
