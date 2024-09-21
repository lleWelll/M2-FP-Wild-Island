package Model.Animals.Predators;

import Enums.Icons;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Tiger extends Predator implements CanWalk {
	public Tiger(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Tiger")[1];
		this.weight = 70;
		this.speed = ANIMALS_STATS.get("Tiger")[3];
		this.neededFood = 15;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Tiger")[2]);
		this.icon = Icons.TIGER.getIcon();
		initializePredationChances();
	}

	public Tiger(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Tiger")[1];
		this.weight = 70;
		this.speed = ANIMALS_STATS.get("Tiger")[3];
		this.neededFood = 15;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Tiger")[2]);
		this.icon = Icons.TIGER.getIcon();
		initializePredationChances();
	}

	@Override
	protected void initializePredationChances() {
		predationChances.put("Horse", 30);
		predationChances.put("Deer", 35);
		predationChances.put("Hare", 60);
		predationChances.put("Mouse", 80);
		predationChances.put("Buffalo", 15);
		predationChances.put("Duck", 30);
		predationChances.put("Corpse", 100);
	}
}
