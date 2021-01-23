package actions.tv_actions;

import actions.Action;
import tv.TV;

public class SwitchTVChannel implements Action{

	private int channel;
	private TV tv;
	
	public SwitchTVChannel(TV tv, int channel) {
		this.tv = tv;
		this.channel = channel;
	}
	
	@Override
	public void execute() {
		tv.setChannel(channel);
	}

	@Override
	public String getButtonIcon() {
		return "Poner el canal " + channel +" del televisor";
	}

}
