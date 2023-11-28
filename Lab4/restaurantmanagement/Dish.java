
package restaurantmanagement;

public class Dish implements MenuItem {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void displayInfo() {
        System.out.println("Dish: " + name);
        System.out.println("Price: $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}
