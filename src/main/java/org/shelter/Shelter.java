package org.shelter;

import java.util.ArrayList;
import java.util.Collections;

import org.sorters.AgeComparator;
import org.sorters.SpeciesComparator;
import org.pet.Pet;

public class Shelter <T extends Pet> {
	ArrayList<T> listOfPets = null;

	/**
	 * Creates a Shelter object.
	 */
	public Shelter() {
		this.listOfPets = new ArrayList<T>();
	}
	
	/**
	 * Takes in a pet and adds it to the given Shelter Object.
	 * @param input
	 */
	public void addPetToShelter(T input) {
		this.listOfPets.add(input);
	}
	
	public ArrayList<T> getListOfPets () {
		return this.listOfPets;
	}
	
	/**
	 * Prints out the pets in the given Shelter.
	 */
	public void printPets () {
		for (T item : this.listOfPets) {
			item.printPet();
		}
	}
	
	/**
	 * Sorts the Pets in the given Shelter object by name.
	 */
	public void sortPetsByName () {
		Collections.sort(this.getListOfPets());
	}
	
	/**
	 * Sorts the Pets in the given Shelter object by age.
	 */
	public void sortPetsByAge () {
		Collections.sort(this.getListOfPets(), new AgeComparator());
	}
	
	/**
	 * Sorts the Pets in the given Shelter object by species.
	 */
	public void sortPetsBySpecies () {
		Collections.sort(this.getListOfPets(), new SpeciesComparator());
	}
}
