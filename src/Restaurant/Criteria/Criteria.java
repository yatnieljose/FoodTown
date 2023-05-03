package Restaurant;

import Restaurant.Restaurant;
import java.util.List;

public interface Criteria {
    public List<Restaurant> meetCriteria(List<Restaurant> restaurants);
}
