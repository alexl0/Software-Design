package collections;

import java.util.*;

public class Queue 
{
    private List<String> elements = new ArrayList<>();

    public void add(String element) 
    {
        elements.add(element);
    }

    public int size() 
    {	
        return elements.size();
    }
    
    public Iterator iterator()
    {
    	return new QueueIterator();
    }

    // Faltarían el resto de los métodos: peek, remove, clear...
    
    private class QueueIterator implements Iterator
    {
    	private int nextIndex;

		@Override
		public boolean hasNext() 
		{
			return nextIndex < elements.size();
		}

		@Override
		public String next() 
		{
			if (!hasNext())
				throw new NoSuchElementException();
			return elements.get(nextIndex++); 
		}
    }
}
