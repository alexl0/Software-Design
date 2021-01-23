package actions.lamp_actions;

import actions.Action;
import lamp.Lamp;

public class TurnOnLamp implements Action {

	Lamp lamp;

	public TurnOnLamp(Lamp l) {
		this.lamp = l;
	}

	@Override
	public void execute() {
		lamp.turnOn();
	}

	@Override
	public String getButtonIcon() {
		return "Encender la luz";
	}

}
