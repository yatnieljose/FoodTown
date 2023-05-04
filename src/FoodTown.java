import javax.swing.*;

//import Menu.MenuType.*;
import Order.Order;
import User.CustomerUser;
import User.RestaurantUser;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.List;
import java.util.Map;

public class FoodTown extends JFrame {

    private CustomerUser user1;
    private CustomerUser user2;
    private OrderController orderController_user1;
    private OrderController orderController_user2;
    private JPanel footerPanel, filterPanel, mainPanel;

    public FoodTown() {
        super("Food Town");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        Border border = BorderFactory("FTBorder");
        // create or load menu items, restaurants, users

        //this.user1 = new User("Brett");
        //this.user2 = new User("Yatniel");
        this.user1 = new CustomerUser("Brett");
        this.user2 = new CustomerUser("Yatniel");
        this.orderController_user1 = new OrderController(user1, new RestaurantManager());
        this.orderController_user2 = new OrderController(user2, new RestaurantManager());

        // set up all displays, checkboxes, buttons (set up the main panel)

        // Set up the footer panel
        this.footerPanel = new JPanel();
        this.footerPanel.setBorder(border);
        footerPanel.setPreferredSize(new Dimension(0, getHeight() / 10));

        // Add a panel for filter selection
        this.filterPanel = new JPanel();
        this.filterPanel.setBorder(border);
        filterPanel.setPreferredSize((new Dimension(getWidth() / 5, 0)));

        // Set up the main panel
        this.mainPanel = new JPanel();
        this.mainPanel.setBorder(border);
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        loadRestaurantOptions(this.orderController_user2.getRestaurantUsers());

        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        this.getContentPane().add(footerPanel, BorderLayout.SOUTH);
        this.getContentPane().add(filterPanel, BorderLayout.WEST);
        

        /*mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.add(filterPanel);*/


        // Create filter selection components
        /*JRadioBox filterByCuisineOption = new JRadioBox("Filter by Cuisine");
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
*/
/*        // Set up the restaurant selection panel
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
*/
        this.setVisible(true);
    }
    
    private Border BorderFactory(String string) {
        return null;
    }

    // Load GUI Restaurant User label options
    public void loadRestaurantOptions(ArrayList<RestaurantUser> rUsers)
    {
        Map<String, RestaurantUser> rUserMap = this.orderController_user1.makeRestaurantUserMap(rUsers);
        for (String rString : rUserMap.keySet())
        {
            JLabel rLabel = new JLabel(rString);
            System.out.println(rString);
            rLabel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String srcTxt = labelSelected(e);
                    System.out.println(srcTxt);
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    // TODO Auto-generated method stub
                    //throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // TODO Auto-generated method stub
                    //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // TODO Auto-generated method stub
                    //throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // TODO Auto-generated method stub
                    //throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
                }
            });
            this.mainPanel.add(rLabel);
        }
    }

    public String labelSelected(MouseEvent event)
    {
        JLabel source = (JLabel)event.getSource();
        return source.getText();
    }
    /*public static void main(String[] args)
    {
        FoodTown fTown = new FoodTown();
        fTown.setVisible(true);
    }*/
}