package Model.Animals.Herbivores;

import Enums.Icons;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Horse extends Herbivore implements CanWalk {
	public Horse(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Horse")[1];
		this.weight = 400;
		this.speed = ANIMALS_STATS.get("Horse")[3];
		this.neededFood = 35;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Horse")[2]);
		this.icon = Icons.HORSE.getIcon();
		initializePredationChances();
	}

	public Horse(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Horse")[1];
		this.weight = 400;
		this.speed = ANIMALS_STATS.get("Horse")[3];
		this.neededFood = 35;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Horse")[2]);
		this.icon = Icons.HORSE.getIcon();
		initializePredationChances();
	}

	@Override
	protected void initializePredationChances() {
		predationChances.put("Grass", 100);
		predationChances.put("Tree", 100);
		predationChances.put("Bush", 100);
	}
}
