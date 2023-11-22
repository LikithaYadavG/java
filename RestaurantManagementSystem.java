// Base class representing a generic Dish
class Dish {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Dish: " + name);
        System.out.println("Price: $" + price);
    }
}

// Subclass representing an Appetizer, inheriting from Dish
class Appetizer extends Dish {
    private boolean isFried;

    public Appetizer(String name, double price, boolean isFried) {
        super(name, price);
        this.isFried = isFried;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: Appetizer");
        System.out.println("Fried: " + isFried);
    }
}

// Subclass representing a Main Course, inheriting from Dish
class MainCourse extends Dish {
    private boolean isVegetarian;

    public MainCourse(String name, double price, boolean isVegetarian) {
        super(name, price);
        this.isVegetarian = isVegetarian;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: Main Course");
        System.out.println("Vegetarian: " + isVegetarian);
    }
}

// Abstract class representing a special of the day
abstract class Special {
    private String name;

    public Special(String name) {
        this.name = name;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displaySpecial();

    public String getName() {
        return name;
    }
}

// Concrete subclass of Special
class DailySpecial extends Special {
    private String chef;

    public DailySpecial(String name, String chef) {
        super(name);
        this.chef = chef;
    }

    @Override
    public void displaySpecial() {
        System.out.println("Special of the Day: " + getName());
        System.out.println("Chef: " + chef);
    }
}

// Final class, cannot be subclassed
final class Dessert extends Dish {
    private boolean isFrozen;

    public Dessert(String name, double price, boolean isFrozen) {
        super(name, price);
        this.isFrozen = isFrozen;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Type: Dessert");
        System.out.println("Frozen: " + isFrozen);
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Creating instances of the classes
        Appetizer appetizer = new Appetizer("Spring Rolls", 8.99, true);
        MainCourse mainCourse = new MainCourse("Chicken Alfredo", 15.99, false);
        Dessert dessert = new Dessert("Chocolate Cake", 6.99, true);
        DailySpecial dailySpecial = new DailySpecial("Grilled Salmon", "Chef Likitha Yadav G");

        // Displaying information about the dishes
        System.out.println("Appetizer:");
        appetizer.display();
        System.out.println("\nMain Course:");
        mainCourse.display();
        System.out.println("\nDessert:");
        dessert.display();
        System.out.println("\nDaily Special:");
        dailySpecial.displaySpecial();
    }
}
