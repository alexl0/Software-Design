package adapter;

//Patron Adapter
//Esta seria la clase Target
//Esta seria la interfaz que transformaria las peticiones al lenguaje entendido por la maquina
//Todos los metodos que implementa son necesarios para su correcto funcionamiento
//Es la interfaz especifica del dominio que compartirian todos los clientes, en este caso Paypal y los posibles nuevos metodos de pago.

public interface Adapter {

	
	void pay(double amount);
	boolean isValid();
}
