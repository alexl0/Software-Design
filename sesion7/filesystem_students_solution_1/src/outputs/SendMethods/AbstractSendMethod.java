package outputs.SendMethods;

import java.io.IOException;
import java.io.Writer;

public abstract class AbstractSendMethod implements SendMethod {

	@Override
	public void send(char c, Writer writer) throws IOException {
		if (cumpleCondicion(c))
			realizaAccion(c, writer);
	}

	@Override
	public abstract boolean cumpleCondicion(char c);

	@Override
	public abstract void realizaAccion(char c, Writer writer) throws IOException;

}
