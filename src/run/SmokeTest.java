package run;

import static util.Utility.*;

import java.util.HashMap;
import java.util.Map;

import datastructure.MyTree;
import util.*;
import zoo.*;

public class SmokeTest {

	public SmokeTest() {
	}
	
	public void listTest() {
		p("Tests started!\n");
		long startTime = System.currentTimeMillis();
		
		Facade lf = new Facade();
		
		Zoo myZoo = lf.createZoo("Better Zoo");
	
		// 3 Parrot -> Bird compound 1 (Birds) -> myZoo
		Compound v1 = lf.createCompound("Bird compound 1", BirdCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Parrot.class, 3, v1);
	
		// 2 Penguins -> Bird compound 2 (Birds) -> myZoo
		Compound v2 = lf.createCompound("Bird compound 2", BirdCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Penguin.class, 2, v2);
		
		// 17 Scorpions -> Desert (LandAnimal) -> myZoo
		Compound desert = lf.createCompound("Desert", LandAnimalCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Scorpion.class, 17, desert);
		
		// 1 Croc -> River (Aquatics) -> myZoo
		Compound river = lf.createCompound("River", AquaticCompound.class, myZoo);
		lf.addAnimalToCompound(lf.createAnimal(Crocodile.class, getRandomName()), river);

		// 2 Hippos -> River (Aquatics) -> myZoo
		lf.addMultAnimalsToCompound(Hippo.class, 2, myZoo.getCompounds().find(river).getData());
		
		// 212 Mulle -> Earth (LandAnimal) -> myZoo
		lf.addMultAnimalsToCompound(Mole.class, 212, 
				lf.createCompound("Earth", LandAnimalCompound.class, myZoo));
		
		MyListIterator<Compound> itComp = myZoo.getCompounds().iterator();
	
		int compCount = 1;
		while (itComp.hasNext()) {
			
			Compound comp = itComp.next();
			String compName = comp.getName();
			String compType = comp.getClass().getSimpleName();
			
			p("\nEntering "+ compCount +". compound: '"+ compName + "' which is taking animals of type " + compType +".");
			
			MyListIterator<Animal> itAnimal = comp.getAnimalList().iterator();
			Map<String, Integer> animalMap = new HashMap<String, Integer>();
			
			while (itAnimal.hasNext()) {
				Animal animal = itAnimal.next();
				String animalType = animal.getClass().getSimpleName();
				if (animalMap.get(animalType) == null) {
					animalMap.put(animalType, 1);
				} else {
					animalMap.put(animalType, animalMap.get(animalType) + 1);
				}
			}
			
			p("Here we can see the following animals: ");
			for (Map.Entry<String, Integer> entry : animalMap.entrySet()) {
			    p(entry.getValue() + "x " + entry.getKey());
			}
			compCount++;
			
			//l('I', "Name: "+ comp.getName() + ", Object: " + comp + ", AnimalList: " + comp.getAnimalList());
		}

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		p("\nTests finished in "+ totalTime +"ms!");
	}

	public void treeTestQueue() {
		p("Tests started!\n");
		long startTime = System.currentTimeMillis();
		
		Facade tf = new Facade();
		
		MyTree<Animal> tree = new MyTree<Animal>();
		
		tree.insertQueue(tf.createAnimal(Penguin.class, "n1"));
		tree.insertQueue(tf.createAnimal(Scorpion.class, "n2"));
		tree.insertQueue(tf.createAnimal(Parrot.class, "n3"));
		tree.insertQueue(tf.createAnimal(Mole.class, "n4"));
		
		MyTreeIterator<Animal> ti = tree.iterator();
		
		while(ti.hasNext()) {
			Animal animal = ti.next();
			
			l(animal + " " + animal.getName());
		}
	
		tree.insertQueue(tf.createAnimal(Parrot.class, "n5"));
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		p("\nTests finished in "+ totalTime +"ms!");
	}

	@SuppressWarnings("unused")
	public void treeTestRec() {
		p("Tests started!\n");
		long startTime = System.currentTimeMillis();
		
		Facade lf = new Facade();
		
		// Create lists
		Zoo myZoo = lf.createZoo("Better Zoo");
		
		Compound x7 = lf.createCompound("11", BirdCompound.class, myZoo);
		Compound x6 = lf.createCompound("10", BirdCompound.class, myZoo);
		Compound x5 = lf.createCompound("9", BirdCompound.class, myZoo);
		Compound x4 = lf.createCompound("8", BirdCompound.class, myZoo);
		Compound x3 = lf.createCompound("7", BirdCompound.class, myZoo);
		Compound x2 = lf.createCompound("6", BirdCompound.class, myZoo);
		Compound x1 = lf.createCompound("5", BirdCompound.class, myZoo);
		
		Compound v1 = lf.createCompound("4", BirdCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Parrot.class, 3, v1);
	
		Compound v2 = lf.createCompound("3", BirdCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Penguin.class, 2, v2);
		
		Compound desert = lf.createCompound("2", LandAnimalCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Scorpion.class, 17, desert);
		
		Compound river = lf.createCompound("1", AquaticCompound.class, myZoo);
		lf.addAnimalToCompound(lf.createAnimal(Crocodile.class, getRandomName()), river);

		lf.addMultAnimalsToCompound(Hippo.class, 2, myZoo.getCompounds().find(river).getData());
		
		lf.addMultAnimalsToCompound(Mole.class, 212, 
				lf.createCompound("0", LandAnimalCompound.class, myZoo));
		
		lf.listToTree(myZoo.getCompounds());
		
		myZoo.getCompoundsTree().print();
		
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		p("\nTests finished in "+ totalTime +"ms!");
	}
	
	public void listToTreeTest() {
		p("Tests started!\n");
		long startTime = System.currentTimeMillis();
		
		Facade lf = new Facade();
		
		Zoo myZoo = lf.createZoo("Better Zoo");
	
		// 3 Parrot -> Bird compound 1 (Birds) -> myZoo
		Compound v1 = lf.createCompound("Bird compound 1", BirdCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Parrot.class, 3, v1);
	
		// 2 Penguins -> Bird compound 2 (Birds) -> myZoo
		Compound v2 = lf.createCompound("Bird compound 2", BirdCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Penguin.class, 2, v2);
		
		// 17 Scorpions -> Desert (LandAnimal) -> myZoo
		Compound desert = lf.createCompound("Desert", LandAnimalCompound.class, myZoo);
		lf.addMultAnimalsToCompound(Scorpion.class, 17, desert);
		
		// 1 Croc -> River (Aquatics) -> myZoo
		Compound river = lf.createCompound("River", AquaticCompound.class, myZoo);
		lf.addAnimalToCompound(lf.createAnimal(Crocodile.class, getRandomName()), river);

		// 2 Hippos -> River (Aquatics) -> myZoo
		lf.addMultAnimalsToCompound(Hippo.class, 2, myZoo.getCompounds().find(river).getData());
		
		// 212 Mulle -> Earth (LandAnimal) -> myZoo
		lf.addMultAnimalsToCompound(Mole.class, 212, 
				lf.createCompound("Earth", LandAnimalCompound.class, myZoo));
		
		//MyTree<Compound> compTree = lf.listToTree(myZoo.getCompounds());
		//compTree.print();
		
		// Transforming compoundList -> compoundTree
		myZoo.setCompoundsTree(lf.listToTree(myZoo.getCompounds()));
		MyListIterator<Compound> it = myZoo.getCompounds().iterator();
		
		// Transforming animalList of compounds -> animalTree
		while (it.hasNext()) {
			Compound curr = it.next();
			curr.setAnimalTree(lf.listToTree(curr.getAnimalList()));
		}
		
		// Pretty output
		MyTreeIterator<Compound> itComp = myZoo.getCompoundsTree().iterator();
		int compCount = 1;
		while (itComp.hasNext()) {
			
			Compound comp = itComp.next();
			String compName = comp.getName();
			String compType = comp.getClass().getSimpleName();
			
			p("\nEntering "+ compCount +". compound: '"+ compName + "' which is taking animals of type " + compType +".");
			
			MyListIterator<Animal> itAnimal = comp.getAnimalList().iterator();
			Map<String, Integer> animalMap = new HashMap<String, Integer>();
			
			while (itAnimal.hasNext()) {
				Animal animal = itAnimal.next();
				String animalType = animal.getClass().getSimpleName();
				if (animalMap.get(animalType) == null) {
					animalMap.put(animalType, 1);
				} else {
					animalMap.put(animalType, animalMap.get(animalType) + 1);
				}
			}
			
			p("Here we can see the following animals: ");
			for (Map.Entry<String, Integer> entry : animalMap.entrySet()) {
			    p(entry.getValue() + "x " + entry.getKey());
			}
			compCount++;
			
			//l('I', "Name: "+ comp.getName() + ", Object: " + comp + ", AnimalList: " + comp.getAnimalList());
		}
		
		
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		p("\nTests finished in "+ totalTime +"ms!");
	}
}
