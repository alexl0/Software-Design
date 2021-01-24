package output.filter;

import output.Output;

public class CalculateMD5 implements Output {
	
	private Output output;

	private int MD5;
	
	public CalculateMD5(Output output) {
		this.output=output;
		this.MD5=0;
	}
	
	@Override
	public void send(String message) {
		MD5=message.getBytes().length;
		output.send(message);
	}

	public int getMD5() {
		return MD5;
	}
	
}
