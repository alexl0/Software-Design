package output.filter;

import output.Output;

public class SendToThisDevices implements Output {
	
	private Output[] outputs;

	public SendToThisDevices(Output... outputs) {
		this.outputs=outputs;
	}
	
	@Override
	public void send(String message) {
		for(Output o:outputs)
			o.send(message);
	}

}
