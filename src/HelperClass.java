import javax.swing.*;
import java.awt.*;

public class HelperClass<T extends ConverterClass> {
    public void showResult(Component parent,T selectedItem, JTextField inputTextField, JTextField resultTextField) {
        if (selectedItem != null) {
            String[] units = selectedItem.getFromTo().split("->");
            String c2 = units[1];

            try {
                double input = Double.parseDouble(inputTextField.getText());

                input = selectedItem.convertFromTo(input);

                resultTextField.setText(String.format("%.3f %s", input, c2));
                inputTextField.setText("");
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(parent,
                        "error\n" + ne.getMessage(),
                        "error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
