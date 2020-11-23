package collections;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class DataBase implements Recorrible {

	public List<String> lista=new ArrayList<String>();

	public void loadElements() {
		try {
			File myObj = new File("database.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				lista.add(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	@Override
	public String getElementAt(int index) {
		return lista.get(index);
	}

	@Override
	public int size() {
		return lista.size();
	}

}
