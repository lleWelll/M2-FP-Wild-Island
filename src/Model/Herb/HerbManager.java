package Model.Herb;

import java.util.ArrayList;
import java.util.List;

public class HerbManager implements Runnable {
	private static final List<Herb> HERB_LIST = new ArrayList<>();
	private static final Object LOCK = new Object(); //Object for synchronization

	public static Object getLock() {
		return LOCK;
	}

	public static List<Herb> getHerbList() {
		return HERB_LIST;
	}

	public synchronized static void addHerb(Herb herb) {
		HERB_LIST.add(herb);
	}

	public static void removeAllEaten() {
		HERB_LIST.removeIf(Herb::isEaten);
	}

	//Manages herb steps
	@Override
	public void run() {
		if (HERB_LIST.isEmpty()) return;
		synchronized (LOCK) {
			for (Herb h : HERB_LIST) {
				if (h.isEaten()) continue;
				if (h.getAge() >= h.getMaxAge()) h.die();
				else h.plusYear();
			}
			removeAllEaten();
		}
	}
}
