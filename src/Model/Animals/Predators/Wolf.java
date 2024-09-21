package Model.Animals.Predators;

import Enums.Icons;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Wolf extends Predator implements CanWalk {
	public Wolf(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Wolf")[1];
		this.weight = 50;
		this.speed = ANIMALS_STATS.get("Wolf")[3];
		this.neededFood = 8;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Wolf")[2]);
		this.icon = Icons.WOLF.getIcon();
		initializePredationChances();
	}

	public Wolf(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Wolf")[1];
		this.weight = 50;
		this.speed = ANIMALS_STATS.get("Wolf")[3];
		this.neededFood = 8;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Wolf")[2]);
		this.icon = Icons.WOLF.getIcon();
		initializePredationChances();
	}

	@Override
	protected void initializePredationChances() {
		predationChances.put("Horse", 10);
		predationChances.put("Deer", 30);
		predationChances.put("Hare", 60);
		predationChances.put("Mouse", 80);
		predationChances.put("Buffalo", 10);
		predationChances.put("Duck", 40);
		predationChances.put("Corpse", 100);
	}
}
