import java.util.concurrent.*;

// Class representing a customer
class Customer extends Thread {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " is seated and ready to order.");
        // Simulate ordering
        orderFood();
        System.out.println(name + " has placed the order.");
        // Simulate eating
        eat();
        System.out.println(name + " has finished the meal and left the restaurant.");
    }

    private void orderFood() {
        // Simulate ordering time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        // Simulate eating time
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Class representing the chef
class Chef extends Thread {
    private BlockingQueue<String> orders;

    public Chef(BlockingQueue<String> orders) {
        this.orders = orders;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String order = orders.take();
                if (order.equals("exit")) {
                    System.out.println("Chef received exit signal. Exiting.");
                    break;
                }
                System.out.println("Chef is preparing " + order);
                // Simulate cooking time
                Thread.sleep(4000);
                System.out.println("Chef has finished preparing " + order);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// Class representing the restaurant
public class Restaurant {
    public static void main(String[] args) {
        BlockingQueue<String> orders = new LinkedBlockingQueue<>();

        Chef chef = new Chef(orders);
        chef.start();

        // Simulate multiple customers
        for (int i = 1; i <= 5; i++) {
            Customer customer = new Customer("Customer " + i);
            customer.start();
            // Simulate time between customers
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Place an order for each customer
            String order = "Dish " + i;
            System.out.println("Waiter takes order: " + order);
            try {
                orders.put(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Signal chef to exit
        try {
            orders.put("exit");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait for chef to finish
        try {
            chef.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
