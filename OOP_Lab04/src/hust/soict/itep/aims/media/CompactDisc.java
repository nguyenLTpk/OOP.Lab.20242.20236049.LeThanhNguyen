package hust.soict.itep.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();;

    // Constructor
    public CompactDisc(String title) {
        super(title);
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public String tracksInfo (){
        String infor = "";
        for (Track track : tracks) {
            infor = infor + track.toString();
        }
        return infor;
    }

    public CompactDisc(String title, String category, String director, float cost,
                       int length, String artist, ArrayList<Track> tracks){
        super(title, category, director, length, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public boolean checkTrackAvailable(ArrayList<Track> trackArrayList, Track track){
        for (Track check: trackArrayList){
            if (check.getTitle().equalsIgnoreCase(track.getTitle())){
                return true;
            }
        }
        return false;
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    // Getter
    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track: " + track.getTitle() + " has been added to CD: " + this.getTitle());
        } else System.out.println("Track has already existed in CD");
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track: " +track.getTitle() + " has been removed from CD: " + this.getTitle());
        } else {
            System.out.println("Track does not exist in CD");
        }
    }

    // Get length track
    public int getLength() {
        int total = 0;
        for (Track track : tracks) {
            total += track.getLength();
        }
        return total;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return this.getId() + " - CD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Artist" + this.getArtist() +
                " - Length: " + this.getLength() + " seconds" +
                " - Cost: " + this.getCost() + "$";
    }
}