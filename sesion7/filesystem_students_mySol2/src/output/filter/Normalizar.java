package output.filter;

import output.Output;

public class Normalizar implements Output {

	private Output output;

	public Normalizar(Output output) {
		this.output=output;
	}
	
	@Override
	public void send(String message) {
		String newMessage="";
		
		for(char c: message.toCharArray())
			if(c!='\r')
				newMessage+=(char)c;
		
		output.send(newMessage);
	}

}
