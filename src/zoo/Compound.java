package zoo;

import datastructure.MyLinkedList;
import datastructure.MyTree;

public abstract class Compound  {

	private String name;
	private MyLinkedList<Animal> animalList = null;
	private MyTree<Animal> animalTree = null;

	public Compound(String name) {
		this.name = name;
	}
	
	public Compound(String name, MyLinkedList<Animal> animalList) {
		this.animalList = animalList;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public MyLinkedList<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(MyLinkedList<Animal> animalList) {
		this.animalList = animalList;
	}
	
	public MyTree<Animal> getAnimalTree() {
		return animalTree;
	}

	public void setAnimalTree(MyTree<Animal> animalTree) {
		this.animalTree = animalTree;
	}
	
	public void addAnimal(Animal animal) {
		this.animalList.add(animal);
	}

 // Use this for debugging
/* 
	@Override
	public String toString() {
		return "Compound ("+ this.hashCode() +") [name=" + name + ", type=" + type + ", animalList=" + animalList + "]";
	}
*/
	@Override
	public String toString() {
		return "Compound '"+ name +"', reserved for "+ this.getClass().getSimpleName() +"s";
	}
}
