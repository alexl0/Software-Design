public class CampoTexto extends AbstractCampo{

	public CampoTexto(String etiqueta) {
		super(etiqueta);
	}

	@Override
	boolean condicion(char ch) {
		return Character.isLetter(ch);
	}

}
