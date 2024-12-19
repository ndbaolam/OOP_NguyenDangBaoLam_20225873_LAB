package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
  protected static int nextId = 1;
  protected int id;
  protected String title;
  protected String category;
  protected float cost;  

  public static final Comparator<Media> COMPARATOR_BY_TITLE_COST = new MediaComparatorByTitleCost();
  public static final Comparator<Media> COMPARATOR_BY_COST_TITLE = new MediaComparatorByCostTitle();

  public Media(String title, String category, float cost) {
    this.title = title;
    this.category = category;
    this.cost = cost;
    this.id = nextId++;
  }  

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getCategory() {
    return category;
  }

  public float getCost() {
    return this.cost;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCategory(String category) {
    this.category = category;
  }    

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Media media = (Media) o;

    return title != null && title.equals(media.title);
  }
}
