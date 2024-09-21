package Model.Animals.Predators;

import Enums.Icons;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Fox extends Predator implements CanWalk {
	public Fox(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Fox")[1];
		this.weight = 8;
		this.speed = ANIMALS_STATS.get("Fox")[3];
		this.neededFood = 2;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Fox")[2]);
		this.icon = Icons.FOX.getIcon();
		initializePredationChances();
	}
	public Fox(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Fox")[1];
		this.weight = 8;
		this.speed = ANIMALS_STATS.get("Fox")[3];
		this.neededFood = 2;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Fox")[2]);
		this.icon = Icons.FOX.getIcon();
		initializePredationChances();
	}
	@Override
	protected void initializePredationChances() {
		predationChances.put("Hare", 70);
		predationChances.put("Mouse", 90);
		predationChances.put("Duck", 60);
		predationChances.put("Corpse", 100);
	}
}
