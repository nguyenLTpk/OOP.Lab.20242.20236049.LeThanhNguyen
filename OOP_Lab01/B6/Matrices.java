
package B6;

import java.util.Scanner;

public class Matrices {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        // Kích thước hàng và cột của 2 ma trận 
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        // Khai báo 2 ma trận 
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        
        // Nhập dữ liệu cho 2 ma trận 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                b[i][j] = sc.nextInt();
            }
        }
        
        // Tính ma trận tổng 
        int[][] sum = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum[i][j] = a[i][j] + b[i][j];
                System.out.print(sum[i][j] + " ");
            }
            System.out.println("");
        }
        
    }
}
