package machine;

import java.util.*;

import machine.hardware.*;
import machine.model.*;
import machine.payMehods.PayByCard;
import machine.payMehods.PayByCash;
import machine.payMehods.PayByPayPal;
import machine.payMehods.PayMethod;

public class Machine {

	private List<Event> events = new ArrayList<>();

	// los distintos componentes físicos con los que interactúa la máquina expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	
	
	//Strategy
	private PayMethod payMethod;
	
	//-- Métodos públicos
	//-------------------------------------------------------------------------

	public void addEvent(Event event)
	{
		events.add(event);
	}
	
	public void run()
	{
		while (true)
		{
			Event selectedEvent = selectEvent();
			
			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
			double amountToPay = numberOfTickets * selectedEvent.getPrice();
			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));
			
			selectPaymentMode();
			
			// se realiza el pago
			boolean isValidPayment;
			isValidPayment = payMethod.pay(amountToPay);

			if (!isValidPayment) {
				display.show("No se ha podido completar el pago\n\n");
				continue;
			}
			
			// se generan las entradas
			List<Ticket> tickets = selectedEvent.generateTickets(numberOfTickets);
			
			// por último, la máquina imprime las entradas generadas
			display.show("\nSus entradas se están imprimiendo...\n");
			for (Ticket ticket : tickets) {
				printer.printTicket(ticket);			
			}
			
			display.show("Gracias por su compra, que disfrute del evento.\n\n");			
		}
	}
	
	
	
	//-- Pago
	//-------------------------------------------------------------------------
	
	private void selectPaymentMode()
	{
		display.show("\nEscoja un método de pago:\n");
		display.show("  1. Pago con tarjeta\n");
		display.show("  2. Pago en efectivo\n");
		display.show("  3. Pago por PayPal\n");
		int option = keyboard.readOption(3);
		switch (option) {
			case 1:
				payMethod=new PayByCard();
				break;
			case 2:
				payMethod=new PayByCash();
				break;
			case 3:
				payMethod=new PayByPayPal();
				break;
			default: throw new AssertionError("Método de pago inválido");
		}
	}

	//-- Seleccionar evento
	//-------------------------------------------------------------------------
	
	private Event selectEvent()
	{
		showEvents();
		int option = keyboard.readOption(events.size());
		Event event = events.get(option - 1);
		showEvent(event);
		return event;
	}
	
	private void showEvents()
	{
		display.show("Seleccione un evento:\n");
		int i = 1;
		for (Event each : events) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}
	}
	
	private void showEvent(Event event)
	{
		display.show("Evento seleccionado:\n");
		display.show("  " + event.getName() + "\n");
		display.show(String.format("  Quedan %d entradas disponibles a %.2f euros%n", 
				event.getAvailableTickets(), event.getPrice()));
	}
	
	
	//-- Pedir el número de entradas
	//-------------------------------------------------------------------------
	
	private int howManyTickets(int availableTickets)
	{
		do {
			int numberOfTickets = keyboard.readInt();
			if (numberOfTickets <= availableTickets)
				return numberOfTickets;
			display.show(String.format("Sólo quedan %d entradas disponibles, seleccione un número menor: ",
					availableTickets));
		} while (true);
	}	
}
