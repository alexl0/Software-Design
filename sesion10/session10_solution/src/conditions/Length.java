package conditions;

public class Length implements Condition
{
	private int length;
	
	public Length(int length)
	{
		this.length = length;
	}
	
	@Override
	public boolean isTrue(String value) 
	{
		return value.length() == length;
	}
}
