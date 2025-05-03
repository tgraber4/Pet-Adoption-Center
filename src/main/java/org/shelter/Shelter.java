package org.shelter;

import java.util.ArrayList;
import java.util.Collections;

import org.sorters.AgeComparator;
import org.sorters.SpeciesComparator;
import org.pet.Pet;

public class Shelter <T extends Pet> {
	ArrayList<T> listOfPets = null;

	public Shelter() {
		this.listOfPets = new ArrayList<T>();
	}

	public void addPetToShelter(T input) {
		this.listOfPets.add(input);
	}
	
	public ArrayList<T> getListOfPets () {
		return this.listOfPets;
	}
	
	public void printPets () {
		for (T item : this.listOfPets) {
			item.printPet();
		}
	}
	
	public void sortPetsByName () {
		Collections.sort(this.getListOfPets());
	}
	
	public void sortPetsByAge () {
		Collections.sort(this.getListOfPets(), new AgeComparator());
	}
	
	public void sortPetsBySpecies () {
		Collections.sort(this.getListOfPets(), new SpeciesComparator());
	}
}
