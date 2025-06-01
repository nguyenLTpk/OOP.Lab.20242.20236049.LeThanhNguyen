package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	private int length;
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String title, String category, String director, int length, int iD, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		id = iD;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public String toString() {
		String cart="DVD-"+this.getTitle()+"-"+this.getCategory()+"-"+this.getLength()+":"+this.getCost()+"$";
		return cart;
				
	}
	
	public boolean isMatch(String title) {
		return this.title==title;
	}
	@Override
	public void play() throws PlayerException {
	    if (getLength() <= 0) {
	        System.out.println("Cannot play DVD: " + getTitle());
	    } else {
	        System.out.println("Playing DVD: " + getTitle());
	        System.out.println("DVD length: " + getLength());
	    }
	}

}
