import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private String name;
    private boolean available;

    public MenuItem(String name, boolean available) {
        this.name = name;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }
}

public class RestaurantMenu {

    public static void main(String[] args) {
        // Sample list of menu items
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Burger", true));
        menuItems.add(new MenuItem("Pizza", false));
        menuItems.add(new MenuItem("Salad", true));
        menuItems.add(new MenuItem("Pasta", false));

        // Using lambda expression to filter available menu items
        List<MenuItem> availableItems = filterItems(menuItems, item -> item.isAvailable());

        // Displaying the filtered menu items
        System.out.println("Available menu items:");
        for (MenuItem item : availableItems) {
            System.out.println(item.getName());
        }
    }

    // Generic method to filter menu items based on a given condition
    private static List<MenuItem> filterItems(List<MenuItem> menuItems, ItemFilterCondition condition) {
        List<MenuItem> filteredItems = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (condition.test(item)) {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    }

    // Functional interface for the condition to filter menu items
    interface ItemFilterCondition {
        boolean test(MenuItem item);
    }
}