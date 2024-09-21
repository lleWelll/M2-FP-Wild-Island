package Model.Animals;

import Additional.Logger;
import Interfaces.HerbEatable;
import Interfaces.MeatEatable;
import ModelManagers.Settings;

import java.util.ArrayList;
import java.util.List;

//Class manage animals behaviour
public class AnimalManager implements Runnable {
	private int stepId = 0;
	private static final List<Animal> ANIMAL_LIST = new ArrayList<>();
	private static final List<Animal> CHILDREN_LIST = new ArrayList<>();
	private static final Object LOCK = new Object(); //Object for synchronization

	public static List<Animal> getAnimalList() {
		return ANIMAL_LIST;
	}

	public static Object getLock() {
		return LOCK;
	}

	public synchronized static void addAnimal(Animal animal) {
		ANIMAL_LIST.add(animal);
	}

	public synchronized static void addChild(Animal animal) {
		CHILDREN_LIST.add(animal);
	}

	public synchronized static void removeAllDied() {
		ANIMAL_LIST.removeIf(Animal::isDead);
	}

	public synchronized static void spawnAllChildren() {
		if (CHILDREN_LIST.isEmpty()) return;
		for (Animal an : CHILDREN_LIST) {
			an.spawnAnimal();
		}
		CHILDREN_LIST.clear();
	}


	@Override
	public void run() {
		synchronized (LOCK) {
			stepId++;
			if (Settings.ACTIVATE_STEP_PRINTING) Logger.logCurrentStep(stepId);

			if (ANIMAL_LIST.isEmpty()) return;
			for (int i = 0; i < ANIMAL_LIST.size(); i++) {
				Animal an = ANIMAL_LIST.get(i);

				if (an.isDead()) continue;
				if (an.getAge() >= an.getMaxAge()) {
					an.die();
					continue;
				} else an.plusYear();
				if (an instanceof Corpse) continue;
				for (int j = 0; j < an.getSpeed(); j++) {
					if (an instanceof MeatEatable) ((MeatEatable) an).eatMeat();
					else if (an instanceof HerbEatable) ((HerbEatable) an).eatHerb();
					an.reproduce();
					an.walk();
				}
				if (an.getFoodConsumed() <= an.getNeededFood() * 0.7) an.die();
				else an.setFoodConsumed(0);
			}
			spawnAllChildren();
			removeAllDied();
			if (Settings.ACTIVATE_STEP_PRINTING) Logger.logStepDivider();
		}
	}
}
