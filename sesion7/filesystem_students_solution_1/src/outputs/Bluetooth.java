package outputs;

import java.io.*;

import outputs.SendMethods.Encriptar;
import outputs.SendMethods.SendMethod;

public class Bluetooth implements Output {
	private StringWriter stringWriter;
	private SendMethod encriptar = new Encriptar();

	public Bluetooth(String device) {
		stringWriter = new StringWriter();
		stringWriter.append("\n--- START Bluetooth [" + device + "]\n");
	}

	public void send(char c) throws IOException {
		encriptar.send(c, stringWriter);
	}

	public void close() throws IOException {
		System.out.print(stringWriter.toString());
		System.out.println("\n--- END   Bluetooth");
	}

}
