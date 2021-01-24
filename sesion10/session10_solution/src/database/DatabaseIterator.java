package database;

import java.io.*;
import java.util.NoSuchElementException;

import collections.Iterator;

public class DatabaseIterator implements Iterator {
	private BufferedReader reader;

	public DatabaseIterator() {
		try {
			reader = new BufferedReader(new FileReader("database.txt"));
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	@Override
	public boolean hasNext() {
		try {
			return reader.ready();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	@Override
	public String next() {
		if (!hasNext())
			throw new NoSuchElementException();
		try {
			return reader.readLine();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
