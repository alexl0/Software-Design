package outputs.SendMethods;

import java.io.IOException;
import java.io.Writer;

public interface SendMethod {

	void send(char c, Writer writer) throws IOException;
	boolean cumpleCondicion(char c);
	void realizaAccion(char c, Writer writer) throws IOException;
	
}
