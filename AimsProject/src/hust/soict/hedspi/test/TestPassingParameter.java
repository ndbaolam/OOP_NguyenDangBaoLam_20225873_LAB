package hust.soict.hedspi.test;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;

public class TestPassingParameter {
  public static void main(String[] args) {
    DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle", null, 0);
    DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella", null, 0);        

    jungleDVD = swap(cinderellaDVD, cinderellaDVD = jungleDVD);
    System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

    changeTitle(jungleDVD, cinderellaDVD.getTitle());
    System.out.println("jungle dvd title: " + jungleDVD.getTitle());    
  }  

  //Update correct swap method
  public static <T> T swap(T itself, T dum) {
    return itself;
  }

  public static void changeTitle(DigitalVideoDisc dvd, String title) {
    String oldTitle = dvd.getTitle();
    dvd.setTitle(title);
    dvd = new DigitalVideoDisc(oldTitle, oldTitle, 0);
  }
}
