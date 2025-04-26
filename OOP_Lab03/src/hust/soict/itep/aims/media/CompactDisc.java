package hust.soict.itep.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, String director, String artist, int length, float cost) {
        super(id, title, category, director, length, cost);
        this.artist = artist;
    }

    public String getArtist() { 
        return artist; 
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track đã tồn tại");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Không tìm thấy track");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD artist: " + this.artist);
        for (Track track : tracks) {
            track.play();
        }
    }
}
