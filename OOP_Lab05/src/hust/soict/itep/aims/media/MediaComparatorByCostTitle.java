package hust.soict.itep.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costCompare = Float.compare(m2.getCost(), m1.getCost());  // Decreasing cost
        return costCompare != 0 ? costCompare : m1.getTitle().compareTo(m2.getTitle());
    }
}
