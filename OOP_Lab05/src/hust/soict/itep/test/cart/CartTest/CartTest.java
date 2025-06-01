package hust.soict.itep.test.cart.CartTest;

import hust.soict.itep.aims.cart.Cart.Cart;
import hust.soict.itep.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        //Test the print method
        cart.print();
        //To-do: Test the search methods here
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Snow white", "Animation", "Roger Allers", 34,1234, 35f);
        cart.addMedia(dvd4);
        
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Tay du ki", "truyen", "Roger Allers", 65,2354, 20f);
        cart.addMedia(dvd5);
        
        cart.searchByID(1234);
        cart.searchByID(623);
        cart.searchByTitle("Tay du ki");
        cart.searchByTitle("Thor");
    }
}

