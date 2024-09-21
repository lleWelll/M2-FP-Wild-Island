package Model.Locations;

import Exceptions.ElementNotFoundException;
import Exceptions.NoEnoughSpaceInLocation;
import Model.Animals.Animal;
import Model.Herb.Herb;

import java.util.ArrayList;
import java.util.List;

public abstract class Location {
	protected final String COORDINATE;
	protected String icon;
	protected double maxAnimalWeightInLocation = 1500;
	protected double maxHerbWeightAmountInLocation = 100;
	protected double currentAnimalWeight = 0;
	protected double currentHerbWeight = 0;
	protected List<Animal> animalsInLocation = new ArrayList<>();
	protected List<Herb> herbsInLocation = new ArrayList<>();

	public List<Animal> getAnimalsInLocation() {
		return animalsInLocation;
	}

	public List<Herb> getHerbsInLocation() {
		return herbsInLocation;
	}

	public boolean isAnimalsListEmpty() {
		return animalsInLocation.isEmpty();
	}

	public double getMaxHerbWeightAmountInLocation() {
		return maxHerbWeightAmountInLocation;
	}

	public double getCurrentHerbWeight() {
		return currentHerbWeight;
	}

	//Adds animal in Location
	public void enteredLocation(Animal animal) throws NoEnoughSpaceInLocation { //Throws exception that will catch Animal class
		if (currentAnimalWeight + animal.getWeight() <= maxAnimalWeightInLocation) {
			currentAnimalWeight += animal.getWeight();
			animalsInLocation.add(animal);
		} else {
			throw new NoEnoughSpaceInLocation("There is not enough space for " + animal.getClass().getSimpleName() + " in location " + COORDINATE);
		}
	}

	//Enter location, that animal definitely could be. For example, if animal enter location,that just leaved;
	public void enteredGuaranteedLocation(Animal animal) {
		currentAnimalWeight += animal.getWeight();
		animalsInLocation.add(animal);
	}

	//removes animal from Location
	public void leavedLocation(Animal animal) {
		if (animalsInLocation.contains(animal)) {
			currentAnimalWeight -= animal.getWeight();
			animalsInLocation.remove(animal);
		} else {
			throw new ElementNotFoundException("There is no such Animal in location " + COORDINATE + " " + animal.getName() + " " + animal.getClass().getSimpleName() + "\n" + currentAnimalWeight);
		}
	}

	//Adds herb in location
	public void grownUpInLocation(Herb herb) throws NoEnoughSpaceInLocation {
		if (currentHerbWeight + herb.getWeight() <= maxHerbWeightAmountInLocation) {
			currentHerbWeight += herb.getWeight();
			herbsInLocation.add(herb);
		} else {
			throw new NoEnoughSpaceInLocation("There is not enough space for herb in location " + COORDINATE);
		}
	}

	//Removes herb from location
	public void herbEatenInLocation(Herb herb) {
		if (herbsInLocation.contains(herb)) {
			currentHerbWeight -= herb.getWeight();
			herbsInLocation.remove(herb);
		} else {
			throw new ElementNotFoundException("There is not such Herb in location " + COORDINATE);
		}
	}

	public void reduceCurrentHerbWeight(double weight) {
		currentHerbWeight -= weight;
	}

	public void reduceCurrentAnimalWeight(double weight) {
		currentAnimalWeight -= weight;
	}

	public void printLocation() {
		System.out.print(icon);
	}

	public void printAnimal() {
		System.out.print(animalsInLocation.get(0).getIcon());
	}

	public Location(String coordinate) {
		this.COORDINATE = coordinate;
	}

}
