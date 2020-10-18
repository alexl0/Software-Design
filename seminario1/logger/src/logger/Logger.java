package logger;

public class Logger {
	private static String log;
	private Logger() {

	}

	public void add(String string) {
		if(log==null)
			log=string+"\n";
		else
			log+=string+"\n";
	}
	public static String getString() {
		return log;
	}

	private static final Logger logger=new Logger();
	public static Logger getInstance() {
		return logger;
	}

}
