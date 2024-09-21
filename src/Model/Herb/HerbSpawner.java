package Model.Herb;

import Exceptions.NoEnoughSpaceInLocation;
import Model.Island;
import Model.Locations.Location;
import ModelManagers.Settings;

public class HerbSpawner implements Runnable {
	private static final Island ISLAND = Island.getInstance();

	//Fills every location with herbs
	@Override
	public void run() {
		synchronized (HerbManager.getLock()) {
			String[][] coordinates = ISLAND.getCoordinates();

			for (String[] row : coordinates) {
				for (String currentCoordinates : row) {
					Location loc = ISLAND.getLocation(currentCoordinates);
					int neededWeight = (int) (loc.getMaxHerbWeightAmountInLocation() - loc.getCurrentHerbWeight());

					while (neededWeight > 0) {
						if (neededWeight < Settings.GRASS_WEIGHT) break;
						Herb h = new Grass(currentCoordinates);
						try {
							h.spawnHerb();
						} catch (NoEnoughSpaceInLocation e) {
							System.out.printf("Location: %s, Current weight: %f, Max weight: %f, Coordinates: %s%n", loc.getClass().getSimpleName(), loc.getCurrentHerbWeight(), loc.getMaxHerbWeightAmountInLocation(), currentCoordinates);
						}
						neededWeight -= Settings.GRASS_WEIGHT;
					}
				}
			}
		}
	}
}