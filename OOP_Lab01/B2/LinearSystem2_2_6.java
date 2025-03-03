
package B2;

import javax.swing.JOptionPane;

public class LinearSystem2_2_6 {
    public static void main(String[] args) {
        String strA1, strB1, strC1, strA2, strB2, strC2;
        String strNotification;
        
        // Nhập hệ số cho hệ phương trình 
        strA1 = JOptionPane.showInputDialog(null,
            "Please input number a1: ", "Input number a1",
            JOptionPane.INFORMATION_MESSAGE);
        
        strB1 = JOptionPane.showInputDialog(null,
            "Please input number b1: ", "Input number b1",
            JOptionPane.INFORMATION_MESSAGE);
        
        strC1 = JOptionPane.showInputDialog(null,
            "Please input number c1: ", "Input number c1",
            JOptionPane.INFORMATION_MESSAGE);
        
        strA2 = JOptionPane.showInputDialog(null,
            "Please input number a2: ", "Input number a2",
            JOptionPane.INFORMATION_MESSAGE);
        
        strB2 = JOptionPane.showInputDialog(null,
            "Please input number b2: ", "Input number b2",
            JOptionPane.INFORMATION_MESSAGE);
        
        strC2 = JOptionPane.showInputDialog(null,
            "Please input number c2: ", "Input number c2",
            JOptionPane.INFORMATION_MESSAGE);
       
        // Giải hệ phương trình 
        try {
            double a1 = Double.parseDouble(strA1);
            double b1 = Double.parseDouble(strB1);
            double c1 = Double.parseDouble(strC1);
            double a2 = Double.parseDouble(strA2);
            double b2 = Double.parseDouble(strB2);
            double c2 = Double.parseDouble(strC2);
            
            // Tính định thức 
            double D = a1 * b2 - a2 * b1;
            double Dx = c1 * b2 - c2 * b1;
            double Dy = a1 * c2 - a2 * c1;
            
            if (D == 0) {
                if (Dx == 0 && Dy == 0) {
                    strNotification = "The system has infinitely many solutions.";
                } else {
                    strNotification = "The system has no solution.";
                }
            } else {
                double x = Dx / D;
                double y = Dy / D;
                strNotification = "The system:\n"
                    + a1 + "x + " + b1 + "y = " + c1 + "\n"
                    + a2 + "x + " + b2 + "y = " + c2 + "\n"
                    + "Has solution: x = " + x + ", y = " + y;
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
