package main;

import collections.*;
import html.*;

public class Main 
{
	public static void main(String[] args) throws Exception 
	{
		// # Parte 1 --------------------------------------------------------------------------------------

		// 1. Uso de la cola
		Queue queue = new Queue();
		queue.add("Amadeo");
		queue.add("Baldomero");
		queue.add("Cipriano");
		queue.add("Desiderio");
		queue.add("Eustaquio");

		HtmlGenerator htmlGenerator = new HtmlGenerator();
		String html = htmlGenerator.writeHtml(queue);
		System.out.println(html);

		// 2. Uso de la lista enlazada
//		LinkedList list = new LinkedList();
//		list.addFirst("Aniceto");
//		list.addFirst("Braulio");
//		list.addFirst("Crisanto");
//		list.addFirst("Demetrio");
//		list.addFirst("Epifanio");
//
//		html = htmlGenerator.writeHtml(list);
//		System.out.println(html);
		//		for (int i = 0; i < list.size(); i++) {
		//			System.out.println(list.getElementAt(i));
		//		}

		// 3. Problema: ¿Cómo imprimir la lista también en HTML?

		// 4. Problema: ¿Cómo imprimir los nombres de "database.txt" en HTML?

		// # Parte 2 --------------------------------------------------------------------------------------

		// $ Sección A -----------------------------------------------------------
		System.out.println("Sección A ----------------------------");
		// Generar HTML con los nombres de la cola en mayúscula.
		// Generar HTML con sólo los cuatro primeros caracteres de los nombres de la lista.
		// Generar HTML con los nombres de la cola precedidos por "Don".

		// $ Sección B -----------------------------------------------------------
		System.out.println("Sección B ----------------------------");
		// Generar HTML con los nombres de la cola que tengan exactamente 9 caracteres.
		// Generar HTML con los nombres de la lista que tengan alguna 'r' entre sus dos primeras letras.

		// $ Sección C -----------------------------------------------------------
		System.out.println("Sección C ----------------------------");
		// Generar HTML con los nombres de la cola de longitud 8. Estos deberán imprimirse en mayúsculas y con "Don" delante.
	}
}
