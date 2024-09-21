package Exceptions;

public class SpawnException extends RuntimeException{
	public SpawnException() {
	}

	public SpawnException(String message) {
		super(message);
	}

	public SpawnException(String message, Throwable cause) {
		super(message, cause);
	}
}
