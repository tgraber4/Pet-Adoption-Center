package org.sorters;

import java.util.Comparator;

import org.pet.Pet;

public class SpeciesComparator implements Comparator<Pet> {

	/**
	 * Compares the species of two inputed Pets.
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getSpecies().compareTo(o2.getSpecies());
	}

}
