package actions;

public class DoNothingAction implements Action {

	@Override
	public void execute() {
        System.out.println("[Botón sin configurar]");
	}

	@Override
	public String getDescription() {
		return "No hacer nada";
	}

}
