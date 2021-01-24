package functions;

import collections.Iterator;
import transformations.Transformation;

public class Map implements Iterator {
	private Transformation transformation;
	private Iterator iterator;

	public Map(Transformation transformation, Iterator iterator) {
		this.iterator = iterator;
		this.transformation = transformation;
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public String next() {
		return transformation.transform(iterator.next());
	}
}
