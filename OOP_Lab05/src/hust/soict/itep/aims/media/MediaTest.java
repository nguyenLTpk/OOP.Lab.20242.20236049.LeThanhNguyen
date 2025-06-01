package hust.soict.itep.aims.media;

import java.util.ArrayList;

public class MediaTest {
    public static void main(String[] args) {
        ArrayList<Media> media = new ArrayList<>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("Laland", "Rom-com", "Damian Chazelle", 116, 10.99f);
        Book book = new Book();
        book.setTitle("Why we sleep");
        book.setCategory("Science");
        book.addAuthor("Matthew Walker");
        book.setCost(9.99f);
        CompactDisc cd = new CompactDisc("Requiem Album", "Music album", 15.50f, "Keshi", "Keshi");
        media.add(dvd);
        media.add(book);
        media.add(cd);
        for (Media m : media) {
            System.out.println(m.toString());
        }
    }
}