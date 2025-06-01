package hust.soict.itep.aims.media;

import hust.soict.itep.aims.exception.PlayerException;

public class Track implements Playable{
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() < 0) {
            throw new PlayerException("Track: " + this.getTitle() + " has no length, cannot play.");
        } else {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Length: " + this.getLength());
        }

    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track other = (Track) obj;
        return title != null && title.equals(other.title) && length == other.length;
    }

}
