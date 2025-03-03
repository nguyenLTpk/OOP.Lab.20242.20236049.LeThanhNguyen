
package B6;

import java.util.Scanner;

public class StarTriangle {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        // Chiều cao của tam giác
        int n = sc.nextInt();
        
        // Biến phụ để chặn vùng in ra ký tự *
        int k1 = n, k2 = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= 2 * n - 1; j++){
                if(j >= k1 && j <= k2){
                    System.out.print("*");
                }
                else System.out.print(" ");
            }
            System.out.println("");
            // Tăng phạm vi in ra *
            k1--;
            k2++;
        }
    }
}
