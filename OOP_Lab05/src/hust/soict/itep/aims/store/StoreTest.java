package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.DigitalVideoDisc;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();

		//Create new dvd objects and add them to the store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
		
		store.removeMedia(dvd1);
		store.removeMedia(dvd1);
		store.removeMedia(dvd2);
	}
}
