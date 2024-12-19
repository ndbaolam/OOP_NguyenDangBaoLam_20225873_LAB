package hust.soict.hedspi.test;


import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;

public class StoreTest {
  public static void main(String[] args) {
    Store store = new Store();
    DigitalVideoDisc dvd = new DigitalVideoDisc("Test", null, 0);
    store.addMedia(dvd);
    store.removeMedia(dvd);
  }
}
