package run;

//import static util.Utility.*;
//import util.Utility;

/**
 * This program implements a tour through a zoo where compounds and animals are first stored in singly linked lists, then swapped into binary trees. 
 * Animals are stored in a list, which is part of a compound. All compounds are then stored in a seperate list, assigned to a zoo.
 * In the second part we transform our linked lists into un-sorted but mostly balanced binary trees. 		 
 *
 * All of the interactions should be done through the Facade class, where most of the logic is implemented. 
 * This makes later changes to the structure/model of the program easier, since the majority of re-work would be done 
 * in the Facade and only a minimun in respective classes.
 */
public class Main {

	public Main() {
	}

	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
//		p("Program started.\n");
		
//		Utility.loggingEnabled = true;
		
		final Tour tour = new Tour();
		tour.run();
		
		
//		long endTime = System.currentTimeMillis();
//		long totalTime = endTime - startTime;
//		p("\nProgram finished after " + totalTime + "ms.");
	}
}
