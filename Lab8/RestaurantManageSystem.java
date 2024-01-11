import java.util.*;

class MenuItem {
    private String itemName;
    private double price;

    public MenuItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "MenuItem{itemName='" + itemName + "', price=" + price + "}";
    }
}

class Menu {
    private Map<String, MenuItem> menuItems;

    public Menu() {
        this.menuItems = new HashMap<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.put(menuItem.getItemName(), menuItem);
    }

    public MenuItem getMenuItem(String itemName) {
        return menuItems.get(itemName);
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (MenuItem menuItem : menuItems.values()) {
            System.out.println(menuItem);
        }
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "'}";
    }
}

class Order {
    private Customer customer;
    private List<MenuItem> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{customer=" + customer + ", items=" + items + ", total=" + calculateTotal() + "}";
    }
}

class Restaurant {
    private String name;
    private Menu menu;
    private List<Customer> customers;
    private List<Order> orders;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new Menu();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menu.addMenuItem(menuItem);
    }

    public void displayMenu() {
        menu.displayMenu();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void placeOrder(Customer customer, List<String> itemNames) {
        Order order = new Order(customer);
        for (String itemName : itemNames) {
            MenuItem menuItem = menu.getMenuItem(itemName);
            if (menuItem != null) {
                order.addItem(menuItem);
            } else {
                System.out.println("Invalid item: " + itemName);
                return;
            }
        }
        orders.add(order);
        System.out.println(customer.getName() + " placed an order at " + name);
    }

    public void displayOrders() {
        System.out.println("Orders at " + name + ":");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}

public class RestaurantManageSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a restaurant
        System.out.print("Enter the name of the restaurant: ");
        String restaurantName = scanner.nextLine();
        Restaurant myRestaurant = new Restaurant(restaurantName);

        // Create menu items
        while (true) {
            System.out.print("Enter menu item name (or 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter menu item price: ");
            double itemPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            MenuItem menuItem = new MenuItem(itemName, itemPrice);
            myRestaurant.addMenuItem(menuItem);
        }

        // Display the menu
        myRestaurant.displayMenu();

        // Create customers
        System.out.print("Enter the number of customers: ");
        int numCustomers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 1; i <= numCustomers; i++) {
            System.out.print("Enter the name of customer " + i + ": ");
            String customerName = scanner.nextLine();
            Customer customer = new Customer(customerName);
            myRestaurant.addCustomer(customer);
        }

        // Place orders
        for (Customer customer : myRestaurant.getCustomers()) {
            System.out.println("Menu for " + customer.getName() + ":");
            myRestaurant.displayMenu();

            System.out.print("Enter the number of items to order for " + customer.getName() + ": ");
            int numItems = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            List<String> orderedItems = new ArrayList<>();
            for (int i = 1; i <= numItems; i++) {
                System.out.print("Enter item " + i + " name: ");
                String itemName = scanner.nextLine();
                orderedItems.add(itemName);
            }

            myRestaurant.placeOrder(customer, orderedItems);
        }

        // Display orders
        myRestaurant.displayOrders();

        scanner.close();
    }
}