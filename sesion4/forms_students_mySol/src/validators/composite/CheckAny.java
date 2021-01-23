package validators.composite;

import validators.Validator;

public class CheckAny implements Validator {

	private Validator[] validators;
	
	public CheckAny(Validator ... validators) {
		this.validators=validators;
	}
	
	@Override
	public boolean validate(String text) {
		for(Validator v: validators)
			if(v.validate(text))
				return true;
		return false;
	}

}
