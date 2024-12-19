package hust.soict.hedspi.aims.media;

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
  public void play() {
    System.out.println("Playing DVD: " + this.getTitle());
    System.out.println("DVD length: " + this.getLength());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Track track = (Track) o;

    return this.title != null && title.equals(track.title) && this.getLength() == track.getLength();
  }
}
