package output;

import java.io.FileWriter;

public class CopyFile implements Output {

	private String to;

	public CopyFile(String to) {
		this.to=to;
	}

	@Override
	public void send(String message) {
		try {
			FileWriter writer = new FileWriter(to);

			for(char c:message.toCharArray())
				writer.append((char) c);

			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
