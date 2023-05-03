import javax.swing.*;

import Menu.MenuType.*;
import Order.Order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoodTown extends JFrame {

    private ArrayList<Restaurant> restaurants;

    public FoodTown() {
        super("Food Town");

        // Initialize the menu items
        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(new ChineseMenu(), "China Wok"));
        restaurants.add(new Restaurant(new ThaiMenu(), "Thai Guy"));
        restaurants.add(new Restaurant(new MediterraneanMenu(), "Greek Gyros"));
        restaurants.add(new Restaurant(new AmericanMenu(), "Brett's Burgers"));
        restaurants.add(new Restaurant(new ItalianMenu(), "Mama Italia's Pasta"));

        // Set up the GUI
        JPanel rPanel = new JPanel(new GridLayout(restaurants.size(), 2));
        JPanel oPanel = new JPanel(getLayout(), rootPaneCheckingEnabled);
        JLabel titleLabel = new JLabel("Menu Items:");
        JLabel orderLabel = new JLabel("Order: ");
        Order order = new Order();
        oPanel.add(titleLabel);
        //panel.add(new JLabel(""));
        for (Restaurant r : restaurants) {
            JButton button = new JButton(r.getName());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Add the item to the order
                    order.addItem(r);
                    // Update the order label
                    orderLabel.setText("Order: " + order.getItemsAsString());
                }
            });
            rPanel.add(button);
            rPanel.add(new JLabel(""));
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
        FoodTown app = new FoodTown();
    }

    // The order class
    /*private static class Order {
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
    }*/

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
