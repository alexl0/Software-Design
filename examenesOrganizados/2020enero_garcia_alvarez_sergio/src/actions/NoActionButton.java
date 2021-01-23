package actions;

public class NoActionButton implements Action{

	@Override
	public void execute() {
		System.out.println("No hay accion ASIGNADA...");
	}

	@Override
	public String getButtonIcon() {
		return "Boton sin accion ASIGNADA...";
	}

}
