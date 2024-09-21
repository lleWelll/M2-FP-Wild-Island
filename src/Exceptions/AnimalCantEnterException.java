package Exceptions;

public class AnimalCantEnterException extends LocationException{
	public AnimalCantEnterException() {
	}

	public AnimalCantEnterException(String message) {
		super(message);
	}
}
