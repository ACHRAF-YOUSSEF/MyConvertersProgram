import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterProgram extends JFrame implements ActionListener {
    private final JButton button1 = new JButton("Open The Currency Converter Program");
    private final JButton button2 = new JButton("Open the Temperature Converter Program");
    private final JPanel jPanel = new JPanel(new GridLayout(2, 1, 10, 10));

    public ConverterProgram() {
        // title
        super("Converters V1.0");

        //
        button1.setFocusable(false);
        button2.setFocusable(false);

        //
        jPanel.add(button1);
        jPanel.add(button2);

        //
        button1.addActionListener(this);
        button2.addActionListener(this);

        //
        this.add(jPanel);

        // setup
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            new CurrencyConverterProgram();
        } else {
            new TemperatureConverterProgram();
        }
    }
}
