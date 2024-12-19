package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
  private ArrayList<Media> itemsInStore = new ArrayList<Media>();  

  public void addMedia(Media media) {
    itemsInStore.add(media);
  }

  public void removeMedia(Media media) {
    if(itemsInStore.contains(media))
      itemsInStore.remove(media);
    else 
      System.out.println("media not found!");
  }

  public void printStore() {
		System.out.println("***********************STORE***********************");
		System.out.println("Store list:");
		for (Media m : this.itemsInStore) {
			System.out.println(m.toString());
		}
		System.out.println("****************************************************");
	}

  public Media search(int id) {
		for (Media media : itemsInStore) {
			if (media.getId() == id) {
				System.out.println("Found");
				return media;
			}
		}
		System.out.println("Not found");
		return null;
	}

	public Media search(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(title)) {
				System.out.println("Found");
				return media;
			}
		}
		System.out.println("Not found");
		return null;
	}

	public ArrayList<Media> getItemsInStore() {
		return this.itemsInStore;
	}
}
