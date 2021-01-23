package validators.composite;

import validators.Validator;

public class CheckAll implements Validator {

	private Validator[] validators;
	
	public CheckAll(Validator ... validators) {
		this.validators=validators;
	}
	
	@Override
	public boolean validate(String text) {
		for(Validator v: validators)
			if(!v.validate(text))
				return false;
		return true;
	}

}
