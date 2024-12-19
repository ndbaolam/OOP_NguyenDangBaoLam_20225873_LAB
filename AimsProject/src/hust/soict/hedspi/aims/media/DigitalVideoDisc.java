package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {        
  public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    super(title, category, director, length, cost);
  }  
  
  public DigitalVideoDisc(String title, String category, float cost) {
    this(title, category, null, 0, cost);
  }

  public DigitalVideoDisc(String title) {
    this(title, null, null, 0, 0);
  }

  public DigitalVideoDisc(String title, String category, String director, float cost) {
    this(title, category, director, 0, cost);
  }

  @Override
  public String toString() {
    return this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + " - " + this.getCost();
  }
  
  public static void searchById(DigitalVideoDisc[] cart, int id) {
    boolean found = false;
    for (DigitalVideoDisc dvd : cart) {
      if (dvd.getId() == id) {
        System.out.println("DVD found by ID: " + dvd);
        found = true;
        break;
      }
    }
    if (!found) {
      System.out.println("No DVD found with ID: " + id);
    }
  }

  public static void searchByTitle(DigitalVideoDisc[] cart, String title) {
    boolean found = false;
    for (DigitalVideoDisc dvd : cart) {
      if (dvd.getTitle().equalsIgnoreCase(title)) {
        System.out.println("DVD found by Title: " + dvd);
        found = true;
      }
    }
    if (!found) {
      System.out.println("No DVD found with Title: " + title);
    }
  }

  @Override
  public void play() {
    System.out.println("Playing DVD: " + this.getTitle());
    System.out.println("DVD length: " + this.getLength());
  }
}
