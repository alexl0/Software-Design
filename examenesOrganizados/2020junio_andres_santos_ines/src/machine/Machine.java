package machine;

import java.util.*;

import machine.hardware.*;
import machine.model.*;
import paymentmode.PaymentMode;
import promociones.Descuento;
import ruralvia.BankGateway;

public class Machine {
	//Contexto de las estrategias
	
	
	
	//Tipo de pago
	private PaymentMode modePayment;
	//Tipo de descuento (si no hay, es null)
	private Descuento descuento;
	
	//lista de tipos de pago
	private List<PaymentMode> paymentsMode = new ArrayList<>();
	//Hashmap de las promociones, también se podría hacer una clase promoción con un nombre y un descuento
	private HashMap<String, Descuento> promociones=new HashMap<String, Descuento>();

	private List<Event> events = new ArrayList<>();
	

	// los distintos componentes físicos con los que interactúa la máquina
	// expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	private CardReader cardReader = new CardReader();
	private BillAcceptor billAcceptor = new BillAcceptor();

	// pasarela de pagos (para los pagos con tarjeta)
	private BankGateway bankGateway = new BankGateway();

	// -- Métodos públicos
	// -------------------------------------------------------------------------

	public void addEvent(Event event) {
		events.add(event);
	}

	public void addPaymentMode(PaymentMode paymentmode) {
		paymentsMode.add(paymentmode);
	}

	public void addPromociones(String nombre,Descuento descuento) {
		promociones.put(nombre,descuento);
	}

	public void run() {
		while (true) {
			Event selectedEvent = selectEvent();

			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
			double amountToPay = numberOfTickets * selectedEvent.getPrice();
			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));
			
			//PEDIMOS CODIGO PROMOCIONAL
			display.show("\nEscriba un código promocional o deje en blanco:");
			selectPromocion();
			
			if (descuento!=null) {
				amountToPay=descuento.cantidadDescuento(amountToPay,selectedEvent.getPrice());
				
			}
			display.show(String.format("\nImporte a pagar: %.2f €%n", amountToPay));
			
			//SI CON EL DESCUENTO Y TODO ES 0, SALTAMOS LO DE LA TARJETA
			if (amountToPay!=0) {
				modePayment = selectPaymentMode();
				// se realiza el pago
				boolean isValidPayment;
				isValidPayment = modePayment.isValidPayment(amountToPay, this);

				if (!isValidPayment) {
					display.show("No se ha podido completar el pago\n\n");
					continue;
				}
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

	// -- Promocion
	// -------------------------------------------------------------------------

	private void selectPromocion() {
		String option = keyboard.readString();
		descuento=promociones.get(option);
		if (descuento==null) {
			display.show("Promocion inexistente");
		}
	}



	// -- Pago
	// -------------------------------------------------------------------------

	private PaymentMode selectPaymentMode() {
		showPaymentsMode();
		int option = keyboard.readOption(paymentsMode.size());
		return paymentsMode.get(option - 1);
	}

	private void showPaymentsMode() {
		display.show("\nEscoja un método de pago:\n");
		int i = 1;
		for (PaymentMode each : paymentsMode) {
			System.out.printf("%d. %s%n", i, each.getDescription());
			i++;
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

	public List<Event> getEvents() {
		return events;
	}

	public Display getDisplay() {
		return display;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public Printer getPrinter() {
		return printer;
	}

	public CardReader getCardReader() {
		return cardReader;
	}

	public BillAcceptor getBillAcceptor() {
		return billAcceptor;
	}

	public BankGateway getBankGateway() {
		return bankGateway;
	}

}
