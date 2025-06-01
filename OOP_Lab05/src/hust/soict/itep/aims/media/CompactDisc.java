package hust.soict.itep.aims.media;

import java.util.List;

import hust.soict.itep.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, director, 0); // Length set later
        this.artist = artist;
    }
    public CompactDisc(String title, String category, float cost, String artist) {
        this.title=title;
        this.category=category;
        this.cost=cost;
        this.length=length;
        this.artist = artist;
    }
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track " + track.getTitle() + " added");
        } else {
            System.out.println("Track " + track.getTitle() + " already exists");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track " + track.getTitle() + " removed");
        } else {
            System.out.println("Track " + track.getTitle() + " not found");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + (getCategory() == null ? "Unknown" : getCategory()) +
               " - " + (artist == null ? "Unknown" : artist) + " : " + getCost() + " $";
    }

     @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("CD length is invalid!");
        }

        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());

        for (Track track : tracks) {
            try {
                track.play();
            } catch (PlayerException e) {
                // Log the error but continue playing other tracks
                System.err.println("Error playing track: " + e.getMessage());
            }
        }
    }

}
