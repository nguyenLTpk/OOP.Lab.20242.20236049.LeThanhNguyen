
import javax.swing.JOptionPane;

public class Aims{
    public static void main(String args[]){
        Cart anOrder = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
        "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
        "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
        "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        
        // Hiển thị STT, tiêu đề và chi phí trước tổng chi phí 
        anOrder.display();
        
        // Tổng chi phí 
        System.out.print("Toatl Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}
