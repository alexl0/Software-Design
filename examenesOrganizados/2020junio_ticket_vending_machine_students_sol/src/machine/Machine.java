package machine;

import java.util.*;

import adapter.PaypalAdapter;
import machine.hardware.*;
import machine.model.*;
import ruralvia.BankGateway;
import strategy.PayByCard;
import strategy.PayByCash;
import strategy.PayByPaypal;
import template.VERANOVEINTE;
import template.FREEONE;
import template.QUINCEURACOS;

//Nota: Los metodos de pago en efectivo y con tarjeta no se han aplicado con el patron Adapter ya que se encontraban ya redefinidos de esa forma.
//Solo se ha contemplado como pedia el enunciado adaptar el metodo de pago nuevo Paypal y las demás se han dejado a criterio del Strategy por lo que entiendo que no sería estrictamente conveniente.

//Patron Strategy
//Esta sería la clase Context donde se configuran las estrategias concretas

public class Machine {
	private enum PaymentMode {
		CREDIT_CARD, CASH, PAYPAL
	}

	private List<Event> events = new ArrayList<>();

	// los distintos componentes físicos con los que interactúa la máquina
	// expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	// private CardReader cardReader = new CardReader();
	// private BillAcceptor billAcceptor = new BillAcceptor();

	// pasarela de pagos (para los pagos con tarjeta)
	// private BankGateway bankGateway = new BankGateway();
	Event selectedEvent;
	QUINCEURACOS quinceuracos = new QUINCEURACOS();
	VERANOVEINTE veranoveinte = new VERANOVEINTE();
	FREEONE freeone = new FREEONE();

	// -- Métodos públicos
	// -------------------------------------------------------------------------

	public void addEvent(Event event) {
		events.add(event);
	}

	public void run() {
		while (true) {
			selectedEvent = selectEvent();
			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
			double amountToPay = numberOfTickets * selectedEvent.getPrice();

			// se calcula el código de descuento

			display.show("\nIntroduzca código de descuento: ");
			String code = keyboard.readString();
			if (code.equals("15EURACOS")) {
				amountToPay = quinceuracos.applyCode(amountToPay, selectedEvent.getPrice());
			} else if (code.equals("15EURACOS")) {
				amountToPay = veranoveinte.applyCode(amountToPay, selectedEvent.getPrice());
			} else if (code.equals("FREE1")) {
				amountToPay = freeone.applyCode(amountToPay, selectedEvent.getPrice());
			}

			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));

			if (amountToPay > 0) {

				PaymentMode paymentMode = selectPaymentMode();

				// se realiza el pago
				boolean isValidPayment;
				if (paymentMode == PaymentMode.CREDIT_CARD) {
					PayByCard payByCard = new PayByCard();
					isValidPayment = payByCard.pay(amountToPay);
				} else if (paymentMode == PaymentMode.CASH) {
					PayByCash payByCash = new PayByCash();
					isValidPayment = payByCash.pay(amountToPay);
				} else if (paymentMode == PaymentMode.PAYPAL) {
					PayByPaypal payByPaypal = new PayByPaypal();
					isValidPayment = payByPaypal.pay(amountToPay);
				} else {
					throw new AssertionError("Método de pago desconocido: " + paymentMode);
				}

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

	// -- Pago
	// -------------------------------------------------------------------------

	private PaymentMode selectPaymentMode() {
		display.show("\nEscoja un método de pago:\n");
		display.show("  1. Pago con tarjeta\n");
		display.show("  2. Pago en efectivo\n");
		display.show("  3. Pago con PayPal\n");
		int option = keyboard.readOption(3);
		switch (option) {
		case 1:
			return PaymentMode.CREDIT_CARD;
		case 2:
			return PaymentMode.CASH;
		case 3:
			return PaymentMode.PAYPAL;
		default:
			throw new AssertionError("Método de pago inválido");
		}
	}
	/*
	 * private boolean payByCard(double amount) { String cardNumber =
	 * cardReader.readCardNumber(); boolean isValid = bankGateway.pay(cardNumber,
	 * amount); if (!isValid) { display.show("Tarjeta rechazada\n"); return false; }
	 * // pago correcto
	 * display.show("Tarjeta aceptada: pago realizado con éxito\n"); return true; }
	 */
	/*
	 * private boolean payByCash(double amount) { int insertedAmount = 0; boolean
	 * cancel = false; billAcceptor.reset(); do {
	 * display.show(String.format("Quedan por pagar %.2f €%n", amount -
	 * insertedAmount)); double inserted = billAcceptor.insertBill(); insertedAmount
	 * = billAcceptor.getTotalAmount(); if (inserted == 0) cancel = true; } while
	 * (insertedAmount < amount && !cancel);
	 * 
	 * if (cancel) { display.show("Operación cancelada por el usuario\n"); // si
	 * antes de cancelar había introducido dinero, se le devuelve if (insertedAmount
	 * > 0) billAcceptor.returnChange(insertedAmount); return false; }
	 * display.show("Pago completado\n"); // se devuelve el cambio if
	 * (insertedAmount > amount) { billAcceptor.returnChange(insertedAmount -
	 * amount); } return true; }
	 */
	/*
	 * private boolean payByPaypal(double amount) { PaypalAdapter paypalAdapter =
	 * new PaypalAdapter();
	 * 
	 * if(paypalAdapter.isValid()) { paypalAdapter.pay(amount); return true; }
	 * return false; }
	 */

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

	// -- Descuentos
	// -------------------------------------------------------------------------

	/*
	 * Version sin patron private double applyCode(String code, double amount) {
	 * List<String> codes = new ArrayList<>(); codes.add("15EURACOS");
	 * codes.add("VERANO20"); codes.add("FREE1");
	 * 
	 * if(code.equals("15EURACOS")) { return amount - 15; }else
	 * if(code.equals("VERANO20")){ return amount - 20; }else
	 * if(code.equals("FREE1")) { return amount - (selectedEvent.getPrice()); }
	 * 
	 * if(amount < 0) { return 0; } return amount;
	 * 
	 * 
	 * 
	 * }
	 */

}
