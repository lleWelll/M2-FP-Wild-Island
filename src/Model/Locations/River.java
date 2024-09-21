package Model.Locations;

import Enums.Icons;
import Exceptions.NoEnoughSpaceInLocation;
import Interfaces.Markers.CanFly;
import Interfaces.Markers.CanSwim;
import Model.Animals.Animal;

public class River extends Location{
	public River(String coordinate) {
		super(coordinate);
		this.icon = Icons.RIVER.getIcon();
		this.maxAnimalWeightInLocation = 200;
		this.maxHerbWeightAmountInLocation = 100;
	}

	@Override
	public void enteredLocation(Animal animal) throws NoEnoughSpaceInLocation { //Throws exception that will catch Animal class
		if (animal instanceof CanSwim || animal instanceof CanFly) super.enteredLocation(animal);
		else throw new NoEnoughSpaceInLocation();
	}
}
