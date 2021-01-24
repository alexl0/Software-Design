import java.io.*;

import output.Output;

public class FileSystem {

	public void sendFile(String name, Output output) {
		try {
			String message = "";
			FileReader reader = new FileReader(name);
			int c;
			while ((c = reader.read()) != -1)
				message+=(char)c;
			output.send(message);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
