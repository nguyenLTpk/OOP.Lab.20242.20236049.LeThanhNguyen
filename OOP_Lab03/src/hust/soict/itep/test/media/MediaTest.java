
package hust.soict.itep.test.media;

import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import java.util.ArrayList;
import java.util.List;

public class MediaTest {
    public static void main(String[] args){
        List<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc(1, "Top Hits", "Music", "Tobu",
        "Various Artists", 143, 14.5f);
    
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King",
        "Animation", "Roger Allers", 87, 19.95f);
    
        Book book = new Book(2, "Vietnam War", "History", 19.97f);
    
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
    
        for(Media m : mediae){
            System.out.println(m.toString());
        }
    }
}
