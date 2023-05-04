import javax.swing.*;

//import Menu.MenuType.*;
import Order.Order;
import User.CustomerUser;
import User.RestaurantUser;
import Restaurant.Criteria.*;
import Menu.Menu;
import Menu.MenuItem.MenuItem;

import javax.swing.border.*;
import javax.swing.JRadioButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.List;
import java.util.Map;
import java.util.HashMap;

public class FoodTown extends JFrame {

    private CustomerUser user1;
    private CustomerUser user2;
    private OrderController orderController_user1;
    private OrderController orderController_user2;
    private JPanel filterPanel, restaurantPanel, menuItemPanel, footerPanel;
    private JLabel currentPriceLabel;

    // Cuisine options
    String[] allCuisineOptions = { "Italian", "Chinese", "American" };

    public FoodTown() {
        super("Food Town");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 600);
        setLayout(new BorderLayout());

        // create or load menu items, restaurants, users
        this.user1 = new CustomerUser("Brett");
        this.user2 = new CustomerUser("Yatniel");
        this.orderController_user1 = new OrderController(user1, new RestaurantManager());
        this.orderController_user2 = new OrderController(user2, new RestaurantManager());

        // set up all displays, checkboxes, buttons (set up the main panel)

        // Add a panel for filter selection
        this.filterPanel = new JPanel();
        this.filterPanel.setLayout(new GridLayout(4, 2));
        this.filterPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        filterPanel.setPreferredSize((new Dimension(getWidth() / 3, getHeight() / 2)));

        // Filter functionality
        JRadioButton filterByCuisineOption = new JRadioButton("Filter by Cuisine");
        JComboBox<String> cuisineOptions = new JComboBox<>(this.allCuisineOptions);
        JRadioButton filterByRatingOption = new JRadioButton("Filter by Rating");
        JComboBox<String> ratingOptions = new JComboBox<>(
                new String[] { "at least 1.0", "at least 2.0", "at least 3.0", "at least 4.0", "5.0" });
        JRadioButton filterByVegetarianOption = new JRadioButton("Filter Vegetarian");
        JButton applyFiltersButton = new JButton("Apply Filters");

        filterPanel.add(filterByCuisineOption);
        filterPanel.add(cuisineOptions);
        filterPanel.add(filterByRatingOption);
        filterPanel.add(ratingOptions);
        filterPanel.add(filterByVegetarianOption);
        filterPanel.add(applyFiltersButton);

        applyFiltersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Criteria filterCriteria = null;

                if (filterByCuisineOption.isSelected()) {
                    System.out.println((String) cuisineOptions.getSelectedItem());
                    filterCriteria = new CriteriaCuisine((String) cuisineOptions.getSelectedItem());
                }
                if (filterByRatingOption.isSelected()) {
                    filterCriteria = new CriteriaRating(ratingOptions.getSelectedIndex() + 1.0);
                }
                if (filterByVegetarianOption.isSelected()) {
                    filterCriteria = new CriteriaVegetarian();
                }

                orderController_user1.filterRestaurants(filterCriteria);
                loadRestaurantOptions(
                        (ArrayList<RestaurantUser>) orderController_user1.restaurantManager.getRestaurantUsers());
            }
        });

        // Set up menu item panel
        this.menuItemPanel = new JPanel();
        this.menuItemPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.menuItemPanel.setPreferredSize(new Dimension(getWidth() / 3, getHeight()));
        loadMenuItems(new HashMap<String, MenuItem>());

        // Set up the footer panel
        this.footerPanel = new JPanel();
        this.footerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        footerPanel.setPreferredSize(new Dimension(getWidth(), getHeight() / 10));
        JButton placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<JCheckBox> selectedBoxes = new ArrayList<>();

                for (Component component : menuItemPanel.getComponents()) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                            selectedBoxes.add(checkBox);
                        }
                    }
                }

                ArrayList<MenuItem> selectedItems = new ArrayList<>();

                for (JCheckBox checkBox : selectedBoxes) {
                    selectedItems.add(orderController_user1.getRestaurantManager().getSelectedRestaurantUser().getMenu()
                            .getItem(checkBox.getText()));
                }
                orderController_user1.handlePlacedOrder(selectedItems);
            }
        });

        JButton calcPriceButton = new JButton("Calculate Price");
        calcPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<JCheckBox> selectedBoxes = new ArrayList<>();

                for (Component component : menuItemPanel.getComponents()) {
                    if (component instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) component;
                        if (checkBox.isSelected()) {
                            selectedBoxes.add(checkBox);
                        }
                    }
                }

                double currentPrice = 0.0;

                for (JCheckBox checkBox : selectedBoxes) {
                    currentPrice += orderController_user1.getRestaurantManager().getSelectedRestaurantUser().getMenu()
                            .getItem(checkBox.getText()).getPrice();
                }
                currentPriceLabel.setText("Price = " + currentPrice);
            }
        });

        this.currentPriceLabel = new JLabel("Price = 0");
        this.footerPanel.add(placeOrderButton);
        this.footerPanel.add(calcPriceButton);
        this.footerPanel.add(this.currentPriceLabel);

        // Set up the main panel
        this.restaurantPanel = new JPanel();
        this.restaurantPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        this.restaurantPanel.setPreferredSize(new Dimension(getWidth() / 3, getHeight()));
        // this.restaurantPanel.setLayout(new BoxLayout(restaurantPanel,
        // BoxLayout.Y_AXIS));
        loadRestaurantOptions(this.orderController_user2.getRestaurantUsers());

        this.getContentPane().add(filterPanel, BorderLayout.WEST);
        this.getContentPane().add(restaurantPanel, BorderLayout.CENTER);
        this.getContentPane().add(menuItemPanel, BorderLayout.EAST);
        this.getContentPane().add(footerPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    // Load GUI Restaurant User label options
    public void loadRestaurantOptions(ArrayList<RestaurantUser> restaurantUsers) {
        this.restaurantPanel.removeAll();

        for (RestaurantUser restaurantUser : restaurantUsers) {
            System.out.println(restaurantUser.getRestaurant().getName());
            JPanel restaurantRow = new JPanel();
            restaurantRow.setLayout(new GridLayout(1, 2));

            JLabel restaurantLabel = new JLabel(restaurantUser.getRestaurant().getName());
            JButton restaurantButton = new JButton("Select");

            restaurantButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    orderController_user1.getRestaurantManager().setSelectedRestaurantUser(restaurantUser);
                    loadMenuItems(restaurantUser.getRestaurant().getMenu().getAllItems());
                }
            });

            restaurantRow.add(restaurantLabel);
            restaurantRow.add(restaurantButton);

            this.restaurantPanel.add(restaurantRow);
        }

        this.restaurantPanel.revalidate();
        this.restaurantPanel.repaint();
    }

    public void loadMenuItems(Map<String, MenuItem> menuItemMap) {
        this.menuItemPanel.removeAll();
        System.out.println("In loadMenuItems...");
        ArrayList<MenuItem> menuItems = new ArrayList<>(menuItemMap.values());

        for (MenuItem menuItem : menuItems) {
            JCheckBox menuItemBox = new JCheckBox(menuItem.getName());
            this.menuItemPanel.add(menuItemBox);
        }

        this.menuItemPanel.revalidate();
        this.menuItemPanel.repaint();
    }

    public String labelSelected(MouseEvent event) {
        JLabel source = (JLabel) event.getSource();
        return source.getText();
    }
    /*
     * public static void main(String[] args)
     * {
     * FoodTown fTown = new FoodTown();
     * fTown.setVisible(true);
     * }
     */
}