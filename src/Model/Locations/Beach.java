package Model.Locations;

import Enums.Icons;

public class Beach extends Location{
	public Beach(String coordinate) {
		super(coordinate);
		this.icon = Icons.BEACH.getIcon();
		this.maxAnimalWeightInLocation = 2200;
		this.maxHerbWeightAmountInLocation = 400;
	}
}
