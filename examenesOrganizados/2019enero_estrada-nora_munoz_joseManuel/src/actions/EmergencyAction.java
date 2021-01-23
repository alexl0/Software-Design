package actions;

public class EmergencyAction implements Action {

	@Override
	public void execute() {
		System.out.println("Marcando el 112...");
        System.out.println("LlamadaConectada");
	}

	@Override
	public String getDescription() {
		return "Llamar a emergencias";
	}

}
