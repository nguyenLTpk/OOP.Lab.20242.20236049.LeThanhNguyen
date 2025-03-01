
package javaapplication2;

import java.util.Arrays;
import static java.util.Arrays.binarySearch;
import java.util.Comparator;
import java.util.Scanner;





public class JavaApplication2 {
    public static int firstPosValue(int a[], int n, int x){
        int l = 0, r = n - 1;
        int res = -1;
        while(l <= r){
            int m = (l + r) / 2;
            if(a[m] == x){
                res = m;
                r = m - 1;
            }
            else if(a[m] > x){
                r = m -1;
            }
            else{
                l = m + 1;
            }
        }
        return res;
    }
    public static int lastPosValue(int a[], int n, int x){
        int l = 0, r = n - 1;
        int res = -1;
        while(l <= r){
            int m = (l + r) / 2;
            if(a[m] == x){
                res = m;
                l = m + 1;
            }
            else if(a[m] < x){
                l = m + 1;
            }
            else r = m - 1;
        }
        return res;
    }
    public static int firstPosGreater(int a[], int n, int x){
        int l = 0, r = n - 1;
        int res = -1;
        while(l <= r){
            int m = (l + r) / 2;
            if(a[m] >= x){
                res = m;
                r = m -1;
            }
            else if(a[m] < x){
                l = m + 1;
            }
            
        }
        return res;
    }
    public static int firstPosHigher(int a[], int n, int x){
        int l = 0, r = n - 1;
        int res = -1;
        while(l <= r){
            int m = (l + r) / 2;
            if(a[m] > x){
                res = m;
                r = m - 1;
            }
            
            else l = m + 1;
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 1;
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for(int i = 1; i < n; i++){
            if(a[i] - a[i-1] > k){
                count++;
            }
        }
        System.out.print(count);
    }
}