package Model.Herb;

import Enums.Icons;
import ModelManagers.Settings;

public class Grass extends Herb {
	public Grass(String position) {
		super(position);
		this.weight = Settings.GRASS_WEIGHT;
		this.icon = Icons.GRASS.getIcon();
	}
}
