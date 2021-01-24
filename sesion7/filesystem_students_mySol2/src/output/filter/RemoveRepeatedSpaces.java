package output.filter;

import output.Output;

public class RemoveRepeatedSpaces implements Output {

	private Output output;

	public RemoveRepeatedSpaces(Output output) {
		this.output=output;
	}
	
	@Override
	public void send(String message) {
		String newMessage="";
		
		boolean lastWasSpace=false;
		
		for(char c: message.toCharArray())
			if(c==' ') {
				if(!lastWasSpace) {
					newMessage+=(char)c;
					lastWasSpace=true;
				}
			} else {
				newMessage+=(char)c;
				lastWasSpace=false;
			}
		
		output.send(newMessage);
	}

}
