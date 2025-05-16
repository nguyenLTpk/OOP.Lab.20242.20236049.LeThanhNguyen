package hust.soict.itep.aims.media;

import java.util.*;

import static java.util.Arrays.asList;


public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    private String content;
    List<String> contentTokens;
    Map<String,Integer> wordFrequency;

    // Constructor
    public Book(String title) {
        super(title);
    }

    public Book(String title, String category) {
        super(title, category);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, String content){
        super(title, category, cost);
        this.content = content;
        processContent();
    }

    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        processContent();
    }

    public void processContent(){
        contentTokens = asList(getContent().split("[\\p{Punct}\\s]+"));
        wordFrequency = new TreeMap<>();
        java.util.Collections.sort(contentTokens);
        Map<String,Integer> tmpWordFrequency = new HashMap<>();
        for (String token: contentTokens){
            if (wordFrequency == null) {
                wordFrequency.put(token, 1);
            } else {
                if (wordFrequency.get(token) == null){
                    wordFrequency.put(token, 1);
                } else {
                    int value = wordFrequency.get(token);
                    wordFrequency.put(token, value + 1);
                }
            }
        }
    }

    public boolean checkAuthor(String authorName){
        for (int i = 0; i < authors.size(); i++){
            if (authors.get(i).equalsIgnoreCase(authorName)){
                return true;
            }
        }
        return false;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) authors.add(authorName);
        else System.out.println("This author has already been in the list");
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) authors.remove(authorName);
        else System.out.println("No author has been found to remove");
    }

    @Override
    public String toString() {
        return this.getId() + " - Book: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }
}