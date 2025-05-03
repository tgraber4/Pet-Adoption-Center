package org.pet;

public abstract class Pet implements Comparable<Pet> {
	int id;
	String name;
	String type;
	String species;
	int age;
	boolean adopted;
	
	
	
	public Pet(int id, String name, String type, String species, int age, boolean adopted) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.species = species;
		this.age = age;
		this.adopted = adopted;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isAdopted() {
		return adopted;
	}
	public int updateAdoptionStatus(boolean adopted) {
		if (this.adopted == false && adopted == true) {
			this.adopted = adopted;
			return 1;
		}
		return 0;
	}
	
	public void printPet () {
		System.out.println("Name: " + this.getName() + "\nId: " + this.getId() + "\nType: " + this.getType() + "\nSpecies: " + this.getSpecies() + "\nAge: " + this.getAge() + "\nAdopt: " + this.isAdopted() + "\n");
	}
	
	@Override
	public int compareTo(Pet other) {
		return this.getName().compareTo(other.getName());
	}
	
}
