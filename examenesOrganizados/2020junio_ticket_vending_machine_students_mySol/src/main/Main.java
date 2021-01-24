package main;

import machine.*;
import machine.discount.Discount_15EURACOS;
import machine.discount.Discount_FREE1;
import machine.discount.Discount_VERANO20;
import machine.model.Event;
import machine.payMehods.PayByCard;
import machine.payMehods.PayByCash;
import machine.payMehods.PayByPayPal;

// El main sólo debería ser modificado para crear nuevos objetos que formen
// parte de la solución.
//
public class Main {
	public static void main(String[] args) {
		Machine machine = new Machine();

		// se introducen unos eventos en la máquina expendedora
		machine.addEvent(new Event("Concierto de los Rolling Stones", 120, 5));
		machine.addEvent(new Event("Cartelera: Blade runner", 10, 100));
		machine.addEvent(new Event("Actuación de Rubén García", 60, 80));
		machine.addEvent(new Event("Concierto de la OSPA", 90, 30));
		machine.addEvent(new Event("Ópera: Nabuco", 160, 20));

		machine.addPayMethod(new PayByCard());
		machine.addPayMethod(new PayByCash());
		machine.addPayMethod(new PayByPayPal());

		machine.addDiscount(new Discount_15EURACOS());
		machine.addDiscount(new Discount_FREE1());
		machine.addDiscount(new Discount_VERANO20());

		// se cede el control de la ejecución a la máquina
		machine.run();
	}
}
