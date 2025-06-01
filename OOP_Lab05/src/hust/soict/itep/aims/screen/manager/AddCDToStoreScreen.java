package hust.soict.itep.aims.screen.manager;

import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField artistField;

    public AddCDToStoreScreen(Store store,StoreManagerScreen storeScreen) {
        super(store, storeScreen, "Add CD to Store");
    }

    @Override
    protected void createForm() {
        form.setLayout(new GridLayout(5, 2, 5, 5));

        titleField = addInputField("Title");
        categoryField = addInputField("Category");
        costField = addInputField("Cost");
        artistField = addInputField("Artist");

        addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            try {
                String title = titleField.getText();
                String category = categoryField.getText();
                float cost = Float.parseFloat(costField.getText());
                String artist = artistField.getText();

                store.addMedia(new CompactDisc(title,category,cost,artist));
                JOptionPane.showMessageDialog(this, "CD added successfully!");
                clearFields();
                refreshStore();
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    @Override
    protected void clearFields() {
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        artistField.setText("");
    }
}