import java.io.*;
import fileSystem.FileSystem;
import outputs.Bluetooth;
import outputs.FileOutput;
import outputs.Internet;
import outputs.filters.Encrypt;
import outputs.filters.LineFilter;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();
		
		/*
		system.copyFile("privado.txt", "copia.txt");
		system.sendToInternet("privado.txt", "156.17.11.196");
		system.sendWithBluetooth("privado.txt", "Galaxy de Raul");
		 */	
		
		system.copyFile("privado.txt", new LineFilter(new FileOutput("copia.txt")));
		system.copyFile("privado.txt", new Encrypt(new Internet("156.17.11.196")));
		system.copyFile("privado.txt", new Encrypt(new LineFilter(new Bluetooth("Galaxy de Raul"))));
	}
}
