package outputs;

import java.io.*;

import outputs.SendMethods.Normalizar;
import outputs.SendMethods.SendMethod;

public class FileOutput implements Output 
{
	private FileWriter file;
	private SendMethod normalizar=new Normalizar();
	
	public FileOutput(String fileName) throws IOException 
	{
		file = new FileWriter(fileName);
	}

	public void send(char c) throws IOException 
	{
		normalizar.send(c, file);
	}

	public void close() throws IOException 
	{
		file.close();
	}

}
