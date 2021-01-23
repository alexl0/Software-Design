package actions.airConditioner_actions;

import actions.Action;
import airconditioning.AirConditioner;
import airconditioning.AirConditioner.Mode;

public class SetAirConditionerMode implements Action{

	AirConditioner ac;
	Mode mode;
	
	public SetAirConditionerMode(AirConditioner ac, Mode m) {
		this.ac = ac;
		this.mode = m;
	}
	
	@Override
	public void execute() {
		ac.setMode(mode);
		
	}

	@Override
	public String getButtonIcon() {
		if(mode == Mode.OFF)
		return "Apagar aire acondicionado";
		else if(mode == Mode.LOW)
		return "Poner el aire acondicionado a baja potencia";
		else {
		return "Poner el aire acondicionado a alta potencia";
		}
	}
	
	

}
