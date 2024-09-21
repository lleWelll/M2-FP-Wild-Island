package ModelManagers;

import java.util.HashMap;
import java.util.Map;

public class Settings {
	//Model Settings
	public static final long STEP_TIME = 500; //Ms that determine how often animals make their steprs
	public static final int HERB_GROW_TIME = 5; //Coefficient that determine how often new herbs will grow (HERB_GROW_TIME = coefficient * STEP_TIME)
	public static final long UPDATE_TIME = 5000; //Ms that determine gow often statistics and island will be printed
	public static final boolean ACTIVATE_STEP_PRINTING = false;
	public static final boolean ACTIVATE_LOGGER_REPRODUCE = false;
	public static final boolean ACTIVATE_LOGGER_EAT = false;
	public static final boolean ACTIVATE_LOGGER_DIE = false;

	//Island Settings
	public static final int ISLAND_SIZE = 30; //Max size = 100, recommended 30
	public static final boolean SPAWN_RIVER = true; //Spawn 1 River location on island
	public static final boolean SPAWN_MOUNTAIN = true; //Spawn 1 Mountain 1 location on island
	public static final double BIOME_SIZE = 1.0; //Coefficient of size of biomes


	//Animal and herbs Settings
	public static final int GRASS_WEIGHT = 20;

	public static final Map<String, Integer[]> ANIMALS_STATS = new HashMap<>() {{
		//Change animals stats, where element[0] = animal amount on start, [1] = maxAge, [2] = amountOfChildren, [3] = speed
		put("Bear", new Integer[]{80, 20, 3, 4});
		put("Eagle", new Integer[]{150, 8, 2, 3});
		put("Fox", new Integer[]{200, 10, 3, 3});
		put("Tiger", new Integer[]{100, 12, 2, 4});
		put("Wolf", new Integer[]{130, 8, 2, 4});
		put("Buffalo", new Integer[]{100, 9, 2, 4});
		put("Deer", new Integer[]{150, 6, 2, 4});
		put("Duck", new Integer[]{100, 4, 2, 3});
		put("Hare", new Integer[]{200, 4, 2, 3});
		put("Horse", new Integer[]{150, 6, 2, 4});
		put("Mouse", new Integer[]{500, 7, 2, 2});
	}};
	public static final int REPRODUCE_CHANCE = 70;
	public static final double AMOUNT_OF_CHILDREN = 1.0; //Coefficient that determine max amount of children (for every animal max children = amountOfChildren * MAX_AMOUNT_OF_CHILDREN)
	public static final int STEPS_NEEDED_TO_REPRODUCE_AGAIN = 3;

}
