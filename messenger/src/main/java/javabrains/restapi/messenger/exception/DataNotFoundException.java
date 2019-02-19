package javabrains.restapi.messenger.exception;

public class DataNotFoundException extends RuntimeException {

	/*
	 * It is necessary for runtime exception to have serial id 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
