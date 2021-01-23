package validators;

public class LessThan implements Validator {
	
	private int number;
	
	public LessThan(int number) {
		this.number=number;
	}
	
	@Override
	public boolean validate(String text) {
		for(char ch:text.toCharArray())
			if(!Character.isDigit(ch))
				return false;
		if(Integer.parseInt(text)>number)
			return false;
		return true;
	}

}
