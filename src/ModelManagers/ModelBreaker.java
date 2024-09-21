package ModelManagers;

import Model.Animals.AnimalManager;
import Model.Animals.Herbivores.Herbivore;
import Model.Animals.Predators.Predator;
import Model.Herb.HerbManager;
import Model.Island;

import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class ModelBreaker implements Runnable {
	private final ExecutorService EXECUTOR_SERVICE;
	private static boolean isStopped = false;
	private static final String STOP_MESSAGE = "Model is stopped, because %s\n";

	public ModelBreaker(ExecutorService es) {
		this.EXECUTOR_SERVICE = es;
	}

	private static boolean noAnimals() {
		synchronized (AnimalManager.getLock()) {
			return AnimalManager.getAnimalList().isEmpty();
		}
	}

	private static boolean tooMuchAnimals() {
		synchronized (HerbManager.getLock()) {
			return AnimalManager.getAnimalList().size() > 30000;
		}
	}

	private static boolean noPredators() {
		synchronized (AnimalManager.getLock()) {
			return AnimalManager.getAnimalList().stream().noneMatch(an -> an instanceof Predator);
		}
	}

	private static boolean noHerbivores() {
		synchronized (AnimalManager.getLock()) {
			return AnimalManager.getAnimalList().stream().noneMatch(an -> an instanceof Herbivore);
		}
	}

	private static boolean noHerbs() {
		synchronized (HerbManager.getLock()) {
			return HerbManager.getHerbList().stream().noneMatch(Objects::nonNull);
		}
	}

	private void stopModel(String cause) {
		Island.getInstance().printIsland();
		EXECUTOR_SERVICE.shutdown();
		System.out.printf(STOP_MESSAGE, cause);
	}

	@Override
	public void run() {
		if (noAnimals()) stopModel("all animals died");
		else if (tooMuchAnimals()) stopModel("it's too much animals ( > 30000)");
		else if (noPredators()) stopModel("all Predators died");
		else if (noHerbivores()) stopModel("all Herbivores died");
		else if (noHerbs()) stopModel("all Herbs died");
	}
}
