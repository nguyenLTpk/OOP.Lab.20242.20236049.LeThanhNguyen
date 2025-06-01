package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.PlayerException;

public class Disc extends Media implements Playable{
    protected int length;
    protected String director;

    public Disc() {
        super();
    }
    
    public void play()  throws PlayerException {
		if (getTitle() == null || getTitle().isEmpty()) {
			throw new PlayerException("Cannot play a disc without a title");
		}
		System.out.println("Playing disc: " + getTitle());
    	
    }

    public Disc(String title, String category, float cost, String director, int length) {
        super();
        setTitle(title);
        setCategory(category);
        setCost(cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title,String category, float cost, int length) {
        super();
        setCategory(category);
        setTitle(title);
        setCost(cost);
        this.length = length;
    }
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
