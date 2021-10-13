package cucumberLogger;

import java.util.logging.Logger;


public class LoggerManager {
	private static Logger logger = Logger.getLogger(LoggerManager.class.getName());

	public static Logger getLogger() {
		return logger;
	}

}
