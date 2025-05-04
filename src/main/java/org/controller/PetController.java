package org.controller;

import org.pet.HousePet;
import org.pet.Pet;
import org.shelter.Shelter;
import org.view.AddPetDialog;
import org.view.AdoptMeGUI;
import inputOutput.Output;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controller that manages interactions between the pet shelter and the user interface.
 */
public class PetController {
    private Shelter<Pet> shelter;
    private AdoptMeGUI view;

    /**
     * Constructs the PetController and wires up all event listeners.
     *
     * @param shelter The shelter model containing pet data.
     * @param view    The GUI view for user interaction.
     */
    public PetController(Shelter<Pet> shelter, AdoptMeGUI view) {
        this.shelter = shelter;
        this.view = view;

        view.addAddButtonListener(new AddButtonListener());
        view.addAdoptButtonListener(new AdoptButtonListener());
        view.addRemoveButtonListener(new RemoveButtonListener());
        view.addViewButtonListener(new ViewButtonListener());
        view.addSaveButtonListener(new SaveButtonListener());
        view.addSortComboListener(new SortComboListener());
        updateView();
    }

    /**
     * Refreshes the table view to reflect current pet data.
     */
    private void updateView() {
        view.updateTable(shelter.getListOfPets());
    }

    /**
     * Listener for adding a new pet via dialog input.
     */
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddPetDialog dialog = new AddPetDialog(view);
            dialog.addOkButtonListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ev) {
                    String name = dialog.getPetName();
                    String ageText = dialog.getPetAgeText();
                    String type = dialog.getPetType();
                    String species = dialog.getPetSpecies();

                    if (name.isEmpty() || ageText.isEmpty() || type.isEmpty() || species.isEmpty()) {
                        dialog.showError("All fields must be filled out.");
                        return;
                    }

                    int age;
                    try {
                        age = Integer.parseInt(ageText);
                    } catch (NumberFormatException ex) {
                        dialog.showError("Age must be a valid number.");
                        return;
                    }

                    int newId = shelter.getShelterSize() + 1;
                    shelter.addPetToShelter(new HousePet(newId, name, type, species, age, false));
                    updateView();
                    dialog.dispose();
                }
            });
            dialog.setVisible(true);
        }
    }

    /**
     * Listener for adopting a selected pet.
     */
    private class AdoptButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Pet selected = view.getSelectedPet();
            if (selected == null) {
                view.showMessage("Select a pet to adopt.");
            } else if (selected.updateAdoptionStatus(true) == 1) {
                updateView();
            } else {
                view.showMessage("This pet is already adopted.");
            }
        }
    }

    /**
     * Listener for removing a selected pet from the shelter.
     */
    private class RemoveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = view.getSelectedRow();
            if (index >= 0) {
                shelter.removePetFromShelter(index);
                updateView();
            } else {
                view.showMessage("Select a pet to remove.");
            }
        }
    }

    /**
     * Listener for viewing pet details.
     */
    private class ViewButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Pet selected = view.getSelectedPet();
            if (selected != null) {
                view.showPetDetails(selected);
            } else {
                view.showMessage("Select a pet to view.");
            }
        }
    }

    /**
     * Listener for saving the pet list to a JSON file.
     */
    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Output.savePets(shelter);
            view.showMessage("Pet list saved successfully.");
        }
    }

    /**
     * Listener for sorting the pet list based on user selection.
     */
    private class SortComboListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String method = view.getSelectedSortMethod();
            switch (method) {
                case "Age":
                    shelter.sortPetsByAge();
                    break;
                case "Species":
                    shelter.sortPetsBySpecies();
                    break;
                default:
                    shelter.sortPetsByName();
                    break;
            }
            updateView();
        }
    }
}

