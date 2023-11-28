
package restaurantmanagement;

public class RestaurantTest {
    public static void main(String[] args) {
        RestaurantManagementSystem restaurant = new RestaurantManagementSystem();

        MenuItem dish1 = new Dish("Pasta", 12.99);
        MenuItem dish2 = new Dish("Burger", 8.99);

        dish1.displayInfo();
        System.out.println("Total Price: $" + dish1.getPrice());

        dish2.displayInfo();
        System.out.println("Total Price: $" + dish2.getPrice());
    }
}
