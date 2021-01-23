package actions.tv_actions;

import actions.Action;
import tv.TV;

public class TVVolumeDown implements Action {

	TV tv;

	public TVVolumeDown(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.volumeDown();
	}

	@Override
	public String getButtonIcon() {
		return "Bajar el volumen del televisor";
	}

}
