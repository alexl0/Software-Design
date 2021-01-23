package validators;

public class IsDigit implements Validator{

	public IsDigit() {
		
	}
	
	@Override
	public boolean validate(String text) {
		for(char ch:text.toCharArray())
			if(!Character.isDigit(ch))
				return false;
		return true;
	}
}
