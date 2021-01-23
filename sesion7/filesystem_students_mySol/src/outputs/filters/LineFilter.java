package outputs.filters;

import java.io.IOException;

import outputs.Output;

public class LineFilter extends AbstractFilter {

	public LineFilter(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		if (c != '\t')
			output.send(c);
	}

}
