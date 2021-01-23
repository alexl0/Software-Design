package actions.lamp_actions;

import actions.Action;
import lamp.Lamp;

public class TurnOffLamp implements Action{

	Lamp lamp;
	
	public TurnOffLamp(Lamp lamp) {
		this.lamp = lamp;
	}
	
	@Override
	public void execute() {
		lamp.turnOff();
	}

	@Override
	public String getButtonIcon() {
		return "Apagar la luz";
	}

}
