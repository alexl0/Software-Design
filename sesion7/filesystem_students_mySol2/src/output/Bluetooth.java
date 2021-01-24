package output;

import java.io.StringWriter;

public class Bluetooth implements Output {

	private String to;

	public Bluetooth(String to) {
		this.to=to;
	}

	@Override
	public void send(String message) {
		StringWriter stringWriter = new StringWriter();
		stringWriter.append("\n--- START Bluetooth [" + to + "]\n");

		for(char c: message.toCharArray())
			stringWriter.append(c);

		System.out.println(stringWriter.toString());
		System.out.println("--- END   Bluetooth");
	}
}
