package Model.Animals.Herbivores;

import Enums.Icons;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Mouse extends Herbivore implements CanWalk {
	public Mouse(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Mouse")[1];
		this.weight = 1;
		this.speed = ANIMALS_STATS.get("Mouse")[3];
		this.neededFood = 0.3;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Mouse")[2]);
		this.icon = Icons.MOUSE.getIcon();
		initializePredationChances();
	}
	public Mouse(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Mouse")[1];
		this.weight = 1;
		this.speed = ANIMALS_STATS.get("Mouse")[3];
		this.neededFood = 0.3;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Mouse")[2]);
		this.icon = Icons.MOUSE.getIcon();
		initializePredationChances();
	}
	@Override
	protected void initializePredationChances() {
		predationChances.put("Grass", 100);
		predationChances.put("Bush", 100);
	}
}
