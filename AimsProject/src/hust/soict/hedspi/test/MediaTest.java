package hust.soict.hedspi.test;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import java.util.*;

public class MediaTest {
  public static void main(String[] args) {
    DigitalVideoDisc dvd  = new DigitalVideoDisc("Test", "Test", 0);
    CompactDisc cd = new CompactDisc("Test", "CD", null, 123, 0);
    Book book = new Book("Book", "Book", 0);

    ArrayList<Media> mediae = new ArrayList<Media>();
    mediae.add(dvd);
    mediae.add(cd);
    mediae.add(book);

    for(Media m : mediae) {
      System.out.println(m.toString());
    } 
  }  
}
