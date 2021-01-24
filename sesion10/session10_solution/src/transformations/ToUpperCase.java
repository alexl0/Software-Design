package transformations;

public class ToUpperCase implements Transformation {
	@Override
	public String transform(String value) {
		return value.toUpperCase();
	}
}
