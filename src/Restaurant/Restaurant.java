import Menu.Menu;
import Order.Order;

public class Restaurant {
    String name;
    String cuisine;
    double rating;
    boolean vegetarian;
    Menu menu;

    public Restaurant(RestaurantUser restaurantUser, String name, String cuisine, double rating, boolean vegetarian,
            Menu menu) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
        this.vegetarian = vegetarian;
        this.menu = menu;
    }

    public String getName() {
        return this.name;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public double getRating() {
        return this.rating;
    }

    public boolean vegetarian() {
        return this.vegetarian;
    }

    public Menu getMenu() {
        return this.menu;
    }
}
