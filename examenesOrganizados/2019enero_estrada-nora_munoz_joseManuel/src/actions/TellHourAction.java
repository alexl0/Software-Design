package actions;

public class TellHourAction implements Action {

	@Override
	public void execute() {
        System.out.println("Son las 12:00");
	}

	@Override
	public String getDescription() {
		return "Decir la hora";
	}

}
