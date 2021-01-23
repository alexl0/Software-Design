package actions;

public class OrderGilletteAction implements Action {

	@Override
	public void execute() {
        System.out.println("Conectando con el servidor...");
        System.out.println("Pedido online realizado de Gillete");
	}

	@Override
	public String getDescription() {
		return "Pedir online Gillette";
	}

}
