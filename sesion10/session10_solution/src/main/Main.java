package main;

import collections.*;
import conditions.*;
import database.DatabaseIterator;
import functions.Filter;
import functions.Map;
import html.HtmlGenerator;
import transformations.*;

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

        writeHtml(queue.iterator());

        // 2. Uso de la lista enlazada
        LinkedList list = new LinkedList();
        list.addFirst("Aniceto");
        list.addFirst("Braulio");
        list.addFirst("Crisanto");
        list.addFirst("Demetrio");
        list.addFirst("Epifanio");

        // for (int i = 0; i < list.size(); i++) {
        //      System.out.println(list.get(i));
        // }

        // 3. Problema: ¿Cómo imprimir la lista también en HTML?
        writeHtml(list.iterator());

        // 4. Problema: ¿Cómo imprimir los nombres de "database.txt" en HTML?
        writeHtml(new DatabaseIterator());
        

        // # Parte 2 --------------------------------------------------------------------------------------

        // $ Sección A -----------------------------------------------------------
        System.out.println("Sección A ----------------------------");
        //     % Opción 1
        // Generar HTML con los nombres de la cola en mayúscula.
        writeHtml(new Map(new ToUpperCase(), queue.iterator()));
        // Generar HTML con sólo los cuatro primeros caracteres de los nombres de la lista.
        writeHtml(new Map(new FirstFourCharacters(), list.iterator()));
       // Generar HTML con los nombres de la cola precedidos por "Don".
        writeHtml(new Map(new DonPrefix(), queue.iterator()));

        //     % Opción 2
        writeHtml(new Map(s -> s.toUpperCase(), queue.iterator()));
        writeHtml(new Map(s -> s.substring(0, 4), list.iterator()));
        writeHtml(new Map(s -> "Don " + s, queue.iterator()));

        
        // $ Sección B -----------------------------------------------------------
        //     % Opción 1
       System.out.println("Sección B ----------------------------");
        // Generar HTML con los nombres de la cola que tengan exactamente 9 caracteres.
        writeHtml(new Filter(new Length(9), queue.iterator()));
        // Generar HTML con los nombres de la lista que tengan alguna 'r' entre sus dos primeras letras.
        writeHtml(new Filter(new Contains("r", 0, 2), list.iterator()));

        //     % Opción 2
        writeHtml(new Filter(s -> s.length() == 9, queue.iterator()));
        writeHtml(new Filter(s -> s.substring(0, 2).contains("r"), list.iterator()));

        
        // $ Sección C -----------------------------------------------------------
        System.out.println("Sección C ----------------------------");
        //     % Opción 1
        // Generar HTML con los nombres de la cola de longitud 8. Estos deberán imprimirse en mayúsculas y con "Don" delante.
        writeHtml(new Map(new DonPrefix(), new Map(new ToUpperCase(), new Filter(new Length(8), queue.iterator()))));

        //     % Opción 2
        writeHtml(new Map(s -> "Don " + s, new Map(s -> s.toUpperCase(), new Filter(s -> s.length() == 8, queue.iterator()))));
}
    
    private static void writeHtml(Iterator iterator)
    {
        HtmlGenerator htmlGenerator = new HtmlGenerator();
        String html = htmlGenerator.writeHtml(iterator);
        System.out.println(html);
    }
}
