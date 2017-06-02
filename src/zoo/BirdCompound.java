package zoo;

import datastructure.MyLinkedList;

public class BirdCompound extends Compound {

	public BirdCompound(String name) {
		super(name);
	}

	public BirdCompound(String name, MyLinkedList<Animal> animalList) {
		super(name, animalList);
	}
}
