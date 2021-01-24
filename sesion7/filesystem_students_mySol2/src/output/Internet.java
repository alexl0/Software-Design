package output;

import java.io.StringWriter;

public class Internet implements Output {

	private String to;

	public Internet(String to) {
		this.to=to;
	}

	@Override
	public void send(String message) {
		StringWriter stringWriter = new StringWriter();
		stringWriter.append("\n--- START Internet [" + to + "]\n");

		for(char c:message.toCharArray())
			stringWriter.append((char) c);

		System.out.println(stringWriter.toString());
		System.out.println("--- END   Internet");
	}
}
