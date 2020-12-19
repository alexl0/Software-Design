package transformations;

public class DonPrefix implements Transformation
{
	@Override
	public String transform(String value) 
	{
		return "Don " + value;
	}
}
