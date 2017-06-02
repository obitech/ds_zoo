package zoo;

import datastructure.*;

public class Zoo {

	private String name;
	private MyLinkedList<Compound> compoundsList = null;
	private MyTree<Compound> compoundsTree = null;
	
	public MyTree<Compound> getCompoundsTree() {
		return compoundsTree;
	}

	public void setCompoundsTree(MyTree<Compound> compoundsTree) {
		this.compoundsTree = compoundsTree;
	}

	public Zoo(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyLinkedList<Compound> getCompounds() {
		return compoundsList;
	}

	public void setCompounds(MyLinkedList<Compound> compounds) {
		this.compoundsList = compounds;
	}
	
	public void addCompound(Compound comp) {
		compoundsList.add(comp);
	}

// Use this for debugging
/*
	@Override
	public String toString() {
		return "Zoo [name=" + name + ", compoundsList=" + compoundsList + ", compoundsTree="+ compoundsTree +"] ";
	}
*/	
	
	@Override
	public String toString() {
		return "Zoo: '"+ name +"'";
	}
}
