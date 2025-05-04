package org.pet;

import org.shelter.Shelter;

public class ExoticAnimalAdapter extends Pet {

	private transient ExoticAnimal exoticAnimal = null;

	
	/**
	 * Takes in an ExoticAnimal and adapts it to fit into the Pet structure.
	 * @param input
	 */
	public ExoticAnimalAdapter(ExoticAnimal input, Shelter<Pet> shelter) {
		super(shelter.getNextAvailableId(), input.getName(), input.getCategory(), input.getSubSpecies(), input.getAge(), false);
		this.exoticAnimal = input;

	}

	public ExoticAnimal getExoticAnimal() {
		return exoticAnimal;
	}

	public void setExoticAnimal(ExoticAnimal exoticAnimal) {
		this.exoticAnimal = exoticAnimal;
	}
	
	

}
