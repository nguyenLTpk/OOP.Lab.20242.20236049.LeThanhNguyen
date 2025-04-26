package hust.soict.itep.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
    private String director;
    private int length;
    

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }   
    
    
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category, director, length, cost);       
    }
    
    
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost); 
    }
    
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost); 
    }
    
    public DigitalVideoDisc(String title){
        super(title);
    }
    
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " +
        getLength() + ": " + String.format("%.2f", getCost()) + " $";
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    
}