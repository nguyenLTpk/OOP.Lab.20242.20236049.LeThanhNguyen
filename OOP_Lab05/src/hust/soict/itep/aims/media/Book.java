package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public Book() {
        // TODO Auto-generated constructor stub
    }
    public Book(String title,String category,float cost) {
    	setCategory(category);
    	setTitle(title);
    	setCost(cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author " + authorName + " added");
        } else {
            System.out.println("Author " + authorName + " already exists");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " removed");
        } else {
            System.out.println("Author " + authorName + " not found");
        }
    }
    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + (getCategory() == null ? "Unknown" : getCategory()) +
               " - Authors: " + authors + " : " + getCost() + " $";
    }
}
