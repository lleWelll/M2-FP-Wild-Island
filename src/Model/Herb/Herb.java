package Model.Herb;

import Exceptions.NoEnoughSpaceInLocation;
import Model.Island;

public abstract class Herb {
	protected String position;
	protected String icon;
	protected int age = 0;
	protected int maxAge = 20;
	protected double weight;
	protected boolean isEaten = false;
	protected static Island island = Island.getInstance();

	public Herb(String position) {
		this.position = position;
	}

	public double getWeight() {
		return weight;
	}

	public String getPosition() {
		return position;
	}

	public String getIcon() {
		return icon;
	}

	public int getAge() {
		return age;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void plusYear() {
		this.age++;
	}

	public boolean isEaten() {
		return isEaten;
	}

	public void spawnHerb() throws NoEnoughSpaceInLocation {
		island.getLocation(position).grownUpInLocation(this);
		HerbManager.addHerb(this);
	}

	public void die() {
		island.getLocation(position).herbEatenInLocation(this);
		this.isEaten = true;
	}

	public void reduceWeight(double reduced) {
		this.weight -= reduced;
		island.getLocation(position).reduceCurrentHerbWeight(reduced);
		if (this.weight <= 0) die();
	}
}
