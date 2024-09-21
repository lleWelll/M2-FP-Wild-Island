package Model.Locations;

import Enums.Icons;

public class Plain extends Location {
	public Plain(String coordinate) {
		super(coordinate);
		this.icon = Icons.PLAIN.getIcon();
		this.maxAnimalWeightInLocation = 2200;
		this.maxHerbWeightAmountInLocation = 500;
	}
}
