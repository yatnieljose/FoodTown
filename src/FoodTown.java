import javax.swing.*;

import Menu.MenuType.*;
import Order.Order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FoodTown extends JFrame {

    private CustomerUser user1;
    private CustomerUser user2;
    private OrderController orderController_user1;
    private OrderController orderController_user2;

    public FoodTown() {
        super("Food Town");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // create or load menu items, restaurants, users

        this.user1 = new User("Brett");
        this.user2 = new User("Yatniel");
        this.orderController_user1 = new OrderController(user1, new RestaurantManager(Restaurant));
        this.orderController_user2 = new OrderController(user2, new Restaurants.getAllRestaurants());

        // set up all displays, checkboxes, buttons (set up the main panel)

        // Set up the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Add a panel for filter selection
        JPanel filterPanel = new JPanel();
        mainPanel.add(filterPanel);

        // Create filter selection components
        JRadioBox filterByCuisineOption = new JRadioBox("Filter by Cuisine");
        JRadioBox<String> cuisineOptions = new JComboBox<>(Restaurants.allCuisines());
        JRadioBox filterByRatingOption = new JRadioBox("Filter by Rating");
        JComboBox<String> ratingOptions = new JComboBox<>(
                new String[] { "at least 1.0", "at least 2.0", "at least 3.0", "at least 4.0", "5.0" });
        JCheckBox filterByVegetarianOption = new JRadioBox("Filter Vegetarian");
        JButton applyFiltersButton = new JButton("Apply Filters");

        filterPanel.add(filterOption1);
        filterPanel.add(filterOption2);
        filterPanel.add(applyFiltersButton);

        applyFiltersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Criteria filterCriteria;

                if (filterByCuisineOption.isSelected()) {
                    filterCriteria = new CriteriaCuisine(cuisineOptions.getSelectedItem());
                }
                if (filterByRatingOption.isSelected()) {
                    filterCriteria = new CriteriaRating(ratingOptions.getSelectedIndex + 1.0);
                }
                if (filterByVegetarianOption.isSelected()) {
                    filterCriteria = new CriteriaVegetarian();
                }

                this.orderController.filterRestaurants(filterCriteria);

                // Update the restaurant display based on the filtered list
                // ...
            }
        });

        // Set up the restaurant selection panel
        JPanel restaurantPanel = new JPanel();
        mainPanel.add(restaurantPanel);

        JComboBox<RestaurantUser> restaurantComboBox = new JComboBox<>();
        for (Restaurant restaurant : restaurants) {
            RestaurantUser restaurantUser = new RestaurantUser(restaurant);
            restaurantComboBox.addItem(restaurantUser);
        }
        restaurantPanel.add(restaurantComboBox);

        // Set up the buttons for placing and processing orders
        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel);

        JButton placeOrderButton = new JButton("Place Order");
        JButton processOrderButton = new JButton("Process Order");
        buttonPanel.add(placeOrderButton);
        buttonPanel.add(processOrderButton);

        // Set up the actions for the buttons
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurantUser selectedRestaurantUser = (RestaurantUser) restaurantComboBox.getSelectedItem();
                OrderController.handlePlaceOrderRequest(user, selectedRestaurantUser);
            }
        });

        processOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RestaurantUser selectedRestaurantUser = (RestaurantUser) restaurantComboBox.getSelectedItem();
                OrderController.handleProcessOrderRequest(selectedRestaurantUser);
            }
        });

        setVisible(true);
    }
}