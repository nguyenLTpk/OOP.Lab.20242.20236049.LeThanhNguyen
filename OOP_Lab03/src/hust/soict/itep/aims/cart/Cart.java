package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Disc;
import hust.soict.itep.aims.media.Media;
import java.util.ArrayList;
public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }

    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }


    public void display() {
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + " " + media.getTitle() +
            String.format(" %.2f", media.getCost()));
            i++;
        }
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
 
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.print(i + ". " + media.getClass().getSimpleName() + " - " +
            media.getTitle() + " - " + media.getCategory());

            if (media instanceof Disc) {
                Disc disc = (Disc) media;
                System.out.print(" - " + disc.getLength());
            }

            System.out.println(": " + String.format("%.2f", media.getCost()) + " $");
            i++;
        }

        System.out.println("Total cost: " + String.format("%.2f", totalCost()) + " $");
        System.out.println("***************************************************");
    }

     
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Media found: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No Media found with the given ID.");
        }
    }

    
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Media found: " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No Media found with the title: " + title);
        }
    }

    
    

}