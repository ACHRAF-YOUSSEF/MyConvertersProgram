import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterProgram extends JFrame implements ActionListener {
    private final JButton convertButton= new JButton("convert");
    private final JTextField inputTextField = new JTextField();
    private final JTextField resultTextField = new JTextField();
    private final JComboBox<TemperatureConverterClass>  comboBox = new JComboBox<>(new TemperatureConverterClass[] {
            new TemperatureConverterClass("Celsius->Fahrenheit", 0) {
                @Override
                public double convertFromTo(double temp) {
                    return (temp * (9 / 5.0)) + 32;
                }
            },
            new TemperatureConverterClass("Fahrenheit->Celsius", 0) {
                @Override
                public double convertFromTo(double temp) {
                    return (temp - 32) * (5.0 / 9);
                }
            },
            new TemperatureConverterClass("Celsius->Kelvin", 0) {
                @Override
                public double convertFromTo(double temp) {
                    return temp + 273.15;
                }
            },
            new TemperatureConverterClass("Kelvin->Celsius", 0) {
                @Override
                public double convertFromTo(double temp) {
                    return temp - 273.15;
                }
            },
            new TemperatureConverterClass("Fahrenheit->Kelvin", 0) {
                @Override
                public double convertFromTo(double temp) {
                    return ((temp - 32) * (5.0 / 9)) + 273.15;
                }
            },
            new TemperatureConverterClass("Kelvin->Fahrenheit", 0) {
                @Override
                public double convertFromTo(double temp) {
                    return ((temp - 273.15) * (9 / 5.0)) + 32;
                }
            },
    });

    public TemperatureConverterProgram() {
        // title
        super("Temperature Convertor V1.0");
        this.setLayout(new GridLayout(3, 2, 5, 5));

        // local variables
        JLabel inputLabel = new JLabel("enter the temperature:");
        JLabel resultLabel = new JLabel("result:");

        // init
        convertButton.setFocusable(false);
        resultTextField.setEditable(false);

        // adding ActionListeners to the components
        convertButton.addActionListener(this);

        // adding components to the frame
        this.add(inputLabel);
        this.add(inputTextField);
        this.add(resultLabel);
        this.add(resultTextField);
        this.add(comboBox);
        this.add(convertButton);

        // setup
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 150);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            resultTextField.setText("");

            TemperatureConverterClass selectedItem = (TemperatureConverterClass) comboBox.getSelectedItem();
            HelperClass<TemperatureConverterClass> temperatureConverterClassHelperClass = new HelperClass<>();

            temperatureConverterClassHelperClass.showResult(this, selectedItem, inputTextField, resultTextField);
        }
    }
}
