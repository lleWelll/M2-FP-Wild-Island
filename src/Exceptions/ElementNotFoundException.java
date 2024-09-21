package Exceptions;

public class ElementNotFoundException extends RuntimeException{
	public ElementNotFoundException() {
	}

	public ElementNotFoundException(String message) {
		super(message);
	}

	public ElementNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
