package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable{
  private String title;
  private int lenght;

  public Track(String title, int lenght) {
    this.lenght = lenght;
    this.title = title;
  }

  public String getTitle() {
    return this.title;
  }

  public int getLength() {
    return this.lenght;
  }

  @Override
  public String play() throws PlayerException {
		if (this.getLength() > 0) {
			StringBuilder resBuilder = new StringBuilder();
			resBuilder.append("Playing DVD: " + this.title + '\n');
			resBuilder.append("DVD length: " + this.lenght + '\n');

			return resBuilder.toString();
		} else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Track track = (Track) o;

    return this.title != null && title.equals(track.title) && this.getLength() == track.getLength();
  }
}
