package Model;

import Additional.Randomizer;
import Model.Locations.*;
import ModelManagers.Settings;

import java.util.*;

public class Island {
	private static volatile Island instance;
	private final int SIZE = Settings.ISLAND_SIZE;
	private final String[][] COORDINATES;
	private final TreeMap<String, ? extends Location> ISLAND;
	private final int BIOME_SIZE = (int) (Math.round(SIZE * SIZE * Settings.BIOME_SIZE) * 0.1);

	//Singleton realization
	public static Island getInstance() {
		Island result = instance;
		if (result != null) {
			return result;
		}
		synchronized (Island.class) {
			if (instance == null) {
				instance = new Island();
			}
			return instance;
		}
	}

	private Island() {
		this.COORDINATES = createCoordinate();
		this.ISLAND = createIsland();
	}

	//Creates coordinates in "A1", "A2" system
	private String[][] createCoordinate() {
		String[][] coordinates = new String[SIZE][SIZE];
		char currentSymbol = 'A';
		int currentDigit;
		for (int i = 0; i < SIZE; i++) {
			currentDigit = 1;
			for (int j = 0; j < SIZE; j++) {
				coordinates[i][j] = currentSymbol + "" + currentDigit;
				currentDigit++;
			}
			currentSymbol++;
		}
		return coordinates;
	}

	//Creates island and spawn biomes
	private TreeMap<String, ? extends Location> createIsland() {
		TreeMap<String, Location> island = new TreeMap<>((o1, o2) -> {
			int compare = Character.compare(o1.charAt(0), o2.charAt(0));
			if (compare != 0) return compare;
			else return Integer.parseInt(o1.substring(1)) - Integer.parseInt(o2.substring(1));
		});
		//Creating default island
		createDefault(island);
		//Creating biomes
		if (Settings.SPAWN_RIVER) createMountain(island);
		if (Settings.SPAWN_MOUNTAIN) createRiver(island);
		return island;
	}

	//Fill island with Default (Plain) locations
	private void createDefault(TreeMap<String, Location> island) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				island.put(COORDINATES[i][j], new Plain(COORDINATES[i][j]));
			}
		}
	}

	//Creates river on island on random position
	private void createRiver(TreeMap<String, Location> island) {
		String startCoordination = Randomizer.generateRandomCoordination(COORDINATES);
		expandRiver(island, startCoordination);
	}

	//expands river on random direction (up or down)
	private void expandRiver(TreeMap<String, Location> island, String startCoordination) {
		int remainingBiomes = BIOME_SIZE / 2; //The number of remaining biomes to place on the playing field

		String currentCoordination = startCoordination; //the current coordinates to start generating biomes from
		String beachCoordinationLeft; //coordinates for creating beach across river
		String beachCoordinationRight;

		int direction = 0; //The direction of river's movement
		while (remainingBiomes > 0) {
			char newSymbol; //Representing the change in coordinates when moving up or down
			switch (direction) {
				case 0 -> newSymbol = (char) (currentCoordination.charAt(0) + 1); //Up direction
				case 1 -> newSymbol = (char) (currentCoordination.charAt(0) - 1); //Down direction
				default -> {
					return;
				}
			}
			if (newSymbol < 'A' || newSymbol > COORDINATES[SIZE - 1][SIZE - 1].charAt(0)) direction++;

			int mediumNumber = Integer.parseInt(currentCoordination.substring(1)); //Numeric part of the coordinates, changes depending on the current position
			if (mediumNumber == SIZE) mediumNumber--;
			else if (mediumNumber == 0) mediumNumber++;

			int random = Randomizer.generateNumber(3);
			if (random < 1) mediumNumber--;
			else if (random > 1) mediumNumber++;
			currentCoordination = newSymbol + "" + mediumNumber;
			beachCoordinationLeft = newSymbol + "" + (mediumNumber - 1);
			beachCoordinationRight = newSymbol + "" + (mediumNumber + 1);
			if (island.replace(currentCoordination, new River(currentCoordination)) != null) {
				island.replace(beachCoordinationLeft, new Beach(currentCoordination)); //Filling near location with Beach (creating river coast)
				island.replace(beachCoordinationRight, new Beach(currentCoordination));
				remainingBiomes -= 1;
			}
			createNaturalBridge(island);
		}
	}

	//Create "natural" bridge in the middle of the river (Class Plain)
	private void createNaturalBridge(TreeMap<String, Location> island) {
		int middleRow = SIZE / 2;
		for (int i = 0; i < SIZE; i++) {
			if (island.get(COORDINATES[middleRow][i]) instanceof River)
				island.replace(COORDINATES[middleRow][i], new Plain(COORDINATES[middleRow][i]));
		}
	}

	//Creates mountain on island on random position
	private void createMountain(TreeMap<String, Location> island) {
		String startCoordination = Randomizer.generateRandomCoordination(COORDINATES);
		int radius = BIOME_SIZE;
		expandMountain(island, startCoordination, radius);
	}

	//Expands mountain in locations around
	private void expandMountain(TreeMap<String, Location> island, String startCoordination, int radius) {
		int remainingBiomes = BIOME_SIZE / 2;

		island.put(startCoordination, new Mountain(startCoordination));
		remainingBiomes--;

		Queue<String> queue = new LinkedList<>();
		queue.add(startCoordination);

		Set<String> visited = new HashSet<>();
		visited.add(startCoordination);

		while (!queue.isEmpty() && remainingBiomes > 0) {
			String currentCoordinate = queue.poll();
			char startCoordinateSymbol = currentCoordinate.charAt(0);
			int startCoordinateDigit = Integer.parseInt(currentCoordinate.substring(1));

			List<String> nearByLocationCoordinates = getNearByLocationCoordinates(startCoordinateSymbol, startCoordinateDigit);

			for (String nearByCoordinate : nearByLocationCoordinates) {
				if (remainingBiomes <= 0) break;
				if (!visited.contains(nearByCoordinate) && island.containsKey(nearByCoordinate)) {
					island.put(nearByCoordinate, new Mountain(nearByCoordinate));
					remainingBiomes--;
					queue.add(nearByCoordinate);
					visited.add(nearByCoordinate);
				}
			}
		}
	}

	//Returns coordinates of near locations (around)
	private List<String> getNearByLocationCoordinates(char startCoordinateSymbol, int startCoordinateDigit) {
		List<String> coordinates = new ArrayList<>();
		for (char symbol = (char) (startCoordinateSymbol - 1); symbol <= (char) (startCoordinateSymbol + 1); symbol++) {
			for (int digit = startCoordinateDigit - 1; digit <= startCoordinateDigit + 1; digit++) {
				if (symbol >= 'A' && symbol <= COORDINATES[SIZE - 1][SIZE - 1].charAt(0) && digit >= 1 && digit <= SIZE) {
					coordinates.add("" + symbol + digit);
				}
			}
		}
		return coordinates;
	}

	public void printIsland() {
		Iterator<String> iterator = ISLAND.keySet().iterator();
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				Location currentLocation = ISLAND.get(iterator.next());
				if (!currentLocation.isAnimalsListEmpty()) currentLocation.printAnimal();
				else currentLocation.printLocation();
			}
			System.out.print("\n");
		}
	}

	public void printCoordination() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(COORDINATES[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public String[][] getCoordinates() {
		return COORDINATES;
	}

	public Location getLocation(String coordination) {
		return ISLAND.get(coordination);
	}
}
