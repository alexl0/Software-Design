package machine;

import java.util.*;

import machine.discount.Discount;
import machine.hardware.*;
import machine.model.*;
import machine.payMehods.PayMethod;

public class Machine {

	private List<Event> events = new ArrayList<>();

	// los distintos componentes físicos con los que interactúa la máquina
	// expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();

	// Strategy
	private PayMethod payMethod;
	private List<PayMethod> payMethods = new ArrayList<PayMethod>();

	// Strategy
	private Discount discount;
	private List<Discount> discounts = new ArrayList<Discount>();

	// -- Métodos públicos
	// -------------------------------------------------------------------------
	public void addEvent(Event event) {
		events.add(event);
	}

	public void addPayMethod(PayMethod payMethod) {
		this.payMethods.add(payMethod);
	}

	public void addDiscount(Discount discount) {
		this.discounts.add(discount);
	}

	public void run() {
		while (true) {
			Event selectedEvent = selectEvent();

			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
			double amountToPay = numberOfTickets * selectedEvent.getPrice();
			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));

			selectDiscount();
			if (discount == null)
				display.show("No hay descuento");
			else {
				amountToPay -= discount.getDiscount(amountToPay, numberOfTickets);
				display.show("Descuento a aplicar: " + discount.getName());
			}

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

	// -- Pago
	// -------------------------------------------------------------------------
	private void selectPaymentMode() {
		display.show("\nEscoja un método de pago:\n");
		for (int i = 1; i <= payMethods.size(); i++) {
			display.show("\t" + i + ": " + payMethods.get(i - 1).getClass().toString());
		}
		int option = keyboard.readOption(payMethods.size());
		payMethod = payMethods.get(option - 1);
		display.show("Ha escojido el metodo de pago: " + payMethod.getClass().toString());

	}

	// -- Discount
	// -------------------------------------------------------------------------
	private void selectDiscount() {
		display.show("\nIntroduzca un codigo de descuento:\n");
		String code = keyboard.readString();
		for (int i = 0; i < discounts.size(); i++) {
			if (discounts.get(i).getName().equals(code)) {
				discount = discounts.get(i);
				break;
			}
		}
	}

	// -- Seleccionar evento
	// -------------------------------------------------------------------------
	private Event selectEvent() {
		showEvents();
		int option = keyboard.readOption(events.size());
		Event event = events.get(option - 1);
		showEvent(event);
		return event;
	}

	private void showEvents() {
		display.show("Seleccione un evento:\n");
		int i = 1;
		for (Event each : events) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}
	}

	private void showEvent(Event event) {
		display.show("Evento seleccionado:\n");
		display.show("  " + event.getName() + "\n");
		display.show(String.format("  Quedan %d entradas disponibles a %.2f euros%n", event.getAvailableTickets(),
				event.getPrice()));
	}

	// -- Pedir el número de entradas
	// -------------------------------------------------------------------------
	private int howManyTickets(int availableTickets) {
		do {
			int numberOfTickets = keyboard.readInt();
			if (numberOfTickets <= availableTickets)
				return numberOfTickets;
			display.show(String.format("Sólo quedan %d entradas disponibles, seleccione un número menor: ",
					availableTickets));
		} while (true);
	}
}
