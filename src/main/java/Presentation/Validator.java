package Presentation;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class Validator {
    public static boolean isPresent(JTextComponent c, String title) {
        if (c.getText().length() == 0) {
            showMessage(c, title + " field is requaerd, \nPlease re-enter");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public static boolean isInteger(JTextComponent c, String title) {
        try {
            int i = Integer.parseInt(c.getText());
            return true;
        } catch (NumberFormatException e) {
            showMessage(c, title + "Must be numeric.\nPlease re-enter");
            c.requestFocusInWindow();
            return false;
        }
    }

    public static boolean isDouble(JTextComponent c, String title) {
        try {
            double d = Double.parseDouble(c.getText());
            return true;
        } catch (NumberFormatException e) {
            showMessage(c, title + "Must be valid number.\nPlease re-enter");
            return false;
        }
    }

    private static void showMessage(JTextComponent c, String message) {
        JOptionPane.showMessageDialog(c, message, "Invalid Entry", JOptionPane.ERROR_MESSAGE);
    }
}
