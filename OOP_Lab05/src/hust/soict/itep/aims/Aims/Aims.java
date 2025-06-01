package hust.soict.itep.aims.Aims;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.cart.*;
import hust.soict.itep.aims.cart.Cart.Cart;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.*;
import hust.soict.itep.aims.store.Store;
import javafx.scene.control.Alert;

import java.util.Scanner;

public class Aims {
	private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
		// Initialize store with sample media
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        Book book = new Book();
        book.setTitle("Never eat alone");
        book.addAuthor("Keith Ferrazzi");
        store.addMedia(book);
        CompactDisc cd = new CompactDisc("Classic Music for deadlines", "Music", 15.99f, "Various", "Band");
        cd.addTrack(new Track("Song 1", 180));
        store.addMedia(cd);

        showMenu();
    }
	
	private static void playMedia(Media media) {
        try {
            if (media instanceof Playable) {
                System.out.println("Playing " + media.getTitle() + "...");
                ((Playable) media).play();
            } else {
                System.out.println("This media is not playable");
            }
        } catch (PlayerException e) {
            // Print detailed exception information
            System.err.println("Error Message: " + e.getMessage());
            System.err.println("Exception: " + e.toString());
            e.printStackTrace();

            // Show error dialog
            javafx.application.Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText("Cannot Play Media");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            });
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                storeMenu();
                break;
            case 2:
                updateStoreMenu();
                break;
            case 3:
                cartMenu();
                break;
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
                showMenu();
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter media title:");
                scanner.nextLine();
                String title = scanner.nextLine();
                // Simplified: Assuming store has a method to find media
                System.out.println("Details not implemented");
                storeMenu();
                break;
            case 2:
                System.out.println("Enter media title to add:");
                scanner.nextLine();
                title = scanner.nextLine();
                // Add logic to find and add
                storeMenu();
                break;
            case 3:
                System.out.println("Enter media title to play:");
                scanner.nextLine();
                title = scanner.nextLine();
                // Add play logic
                storeMenu();
                break;
            case 4:
                cartMenu();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice");
                storeMenu();
        }
    }

    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media");
        System.out.println("2. Remove media");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                // Add media logic
                updateStoreMenu();
                break;
            case 2:
                // Remove media logic
                updateStoreMenu();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice");
                updateStoreMenu();
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                filterMenu();
                break;
            case 2:
                sortMenu();
                break;
            case 3:
                System.out.println("Enter media title to remove:");
                scanner.nextLine();
                String title = scanner.nextLine();
                // Remove logic
                cartMenu();
                break;
            case 4:
                System.out.println("Enter media title to play:");
                scanner.nextLine();
                title = scanner.nextLine();
                // Play logic
                cartMenu();
                break;
            case 5:
                System.out.println("Order created");
                cart = new Cart();
                cartMenu();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice");
                cartMenu();
        }
    }

    public static void filterMenu() {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter ID:");
                int id = scanner.nextInt();
                cart.searchByID(id);
                filterMenu();
                break;
            case 2:
                System.out.println("Enter title:");
                scanner.nextLine();
                String title = scanner.nextLine();
                cart.searchByTitle(title);
                filterMenu();
                break;
            case 0:
                cartMenu();
                break;
            default:
                System.out.println("Invalid choice");
                filterMenu();
        }
    }

    public static void sortMenu() {
        System.out.println("Sort by: ");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.println("0. Back");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                cart.sortByTitle();
                cart.print();
                sortMenu();
                break;
            case 2:
                cart.sortByCost();
                cart.print();
                sortMenu();
                break;
            case 0:
                cartMenu();
                break;
            default:
                System.out.println("Invalid choice");
                sortMenu();
        }
	}

}