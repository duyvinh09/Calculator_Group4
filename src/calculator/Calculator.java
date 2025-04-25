/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package calculator;

<<<<<<< HEAD
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.script.ScriptException;

public class Calculator {

    // Hàm chính để tính biểu thức, xử lý cả √
    public static double evaluate(String expr) {
        // Xử lý căn bậc hai √x -> Math.sqrt(x)
        expr = expr.replaceAll("√\\s*\\(", "Math.sqrt(");
        expr = expr.replaceAll("√\\s*(\\d+(\\.\\d+)?)", "Math.sqrt($1)");

        try {
            // Dùng JavaScript engine để tính biểu thức (Java core, không cần thư viện ngoài)
            javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
            Object result = engine.eval(expr);
            return Double.parseDouble(result.toString());
        } catch (NumberFormatException | ScriptException e) {
            System.out.println("Lỗi biểu thức: " + e.getMessage());
            return Double.NaN;
        }
    }

    // Hàm copy kết quả vào clipboard
    public static void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    // Test
    public static void main(String[] args) {
        String expr = "5 + (3 * 2) - √9";
        double result = evaluate(expr);
        System.out.println("Kết quả: " + result);

        copyToClipboard(String.valueOf(result));
        System.out.println("Kết quả đã được copy vào clipboard.");
=======
/**
 *
 * @author dinhduyvinh
 */
public class Calculator {
   
    public static void main(String[] args) {
        calculatorForm a = new calculatorForm();
        a.setVisible(true);
>>>>>>> 60b650e31f511ea2d09094cbdc298069d3bda27a
    }
}

