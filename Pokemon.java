/*Name: Samantha Garcia
 *Date: November 15, 2016
 *Description: This program uses the implementation of different classes combines with no-arg and arg constructors in order to tie
 *in to the main menu in Project4.java. Global variables and array are used to keep track of the species inputed. 
 *
 *This was a class project.
 */


public class Pokemon {
//Here I declared all of the global variables that will enable the attack, defense, and speed of each Pokemon to be initialized. 
	public String species;
	public int attack;
	public int defense;
	public int speed;
//Default Constructor
	public Pokemon () {
		
	}
//Arg. Constructor 
	public Pokemon (String species) { 
		this.species = species;
		attack = (species.length() * 4) + 2;
		defense = (species.length() * 2) + 7;
		speed = (species.length() * 3) + 5;
	}
	
	
	public void grow(int boost) {
		attack += boost;
	}
	
	public void harden(int boost) {
		defense += boost;
	}
	
	public void haste(int boost) {
		speed += boost;
 	}
	//The following methods take in the inputed species and other variables and equal them to the global variable in order to make them 
	//more accessible.
	public void setSpecies(String spc) {
		species = spc;
	}
	//The getter methods return the desired variables.
	public String getSpecies() {
		return species;
	}
	//The rest of these methods have the same functions as the ones described above, but take in different values and return them.
	public void setAttack(int atk) {
		attack = atk;
	}
	
	public int getAttack() {
		return attack;
	}
	
	public void setDefense(int def) {
		defense = def;
	}
	 
	public int getDefense() {
		return defense;
	}
	
	public void setSpeed(int spd) {
		speed = spd;
	}
	
	public int getSpeed() {
		return speed;
	}
	
}
