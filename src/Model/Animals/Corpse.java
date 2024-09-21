package Model.Animals;

import Enums.Icons;
import Interfaces.Markers.CanFly;
import Interfaces.Markers.CanSwim;
import Interfaces.Markers.CanWalk;

public class Corpse extends Animal implements CanWalk, CanFly, CanSwim {
	public Corpse(double weight, int age, String position) {
		super(age, position);
		this.weight = weight;
		this.maxAge = 15;
		this.icon = Icons.CORPSE.getIcon();
	}

	public void reduceWeight(double reduced) {
		this.weight -= reduced;
		island.getLocation(position).reduceCurrentAnimalWeight(reduced);
		if (this.weight <= 0) rot();
	}

	//Method rot = die, but with more suitable name
	public void rot() {
		this.die();
	}
	@Override
	public void reproduce() {
		throw new UnsupportedOperationException("Method reproduce is unsupported in this class");
	}

	@Override
	public void walk() {
		throw new UnsupportedOperationException("Method walk is unsupported in this class");
	}
	@Override
	public String getUpPosition() {
		throw new UnsupportedOperationException("Method getUpPosition is unsupported in this class");
	}

	@Override
	public String getRightPosition() {
		throw new UnsupportedOperationException("Method getRightPosition is unsupported in this class");
	}

	@Override
	public String getDownPosition() {
		throw new UnsupportedOperationException("Method getDownPosition is unsupported in this class");
	}

	@Override
	public String getLeftPosition() {
		throw new UnsupportedOperationException("Method getLeftPosition is unsupported in this class");
	}

	@Override
	protected void initializePredationChances() {
		throw new UnsupportedOperationException("Method initializePredationChances is unsupported in this class");
	}
}
