import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

public class RestaurantManagementSystem extends JFrame {

    private JTextField itemNameField, quantityField, priceField;
    private JTextArea orderTextArea;
    private double totalAmount = 0.0;

    public RestaurantManagementSystem() {
        setTitle("Restaurant Management System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating components
        itemNameField = new JTextField(15);
        quantityField = new JTextField(5);
        priceField = new JTextField(8); // Adjusted size
        orderTextArea = new JTextArea(10, 30);
        orderTextArea.setEditable(false);

        JButton addItemButton = new JButton("Add Item");
        JButton calculateTotalButton = new JButton("Calculate Total");

        // Adding action listeners
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        calculateTotalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });

        // Creating layout (FlowLayout)
        setLayout(new FlowLayout());

        // Adding components to the frame
        add(new JLabel("Item Name:"));
        add(itemNameField);
        add(new JLabel("Quantity:"));
        add(quantityField);
        add(new JLabel("Price (INR):")); // Changed label
        add(priceField);
        add(addItemButton);
        add(new JLabel("Order Details:"));
        add(new JScrollPane(orderTextArea));
        add(calculateTotalButton);

        setVisible(true);
    }

    private void addItem() {
        String itemName = itemNameField.getText();
        int quantity = Integer.parseInt(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());

        double itemTotal = quantity * price;
        totalAmount += itemTotal;

        NumberFormat indianCurrencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

        String itemDetails = String.format("%s - Quantity: %d - Price: %s - Total: %s\n",
                itemName, quantity, indianCurrencyFormat.format(price), indianCurrencyFormat.format(itemTotal));

        orderTextArea.append(itemDetails);

        // Clear input fields
        itemNameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    private void calculateTotal() {
        NumberFormat indianCurrencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));

        JOptionPane.showMessageDialog(this, "Total Amount: " + indianCurrencyFormat.format(totalAmount), "Total", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RestaurantManagementSystem();
            }
        });
    }
}
