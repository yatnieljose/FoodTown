
public class Restaurants {
    private static List<RestaurantUser> allRestaurants;
    private List<String> allCuisines;

    private Restaurants() {
        // do nothing
    }

    public static List<RestaurantUser> getAllRestaurants() {
        return this.allRestaurants;
    }

}

    private static List<String> createAllCuisines() {
        // create all cuisines here
        return new List<String>("Italian", "Chinese", "American", "Mexican");
    }

List<RestaurantUser> createAllRestaurants() {
    // create all restaurants here
}
