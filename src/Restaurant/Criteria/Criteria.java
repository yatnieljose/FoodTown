package Restaurant;

import User.RestaurantUser;
import java.util.List;

public interface Criteria {
    public List<RestaurantUser> meetCriteria(List<RestaurantUser> restaurants);
}
