package org.pet;

public class ExoticAnimalAdapter extends Pet {

	private ExoticAnimal exoticAnimal = null;
	
	public ExoticAnimalAdapter(ExoticAnimal input) {
		super(convertStringIdToIntId(input.getId()), input.getName(), input.getCategory(), input.getSubSpecies(), input.getAge(), false);
		this.exoticAnimal = input;
	}
	
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
