package outputs.filters;

import java.io.IOException;

import outputs.Output;

public class Encrypt extends AbstractFilter {

	public Encrypt(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		if (Character.isLetterOrDigit(c))
			output.send((char) (c + 1));
		else
			output.send(c);
	}

}
