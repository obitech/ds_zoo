package zoo;

import datastructure.MyLinkedList;

public class AquaticCompound extends Compound {

	public AquaticCompound(String name) {
		super(name);
	}

	public AquaticCompound(String name, MyLinkedList<Animal> animalList) {
		super(name, animalList);
	}
}
