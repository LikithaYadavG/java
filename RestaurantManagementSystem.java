package proj3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RestaurantManagementSystem extends JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/restaurant";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Likitha@1234";

    private JTextArea displayArea;

    public RestaurantManagementSystem() {
        super("Restaurant Management System");

        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        JButton viewMenuButton = new JButton("View Menu");
        viewMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMenu();
            }
        });

        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promptOrder();
            }
        });

        JButton viewOrdersButton = new JButton("View Orders");
        viewOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayOrders();
            }
        });

        JPanel panel = new JPanel();
        panel.add(viewMenuButton);
        panel.add(placeOrderButton);
        panel.add(viewOrdersButton);

        add(displayArea, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    private void displayMenu() {
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM menu")) {

            displayArea.setText("Menu:\n");
            while (rs.next()) {
                displayArea.append(rs.getInt("id") + "\t" + rs.getString("item") + "\t" + rs.getDouble("price") + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            displayArea.setText("Error: " + e.getMessage());
        }
    }

    private void promptOrder() {
        JFrame orderFrame = new JFrame("Place Order");
        orderFrame.setLayout(new GridLayout(3, 2));

        JLabel quantityLabel = new JLabel("Enter quantity:");
        JTextField quantityField = new JTextField();

        JLabel itemLabel = new JLabel("Select item:");
        JComboBox<String> itemComboBox = new JComboBox<>();
        // Populate combo box with menu items
        populateItemComboBox(itemComboBox);

        JButton confirmButton = new JButton("Confirm Order");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(quantityField.getText());
                String selectedItem = (String) itemComboBox.getSelectedItem();
                placeOrderInDatabase(quantity, selectedItem);
                displayOrder(quantity, selectedItem);
                orderFrame.dispose();
            }
        });

        orderFrame.add(quantityLabel);
        orderFrame.add(quantityField);
        orderFrame.add(itemLabel);
        orderFrame.add(itemComboBox);
        orderFrame.add(confirmButton);

        orderFrame.setSize(300, 150);
        orderFrame.setLocationRelativeTo(null);
        orderFrame.setVisible(true);
    }

    private void populateItemComboBox(JComboBox<String> comboBox) {
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT item FROM menu")) {

            while (rs.next()) {
                comboBox.addItem(rs.getString("item"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            displayArea.setText("Error: " + e.getMessage());
        }
    }

    private void placeOrderInDatabase(int quantity, String selectedItem) {
        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pst = con.prepareStatement("INSERT INTO orders (item, quantity) VALUES (?, ?)")) {

            pst.setString(1, selectedItem);
            pst.setInt(2, quantity);

            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            displayArea.setText("Error placing order in database: " + e.getMessage());
        }
    }

    private void displayOrder(int quantity, String selectedItem) {
        displayArea.append("\nOrder Placed:\n");
        displayArea.append("Quantity: " + quantity + "\tItem: " + selectedItem + "\n");
    }

    private void displayOrders() {
        JFrame ordersFrame = new JFrame("Placed Orders");
        JTextArea ordersTextArea = new JTextArea(10, 30);
        ordersTextArea.setEditable(false);

        try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM orders")) {

            ordersTextArea.setText("Placed Orders:\n");
            while (rs.next()) {
                ordersTextArea.append("Order ID: " + rs.getInt("order_id") + "\tItem: " + rs.getString("item")
                        + "\tQuantity: " + rs.getInt("quantity") + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            ordersTextArea.setText("Error retrieving orders: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(ordersTextArea);
        ordersFrame.add(scrollPane);

        ordersFrame.setSize(400, 300);
        ordersFrame.setLocationRelativeTo(null);
        ordersFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RestaurantManagementSystem().setVisible(true);
            }
        });
    }
}
