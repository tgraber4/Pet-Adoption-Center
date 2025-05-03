package org.main;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.pet.ExoticAnimal;
import org.pet.ExoticAnimalAdapter;
import org.pet.HousePet;
import org.pet.Pet;
import org.shelter.Shelter;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class App 
{
    public static void main( String[] args )
    {
    	Shelter<Pet> Petco = new Shelter<>();
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("./src/main/resources/pets.json")) {
        	JsonArray petArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (int i = 0; i < petArray.size(); i++) {
                JsonObject pet = petArray.get(i).getAsJsonObject();
                
                HousePet newPet = new HousePet(pet.get("id").getAsInt(), pet.get("name").getAsString(), pet.get("type").getAsString(), pet.get("species").getAsString(), pet.get("age").getAsInt(), pet.get("adopted").getAsBoolean());
                Petco.addPetToShelter(newPet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try (FileReader reader = new FileReader("./src/main/resources/exotic_animals.json")) {
        	JsonArray animalArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (int i = 0; i < animalArray.size(); i++) {
                JsonObject pet = animalArray.get(i).getAsJsonObject();
                
                ExoticAnimal newAnimal = new ExoticAnimal(pet.get("uniqueId").getAsString(), pet.get("animalName").getAsString(), pet.get("category").getAsString(), pet.get("subSpecies").getAsString(), pet.get("yearsOld").getAsInt());
                ExoticAnimalAdapter adapter = new ExoticAnimalAdapter(newAnimal);
                Petco.addPetToShelter(adapter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
//        Petco.addPetToShelter(new HousePet(6, "Johny", "Dog", "Golden Retriever", 17, false));
//        
//        ExoticAnimal bob = new ExoticAnimal("exo001", "bob", "bird", "green flyer", 18);
//        
//        Petco.addPetToShelter(new ExoticAnimalAdapter(bob));
        
        Petco.printPets();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String filename = timestamp + "_pets.json";
        
        try (FileWriter writer = new FileWriter("./src/main/resources/" + filename)) {
            gson.toJson(Petco.getListOfPets(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
