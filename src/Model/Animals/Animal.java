package Model.Animals;

import Additional.Logger;
import Additional.Randomizer;
import Exceptions.NoEnoughSpaceInLocation;
import Interfaces.Dying;
import Interfaces.Reproducible;
import Interfaces.Walkable;
import Model.Island;
import ModelManagers.Settings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Animal implements Walkable, Reproducible, Dying {
	protected static Island island = Island.getInstance();

	protected String name;
	protected String icon;
	protected String gender;
	protected String position;
	protected double weight;
	protected double neededFood;
	protected double foodConsumed = 0;
	protected int age;
	protected int maxAge;
	protected int speed;
	protected int amountOfChildren;
	protected int stepsForNextReproduce = 0;
	protected boolean canReproduce = true;
	protected boolean isDead = false;
	protected Map<String, Integer> predationChances = new HashMap<>();

	public Animal(int age, String position) {
		this.age = age;
		this.gender = Randomizer.generateGender();
		this.name = Randomizer.generateRandomName(this.gender);
		this.position = position;
	}

	protected int AmountOfChildren(int amount) {
		return (int) Math.round(amount * Settings.AMOUNT_OF_CHILDREN);
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getPosition() {
		return position;
	}

	public String getIcon() {
		return icon;
	}

	public Integer getPredationChance(String animalType) {
		return predationChances.get(animalType);
	}

	public int getAge() {
		return age;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public int getSpeed() {
		return speed;
	}

	public double getWeight() {
		return weight;
	}

	public double getFoodConsumed() {
		return foodConsumed;
	}

	public double getNeededFood() {
		return neededFood;
	}

	public void setFoodConsumed(double foodConsumed) {
		this.foodConsumed = foodConsumed;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void plusYear() {
		this.age++;
	}

	public void setCanReproduce(boolean canReproduce) {
		this.canReproduce = canReproduce;
	}

	public boolean isCanReproduce() {
		return canReproduce;
	}

	public boolean isDead() {
		return isDead;
	}

	public int getPositionNumber() {
		return Integer.parseInt(position.substring(1));
	}

	public char getPositionChar() {
		return position.charAt(0);
	}

	public Map<String, Integer> getPredationTable() {
		return predationChances;
	}

	protected abstract void initializePredationChances();

	public boolean spawnAnimal() {
		synchronized (AnimalManager.getLock()) {
			try {
				island.getLocation(position).enteredLocation(this);
				AnimalManager.addAnimal(this);
				return true;
			} catch (NoEnoughSpaceInLocation ignore) {
				return false;
			}
		}
	}

	@Override
	public void reproduce() {
		if (!isCanReproduce()) stepsForNextReproduce++;
		if (stepsForNextReproduce >= Settings.STEPS_NEEDED_TO_REPRODUCE_AGAIN) {
			setCanReproduce(true);
			stepsForNextReproduce = 0;
		}
		List<Animal> animalsInLocation = island.getLocation(position).getAnimalsInLocation();
		animalsInLocation.stream()
				.filter(an -> an != this)
				.filter(an -> !an.isDead())
				.filter(an -> an.getClass().equals(this.getClass()))
				.filter(an -> !an.getGender().equals(this.gender))
				.filter(an -> an.isCanReproduce() && this.isCanReproduce())
				.filter(an -> Randomizer.generatePercent() <= Settings.REPRODUCE_CHANCE)
				.forEach(an -> {
					for (int i = 0; i < this.amountOfChildren; i++) {
						Animal baby = null;
						try {
							baby = this.getClass()
									.getDeclaredConstructor(int.class, String.class, boolean.class)
									.newInstance(0, getPosition(), false);
						} catch (Exception ignore) {}
						synchronized (AnimalManager.getLock()) {
							AnimalManager.addChild(baby);
							setCanReproduce(false);
							an.setCanReproduce(false);
						}
						if (Settings.ACTIVATE_LOGGER_REPRODUCE) Logger.logReproduce(this, an);
					}
				});
	}

	@Override
	public void die() {
		island.getLocation(position).leavedLocation(this);
		this.isDead = true;
		if (Settings.ACTIVATE_LOGGER_DIE) Logger.logDied(this);
	}

	@Override
	public void walk() {
		String newPosition;

		//Leaving current location
		island.getLocation(this.position).leavedLocation(this);

		try {
			int direction = Randomizer.generateNumber(4); //Determining direction of walking
			switch (direction) {
				case 0 -> {
					newPosition = getUpPosition();
					island.getLocation(newPosition).enteredLocation(this);
					this.setPosition(newPosition);
				}
				case 1 -> {
					newPosition = getRightPosition();
					island.getLocation(newPosition).enteredLocation(this);
					this.setPosition(newPosition);
				}
				case 2 -> {
					newPosition = getDownPosition();
					island.getLocation(newPosition).enteredLocation(this);
					this.setPosition(newPosition);
				}
				case 3 -> {
					newPosition = getLeftPosition();
					island.getLocation(newPosition).enteredLocation(this);
					this.setPosition(newPosition);
				}
				default -> throw new RuntimeException();
			}
		} catch (NoEnoughSpaceInLocation | NullPointerException e) {
			island.getLocation(this.position).enteredGuaranteedLocation(this); //if animal can't enter position, it enters in position, that just leaved
		}
	}

	@Override
	public String getUpPosition() {
		return (char) (this.getPositionChar() - 1) + "" + this.getPositionNumber();
	}

	@Override
	public String getRightPosition() {
		return this.getPositionChar() + "" + (this.getPositionNumber() + 1);
	}

	@Override
	public String getDownPosition() {
		return (char) (this.getPositionChar() + 1) + "" + this.getPositionNumber();
	}

	@Override
	public String getLeftPosition() {
		return this.getPositionChar() + "" + (this.getPositionNumber() - 1);
	}
}
