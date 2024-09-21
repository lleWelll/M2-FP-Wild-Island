package ModelManagers;

import Model.Animals.Animal;
import Model.Animals.AnimalManager;
import Model.Animals.Corpse;
import Model.Animals.Herbivores.Herbivore;
import Model.Animals.Herbivores.*;
import Model.Animals.Predators.Predator;
import Model.Animals.Predators.*;
import Model.Herb.*;
import Model.Herb.HerbManager;
import Model.Island;

import java.util.List;

public class Statistic implements Runnable{
	private static final Island ISLAND = Island.getInstance();
	private static int updateId = 1;
	private static final String DIVIDER = "----------------------\n";
	private static final String updateNumber = "Update number: %d\n";
	private static final String TOTAL_ANIMAL_AMOUNT_MESSAGE = "Total amount of animals: %d\n";
	private static final String PREDATORS_AMOUNT_MESSAGE = "Predators: %d\n";
	private static final String HERBIVORE_AMOUNT_MESSAGE = "Herbivores: %d\n";
	private static final String WOLF_AMOUNT_MESSAGE = "Wolfs: %d\n";
	private static final String TIGER_AMOUNT_MESSAGE = "Tigers: %d\n";
	private static final String HARE_AMOUNT_MESSAGE = "Hares: %d\n";
	private static final String BEAR_AMOUNT_MESSAGE = "Bears: %d\n";
	private static final String EAGLE_AMOUNT_MESSAGE = "Eagles: %d\n";
	private static final String FOX_AMOUNT_MESSAGE = "Foxes: %d\n";
	private static final String BUFFALO_AMOUNT_MESSAGE = "Buffalos: %d\n";
	private static final String DEER_AMOUNT_MESSAGE = "Deers: %d\n";
	private static final String DUCK_AMOUNT_MESSAGE = "Ducks: %d\n";
	private static final String HORSE_AMOUNT_MESSAGE = "Horses: %d\n";
	private static final String MOUSE_AMOUNT_MESSAGE = "Mice: %d\n";
	private static final String CORPSES_AMOUNT_MESSAGE = "Corpses: %d\n";
	private static final String TOTAL_HERB_AMOUNT_MESSAGE = "Total amount of herb: %d\n";

	private static int totalAnimalAmount;
	private static int totalPredatorsAmount;
	private static int totalHerbivoresAmount;
	private static int totalWolfsAmount;
	private static int totalTigersAmount;
	private static int totalHareAmount;
	private static int totalBearsAmount;
	private static int totalEaglesAmount;
	private static int totalFoxesAmount;
	private static int totalBuffalosAmount;
	private static int totalDeersAmount;
	private static int totalDucksAmount;
	private static int totalHorsesAmount;
	private static int totalMiceAmount;
	private static int totalCorpsesAmount;
	private static int totalHerbsAmount;
	private static void setFieldsToDefault() {
		totalAnimalAmount = 0;
		totalPredatorsAmount = 0;
		totalHerbivoresAmount = 0;
		totalWolfsAmount = 0;
		totalTigersAmount = 0;
		totalHareAmount = 0;
		totalBearsAmount = 0;
		totalEaglesAmount = 0;
		totalFoxesAmount = 0;
		totalBuffalosAmount = 0;
		totalDeersAmount = 0;
		totalDucksAmount = 0;
		totalHorsesAmount = 0;
		totalMiceAmount = 0;
		totalCorpsesAmount = 0;
		totalHerbsAmount = 0;
	}
	private static void animalCheck() {
		synchronized (HerbManager.getLock()) {
			synchronized (AnimalManager.getLock()) {
				setFieldsToDefault();
				List<Animal> animalList = AnimalManager.getAnimalList();
				List<Herb> herbList = HerbManager.getHerbList();

				totalAnimalAmount = animalList.size();
				totalHerbsAmount = herbList.size();

				for (Animal an : animalList) {

					if (an instanceof Predator) totalPredatorsAmount++;
					else if (an instanceof Herbivore) totalHerbivoresAmount++;

					if (an instanceof Wolf) totalWolfsAmount++;
					else if (an instanceof Tiger) totalTigersAmount++;
					else if (an instanceof Hare) totalHareAmount++;
					else if (an instanceof Bear) totalBearsAmount++;
					else if (an instanceof Eagle) totalEaglesAmount++;
					else if (an instanceof Fox) totalFoxesAmount++;
					else if (an instanceof Buffalo) totalBuffalosAmount++;
					else if (an instanceof Deer) totalDeersAmount++;
					else if (an instanceof Duck) totalDucksAmount++;
					else if (an instanceof Horse) totalHorsesAmount++;
					else if (an instanceof Mouse) totalMiceAmount++;
					else if (an instanceof Corpse) totalCorpsesAmount++;
				}

				System.out.print(DIVIDER);
				System.out.printf(updateNumber, updateId);
				System.out.printf(TOTAL_ANIMAL_AMOUNT_MESSAGE, totalAnimalAmount);
				System.out.printf(PREDATORS_AMOUNT_MESSAGE, totalPredatorsAmount);
				System.out.printf(HERBIVORE_AMOUNT_MESSAGE, totalHerbivoresAmount);
				System.out.printf(WOLF_AMOUNT_MESSAGE, totalWolfsAmount);
				System.out.printf(TIGER_AMOUNT_MESSAGE, totalTigersAmount);
				System.out.printf(HARE_AMOUNT_MESSAGE, totalHareAmount);
				System.out.printf(BEAR_AMOUNT_MESSAGE, totalBearsAmount);
				System.out.printf(EAGLE_AMOUNT_MESSAGE, totalEaglesAmount);
				System.out.printf(FOX_AMOUNT_MESSAGE, totalFoxesAmount);
				System.out.printf(BUFFALO_AMOUNT_MESSAGE, totalBuffalosAmount);
				System.out.printf(DEER_AMOUNT_MESSAGE, totalDeersAmount);
				System.out.printf(DUCK_AMOUNT_MESSAGE, totalDucksAmount);
				System.out.printf(HORSE_AMOUNT_MESSAGE, totalHorsesAmount);
				System.out.printf(MOUSE_AMOUNT_MESSAGE, totalMiceAmount);
				System.out.printf(CORPSES_AMOUNT_MESSAGE, totalCorpsesAmount);
				System.out.println();
				System.out.printf(TOTAL_HERB_AMOUNT_MESSAGE, totalHerbsAmount);
			}
		}
	}


	@Override
	public void run() {
		animalCheck();
		ISLAND.printIsland();
		updateId++;
	}
}
