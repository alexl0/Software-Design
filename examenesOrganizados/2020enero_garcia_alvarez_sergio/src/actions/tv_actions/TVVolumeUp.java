package actions.tv_actions;

import actions.Action;
import tv.TV;

public class TVVolumeUp implements Action{

	TV tv;

	public TVVolumeUp(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.volumeUp();
	}

	@Override
	public String getButtonIcon() {
		return "Subir el volumen del televisor";
	}

}
