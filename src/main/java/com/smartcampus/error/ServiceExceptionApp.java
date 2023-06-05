package com.smartcampus.error;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ServiceExceptionApp extends Throwable{
	
	protected static final Logger LOGGER = LogManager.getRootLogger();
	private static final long serialVersionUID = -3558880621798759939L;
	
	public ServiceExceptionApp( String message ) {
		super( message );
		LOGGER.error(message);
	}
	
	public ServiceExceptionApp( String message, Throwable cause ) {
		super( message, cause);
		LOGGER.error(cause.hashCode() + " ", message, cause);
	}
}
