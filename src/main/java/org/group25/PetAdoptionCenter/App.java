package org.group25.PetAdoptionCenter;

import org.pet.ExoticAnimal;
import org.pet.ExoticAnimalAdapter;
import org.pet.HousePet;
import org.pet.Pet;
import org.shelter.Shelter;

import com.google.gson.Gson;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Gson gson = new Gson();
        
        Shelter<Pet> Petco = new Shelter<>();
        
        Petco.addPetToShelter(new HousePet(6, "Johny", "Dog", "Golden Retriever", 17, false));
        
        ExoticAnimal bob = new ExoticAnimal("exo001", "bob", "bird", "green flyer", 18);
        
        Petco.addPetToShelter(new ExoticAnimalAdapter(bob));
        
        Petco.printPets();
    }
}
