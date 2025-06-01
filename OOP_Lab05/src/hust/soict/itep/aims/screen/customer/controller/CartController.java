package hust.soict.itep.aims.screen.customer.controller;
import java.io.IOException;

import hust.soict.itep.aims.cart.Cart.Cart;
import hust.soict.itep.aims.exception.AimsException;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Playable;
import hust.soict.itep.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
	private Media media;
	
	private Cart cart= new Cart();
	
	private Store store = new Store();
	
	public CartController(Cart cart) {
		this.cart = cart;
	}
	
	public CartController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;
    
    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
  @FXML
  private RadioButton radioBtnFilterId;

    @FXML
    void btnPlayPressed(ActionEvent event) throws PlayerException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
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

    @FXML
    void btnRemovePressed(ActionEvent event) throws AimsException {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		cart.setItemID();
		updateTotalCost();
    }
    
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
      cart.emptyCart();
      tblMedia.refresh();
      updateTotalCost();
      System.out.println("Order placed successfully!");
  }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
        	final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            ViewStoreController viewStoreController = new ViewStoreController(store);
         // Pass the existing cart to the controller
            viewStoreController.cart = this.cart;
            fxmlLoader.setController(viewStoreController);
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateTotalCost() {
      float totalCost = cart.totalCost();
      costLabel.setText(totalCost + "$");
   }

    
    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
            new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
            new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
            new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
            new PropertyValueFactory<Media, Float>("cost"));
        
        if(cart.getItemsOrdered() != null)
            tblMedia.setItems(cart.getItemsOrdered());
        
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        float totalCost = cart.totalCost();
        costLabel.setText(totalCost + "$");
        
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });

     // Add filter listener
        tfFilter.textProperty().addListener((obs, oldValue, newValue) -> showFilteredMedia());

    }
    void showFilteredMedia() {
      String filterText = tfFilter.getText().toLowerCase();
      FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), item -> true);

      filteredList.setPredicate(item -> {
          if (filterText == null || filterText.isEmpty()) {
              return true;
          }

          if (radioBtnFilterId.isSelected()) {
              return String.valueOf(item.getId()).contains(filterText);
          } else { // Filter by title
              return item.getTitle().toLowerCase().contains(filterText);
          }
      });

      tblMedia.setItems(filteredList);
  }
    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }
    
    void showFilteredMedia(String filter) {
		if (filter == null || filter.isEmpty()) {
			tblMedia.setItems(cart.getItemsOrdered());
		} else {
			tblMedia.setItems(cart.getItemsOrdered().filtered(media -> media.getTitle().toLowerCase().contains(filter.toLowerCase())));
		}
    }

}
