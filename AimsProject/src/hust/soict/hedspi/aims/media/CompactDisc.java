package hust.soict.hedspi.aims.media;

import java.util.*;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
  private String artist;
  private List<Track> tracks = new ArrayList<Track>();

  public CompactDisc(String title, String category, String director, int length, float cost) {
    super(title, category, director, length, cost);
  }

  public CompactDisc(String title, String category, String director, int length, float cost, String artist,
      List<Track> tracks2) {
    super(title, category, director, length, cost);
    this.artist = artist;
    this.tracks = tracks2;
  }

  public int getLength() {
    int sum = 0;
    for (Track track : tracks) {
      sum += track.getLength();
    }

    return sum;
  }

  @Override
  public String play() throws PlayerException {
    if (this.getLength() > 0) {
      StringBuilder resBuilder = new StringBuilder();

      for (int i = 0; i < tracks.size(); ++i) {
        resBuilder.append("Track " + i + ": " + '\n');
        try {
          resBuilder.append(tracks.get(i).play());
        } catch (PlayerException e) {
          throw e;
        }
      }

      return resBuilder.toString();
    } else {
      throw new PlayerException("ERROR: CD length is non-positive!");
    }

  }
}
