package validators;

public class GreaterThan implements Validator {

	private int number;
	
	public GreaterThan(int number) {
		this.number=number;
	}
	
	@Override
	public boolean validate(String text) {
		for(char ch:text.toCharArray())
			if(!Character.isDigit(ch))
				return false;
		if(Integer.parseInt(text)<number)
			return false;
		return true;
	}

}
