package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import java.util.ArrayList;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 1000;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int qtyInStore = 0;

    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

    public void printStore() {
        System.out.println("*********** CỬA HÀNG ***********");
        int i = 1;
        for (Media media : itemsInStore) {
            System.out.println(i + ". " + media.getTitle());
            i++;
        }
        System.out.println("********************************");
    }

    public Media searchMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media; 
            }
        }
        return null; 
    }
}

