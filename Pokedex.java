/*Name: Samantha Garcia
 *Date: November 15, 2016
 *Description: This program uses the implementation of different classes combines with no-arg and arg constructors in order to tie
 *in to the main menu in Project4.java. Global variables and array are used to keep track of the species inputed.
 *
 * This was a class project.
 */

//package project4;

import java.util.Arrays;

public class Pokedex {

	//Here I made a static global variable in order for the array to be of equal size to the amount of objects created.
	public int addedPokemon = 0;
	//Created array to store pokemon objects. 
	public String[] pokedex;
	
	//No-Arg Constructor
	public Pokedex() {
		
	}
	
	//Arg Constructor to initialize how many objects can be stored in the pokedex.
	public Pokedex(int size) {
		pokedex = new String[size];
	}
	
	//The pokemon are listed in their current order; it only lists up to the number that have been put in,
	//not until the array size has ended.
	public String[] listPokemon() {
		//This int is to count how many pokemon indexes have been filled out.
		int count = 0;
		//This array will be the new one that will display the non-filled version of the pokedex array.
		String[] pokemonNames;
		//If there are no pokemon then it will automatically return "Empty" from the Project4.java.
		if (addedPokemon == 0) {
			return null;
		}
		//For every pokemon that is found, 1 is added to the count.
		for (int i = 0; i < pokedex.length; i++) {
			if (pokedex[i] != null)
			count++;
		}
		//Here is where I initialize thenew array by making it the size of the count.
		pokemonNames = new String[count];
		for (int j = 0; j < pokemonNames.length; j++) {
			//For every pokemon object in the pokedex array, it is placed into the new array.
			pokemonNames[j] = pokedex[j];
		}
		//I return the new array with the shortened size (if it needed to be shortened to begin with).
		return pokemonNames;
	}

	//Here is the method to add new pokemon to the pokedex array. It returns whether the action was successful or not. 
	public boolean addPokemon(String species) {
		//This variable is to determine if the user reached the maximum amount of spaces available in the pokedex.
		int max = pokedex.length;
		//The system will print out "Max" and return false if the global variable addedPokemon exceeds the maximum amount of spaces in the pokedex array.
		if (addedPokemon >= (pokedex.length)) { 
			System.out.println("Max");
			return false;
		}
		
		else
		{
			for (int i = 0; i < pokedex.length; i++) {
				//Here I check to see if the user already inputed a pokemon of the same name previously by using the 
				//equalsIgnoreCase(). It prints "Duplicate" and returns false.
				if (i >= 0 && (species.equalsIgnoreCase(pokedex[i]) == true)) {
						System.out.println("Duplicate");
						return false;
				}
				else {
					//If the next available space is empty, or null, then place that pokemon in that index and add a count to the total pokemon with addedPokemon. 
					if (pokedex[i] == null) {
					pokedex[i] = species;
					addedPokemon++;
					return true;
					
					}
				}
			}
			
		}
		return false;
	}
	
	//Here a new array consisting of three stats called from the Pokemon.java file are returned after accepting the species name for the desired calculation.
	public int[] checkStats(String species) {
		//This boolean was made to determine whether or not the pokemon that is being search for 
		boolean missing = false;
		//Here is the array that is returned with the three stats of the pokemon.
		int [] stats = new int[3];
		//If there are no pokemon to begin with then null will be returned and "Missing" will be printed (from Project4.java).
		if (addedPokemon == 0) {
			return null;
		}
		else { 
			//This checks if the pokemon inserted matches on in the loop by using equalsIgnoreCase() and making sure the index is not empty.
			for (int i = 0; i < pokedex.length; i++) {
				if ((pokedex[i] != null) && (species.equalsIgnoreCase(pokedex[i]))) {
					Pokemon inputedPokemon = new Pokemon(species);
					stats[0] = inputedPokemon.getAttack();
					stats[1] = inputedPokemon.getDefense();
					stats[2] = inputedPokemon.getSpeed();
					//This was placed here to make certain that the pokemon was found.
					missing = true;
				}

			}
		}
		//If the pokemon was not found, then missing was never changed to true and the Project4.java will print out "Missing".
		if (missing == false) {
			return null;
		}
		return stats;
	}
	
	//Here is the selection sort for type String arrays. It sorts the pokemon and arranges them alphabetically.
	public void sortPokemon() {
		//This will only run if there are one or more pokemon objects inputed in the array.
		if (addedPokemon > 0) {
		for (int i = 0; i < addedPokemon; i++) {
			//Here I am setting up a variable called minimum to later compare the other indexes and replace minimum with the 
			//pokemon that is first in the alphabetical order.
			String min = pokedex[i];
			for (int j = 0; j < addedPokemon; j++) {
				//If the pokemon object is not empty and it compares to the minimum and results in being lower than the minimum, the swap
				//of array indexes occurs.
				if ((pokedex[i] != null) && (pokedex[j] != null) && (min.compareToIgnoreCase(pokedex[j]) < 0)) { //ADDED (pokedex[j] != null)
					//I set the minimum equal to the new index and make a temporary String to hold in the original value at the i index.
					//Then I swap the j index into the i index and equal the j index to the temporary String I had made with the i index.
					min = pokedex[j];
					String temp = pokedex[i];
					pokedex[i] = pokedex[j];	
					pokedex[j] = temp; 
				}
			}
		}
		}
		
	}
	
}
