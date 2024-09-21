package Exceptions;

public class NoEnoughSpaceInLocation extends LocationException{
	public NoEnoughSpaceInLocation() {
	}

	public NoEnoughSpaceInLocation(String message) {
		super(message);
	}
}
