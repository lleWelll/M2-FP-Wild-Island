package Model.Animals.Herbivores;

import Additional.Logger;
import Additional.Randomizer;
import Interfaces.HerbEatable;
import Model.Animals.Animal;
import Model.Herb.Herb;
import ModelManagers.Settings;

import java.util.List;

public abstract class Herbivore extends Animal implements HerbEatable {
	public Herbivore(int age, String position) {
		super(age, position);
	}
	@Override
	public void eatHerb() {
		if (foodConsumed >= neededFood) return;
		List<Herb> herbInLocation = island.getLocation(position).getHerbsInLocation();
		herbInLocation.stream()
				.filter(h -> ! h.isEaten())
				.filter(h -> this.getPredationTable().containsKey((h.getClass().getSimpleName())))
				.sorted((h1, h2) -> (int) (h1.getWeight() - h2.getWeight()))
				.forEach(h -> {
					if (foodConsumed <= neededFood && Randomizer.generatePercent() <= getPredationChance(h.getClass().getSimpleName())) {
						double foodConsumedThisTurn = 0;
						if (neededFood - foodConsumed < h.getWeight()) foodConsumedThisTurn = neededFood - foodConsumed;
						else foodConsumedThisTurn += h.getWeight();
						foodConsumed += foodConsumedThisTurn;
						h.reduceWeight(foodConsumedThisTurn);
						if (Settings.ACTIVATE_LOGGER_EAT) Logger.logEaten(this, h);
					}
				});
	}
}
