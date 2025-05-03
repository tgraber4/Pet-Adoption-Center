package org.shelter;

import java.util.ArrayList;

import org.pet.Pet;

public class Shelter <T extends Pet> {
	ArrayList<T> listOfPets = null;

	public Shelter() {
		this.listOfPets = new ArrayList<T>();
	}

	public void addPetToShelter(T input) {
		this.listOfPets.add(input);
	}
	
	public void printPets () {
		for (T item : this.listOfPets) {
			item.printPet();
		}
	}
	
}
