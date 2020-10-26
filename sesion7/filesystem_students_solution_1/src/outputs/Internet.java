package outputs;

import java.io.*;

import outputs.SendMethods.Encriptar;
import outputs.SendMethods.SendMethod;

public class Internet implements Output 
{	
	private StringWriter stringWriter = new StringWriter();
	private SendMethod encriptar=new Encriptar();
	
	public Internet(String url) 
	{
		stringWriter = new StringWriter();
		stringWriter.append("\n--- START Internet [" + url + "]\n");
	}
	
	public void send(char c) throws IOException 
	{
		encriptar.send(c, stringWriter);
	}

	public void close() throws IOException 
	{
		System.out.print(stringWriter.toString());
		System.out.println("\n--- END   Internet");
	}

}
