package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
  public static final int MAX_NUMBERS_ORDERD = 20;
  private ArrayList<Media> itemsOrdered = new ArrayList<Media>();  

  public void addMedia(Media... mediaList) {
    for(Media media : mediaList) {
      if (itemsOrdered.size() >= MAX_NUMBERS_ORDERD) { 
        System.out.println("The cart is almost full");
        break;
      }
      itemsOrdered.add(media);
      System.out.println("The disc " + media.getTitle() + " has been added");
    }
  }

  public void printCart() {
    System.out.println("***********************CART***********************");
    System.out.println("Ordered Items:");    
    for (int i = 0; i < itemsOrdered.size(); i++) {   
      if(itemsOrdered.get(i) != null) {
        System.out.println((i + 1) + ". DVD - " + itemsOrdered.get(i).toString());
      }        
    }
    System.out.println("Total cost: " + this.totalCost());
    System.out.println("**************************************************");
  }

  public void removeMedia(Media media) {
    if (itemsOrdered.size() == 0) {
      System.out.println("The cart is almost empty");
      return;
    }

    boolean removed = false;

    for (int i = 0; i < itemsOrdered.size(); i++) {
      if (itemsOrdered.get(i) != null && itemsOrdered.get(i).equals(media)) {
        itemsOrdered.remove(media);
        removed = true;
        break;
      }
    }

    if (!removed) {
      System.out.println("Could not find the searched disc in cart!");
      return;
    }

    System.out.println("The disc has been removed!");
  }

  public float totalCost() {
    float total = 0f;
    for (int i = 0; i < itemsOrdered.size(); i++) {   
      if(itemsOrdered.get(i) != null)   
        total += itemsOrdered.get(i).getCost();
    }
    return total;
  }

  public Media search(int id) {
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found");
				return media;
			}
		}
		System.out.println("Not found");
		return null;
	}

	public Media search(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equals(title)) {
				System.out.println("Found");
				return media;
			}
		}
		System.out.println("Not found");
		return null;
	}

  public void emptyCart() {
		itemsOrdered.clear();
	}

	public void sortCart(int choice) {
		if (choice == 0) {
			itemsOrdered.sort(Media.COMPARATOR_BY_TITLE_COST);
			System.out.println("Cart sorted!");
		} else if (choice == 1) {
			itemsOrdered.sort(Media.COMPARATOR_BY_COST_TITLE);
			System.out.println("Cart sorted!");
		}
	}
}
