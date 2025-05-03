package org.sorters;

import java.util.Comparator;

import org.pet.Pet;

public class AgeComparator implements Comparator<Pet> {

	@Override
	public int compare(Pet o1, Pet o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
	
}
