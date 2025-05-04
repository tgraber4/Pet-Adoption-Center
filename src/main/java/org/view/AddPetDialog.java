package org.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A dialog window for adding a new pet to the shelter.
 */
public class AddPetDialog extends JDialog {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField typeField;
    private JTextField speciesField;
    private JButton okButton;
    private JButton cancelButton;

    /**
     * Constructs a dialog for entering new pet details.
     *
     * @param parent The parent frame of this dialog.
     */
    public AddPetDialog(JFrame parent) {
        super(parent, "Add New Pet", true);
        setupComponents();
        layoutComponents();
        pack();
        setLocationRelativeTo(parent);
    }

    /**
     * Initializes the input fields and buttons.
     */
    private void setupComponents() {
        nameField = new JTextField(15);
        ageField = new JTextField(5);
        typeField = new JTextField(15);
        speciesField = new JTextField(15);
        okButton = new JButton("Add Pet");
    }

    /**
     * Arranges the form layout and adds components to the dialog.
     */
    private void layoutComponents() {
        getContentPane().setLayout(new GridLayout(5, 2, 8, 8));
        getContentPane().add(new JLabel("Name:"));
        getContentPane().add(nameField);
        getContentPane().add(new JLabel("Age:"));
        getContentPane().add(ageField);
        getContentPane().add(new JLabel("Type:"));
        getContentPane().add(typeField);
        getContentPane().add(new JLabel("Species:"));
        getContentPane().add(speciesField);

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        getContentPane().add(cancelButton);
        getContentPane().add(okButton);
    }

    /**
     * Adds a listener to the OK button.
     *
     * @param listener the ActionListener to attach
     */
    public void addOkButtonListener(ActionListener listener) {
        okButton.addActionListener(listener);
    }

    /**
     * Adds a listener to the Cancel button.
     *
     * @param listener the ActionListener to attach
     */
    public void addCancelButtonListener(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    public String getPetName() {
        return nameField.getText();
    }

    public String getPetType() {
        return typeField.getText();
    }

    public String getPetSpecies() {
        return speciesField.getText();
    }

    public String getPetAgeText() {
        return ageField.getText();
    }

    /**
     * Shows an error dialog with a provided message.
     *
     * @param message the message to display
     */
    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
