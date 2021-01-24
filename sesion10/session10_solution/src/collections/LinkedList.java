package collections;

import java.util.NoSuchElementException;

public class LinkedList {
	private Node head;
	private int numberOfElements;

	public void addFirst(String element) {
		head = new Node(element, head);
		numberOfElements++;
	}

	public String get(int index) {
		if (index >= numberOfElements)
			throw new IllegalArgumentException();

		Node current = head;
		for (int i = 0; i < index; i++)
			current = current.next;
		return current.value;
	}

	public int size() {
		return numberOfElements;
	}

	public Iterator iterator() {
		return new LinkedListIterator();
	}

	// Faltarían el resto de los métodos: add, set, remove, clear...

	private class Node {
		String value;
		Node next;

		Node(String value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	private class LinkedListIterator implements Iterator {
		private Node next = head;

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public String next() {
			if (!hasNext())
				throw new NoSuchElementException();
			String result = next.value;
			next = next.next;
			return result;
		}
	}
}
