package functions;

import java.util.NoSuchElementException;

import collections.Iterator;
import conditions.Condition;

public class Filter implements Iterator
{
	private Condition condition;
	private Iterator iterator;
	private String next;
	
	public Filter(Condition condition, Iterator iterator) 
	{
		this.condition = condition;
		this.iterator = iterator;
	}

	@Override
	public boolean hasNext() 
	{
		if (next != null)
			return true;
		while (iterator.hasNext()) {
			String each = iterator.next();
			if (condition.isTrue(each)) {
				next = each;
				return true;
			}
		}
		return false;
	}

	@Override
	public String next() 
	{
		if (!hasNext())
			throw new NoSuchElementException();
		String result = next;
		next = null;
		return result;
	}
}
