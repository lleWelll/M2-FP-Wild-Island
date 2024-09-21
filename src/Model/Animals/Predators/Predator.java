package Model.Animals.Predators;

import Additional.Logger;
import Additional.Randomizer;
import Interfaces.MeatEatable;
import Model.Animals.Animal;
import Model.Animals.Corpse;
import Model.Animals.Herbivores.Herbivore;
import ModelManagers.Settings;

import java.util.List;

public abstract class Predator extends Animal implements MeatEatable {
	public Predator(int age, String position) {
		super(age, position);
	}
	@Override
	public void eatMeat() {
		if (foodConsumed >= neededFood) return;
		List<Animal> animalsInLocation = island.getLocation(position).getAnimalsInLocation();
		animalsInLocation.stream()
				.filter(an -> an instanceof Herbivore || an instanceof Corpse)
				.filter(an -> ! an.isDead())
				.filter(h -> this.getPredationTable().containsKey((h.getClass().getSimpleName())))
				.sorted((an1, an2) -> (int) (an2.getWeight() - an1.getWeight()))
				.forEach(an -> {
					if (foodConsumed < neededFood && Randomizer.generatePercent() <= this.getPredationChance(an.getClass().getSimpleName())) {
						double foodConsumedThisTurn = 0;
						if (neededFood - foodConsumed < an.getWeight()) foodConsumedThisTurn = neededFood - foodConsumed;
						else foodConsumedThisTurn += an.getWeight();
						foodConsumed += foodConsumedThisTurn;
						an.die();
						Corpse c = new Corpse(an.getWeight(), 0, an.getPosition());
						if (c.spawnAnimal()) c.reduceWeight(foodConsumedThisTurn);
						if (Settings.ACTIVATE_LOGGER_EAT) Logger.logEaten(this, an);
					}
				});
	}
}
