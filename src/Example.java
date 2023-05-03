import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Example extends JFrame {

    private ArrayList<FoodItem> menuItems;

    public Example() {
        super("Food Town");

        // Initialize the menu items
        menuItems = new ArrayList<>();
        menuItems.add(new FoodItem("Hamburger", 6.99));
        menuItems.add(new FoodItem("Pizza", 12.99));
        menuItems.add(new FoodItem("Fries", 2.99));
        menuItems.add(new FoodItem("Salad", 5.99));

        // Set up the GUI
        JPanel panel = new JPanel(new GridLayout(menuItems.size(), 2));
        JLabel titleLabel = new JLabel("Menu Items:");
        JLabel orderLabel = new JLabel("Order: ");
        Order order = new Order();
        panel.add(titleLabel);
        panel.add(new JLabel(""));
        for (FoodItem item : menuItems) {
            JButton button = new JButton(item.getName() + " - $" + item.getPrice());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add the item to the order
                    order.addItem(item);
                    // Update the order label
                    orderLabel.setText("Order: " + order.getItemsAsString());
                }
            });
            panel.add(button);
            panel.add(new JLabel(""));
        }
        JLabel orderTitleLabel = new JLabel("Order:");
        panel.add(orderTitleLabel);
        panel.add(orderLabel);
        JButton submitButton = new JButton("Submit Order");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Process the order
                order.process();
                // Clear the order
                order.clear();
                // Update the order label
                orderLabel.setText("Order: " + order.getItemsAsString());
            }
        });
        panel.add(submitButton);
        add(panel);

        // Set the window properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        Example app = new Example();
    }

    // The order class
    private static class Order {
        private ArrayList<FoodItem> items;

        public Order() {
            items = new ArrayList<>();
        }

        public void addItem(FoodItem item) {
            items.add(item);
        }

        public void process() {
            // Process the order
            // ...
            System.out.println("Order processed: " + getItemsAsString());
        }

        public void clear() {
            items.clear();
        }

        public String getItemsAsString() {
            StringBuilder sb = new StringBuilder();
            for (FoodItem item : items) {
                sb.append(item.getName() + ", ");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }
            return sb.toString();
        }
    }

    // The food item class
    private static class FoodItem {
        private String name;
        private double price;

        public FoodItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
