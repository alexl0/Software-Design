package outputs.filters;

import java.io.*;

import outputs.*;

public abstract class AbstractFilter implements Output {
	protected Output output;

	public AbstractFilter(Output output) {
		this.output = output;
	}

	public void close() throws IOException {
		output.close();
	}

}