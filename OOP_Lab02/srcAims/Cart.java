public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm");
        }
        else {
            System.out.println("Giỏ hàng gần đầy");
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) return; // Không có đĩa để xóa 
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i] == disc) { // So sánh với đĩa cần xóa 
            for (int j = i; j < qtyOrdered - 1; j++) {
                itemOrdered[j] = itemOrdered[j + 1];
            }
            itemOrdered[qtyOrdered - 1] = null; 
            qtyOrdered--; // Giảm số lượng đĩa
            return; 
            }
        }
    }
    
    public float totalCost(){
        float tong = 0;
        for(int i = 0; i < qtyOrdered; i++){
            tong += itemOrdered[i].getCost();
        }
        return tong;
    }

    public void display(){
        for(int i = 0; i < qtyOrdered; i++){
            System.out.println((i + 1) + " " + itemOrdered[i].getTitle()
            + String.format(" %.2f",itemOrdered[i].getCost()));
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        for(int i = 0; i < dvdList.length; i++){
            if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemOrdered[qtyOrdered] = dvdList[i];
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm");
        }
            else {
            System.out.println("Giỏ hàng gần đầy");
            }
        }
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm");
        }
        else {
            System.out.println("Giỏ hàng gần đầy");
        }
        if(qtyOrdered < MAX_NUMBERS_ORDERED){
            itemOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("Đĩa đã được thêm");
        }
        else {
            System.out.println("Giỏ hàng gần đầy");
        }
    }
}
