package hust.soict.itep.aims;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();  
    private static Cart cart = new Cart();  
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        
        while (choice != 0) {
            showMenu();  
            choice = scanner.nextInt();  
            
            switch (choice) {
                case 1: 
                    viewStore();  
                    break;
                case 2: 
                    updateStore();  
                    break;
                case 3: 
                    seeCurrentCart();  
                    break;
                case 0: 
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
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
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        int choice = -1;
        
        store.printStore();

        while (choice != 0) {
            storeMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    viewMediaDetails();  
                    break;
                case 2:
                    addToCart();  
                    break;
                case 3:
                    playMedia();  
                    break;
                case 4:
                    seeCurrentCart();  
                    break;
                case 0: 
                    break;  
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void viewMediaDetails() {
        System.out.print("Enter the title of the media: ");
        scanner.nextLine();  
        String title = scanner.nextLine();

        Media media = store.searchMedia(title);
        if (media != null) {
            System.out.println(media);  
            mediaDetailsMenu();
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();  
        
        switch (choice) {
            case 1:
                addToCart();  
                break;
            case 2:
                playMedia();  
                break;
            case 0:
                break;  
            default:
                System.out.println("Invalid option.");
        }
    }

    public static void addToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        
        Media media = store.searchMedia(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        
        Media media = store.searchMedia(title);
        if (media != null && (media instanceof CompactDisc || media instanceof DigitalVideoDisc)) {
            System.out.println("Playing media: " + title);
        } else {
            System.out.println("Invalid media type or not found");
        }
    }

    public static void updateStore() {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  
        
        if (choice == 1) {
            System.out.print("Enter media type (DVD/CD/Book): ");
            String type = scanner.nextLine();
            
        } else if (choice == 2) {
            System.out.print("Enter the title of the media to remove: ");
            String title = scanner.nextLine();
        }
    }

    public static void seeCurrentCart() {
        cart.print();
        cartMenu();
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
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

}