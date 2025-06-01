package hust.soict.itep.aims.screen.customer.controller;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	private Media media;
    private Cart cart;
    
    public ItemController(Cart cart) {
		this.cart = cart;
    	
    }
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws AimsException {
    	if (media != null) {
			cart.addMedia(media);
			System.out.println("Added to cart: " + media.getTitle());
		} else {
			System.out.println("No media selected to add to cart.");
		}
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
		if (media == null) {
			System.out.println("No media selected to play.");
			return;
		}
		
		// Check if the media is playable
    	if (media instanceof Playable) {
            Playable playableMedia = (Playable) media;
            playableMedia.play();
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Media Information");
            alert.setHeaderText("Playing: " + media.getTitle());
            alert.setContentText("Title: " + media.getTitle() + "\nCost: " + media.getCost() + " $");
            alert.showAndWait();
        } else {
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
            alert.setTitle("Not Playable");
            alert.setHeaderText(null);
            alert.setContentText("This media is not playable.");
            alert.showAndWait();
        }
    }
    
    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }


}
