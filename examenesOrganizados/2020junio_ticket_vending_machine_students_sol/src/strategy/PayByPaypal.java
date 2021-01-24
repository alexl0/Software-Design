package strategy;

//Patrón Strategy
//Esta sería la clase ConcreteStrategy donde implementa los distintos algoritmos de la interfaz Strategy

//Patron Adapter
//Esta sería la clase Cliente la cual colabora con objetos de tipo Target(Adapter)

import adapter.Adapter;
//Patrón Strategy
//Esta sería la clase ConcreteStrategy donde implementa los distintos algoritmos de la interfaz Strategy
//Patron Adapter
//Esta seria la clase client la cual colabora con objetos de tipo Target
import adapter.PaypalAdapter;

public class PayByPaypal implements Pay {

	private Adapter adapter;

	@Override
	public boolean pay(double amount) {
		adapter = new PaypalAdapter();

		if (adapter.isValid()) {
			adapter.pay(amount);
			return true;
		}
		return false;
	}

}
