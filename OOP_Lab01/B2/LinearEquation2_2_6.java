
package B2;

import javax.swing.JOptionPane;

public class LinearEquation2_2_6 {
    public static void main(String[] args) {
        String strA, strB;
        String strNotification;
        
        // Nhập hai số 
        strA = JOptionPane.showInputDialog(null,
            "Please input number a: ", "Input number a",
            JOptionPane.INFORMATION_MESSAGE);
        
        strB = JOptionPane.showInputDialog(null,
            "Please input number b: ", "Input number b",
            JOptionPane.INFORMATION_MESSAGE);
        
        // Giải phương trình 
        try {
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            
            if (a == 0) {
                if (b == 0) {
                    strNotification = "The equation has infinitely many solutions.";
                } else {
                    strNotification = "The equation has no solution.";
                }
            } else {
                double x = -b / a;
                strNotification = "The equation " + a + "x + " + b + " = 0 has solution: x = " + x;
            }
            
            JOptionPane.showMessageDialog(null, strNotification,
                "Solution", JOptionPane.INFORMATION_MESSAGE);
        } 
        
        // Xử lý ngoại lệ 
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter numbers only.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        System.exit(0);
    }
}
