package transformations;

public class FirstFourCharacters implements Transformation {
	@Override
	public String transform(String value) {
		return value.substring(0, 4);
	}
}
