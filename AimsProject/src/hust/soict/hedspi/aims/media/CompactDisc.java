package hust.soict.hedspi.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
  private String artist;
  private List<Track> tracks = new ArrayList<Track>();

  public CompactDisc(String title, String category, String director, int length, float cost) {
    super(title, category, director, length, cost);
  }

  public CompactDisc(String title, String category, String director, int length, float cost, String artist, ArrayList<Track> tracks) {
    super(title, category, director, length, cost);
    this.artist = artist;
    this.tracks = tracks;
  }

  public int getLength() {
    int sum = 0;
    for (Track track : tracks) {
      sum += track.getLength();
    }

    return sum;
  }

  @Override
  public void play() {    
    for (Track track : tracks) {
      System.out.println("Track: " + track.getTitle());
    }
  }
}
