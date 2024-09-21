package Model.Animals.Herbivores;

import Enums.Icons;
import Interfaces.Markers.CanFly;
import Interfaces.Markers.CanSwim;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Duck extends Herbivore implements CanWalk, CanSwim, CanFly {
	public Duck(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Duck")[1];
		this.weight = 1;
		this.speed = ANIMALS_STATS.get("Duck")[3];
		this.neededFood = 1;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Duck")[2]);
		this.icon = Icons.DUCK.getIcon();
		initializePredationChances();
	}

	public Duck(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Duck")[1];
		this.weight = 1;
		this.speed = ANIMALS_STATS.get("Duck")[3];
		this.neededFood = 1;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Duck")[2]);
		this.icon = Icons.DUCK.getIcon();
		initializePredationChances();
	}

	@Override
	protected void initializePredationChances() {
		predationChances.put("Grass", 100);
		predationChances.put("Bush", 100);
	}
}
