package output.filter;

import output.Output;

public class Encrypt implements Output {
	
	private Output output;

	public Encrypt(Output output) {
		this.output=output;
	}
	
	@Override
	public void send(String message) {
		String newMessage="";
		
		for(char c: message.toCharArray())
			if(Character.isDigit(c) || Character.isLetter(c))
				newMessage+=(char)(c+1);
		
		output.send(newMessage);
	}

}
