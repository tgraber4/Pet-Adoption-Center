package inputOutput;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.pet.Pet;
import org.shelter.Shelter;

import com.google.gson.Gson;

public class Output {
	public static void savePets(Shelter<Pet> Petco) {
		Gson gson = new Gson();
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
