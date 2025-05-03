package org.pet;

public class ExoticAnimalAdapter extends Pet {

	private ExoticAnimal exoticAnimal = null;
	
	/**
	 * Takes in an ExoticAnimal and adapts it to fit into the Pet structure.
	 * @param input
	 */
	public ExoticAnimalAdapter(ExoticAnimal input) {
		super(convertStringIdToIntId(input.getId()), input.getName(), input.getCategory(), input.getSubSpecies(), input.getAge(), false);
		this.exoticAnimal = input;
	}
	
	/**
	 * Converts the StingId for an ExoticAnimal to the Id format of a Pet.
	 * @param inputId
	 * @return
	 */
	private static int convertStringIdToIntId (String inputId) {
		return Integer.parseInt(inputId.replaceAll("\\D+", ""));
	}

	public ExoticAnimal getExoticAnimal() {
		return exoticAnimal;
	}

	public void setExoticAnimal(ExoticAnimal exoticAnimal) {
		this.exoticAnimal = exoticAnimal;
	}
	
	

}
