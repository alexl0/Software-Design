package actions.tv_actions;

import actions.Action;
import tv.TV;

public class TurnOnOffTV implements Action{

	TV tv;
	
	public TurnOnOffTV(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		if(tv.isOn()) {
			tv.turnOff();
		}else {
			tv.turnOn();
		}
	}

	@Override
	public String getButtonIcon() {
		return "Encender/apagar el televisor";
	}

}
