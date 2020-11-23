package collections;

public class LinkedList implements Recorrible
{
    private Node head;
    private int numberOfElements;

    public void addFirst(String element) 
    {
        head = new Node(element, head);
        numberOfElements++;
    }

    public String getElementAt(int index) 
    {
        if (index >= numberOfElements)
            throw new IllegalArgumentException();

        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.value;
    }

    public int size() 
    {
        return numberOfElements;
    }

    // Faltarían el resto de los métodos: add, remove, clear...
    
    private class Node 
    {
        String value;
        Node next;

        Node(String value, Node next) 
        {
            this.value = value;
            this.next = next;
        }
    }
}
