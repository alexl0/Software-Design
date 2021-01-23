package outputs.filters;

import java.io.IOException;

import outputs.Output;

public class HashCalculator extends AbstractFilter {

	private String message;

	public HashCalculator(Output output) {
		super(output);
		message = "";
	}

	@Override
	public void send(char c) throws IOException {
		output.send(c);
		message += c;
	}

	public String getHashMD5() {
		String hash = "";
		for (byte s : message.getBytes()) {
			hash += s;
		}
		return hash;
	}

}
