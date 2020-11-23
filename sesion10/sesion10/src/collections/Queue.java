package collections;

import java.util.*;

public class Queue implements Recorrible
{
    private List<String> elements = new ArrayList<String>();

    public void add(String element) 
    {
        elements.add(element);
    }

    public String getElementAt(int index) 
    {
        return elements.get(index);
    }

    public int size() {
    	
        return elements.size();
    }

    // Faltarían el resto de los métodos: remove, clear...
}
