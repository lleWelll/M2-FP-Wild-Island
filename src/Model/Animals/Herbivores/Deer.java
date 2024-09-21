package Model.Animals.Herbivores;

import Enums.Icons;
import Interfaces.Markers.CanWalk;

import static ModelManagers.Settings.ANIMALS_STATS;

public class Deer extends Herbivore implements CanWalk {

	public Deer(int age, String position) {
		super(age, position);
		this.maxAge = ANIMALS_STATS.get("Deer")[1];
		this.weight = 300;
		this.speed = ANIMALS_STATS.get("Deer")[3];
		this.neededFood = 30;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Deer")[2]);
		this.icon = Icons.DEER.getIcon();
		initializePredationChances();
	}

	public Deer(int age, String position, boolean canReproduce) {
		super(age, position);
		this.canReproduce = canReproduce;
		this.maxAge = ANIMALS_STATS.get("Deer")[1];
		this.weight = 300;
		this.speed = ANIMALS_STATS.get("Deer")[3];
		this.neededFood = 30;
		this.amountOfChildren = AmountOfChildren(ANIMALS_STATS.get("Deer")[2]);
		this.icon = Icons.DEER.getIcon();
		initializePredationChances();
	}

	@Override
	protected void initializePredationChances() {
		predationChances.put("Grass", 100);
		predationChances.put("Tree", 100);
		predationChances.put("Bush", 100);
	}
}
