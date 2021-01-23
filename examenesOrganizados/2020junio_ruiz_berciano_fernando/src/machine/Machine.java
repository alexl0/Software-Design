package machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import descuentos.Descuento;
import machine.hardware.BillAcceptor;
import machine.hardware.CardReader;
import machine.hardware.Display;
import machine.hardware.Keyboard;
import machine.hardware.Printer;
import machine.model.Event;
import machine.model.Ticket;
import medioPago.MedioPago;

public class Machine {

	private List<Event> events = new ArrayList<>();
	//Lista q contiene los commands de los medios de pago.
	private List<MedioPago> payments = new ArrayList<MedioPago>();
	//HashMap q contiene los distintos descuentos
	private Map<String, Descuento> descuentos = new HashMap<String, Descuento>();

	// los distintos componentes físicos con los que interactúa la máquina
	// expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	private CardReader cardReader = new CardReader();
	private BillAcceptor billAcceptor = new BillAcceptor();

	// -- Métodos públicos
	// -------------------------------------------------------------------------

	public void addEvent(Event event) {
		events.add(event);
	}

	//Metodo para obtener el display
	public Display getDisplay() {
		return display;
	}

	//Metodo para obtener el keyboard
	public Keyboard getKeyboard() {
		return keyboard;
	}

	//Metodo para obtener el printer
	public Printer getPrinter() {
		return printer;
	}

	//Metodo para obtener el card reader
	public CardReader getCardReader() {
		return cardReader;
	}

	//Metodo para obtener el bill acceptor
	public BillAcceptor getBillAcceptor() {
		return billAcceptor;
	}

	//Metodo para añadir medios de pago
	public void addMedioPago(MedioPago medioPago) {
		payments.add(medioPago);
	}

	//Metodo para añadir descuentos
	public void addDescuento(String name, Descuento descuento) {
		descuentos.put(name, descuento);
	}

	public void run() {
		while (true) {
			Event selectedEvent = selectEvent();

			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
			double amountToPay = numberOfTickets * selectedEvent.getPrice();
			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));

			//se aplica el descuento en caso de poseer el codigo
			amountToPay = aplicarDescuento(amountToPay, numberOfTickets);
			MedioPago paymentMode = selectPaymentMode();
			

			// se realiza el pago
			boolean isValidPayment = paymentMode.isValidPay(amountToPay, this);

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

	//MEtodo nuevo para aplicar los descuentos
	private double aplicarDescuento(double amount, int tickets) {
		display.show("\nEscoja un descuento:\n");
		String name = keyboard.readString();
		if (name.isEmpty()) {
			return amount;
		}
		Descuento descuento = descuentos.get(name);
		display.show(String.format("Importe a pagar: ", descuento.aplicarDescuento(tickets, amount)));
		return descuento.aplicarDescuento(tickets, amount);
	}

	// -- Pago
	// -------------------------------------------------------------------------

	//Metodo nuevo para seleccionar el medio de pago
	private MedioPago selectPaymentMode() {
		display.show("\nEscoja un método de pago:\n");
		for (int i = 0; i < payments.size(); i++) {
			display.show(i + 1 + "." + " " + payments.get(i).getNamePayment() + "\n");
		}
		int option = keyboard.readOption(3) - 1;
		return payments.get(option);
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
