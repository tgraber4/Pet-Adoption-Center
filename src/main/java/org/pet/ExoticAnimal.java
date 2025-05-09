package org.pet;

public class ExoticAnimal {
	String id;
	String name;
	String category;
	String subSpecies;
	int age;
	
	
	/**
	 * Takes in the id, name, category, sub species, and age of a new exotic animal and creates
	 * an ExoticAnimal object from that.
	 * @param id
	 * @param name
	 * @param category
	 * @param subSpecies
	 * @param age
	 */
	public ExoticAnimal(String id, String name, String category, String subSpecies, int age) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.subSpecies = subSpecies;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubSpecies() {
		return subSpecies;
	}
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
