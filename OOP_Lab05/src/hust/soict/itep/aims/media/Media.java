package hust.soict.itep.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
    public int id;
    public String title;
    public String category;
    public float cost;

    public Media() {
    }
    
    public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    @Override
    public boolean equals(Object obj) {
        try {
            if (obj == null) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Media)) {
                return false;
            }
            Media other = (Media) obj;
            return this.getTitle().equals(other.getTitle())
                    && Float.compare(this.getCost(), other.getCost()) == 0;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e) {
            return false;
        }
    }
    @Override
    public int compareTo(Media other) {
        try {
            int titleComparison = this.getTitle().compareTo(other.getTitle());
            if (titleComparison != 0) {
                return titleComparison;
            }
            return Float.compare(this.getCost(), other.getCost());
        } catch (NullPointerException e) {
            throw new RuntimeException("Cannot compare with null media", e);
        }
    }
    @Override
    public String toString() {
        return "Media - " + title + " - " + (category == null ? "Unknown" : category) + " : " + cost + " $";
    }
}
