package fr.univnantes.julestar.uima.resources;

public class ResourceFormatException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceFormatException() {
		super();
	}

	public ResourceFormatException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceFormatException(String message) {
		super(message);
	}

	public ResourceFormatException(Throwable cause) {
		super(cause);
	}

	
}
