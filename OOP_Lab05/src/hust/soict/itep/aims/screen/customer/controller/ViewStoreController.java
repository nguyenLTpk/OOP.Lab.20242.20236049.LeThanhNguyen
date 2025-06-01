package hust.soict.itep.aims.screen.customer.controller;

import java.io.IOException;


import hust.soict.itep.aims.cart.Cart.Cart;
import hust.soict.itep.aims.media.Disc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ViewStoreController {
	private Store store= new Store();
	public Cart cart = new Cart();
	public int id=0;
	public ViewStoreController(Store store) {
		this.store = store;
	}

    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
    	final String CART_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
    	cart.setItemID();
        try {            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;

        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlLoader.load();
                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }
                column++;
                gridPane.add(anchorPane, column, row);
                GridPane.setMargin(anchorPane, new Insets(10, 10, 10, 10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

