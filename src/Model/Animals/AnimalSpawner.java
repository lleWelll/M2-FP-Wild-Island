package Model.Animals;

import Additional.Randomizer;
import Model.Animals.Predators.*;
import Model.Animals.Herbivores.*;
import Model.Island;
import ModelManagers.Settings;

public class AnimalSpawner {
	private static final String[][] COORDINATES = Island.getInstance().getCoordinates();

	public static void spawnStartAnimals() {
		spawnBears();
		spawnEagles();
		spawnFoxes();
		spawnTigers();
		spawnWolves();
		spawnBuffalos();
		spawnDeers();
		spawnDucks();
		spawnHares();
		spawnHorses();
		spawnMice();
	}

	private static void spawnBuffalos() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Buffalo")[0]; i++) {
			Animal an = new Buffalo(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnDeers() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Deer")[0]; i++) {
			Animal an = new Deer(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnDucks() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Duck")[0]; i++) {
			Animal an = new Duck(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnHares() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Hare")[0]; i++) {
			Animal an = new Hare(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnHorses() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Horse")[0]; i++) {
			Animal an = new Horse(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnMice() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Mouse")[0]; i++) {
			Animal an = new Mouse(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnBears() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Bear")[0]; i++) {
			Animal an = new Bear(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnEagles() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Eagle")[0]; i++) {
			Animal an = new Eagle(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnFoxes() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Fox")[0]; i++) {
			Animal an = new Fox(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnTigers() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Tiger")[0]; i++) {
			Animal an = new Tiger(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}

	private static void spawnWolves() {
		for (int i = 0; i < Settings.ANIMALS_STATS.get("Wolf")[0]; i++) {
			Animal an = new Wolf(1, Randomizer.generateRandomCoordination(COORDINATES));
			an.spawnAnimal();
		}
	}


}
