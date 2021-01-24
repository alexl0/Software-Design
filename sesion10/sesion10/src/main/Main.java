package main;

import collections.*;
import html.*;

public class Main {
	public static void main(String[] args) throws Exception {
		// # Parte 1
		// --------------------------------------------------------------------------------------

		HtmlGenerator htmlGenerator = new HtmlGenerator();
		String html;

		// Uso de la cola
		Queue queue = new Queue();
		queue.add("Amadeo");
		queue.add("Baldomero");
		queue.add("Cipriano");
		queue.add("Desiderio");
		queue.add("Eustaquio");

		// Imprimir cola en html
		html = htmlGenerator.writeHtml(queue);
		System.out.println(html);

		// Uso de la lista enlazada
		LinkedList list = new LinkedList();
		list.addFirst("Aniceto");
		list.addFirst("Braulio");
		list.addFirst("Crisanto");
		list.addFirst("Demetrio");
		list.addFirst("Epifanio");

		// Imprimir lista en html
		html = htmlGenerator.writeHtml(list);
		System.out.println(html);

		// Uso de la base de datos
		DataBase db = new DataBase();
		db.loadElements();

		// Imprimir base de datos en html
		html = htmlGenerator.writeHtml(db);
		System.out.println(html);

		// # Parte 2
		// --------------------------------------------------------------------------------------

		// $ Seccion A -----------------------------------------------------------
		System.out.println("Sección A ----------------------------");
		// Generar HTML con los nombres de la cola en mayúscula.
		// Generar HTML con solo los cuatro primeros caracteres de los nombres de la
		// lista.
		// Generar HTML con los nombres de la cola precedidos por "Don".

		// $ Sección B (filtro)
		// -----------------------------------------------------------
		System.out.println("Sección B ----------------------------");
		// Generar HTML con los nombres de la cola que tengan exactamente 9 caracteres.
		// Generar HTML con los nombres de la lista que tengan alguna 'r' entre sus dos
		// primeras letras.

		// $ Sección C (combinacion de A y B)
		// -----------------------------------------------------------
		System.out.println("Sección C ----------------------------");
		// Generar HTML con los nombres de la cola de longitud 8. Estos deberán
		// imprimirse en mayúsculas y con "Don" delante.
	}
}
