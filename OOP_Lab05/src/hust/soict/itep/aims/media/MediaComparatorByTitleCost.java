package hust.soict.itep.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleCompare = m1.getTitle().compareTo(m2.getTitle());
        return titleCompare != 0 ? titleCompare : Float.compare(m2.getCost(), m1.getCost());
    }
}
