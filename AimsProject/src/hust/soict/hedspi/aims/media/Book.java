package hust.soict.hedspi.aims.media;
import java.util.*;

public class Book extends Media {  
  private List<String> authors = new ArrayList<String>();

  public Book(String title, String category, float cost) {
    super(title, category, cost);
  }

  public void addAuthor(String authorName) {
    if(authors.contains(authorName)) {
      System.out.println("Author has already existed!");
      return;
    }      

    authors.add(authorName);
  }

  public void removeAuthor(String authorName) {
    if(!authors.contains(authorName)) {
      System.out.println("Author doesn't exist!");
      return;
    }      

    authors.remove(authorName);
  }  
}
