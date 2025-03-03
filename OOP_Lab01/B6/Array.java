
package B6;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        // Kích thước mảng 
        int n = sc.nextInt(); 
        
        // Biến tính tổng và trung bình 
        int sum = 0;
        double average;
        int[] a = new int[n];
        
        // Khởi tạo giá trị 
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            sum += a[i];
        }
        
        // Sắp xếp mảng
        Arrays.sort(a);
        
        // In ra kết quả 
        System.out.println(sum);
        average = 1.0 * sum / n;
        System.out.println(average);
    }
}
