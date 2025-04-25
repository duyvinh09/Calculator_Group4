package calculator;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator {

    // Hàm tính toán biểu thức
    public static double evaluate(String expr) {
        expr = expr.replaceAll("√", "sqrt");
        Expression expression = new ExpressionBuilder(expr)
                .build();
        return expression.evaluate();
    }

    // Hàm copy kết quả vào clipboard
    public static void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    // Hàm main test (tùy bạn giữ hay bỏ)
    public static void main(String[] args) {
        calculatorForm a = new calculatorForm();
        a.setVisible(true);

        // Test biểu thức
        String expr = "5 + (3 * 2) - √9";
        double result = evaluate(expr);
        System.out.println("Kết quả: " + result);

        // Copy vào clipboard
        copyToClipboard(String.valueOf(result));
    }
}
