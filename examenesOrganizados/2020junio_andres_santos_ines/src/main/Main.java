package main;

import machine.*;
import machine.model.Event;
import paymentmode.Cash;
import paymentmode.Credit_card;
import paymentmode.PayPal;
import promociones.DescuentoCantidadFija;
import promociones.DescuentoEntradaGratis;
import promociones.DescuentoNada;
import promociones.DescuentoPorcentaje;

// El main sólo debería ser modificado para crear nuevos objetos que formen
// parte de la solución.
//
public class Main 
{
	public static void main(String[] args) 
	{		
		Machine machine = new Machine();
				
		// se introducen unos eventos en la máquina expendedora
		machine.addEvent(new Event("Concierto de los Rolling Stones", 120, 5));
		machine.addEvent(new Event("Cartelera: Blade runner", 10, 100));
		machine.addEvent(new Event("Actuación de Rubén García", 60, 80));
		machine.addEvent(new Event("Concierto de la OSPA", 90, 30));
		machine.addEvent(new Event("Ópera: Nabuco", 160, 20));
		
		///SE AÑADIÓ LO DE ABAJO PARA INTRODUCIR LOS TIPOS DE PAGO Y LAS PROMOCIONES CON SU DESCUENTO
		
		//se introduce los métodos de pago
		machine.addPaymentMode(new Credit_card("Pago con tarjeta"));
		machine.addPaymentMode(new Cash("Pago en efectivo"));
		machine.addPaymentMode(new PayPal("Pago por PayPal"));
		
		//promociones, se podría añadir tantas quieras de los tipos que quieras con la unica 
		//condición de que el nombre sea distinto
		machine.addPromociones("15EURACOS", new DescuentoCantidadFija(15));
		machine.addPromociones("VERANO20", new DescuentoPorcentaje(10));
		machine.addPromociones("FREE1", new DescuentoEntradaGratis());
		machine.addPromociones("", new DescuentoNada());
		
		// se cede el control de la ejecución a la máquina
		machine.run();
	}
}
