package org.view;

import org.pet.Pet;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI for the Adopt Me
 * Displays pets and provides controls for adding, removing, viewing, and saving pets.
 */
public class AdoptMeGUI extends JFrame {
    private JTable petTable;
    private PetTableModel tableModel;
    private JComboBox<String> sortCombo;
    private JButton addButton, adoptButton, removeButton, viewButton, saveButton;

    /**
     * Constructs the main GUI frame.
     */
    public AdoptMeGUI() {
        super("Adopt Me! Pet Adoption Center");
        setupComponents();
        layoutComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    /**
     * Initializes components and their default values.
     */
    private void setupComponents() {
        tableModel = new PetTableModel(new ArrayList<>());
        petTable = new JTable(tableModel);
        sortCombo = new JComboBox<>(new String[]{"Name", "Age", "Species"});
        addButton = new JButton("Add");
        adoptButton = new JButton("Adopt");
        removeButton = new JButton("Remove");
        viewButton = new JButton("View Details");
        saveButton = new JButton("Save");
    }

    /**
     * Lays out all components in the GUI using panels and layout managers.
     */
    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));
        add(new JScrollPane(petTable), BorderLayout.CENTER);

        JPanel top = new JPanel();
        top.add(new JLabel("Sort by:"));
        top.add(sortCombo);
        add(top, BorderLayout.NORTH);

        JPanel bottom = new JPanel(new BorderLayout());

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(addButton);
        bottom.add(leftPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.add(viewButton);
        centerPanel.add(adoptButton);
        centerPanel.add(removeButton);
        bottom.add(centerPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.add(saveButton);
        bottom.add(rightPanel, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

    public void addAddButtonListener(ActionListener l) {
        addButton.addActionListener(l);
    }

    public void addAdoptButtonListener(ActionListener l) {
        adoptButton.addActionListener(l);
    }

    public void addRemoveButtonListener(ActionListener l) {
        removeButton.addActionListener(l);
    }

    public void addViewButtonListener(ActionListener l) {
        viewButton.addActionListener(l);
    }

    public void addSaveButtonListener(ActionListener l) {
        saveButton.addActionListener(l);
    }

    public void addSortComboListener(ActionListener l) {
        sortCombo.addActionListener(l);
    }

    public int getSelectedRow() {
        return petTable.getSelectedRow();
    }

    public Pet getSelectedPet() {
        int row = getSelectedRow();
        return row >= 0 ? tableModel.getPetAt(row) : null;
    }

    public String getSelectedSortMethod() {
        return (String) sortCombo.getSelectedItem();
    }

    public void updateTable(List<Pet> updatedPets) {
        tableModel.setPets(updatedPets);
    }

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    public void showPetDetails(Pet pet) {
        JOptionPane.showMessageDialog(this,
        	"Id: " + pet.getId() +
            "\nName: " + pet.getName() +
            "\nType: " + pet.getType() +
            "\nSpecies: " + pet.getSpecies() +
            "\nAge: " + pet.getAge() +
            "\nAdopted: " + pet.isAdopted(),
            "Pet Details", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Table model for displaying a list of pets.
     */
    private static class PetTableModel extends AbstractTableModel {
        private final String[] columns = {"Name", "Type", "Species", "Age", "Adopted"};
        private List<Pet> pets;

        public PetTableModel(List<Pet> pets) {
            this.pets = pets;
        }

        public void setPets(List<Pet> pets) {
            this.pets = pets;
            fireTableDataChanged();
        }

        public Pet getPetAt(int row) {
            return pets.get(row);
        }

        @Override
        public int getRowCount() {
            return pets.size();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public String getColumnName(int col) {
            return columns[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            Pet pet = pets.get(row);
            switch (col) {
                case 0: return pet.getName();
                case 1: return pet.getType();
                case 2: return pet.getSpecies();
                case 3: return pet.getAge();
                case 4: return pet.isAdopted();
                default: return null;
            }
        }
    }
}
