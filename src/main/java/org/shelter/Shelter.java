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
	 * Removes the Pet at the given position in the Shelter list.
	 * @param index
	 * @return
	 */
	public int removePetFromShelter (int index) {
		if (index >= this.listOfPets.size() || index < 0) {
			return 0;
		}
		this.listOfPets.remove(index);
		return 1;
	}
	
	/**
	 * Returns the Pet at the given position in the Shelter list.
	 * @param index
	 * @return
	 */
	public T getPetFromShelter (int index) {
		return this.listOfPets.get(index);
	}
	
	/**
	 * Returns the amount of Pets currently in the Shelter.
	 * @return
	 */
	public int getShelterSize () {
		return this.listOfPets.size();
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
