package hust.soict.itep.aims.media;

import java.util.Comparator;

public abstract class Media {
    int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = (Comparator<Media>) new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = (Comparator<Media>) new MediaComparatorByCostTitle();

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
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Media(int id, String title, String category, float cost) {
        this.title = title;
        this.id = id;
        this.category = category;
        this.cost = cost;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    

    public Media(String title) {
        this.title = title;
    }
    
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Media)) return false;
        Media media = (Media) o;
        return this.title.equals(media.getTitle());
    }

}
