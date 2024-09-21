package Model.Animals.Predators;

import Enums.Icons;
import Interfaces.Markers.CanFly;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Eagle extends Predator implements CanWalk, CanFly {
	public Eagle(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Eagle")[1];
		this.weight = 6;
		this.speed = ANIMALS_STATS.get("Eagle")[3];
		this.neededFood = 1;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Eagle")[2]);
		this.icon = Icons.EAGLE.getIcon();
		initializePredationChances();
	}
	public Eagle(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Eagle")[1];
		this.weight = 6;
		this.speed = ANIMALS_STATS.get("Eagle")[3];
		this.neededFood = 1;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Eagle")[2]);
		this.icon = Icons.EAGLE.getIcon();
		initializePredationChances();
	}
	@Override
	protected void initializePredationChances() {
		predationChances.put("Fox", 10);
		predationChances.put("Hare", 90);
		predationChances.put("Mouse", 90);
		predationChances.put("Duck", 80);
		predationChances.put("Corpse", 100);
	}
}
