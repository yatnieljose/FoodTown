import java.util.ArrayList;
import java.util.List;

import Menu.Menu;
import Menu.MenuItem.MenuItem;
import Restaurant.Criteria.Criteria;
import User.RestaurantUser;

public class RestaurantManager {
    List<RestaurantUser> restaurantUsers;
    RestaurantUser selectedRestaurantUser;

    public RestaurantManager() {
        this.restaurantUsers = new ArrayList<RestaurantUser>();
        this.selectedRestaurantUser = null;
        MenuItemData menuItemData = new MenuItemData();

        RestaurantUser bucaUser = new RestaurantUser("Buca de Fini", "Italian", 3.0, false, new Menu());
        this.addRestaurantUser(bucaUser);

        RestaurantUser krustyKrabUser = new RestaurantUser("Krusty Krab", "Meditteranean", 5.0, false, new Menu());
        for (MenuItem item : menuItemData.krustyKrabItems) {
            krustyKrabUser.getRestaurant().getMenu().addItem(item);
        }
        this.addRestaurantUser(krustyKrabUser);

        RestaurantUser greenGooUser = new RestaurantUser("Green Goo", "American", 1.0, false, new Menu());
        for (MenuItem item : menuItemData.greenGooItems) {
            greenGooUser.getRestaurant().getMenu().addItem(item);
        }
        this.addRestaurantUser(greenGooUser);
    }

    public RestaurantUser getSelectedRestaurantUser() {
        return this.selectedRestaurantUser;
    }

    public void setSelectedRestaurantUser(RestaurantUser restaurantUser) {
        this.selectedRestaurantUser = restaurantUser;
    }

    public void addRestaurantUser(RestaurantUser restaurantUser) {
        this.restaurantUsers.add(restaurantUser);
    }

    public List<RestaurantUser> getRestaurantUsers() {
        return this.restaurantUsers;
    }

    public void filterRestaurants(Criteria filterCriteria) {
        this.restaurantUsers = filterCriteria.meetCriteria(this.restaurantUsers);
    }
}
