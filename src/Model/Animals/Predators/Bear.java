package Model.Animals.Predators;

import Enums.Icons;
import Interfaces.Markers.CanSwim;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Bear extends Predator implements CanWalk, CanSwim {
	public Bear(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Bear")[1];
		this.weight = 500;
		this.speed = ANIMALS_STATS.get("Bear")[3];
		this.neededFood = 50;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Bear")[2]);
		this.icon = Icons.BEAR.getIcon();
		initializePredationChances();
	}
	public Bear(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Bear")[1];
		this.weight = 500;
		this.speed = ANIMALS_STATS.get("Bear")[3];
		this.neededFood = 50;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Bear")[2]);
		this.icon = Icons.BEAR.getIcon();
		initializePredationChances();
	}
	@Override
	protected void initializePredationChances() {
		predationChances.put("Horse", 40);
		predationChances.put("Deer", 80);
		predationChances.put("Hare", 80);
		predationChances.put("Mouse", 90);
		predationChances.put("Buffalo", 20);
		predationChances.put("Duck", 10);
		predationChances.put("Corpse", 100);
	}
}
