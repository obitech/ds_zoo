package zoo;

import datastructure.MyLinkedList;

public class LandAnimalCompound extends Compound {

	public LandAnimalCompound(String name) {
		super(name);
	}

	public LandAnimalCompound(String name, MyLinkedList<Animal> animalList) {
		super(name, animalList);
	}
}
