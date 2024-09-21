package Exceptions;

public class NameGenerationException extends RuntimeException{
	public NameGenerationException() {
		super("Error in name generation");
	}

	public NameGenerationException(String message) {
		super(message);
	}
}
