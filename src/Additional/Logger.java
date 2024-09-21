package Additional;

import Model.Animals.Animal;
import Model.Herb.Herb;

public class Logger {
	private static final String ANIMAL_REPRODUCED = "Animal %s, named %s and %s gave birth in %s\n";
	private static final String ANIMAL_DIED = "Animal %s, named %s died at %d years old in %s\n";
	private static final String ANIMAL_EATEN = "Animal %s, named %s have eaten %s with weight %f\n";
	private static final String CURRENT_STEP = "Current step: %d\n";
	private static final String STEP_DIVIDER = "-------------------------\n";

	public static void logCurrentStep(int step) {
		System.out.printf(CURRENT_STEP, step);
	}

	public static void logStepDivider() {
		System.out.printf(STEP_DIVIDER);
	}

	public static void logReproduce(Animal parent1, Animal parent2) {
		System.out.printf(ANIMAL_REPRODUCED, parent1.getClass().getSimpleName(), parent1.getName(), parent2.getName(), parent1.getPosition());
	}

	public static void logDied(Animal animal) {
		System.out.printf(ANIMAL_DIED, animal.getClass().getSimpleName(), animal.getName(), animal.getAge(), animal.getPosition());
	}

	public static void logEaten(Animal predator, Animal victim) {
		System.out.printf(ANIMAL_EATEN, predator.getClass().getSimpleName(), predator.getName(), victim.getClass().getSimpleName(), victim.getWeight());
	}

	public static void logEaten(Animal predator, Herb victim) {
		System.out.printf(ANIMAL_EATEN, predator.getClass().getSimpleName(), predator.getName(), victim.getClass().getSimpleName(), victim.getWeight());
	}


}
