package actions;

public class OrderCoffeeAction implements Action {

	@Override
	public void execute() {
		System.out.println("Conectando con el servidor...");
        System.out.println("Pedido online realizado de café");
	}

	@Override
	public String getDescription() {
		return "Pedir online café";
	}

}
