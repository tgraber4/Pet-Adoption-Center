package org.main;

import javax.swing.SwingUtilities;
import org.controller.PetController;
import org.pet.Pet;
import org.shelter.Shelter;
import org.view.AdoptMeGUI;
import inputOutput.Input;


public class App 
{
    public static void main( String[] args )
    {
    	SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Shelter<Pet> petco = new Shelter<>();
                Input.loadPets(petco);
                petco.updateMaxId();
                AdoptMeGUI view = new AdoptMeGUI();
                PetController controller = new PetController(petco, view);
                view.setVisible(true);
            }
        });
    }
}
