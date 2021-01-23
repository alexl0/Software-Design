package validators;

public class TalLongitud implements Validator{

	int length;
	
	public TalLongitud(int length) {
		this.length=length;
	}

	@Override
	public boolean validate(String text) {
			if(text.length()!=length)
				return false;
		return true;
	}
}
