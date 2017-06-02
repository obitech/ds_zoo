package util;

import static util.Utility.*;

import java.util.HashMap;
import java.util.Map;

import datastructure.*;
import zoo.*;


public class Facade {

	public Facade() {
	}
	
	/******************************************************************
	 **************************** LinkedList **************************
	 ******************************************************************/
	
	// ------------------- Animals -------------------
	
	// New Animal
    public Animal createAnimal(Class<? extends Animal> type, String name) {
        if (type == Scorpion.class) {
            Animal out = new Scorpion(name);
            l("New " + out + " has been created.");
            return out;
        } else if (type == Mole.class) {
            Animal out = new Mole(name);
            l("New " + out + " has been created.");
            return out;
        } else if (type == Parrot.class) {
            Animal out = new Parrot(name);
            l("New " + out + " has been created.");
            return out;
        } else if (type == Penguin.class) {
            Animal out = new Penguin(name);
            l("New " + out + " has been created.");
            return out;
        } else if (type == Crocodile.class) {
            Animal out = new Crocodile(name);
            l("New " + out + " has been created.");
            return out;
        } else if (type == Hippo.class) {
            Animal out = new Hippo(name);
            l("New " + out + " has been created.");
            return out;
        } else {
            l("Unable to create Animal of type " + type + ", type not found.");
            return null;
        }
    }
    
	// Animal -> Compound
	public void addAnimalToCompound(Animal animal, Compound comp) {
		// Check if it belongs
		if ((animal instanceof LandAnimal 	&& comp instanceof LandAnimalCompound)	||
			(animal instanceof Aquatic 		&& comp instanceof AquaticCompound) 	|| 
			(animal instanceof Bird 		&& comp instanceof BirdCompound) ) {
			
			if (comp.getAnimalList() == null) {
				comp.setAnimalList(createAnimalList());
			}
			
			comp.addAnimal(animal);
			l(animal + " has been added to " + comp);
			
			animal.setCompound(comp);
			l(comp + " has been added to " + animal);
		} else {
			l("E", "Unable to add Animal " + animal.getClass().getSuperclass() + " to "+ comp +", doesn't belong!");
		}
	}
	
	// Multiple Animals -> Compound
	public void addMultAnimalsToCompound(Class<? extends Animal> type, int n, Compound comp) {
		for (int i = 0; i < n; i++) {
			l("Adding " + type.getSimpleName() + " " + (i+1) + "/"+ n +":");
			addAnimalToCompound(createAnimal(type, getRandomName()), comp);
		}
	}
	
	// New AnimalList
	public MyLinkedList<Animal> createAnimalList(){
		MyLinkedList<Animal> out = new MyLinkedList<Animal>();
		l("New "+out+ "<Animal> has been created.");
		return out;
	}
	
	// Animal -> AnimalList
	public void addAnimalToList(Animal animal, MyLinkedList<Animal> list) {
		ListNode<Animal> newNode = new ListNode<Animal>(animal);
		l(newNode+ "<Animal> with data " + animal + "<LandAnimal> has been created.");
		list.add(newNode);
		l(newNode + "<LandAnimal> has been added to MyLinkedList<LandAnimal> " + list);
	}

	// AnimalList -> Compound
	public void addAnimalListToCompound(MyLinkedList<Animal> animalList, Compound compound) {
		compound.setAnimalList(animalList);
		l(animalList + " has been added to " + compound);
	}

	// ------------------ Compounds ------------------

	// New Compound
	public Compound createCompound(String name, Class<? extends Compound> type, Zoo zoo) {
		
		if (type == LandAnimalCompound.class) {
			Compound comp = new LandAnimalCompound(name);
			l("New " + comp + " has been created.");
			addCompoundToZoo(comp, zoo);
			return comp;
		} else if (type == AquaticCompound.class) {
			Compound comp = new AquaticCompound(name);
			l("New " + comp + " has been created.");
			addCompoundToZoo(comp, zoo);
			return comp;
		} else if (type == BirdCompound.class) {
			Compound comp = new BirdCompound(name);
			l("New " + comp + " has been created.");
			addCompoundToZoo(comp, zoo);
			return comp;
		} else {
			l("Unable to create Compound of type " + type + ", type not found.");
			return null;
		}
	}
	
	// For nicer print: BirdCompound will return Bird, etc.
	public Class<? extends Animal> compAnimalType(Compound comp) {
		if (comp instanceof BirdCompound) {
			return Bird.class;
		} else if (comp instanceof LandAnimalCompound) {
			return LandAnimal.class;
		} else {
			return Aquatic.class;
		}
	}
	
	// Compound -> Zoo
	public void addCompoundToZoo(Compound comp, Zoo zoo) {
		if (zoo.getCompounds() == null) {
			zoo.setCompounds(new MyLinkedList<Compound>());
		}
		
		zoo.addCompound(comp);
		l(comp + " has been added to Zoo " + zoo);
	}
	
	// CompoundList -> Zoo
	public void addCompoundListToZoo(MyLinkedList<Compound> compounds, Zoo zoo) {
		zoo.setCompounds(compounds);
		l(compounds + " has been added to Zoo " + zoo);
	}
	
	// --------------------- Zoo ---------------------
	
	// New Zoo
	public Zoo createZoo(String name) {
		Zoo zoo = new Zoo(name);
		l("New " + zoo + " has been created.");
		
		MyLinkedList<Compound> compList = new MyLinkedList<Compound>();
		zoo.setCompounds(compList);
		l("New " + compList + "<Compound> has been created and added to " + zoo);
		
		return zoo;
	}
	
	// Destroy AnimalLists and Compounds
	public void destroyLists(Zoo zoo) {
		MyListIterator<Compound> itComp = zoo.getCompounds().iterator();
		while (itComp.hasNext()) {
			Compound comp = itComp.next();
			comp.getAnimalList().delete();
		}
		
		zoo.getCompounds().delete();
	}
	
	/******************************************************************
	 ****************************** Trees *****************************
	 ******************************************************************/
	
	// ListNode -> TreeNode
	public <T> TreeNode<T> listNodeToTreeNode(ListNode<T> node) {
		TreeNode<T> out = new TreeNode<T>(node.getData());
		l(out + " has been created from " + node);
		return out;
	}
	
	// MyLinkedList -> MyTree
	public <T> MyTree<T> listToTree(MyLinkedList<T> list) {
		MyTree<T> out = new MyTree<T>();
		
		MyListIterator<T> it = list.iterator();
		while (it.hasNext()) {
			TreeNode<T> node = new TreeNode<T>(it.next());
			out.insertRec(node, out.getRoot(), out.getNodeCount());
		}
		
		return out;
	}
	
	/******************************************************************
	 ****************************** Tours *****************************
	 ******************************************************************/ 
	
	public <T> void listTour(Zoo zoo) {
		MyListIterator<Compound> itComp = zoo.getCompounds().iterator();
		
		// Iterating over each compound
		int compCount = 0;
		while (itComp.hasNext()) {
			Compound comp = itComp.next();
			
			p("\nWe're now entering compound #"+ (compCount + 1) +": '"+ comp.getName() + "', which is taking animals of type " + compAnimalType(comp).getSimpleName() +".");
			p("Here we can see the following animals: ");
			
			// Iterating over each animal in each compound
			MyListIterator<Animal> itAnimal = comp.getAnimalList().iterator();
			
			// Print animals of small compounds individually
			if (comp.getAnimalList().getSize() < 6) {

				
				while (itAnimal.hasNext()) {
					Animal animal = itAnimal.next();
					p("- " + animal.getClass().getSimpleName() + " " + animal.getName());
				}
			
			// Bigger compounds will be printed in bulk
			} else {
				// Using HashMap to store count of specific animal type in current compound
				Map<String, Integer> animalMap = new HashMap<String, Integer>();				
		
				while (itAnimal.hasNext()) {
					Animal animal = itAnimal.next();
					String animalType = animal.getClass().getSimpleName();
					
					// Type already saved in map?
					if (animalMap.get(animalType) == null) {
						// ... no -> set count to 1
						animalMap.put(animalType, 1);
					} else {
						// ... yes -> increase count by 1
						animalMap.put(animalType, animalMap.get(animalType) + 1);
					}
				}
				
				for (Map.Entry<String, Integer> item : animalMap.entrySet()) {
					p(item.getValue() + " " + item.getKey() + "s");
				}
			}
			compCount++;
		}
	}
	
	public <T> void treeTour(Zoo zoo) {
		MyTreeIterator<Compound> itComp = zoo.getCompoundsTree().iterator();
		
		// Iterating over each compound
		int compCount = 0;
		while (itComp.hasNext()) {
			Compound comp = itComp.next();
			
			p("\nWe're now entering compound #"+ (compCount + 1) +": '"+ comp.getName() + "', which is taking animals of type " + compAnimalType(comp).getSimpleName() +".");
			p("Here we can see the following animals: ");
			
			// Iterating over each animal in each compound
			MyTreeIterator<Animal> itAnimal = comp.getAnimalTree().iterator();
			
			// Print animals of small compounds individually
			if (comp.getAnimalTree().getSize() < 6) {

				
				while (itAnimal.hasNext()) {
					Animal animal = itAnimal.next();
					p("- " + animal.getClass().getSimpleName() + " " + animal.getName());
				}
			
			// Bigger compounds will be printed in bulk
			} else {
				// Using HashMap to store count of specific animal type in current compound
				Map<String, Integer> animalMap = new HashMap<String, Integer>();				
		
				while (itAnimal.hasNext()) {
					Animal animal = itAnimal.next();
					String animalType = animal.getClass().getSimpleName();
					
					// Type already saved in map?
					if (animalMap.get(animalType) == null) {
						// ... no -> set count to 1
						animalMap.put(animalType, 1);
					} else {
						// ... yes -> increase count by 1
						animalMap.put(animalType, animalMap.get(animalType) + 1);
					}
				}

				for (Map.Entry<String, Integer> item : animalMap.entrySet()) {
					p(item.getValue() + " " + item.getKey() + "s");
				}
			}
			compCount++;
		}
	}
}
