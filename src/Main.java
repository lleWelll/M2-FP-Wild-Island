import ModelManagers.ModelBreaker;
import ModelManagers.Statistic;
import Model.Animals.AnimalManager;
import Model.Animals.AnimalSpawner;
import Model.Herb.HerbManager;
import Model.Herb.HerbSpawner;
import Model.Island;
import ModelManagers.Settings;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		Island i = Island.getInstance();
		ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(4);

		i.printIsland();
		AnimalSpawner.spawnStartAnimals();
		scheduledExecutor.scheduleAtFixedRate(new HerbSpawner(), 0, Settings.HERB_GROW_TIME * Settings.STEP_TIME, TimeUnit.MILLISECONDS);
		scheduledExecutor.scheduleAtFixedRate(new Statistic(), 50, Settings.UPDATE_TIME, TimeUnit.MILLISECONDS);
		scheduledExecutor.scheduleAtFixedRate(new AnimalManager(), 100, Settings.STEP_TIME, TimeUnit.MILLISECONDS);
		scheduledExecutor.scheduleAtFixedRate(new HerbManager(), 100, Settings.STEP_TIME, TimeUnit.MILLISECONDS);
		scheduledExecutor.scheduleAtFixedRate(new ModelBreaker(scheduledExecutor), 200, Settings.UPDATE_TIME, TimeUnit.MILLISECONDS);
	}
}
