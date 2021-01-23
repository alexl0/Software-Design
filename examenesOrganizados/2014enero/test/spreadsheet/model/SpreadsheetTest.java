package spreadsheet.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpreadsheetTest 
{
	private Spreadsheet ss;
	
	@Before
	public void setUp()
	{
		ss = new Spreadsheet();
		
		// Primero, unos cuantos valores literales		
		ss.getCell("A1").setValue(2);
		ss.getCell("C3").setValue(5);
		ss.getCell("A3").setValue(3);
		ss.getCell("B4").setValue(-1);
		ss.getCell("D5").setValue(-12);

		// Ahora, añadimos unas pocas fórmulas		
		ss.getCell("B1").setFormula("SUMA(A1; A3; C3)");	// 2 + 3 + 5 = 10
		ss.getCell("A2").setFormula("SUMA(B1; C3; D5)");	// 10 + 5 + (-12) = 3
		ss.getCell("C1").setFormula("A1");					// Es una referencia a una celda: 2
		ss.getCell("C4").setFormula("PRODUCTO(A2; C1)");	// 3 * 2 = 6
	}
		
	@Test
	public void testSimpleValues() 
	{
		assertEquals(2, ss.getCell("A1").getValue());
		assertEquals(5, ss.getCell("C3").getValue());
		assertEquals(3, ss.getCell("A3").getValue());
		assertEquals(-1, ss.getCell("B4").getValue());
		assertEquals(-12, ss.getCell("D5").getValue());
	}

	@Test
	public void testFormulas() 
	{
		assertEquals(10, ss.getCell("B1").getValue());
		assertEquals(3, ss.getCell("A2").getValue());
		assertEquals(6, ss.getCell("C4").getValue());
	}
	
	@Test
	public void testCellReferences() 
	{
		assertEquals(2, ss.getCell("C1").getValue());
	}
	
	@Test
	public void testPrintTabularData()
	{
		String expected = 
				"        +-------+-------+-------+-------+\n" +
				"        |   A   |   B   |   C   |   D   |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   1   |     2 |    10 |     2 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   2   |     3 |       |       |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   3   |     3 |       |     5 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   4   |       |    -1 |     6 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   5   |       |       |       |   -12 |\n" +
				"+-------+-------+-------+-------+-------+";
		assertEquals(expected, ss.printTabularData());		
	}
	
	@Test
	public void testUpdateValues()
	{
		ss.getCell("A1").setValue(4);
		assertEquals(12, ss.getCell("B1").getValue());
		assertEquals(5, ss.getCell("A2").getValue());
		assertEquals(4, ss.getCell("C1").getValue());
		assertEquals(20, ss.getCell("C4").getValue());
		
		String expected = 
				"        +-------+-------+-------+-------+\n" +
				"        |   A   |   B   |   C   |   D   |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   1   |     4 |    12 |     4 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   2   |     5 |       |       |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   3   |     3 |       |     5 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   4   |       |    -1 |    20 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   5   |       |       |       |   -12 |\n" +
				"+-------+-------+-------+-------+-------+";
		assertEquals(expected, ss.printTabularData());
	}
	
	@Test
	public void testMinAndMax()
	{
		ss.getCell("D1").setFormula("MIN(A1; A3; C3)");							// 2
		ss.getCell("D2").setFormula("MAX(A1; A3; C3)");							// 5
		ss.getCell("D3").setFormula("MIN(A1; B1; C1; A2; A3; C4; B4; D5)");		// -12
		ss.getCell("D4").setFormula("MAX(A1; B1; C1; A2; A3; C4; B4; D5)");		// 10
		
		assertEquals(2, ss.getCell("D1").getValue());
		assertEquals(5, ss.getCell("D2").getValue());
		assertEquals(-12, ss.getCell("D3").getValue());
		assertEquals(10, ss.getCell("D4").getValue());
	}
	
	@Test
	public void testUpdateMinAndMax()
	{
		ss.getCell("A1").setValue(4);

		ss.getCell("D1").setFormula("MIN(A1; A3; C3)");							// 3
		ss.getCell("D2").setFormula("MAX(A1; A3; C3)");							// 5
		ss.getCell("D3").setFormula("MIN(A1; B1; C1; A2; A3; C4; B4; D5)");		// -12
		ss.getCell("D4").setFormula("MAX(A1; B1; C1; A2; A3; C4; B4; D5)");		// 20
		
		assertEquals(3, ss.getCell("D1").getValue());
		assertEquals(5, ss.getCell("D2").getValue());
		assertEquals(-12, ss.getCell("D3").getValue());
		assertEquals(20, ss.getCell("D4").getValue());

		String expected = 
				"        +-------+-------+-------+-------+\n" +
				"        |   A   |   B   |   C   |   D   |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   1   |     4 |    12 |     4 |     3 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   2   |     5 |       |       |     5 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   3   |     3 |       |     5 |   -12 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   4   |       |    -1 |    20 |    20 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   5   |       |       |       |   -12 |\n" +
				"+-------+-------+-------+-------+-------+";
		assertEquals(expected, ss.printTabularData());
		
		// Otras dos actualizaciones de valores simples
		ss.getCell("C3").setValue(1);
		ss.getCell("A3").setValue(7);

		assertEquals(1, ss.getCell("D1").getValue());
		assertEquals(7, ss.getCell("D2").getValue());
		assertEquals(-12, ss.getCell("D3").getValue());
		assertEquals(12, ss.getCell("D4").getValue());

		expected = 
				"        +-------+-------+-------+-------+\n" +
				"        |   A   |   B   |   C   |   D   |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   1   |     4 |    12 |     4 |     1 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   2   |     1 |       |       |     7 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   3   |     7 |       |     1 |   -12 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   4   |       |    -1 |     4 |    12 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   5   |       |       |       |   -12 |\n" +
				"+-------+-------+-------+-------+-------+";
		assertEquals(expected, ss.printTabularData());
	}
	
	@Test
	public void testReplaceFormulaWithValue()
	{
		ss.getCell("B1").setValue(8);
		ss.getCell("C1").setValue(6);
		
		assertEquals(8, ss.getCell("B1").getValue());
		assertEquals(6, ss.getCell("C1").getValue());
		assertEquals("B1=8", ss.getCell("B1").toString());
		assertEquals("C1=6", ss.getCell("C1").toString());
		
		assertEquals(1, ss.getCell("A2").getValue());
		
		String expected = 
				"        +-------+-------+-------+-------+\n" +
				"        |   A   |   B   |   C   |   D   |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   1   |     2 |     8 |     6 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   2   |     1 |       |       |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   3   |     3 |       |     5 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   4   |       |    -1 |     6 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   5   |       |       |       |   -12 |\n" +
				"+-------+-------+-------+-------+-------+";
		assertEquals(expected, ss.printTabularData());
	}
	
	@Test
	public void testReplaceValueWithFormula()
	{
		String expected = 
				"        +-------+-------+-------+-------+\n" +
				"        |   A   |   B   |   C   |   D   |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   1   |     2 |    10 |     2 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   2   |     3 |       |       |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   3   |     3 |       |     5 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   4   |       |    -1 |     6 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   5   |       |       |       |   -12 |\n" +
				"+-------+-------+-------+-------+-------+";
		assertEquals(expected, ss.printTabularData());		

		ss.getCell("A3").setFormula("B4");
		ss.getCell("D5").setFormula("A3");
		
		expected = 
				"        +-------+-------+-------+-------+\n" +
				"        |   A   |   B   |   C   |   D   |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   1   |     2 |     6 |     2 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   2   |    10 |       |       |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   3   |    -1 |       |     5 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   4   |       |    -1 |    20 |       |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   5   |       |       |       |    -1 |\n" +
				"+-------+-------+-------+-------+-------+";
		assertEquals(expected, ss.printTabularData());				
	}
	
	@Test
	public void testAllTogether()
	{
		// Comprobamos que las fórmulas se actualicen automáticamente
		// cuando cambia el valor de alguna celda a la que hacen referencia
		ss.getCell("A1").setValue(4);

		// Probamos las nuevas funciones añadidas
		ss.getCell("D1").setFormula("MIN(A1; A3; C3)");							// 3
		ss.getCell("D2").setFormula("MAX(A1; A3; C3)");							// 5
		ss.getCell("D3").setFormula("MIN(A1; B1; C1; A2; A3; C4; B4; D5)");		// -12
		ss.getCell("D4").setFormula("MAX(A1; B1; C1; A2; A3; C4; B4; D5)");		// 20
		
		// Y comprobamos que siguen actualizándose correctamente
		ss.getCell("C3").setValue(1);
		ss.getCell("A3").setValue(7);
		
		// Por último, probamos a modificar una celda que tenía una fórmula
		// asignándole un valor, y viceversa
		ss.getCell("B1").setValue(8);
		ss.getCell("A3").setFormula("B4");
		ss.getCell("C1").setValue(6);
		ss.getCell("D5").setFormula("A3");

		// El resultado final debe ser éste:
		String expected = 
				"        +-------+-------+-------+-------+\n" +
				"        |   A   |   B   |   C   |   D   |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   1   |     4 |     8 |     6 |    -1 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   2   |     8 |       |       |     4 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   3   |    -1 |       |     1 |    -1 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   4   |       |    -1 |    48 |    48 |\n" +
				"+-------+-------+-------+-------+-------+\n" +
				"|   5   |       |       |       |    -1 |\n" +
				"+-------+-------+-------+-------+-------+";
		assertEquals(expected, ss.printTabularData());
	}
}
