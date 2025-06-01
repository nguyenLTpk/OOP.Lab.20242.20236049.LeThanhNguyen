package hust.soict.itep.test.screen.customer.store;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.Disc;
import hust.soict.itep.aims.screen.customer.controller.ViewStoreController;
import hust.soict.itep.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        final String STORE_FXML_FILE_PATH = "/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        /*
         * Add some items to store here
         * ...
         */
        store.addMedia(new Disc("Inception", "Sci-Fi", 14.99f, 148));
        store.addMedia(new Disc("Interstellar", "Sci-Fi", 17.99f, 169));
        store.addMedia(new Disc("The Matrix", "Sci-Fi", 19.99f, 120));
        store.addMedia(new Disc("The Godfather", "Crime", 15.99f, 175));
        store.addMedia(new Book("1984", "Dystopian", 9.99f));
        store.addMedia(new Disc("Pulp Fiction", "Crime", 16.99f, 154));
        store.addMedia(new Book("To Kill a Mockingbird", "Classic", 12.99f));
        store.addMedia(new DigitalVideoDisc("Avatar", "Sci-Fi", "dsds", 16.12f));
        launch(args);
    }
}

