public class CampoNumero extends AbstractCampo{

	public CampoNumero(String etiqueta) {
		super(etiqueta);
	}

	@Override
	boolean condicion(char ch) {
		return Character.isDigit(ch);
	}

}
