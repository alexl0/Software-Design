package outputs.SendMethods;

import java.io.IOException;
import java.io.Writer;

public class Normalizar extends AbstractSendMethod {

	@Override
	public boolean cumpleCondicion(char c) {
		return c!='\r';
	}

	@Override
	public void realizaAccion(char c, Writer writer) throws IOException {
		writer.append(c);
	}

}
