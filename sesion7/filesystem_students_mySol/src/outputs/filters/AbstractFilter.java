package outputs.filters;

import java.io.IOException;
import outputs.Output;

public abstract class AbstractFilter implements Output {

	public Output output;

	public AbstractFilter(Output output) {
		this.output = output;
	}

	@Override
	public abstract void send(char c) throws IOException;

	@Override
	public void close() throws IOException {
		output.close();
	}

}
