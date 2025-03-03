
package B6;

import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String month;
        int year;
        while(true){
            month = sc.next();
            year = sc.nextInt();
            
            // Kiểm tra năm hợp lệ 
            if(year < 0){
                System.out.println("The year is invalid");
                continue;
            }
            
            // Kiểm tra tháng được nhập 
            if(month.compareTo("January") == 0 || month.compareTo("1") == 0 || month.compareTo("Jan") == 0){
                System.out.println("31");
                break;
            }
            else if(month.compareTo("March") == 0 || month.compareTo("Mar") == 0 || month.compareTo("3") == 0){
                System.out.println("31");
                break;
            }
            else if(month.compareTo("April") == 0 || month.compareTo("Apr") == 0 || month.compareTo("4") == 0){
                System.out.println("30");
                break;
            }
            else if(month.compareTo("May") == 0 || month.compareTo("5") == 0){
                System.out.println("31");
                break;
            }
            else if(month.compareTo("June") == 0 || month.compareTo("Jun") == 0 || month.compareTo("6") == 0){
                System.out.println("30");
                break;
            }
            else if(month.compareTo("July") == 0 || month.compareTo("Jul") == 0 || month.compareTo("7") == 0){
                System.out.println("31");
                break;
            }
            else if(month.compareTo("August") == 0 || month.compareTo("Aug") == 0 || month.compareTo("8") == 0){
                System.out.println("31");
                break;
            }
            else if(month.compareTo("September") == 0 || month.compareTo("Sep") == 0 || month.compareTo("9") == 0){
                System.out.println("30");
                break;
            }
            else if(month.compareTo("October") == 0 || month.compareTo("Oct") == 0 || month.compareTo("10") == 0){
                System.out.println("31");
                break;
            }
            else if(month.compareTo("November") == 0 || month.compareTo("Nov") == 0 || month.compareTo("11") == 0){
                System.out.println("30");
                break;
            }
            else if(month.compareTo("December") == 0 || month.compareTo("Dec") == 0 || month.compareTo("12") == 0){
                System.out.println("31");
                break;
            }
            else if(month.compareTo("February") == 0 || month.compareTo("Feb") == 0 || month.compareTo("2") == 0){
                if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
                    System.out.println("29");
                } 
                else System.out.println("28");
                break;
            }
            
            // Nếu tháng không hợp lệ 
            else {
                System.out.println("The month is invalid");
            }
        }
    }
}
