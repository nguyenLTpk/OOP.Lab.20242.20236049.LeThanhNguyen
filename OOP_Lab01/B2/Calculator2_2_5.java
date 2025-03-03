package B2;

import javax.swing.JOptionPane;

public class Calculator2_2_5{
    public static void main(String args[]){
        String strNum1, strNum2;
        String strNotification;
        
        // Nhập hai số 
        strNum1 = JOptionPane.showInputDialog(null,
            "Please input the first number: ", "Input the first number",
            JOptionPane.INFORMATION_MESSAGE);
        
        strNum2 = JOptionPane.showInputDialog(null,
            "Please input the second number: ", "Input the second number",
            JOptionPane.INFORMATION_MESSAGE);
        
        // Tính toán biểu thức
        try {
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);
            
            double sum = num1 + num2;
            double difference = num1 - num2;
            double product = num1 * num2;
            double quotient = (num2 != 0) ? (num1 / num2) : Double.NaN; // Kiểm tra chia cho 0
            
            strNotification = "You've just entered: " + num1 + " and " + num2 +
                "\nSum: " + sum +
                "\nDifference: " + difference +
                "\nProduct: " + product +
                "\nQuotient: " + (num2 != 0 ? quotient : "Undefined (cannot divide by zero)");
            
            JOptionPane.showMessageDialog(null, strNotification,
                "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
        } 
        
        // Xử lý ngoại lệ 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter numbers only.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        System.exit(0);
    }
}

    

