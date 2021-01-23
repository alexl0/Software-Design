package actions;

public class MeteorologyAction implements Action {

	@Override
	public void execute() {
		System.out.println("Conectando con el servidor...");
        System.out.println("Hoy hace mucho frío y mañana también hará frío, mejor quedate en casa");
	}

	@Override
	public String getDescription() {
		return "Ver el tiempo de hoy y mañana";
	}

}
