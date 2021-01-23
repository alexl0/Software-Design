package validators;

public class CampoPredefinido implements Validator{

	private String[] valores;
	
	public CampoPredefinido(String ... valores) {
		this.valores=valores;
	}

	@Override
	public boolean validate(String text) {
		for (String valor : valores) {
			if (text.toLowerCase().equals(valor.toLowerCase()))
				return true;
		}
		return false;
	}

}
