package Model.Locations;

import Enums.Icons;
import Exceptions.NoEnoughSpaceInLocation;
import Interfaces.Markers.CanFly;
import Model.Animals.Animal;

public class Mountain extends Location {
	public Mountain(String coordinate) {
		super(coordinate);
		this.icon = Icons.MOUNTAIN.getIcon();
		this.maxAnimalWeightInLocation = 100;
		this.maxHerbWeightAmountInLocation = 20;
	}

	@Override
	public void enteredLocation(Animal animal) throws NoEnoughSpaceInLocation { //Throws exception that will catch Animal class
		if (animal instanceof CanFly) super.enteredLocation(animal);
		else throw new NoEnoughSpaceInLocation();
	}
}
