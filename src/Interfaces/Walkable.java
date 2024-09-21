package Interfaces;

import Model.Animals.Animal;
import Model.Island;

public interface Walkable {
	void walk();
	String getUpPosition();
	String getRightPosition();
	String getDownPosition();
	String getLeftPosition();

}
