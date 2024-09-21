package Model.Animals.Herbivores;

import Enums.Icons;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Hare extends Herbivore implements CanWalk {
	public Hare(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Hare")[1];
		this.weight = 2;
		this.speed = ANIMALS_STATS.get("Hare")[3];
		this.neededFood = 0.5;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Hare")[2]);
		this.icon = Icons.HARE.getIcon();
		initializePredationChances();
	}

	public Hare(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Hare")[1];
		this.weight = 2;
		this.speed = ANIMALS_STATS.get("Hare")[3];
		this.neededFood = 0.5;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Hare")[2]);
		this.icon = Icons.HARE.getIcon();
		initializePredationChances();
	}

	@Override
	protected void initializePredationChances() {
		predationChances.put("Grass", 100);
		predationChances.put("Bush", 100);
	}
}
