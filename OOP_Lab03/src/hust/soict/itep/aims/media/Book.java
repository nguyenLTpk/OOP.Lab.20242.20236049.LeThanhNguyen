
package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {  
    private List<String> authors = new ArrayList<String>();
    public Book(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }
    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Đã có tác giả");
        } 
        else {
            authors.add(authorName);
            System.out.println("Đã thêm tác giả");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Đã xóa tác giả");
        } 
        else {
            System.out.println("Không tìm thấy tác giả");
        }
    }
}
    
    

