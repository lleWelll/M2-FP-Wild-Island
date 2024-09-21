package Additional;

import Enums.Names;
import ModelManagers.Settings;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
	private static final ThreadLocalRandom RANDOMIZER = ThreadLocalRandom.current();
	public static int generateNumber(int to) {
		return RANDOMIZER.nextInt(to);
	}

	//returns number from 0 to 99
	public static int generatePercent() {
		return RANDOMIZER.nextInt(100);
	}

	//Generate random male or female name, based on enum "Names"
	public static String generateRandomName(String gender) {
		gender = gender.toLowerCase();

		do {
			Names name = Names.getNameInstance(generatePercent());
			if (gender.equals(name.getGENDER().toLowerCase())) {
				return name.getNAME();
			}
		}
		while (true);
	}

	public static String generateRandomCoordination(String[][] coordinates) {
		int x = RANDOMIZER.nextInt(0, Settings.ISLAND_SIZE);
		int y = RANDOMIZER.nextInt(0, Settings.ISLAND_SIZE);

		return coordinates[x][y];
	}

	public static String generateGender() {
		if (generatePercent() < 50) return "Male";
		else return "Female";
	}
}
