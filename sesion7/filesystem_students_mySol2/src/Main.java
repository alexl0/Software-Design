import java.io.*;

import output.Bluetooth;
import output.CopyFile;
import output.Internet;
import output.filter.CalculateMD5;
import output.filter.Counter;
import output.filter.Encrypt;
import output.filter.Normalizar;
import output.filter.RemoveRepeatedSpaces;
import output.filter.SendToThisDevices;

public class Main {
	public static void main(String[] args) throws IOException {
		FileSystem system = new FileSystem();
/*
		system.copyFile("privado.txt", "copia.txt");
		system.sendToInternet("privado.txt", "156.17.11.196");
		system.sendWithBluetooth("privado.txt", "Galaxy de Raul");
*/
		//Mejorar diseño y hacer cambios para que se pueda encriptar y normalizar
		System.out.println("\n##################### Diseño base #####################\n");
		system.sendFile("privado.txt", new Normalizar(new CopyFile("copiaFichero")));
		system.sendFile("privado.txt", new Encrypt(new Internet("156.17.11.196")));
		system.sendFile("privado.txt", new Encrypt(new RemoveRepeatedSpaces(new Bluetooth("Galaxy de Raul"))));
		
		//Modificacion 1 (no es necesario modificar ningun código, solo esta linea del main
		System.out.println("\n##################### Modificacion 1 #####################\n");
		system.sendFile("privado.txt", new Encrypt(new Normalizar(new CopyFile("copiaFicheroEncriptado"))));

		//Modificacion 2
		System.out.println("\n##################### Modificacion 2 #####################\n");
		system.sendFile("privado.txt", new Encrypt(new Normalizar(new Internet("156.17.11.196"))));
		system.sendFile("privado.txt", new Encrypt(new RemoveRepeatedSpaces(new Internet("156.17.11.196"))));
		system.sendFile("privado.txt", new Encrypt(new Normalizar(new RemoveRepeatedSpaces(new Internet("156.17.11.196")))));
		

		//Modificacion 3
		System.out.println("\n##################### Modificacion 3 #####################\n");
		Counter counter=new Counter(new Normalizar(new Internet("156.17.11.196")));
		system.sendFile("privado.txt", counter);
		System.out.println("counter: "+counter.getCount());
		
		Counter counter2=new Counter(new RemoveRepeatedSpaces(new Internet("156.17.11.196")));
		system.sendFile("privado.txt", counter2);
		System.out.println("counter: "+counter2.getCount());
		

		//Modificacion 4
		System.out.println("\n##################### Modificacion 4 #####################\n");
		//Igual que la 3

		
		//Modificacion 5
		System.out.println("\n##################### Modificacion 5 #####################\n");
		system.sendFile("privado.txt", new Encrypt(new SendToThisDevices(new Internet("156.17.11.196"), new Bluetooth("Galaxy de Raul")) ));
		

		//Opcional 3 MD5
		System.out.println("\n##################### Opcional 3 MD5 #####################\n");
		CalculateMD5 calculateMD5=new CalculateMD5(new Encrypt(new Internet("156.17.11.196")));
		system.sendFile("privado.txt", calculateMD5);
		System.out.println("MD5: "+counter.getCount());
		
	}
}
