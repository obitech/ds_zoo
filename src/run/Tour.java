package run;

import static util.Utility.*;

import util.*;
import zoo.*;


public final class Tour {

	public Tour() {
	}
	
	// Driver function
	public void run() {
		final Facade fa = new Facade();

		p("===== Task 1 =====");
		final Zoo myZoo = fa.createZoo("Better Zoo");
		
		// 3 Parrot -> Bird compound 1 (Birds) -> myZoo
		final Compound bird1 = fa.createCompound("Bird compound 1", BirdCompound.class, myZoo);
		fa.addMultAnimalsToCompound(Parrot.class, 3, bird1);
	
		// 2 Penguins -> Bird compound 2 (Birds) -> myZoo
		final Compound bird2 = fa.createCompound("Bird compound 2", BirdCompound.class, myZoo);
		fa.addMultAnimalsToCompound(Penguin.class, 2, bird2);
		
		// 17 Scorpions -> Desert (LandAnimals) -> myZoo
		final Compound desert = fa.createCompound("Desert", LandAnimalCompound.class, myZoo);
		fa.addMultAnimalsToCompound(Scorpion.class, 17, desert);
		
		// 1 Croc -> River (Aquatics) -> myZoo
		final Compound river = fa.createCompound("River", AquaticCompound.class, myZoo);
		fa.addAnimalToCompound(fa.createAnimal(Crocodile.class, getRandomName()), river);

		// 2 Hippos -> River (Aquatics) -> myZoo
		// find() works too!
		fa.addMultAnimalsToCompound(Hippo.class, 2, myZoo.getCompounds().find(river).getData());
		
		// 212 Mulle -> Earth (LandAnimal) -> myZoo
		fa.addMultAnimalsToCompound(Mole.class, 212, 
				fa.createCompound("Earth", LandAnimalCompound.class, myZoo));
		
		// Pretty output
		p("Welcome to " + myZoo.getName() + "! Today we'll be touring our " + myZoo.getCompounds().size() + " animal compounds. Please follow me.");
		fa.listTour(myZoo);
		
		p("\n===== Task 2 =====");
		p("That was pretty great right? Now I need to ask you to step out for a minute so we can rebuild our amazing " + myZoo.getName() +". Please come back in a couple of ms.");
		
		// Transforming compoundList to compoundTree
		myZoo.setCompoundsTree(fa.listToTree(myZoo.getCompounds()));
		
		// Transforming animalLists in compounds to animalTrees
		MyListIterator<Compound> it = myZoo.getCompounds().iterator();
		while (it.hasNext()) {
			Compound curr = it.next();
			curr.setAnimalTree(fa.listToTree(curr.getAnimalList()));
		}
		
		// Setting the old lists null, since we need to swap list for tree
		fa.destroyLists(myZoo);		

		p("\nWelcome again to " + myZoo.getName() + "! Today we'll be touring our " + myZoo.getCompoundsTree().getSize() + " animal compounds again. Let's go this way.");
		
		// Pretty output
		fa.treeTour(myZoo);
		
		p("\nThank you for visiting " + myZoo.getName() + " today.");
	}
}
