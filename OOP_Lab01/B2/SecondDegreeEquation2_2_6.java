
package B2;

import javax.swing.JOptionPane;

public class SecondDegreeEquation2_2_6 {
    public static void main(String[] args) {
        String strA, strB, strC;
        String strNotification;
        
        // Nhập ba hếj số a, b, c 
        strA = JOptionPane.showInputDialog(null,
            "Please input coefficient a: ", "Input Coefficient a",
            JOptionPane.INFORMATION_MESSAGE);
        
        strB = JOptionPane.showInputDialog(null,
            "Please input coefficient b: ", "Input Coefficient b",
            JOptionPane.INFORMATION_MESSAGE);
        
        strC = JOptionPane.showInputDialog(null,
            "Please input coefficient c: ", "Input Coefficient c",
            JOptionPane.INFORMATION_MESSAGE);
        
        // Giải phương trình 
        try {
            double a = Double.parseDouble(strA);
            double b = Double.parseDouble(strB);
            double c = Double.parseDouble(strC);
            
            if (a == 0) {
                if (b == 0) {
                    strNotification = (c == 0) ? "The equation has infinitely many solutions." : "The equation has no solution.";
                } else {
                    double x = -c / b;
                    strNotification = "The equation is linear with solution: x = " + x;
                }
            } else {
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    strNotification = "The equation has no real solution.";
                } else if (delta == 0) {
                    double x = -b / (2 * a);
                    strNotification = "The equation has a double root: x = " + x;
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    strNotification = "The equation has two distinct solutions: x1 = " + x1 + ", x2 = " + x2;
                }
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
