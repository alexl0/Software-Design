package outputs.SendMethods;

import java.io.IOException;
import java.io.Writer;

public class Encriptar extends AbstractSendMethod {

	@Override
	public boolean cumpleCondicion(char c) {
		return Character.isDigit(c) || Character.isLetter(c);
	}

	@Override
	public void realizaAccion(char c, Writer writer) throws IOException {
		writer.append((char) (c + 1));
	}

}
