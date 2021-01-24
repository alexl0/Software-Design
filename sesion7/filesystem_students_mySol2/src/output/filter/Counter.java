package output.filter;

import output.Output;

public class Counter implements Output {
	
	private Output output;

	private int count;
	
	public Counter(Output output) {
		this.output=output;
		this.count=0;
	}
	
	@Override
	public void send(String message) {
		count=message.length();
		output.send(message);
	}

	public int getCount() {
		return count;
	}
	
}
