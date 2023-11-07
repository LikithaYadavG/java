public class Restaurant {
    private String name;
    private String address;
    private int rating;
    private int capacity;
    private String[] menu;

    public Restaurant() {
        this.name = "HappyRestaurant";
        this.address = "Jayanagar";
        this.rating = 5;
        this.capacity = 30;
        this.menu = new String[]{"Burger", "Pizza", "Cheese rolls"};
    }

    public Restaurant(String name, String address, int rating, int capacity, String[] menu) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.capacity = capacity;
        this.menu = menu;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMenu(String[] menu) {
        this.menu = menu;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getRating() {
        return this.rating;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String[] getMenu() {
        return this.menu;
    }

    public void printDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Rating: " + this.rating);
        System.out.println("Capacity: " + this.capacity);
        System.out.println("Menu: ");
        for (String item : this.menu) {
            System.out.println("- " + item);
        }
    }

    public void printDetails(String message) {
        System.out.println(message);
        this.printDetails();
    }

    public void printDetails(String message, boolean showMenu) {
        System.out.println(message);
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Rating: " + this.rating);
        System.out.println("Capacity: " + this.capacity);
        if (showMenu) {
            System.out.println("Menu: ");
            for (String item : this.menu) {
                System.out.println("- " + item);
            }
        }
    }

    public static void main(String[] args) {
        String[] menu = new String[]{"Rice Sambar", "Idli", "Vada"};
        Restaurant restaurant1 = new Restaurant();
        restaurant1.printDetails("Default Restaurant Details:");

        Restaurant restaurant2 = new Restaurant("MyRestaurant", "Koramangala", 4, 50, menu);
        restaurant2.printDetails("My Restaurant Details:", true);
    }
}
