package Model.Animals.Herbivores;


import Enums.Icons;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Buffalo extends Herbivore implements CanWalk {
	public Buffalo(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Buffalo")[1];
		this.weight = 550;
		this.speed = ANIMALS_STATS.get("Buffalo")[3];
		this.neededFood = 100;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Buffalo")[2]);
		this.icon = Icons.BUFFALO.getIcon();
		initializePredationChances();
	}

	public Buffalo(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Buffalo")[1];
		this.weight = 550;
		this.speed = ANIMALS_STATS.get("Buffalo")[3];
		this.neededFood = 40;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Buffalo")[2]);
		this.icon = Icons.BUFFALO.getIcon();
		initializePredationChances();
	}

	@Override
	protected void initializePredationChances() {
		predationChances.put("Grass", 100);
		predationChances.put("Tree", 100);
		predationChances.put("Bush", 100);
	}
}
