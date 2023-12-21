// Generic interface representing an orderable item
interface Orderable {
    String getName();
    double getPrice();
}

// Generic class representing a MenuItem
class MenuItem<T extends Orderable> {
    private T item;

    public MenuItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void displayItemDetails() {
        System.out.println("Item: " + item.getName());
        System.out.println("Price: Rs" + item.getPrice());
    }
}

// Concrete class representing a food item
class FoodItem implements Orderable {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

// Concrete class representing a beverage item
class BeverageItem implements Orderable {
    private String name;
    private double price;

    public BeverageItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

public class RestaurantGenericsExample {
    public static void main(String[] args) {
        // Creating a food item
        FoodItem burger = new FoodItem("Cheeseburger", 230);

        // Creating a beverage item
        BeverageItem soda = new BeverageItem("Cola", 50);

        // Creating menu items using generics
        MenuItem<FoodItem> foodMenuItem = new MenuItem<>(burger);
        MenuItem<BeverageItem> beverageMenuItem = new MenuItem<>(soda);

        // Displaying menu item details
        System.out.println("Food Menu Item:");
        foodMenuItem.displayItemDetails();

        System.out.println("\nBeverage Menu Item:");
        beverageMenuItem.displayItemDetails();
    }
}
