import java.util.ArrayList;
import Menu.MenuItem.MenuItem;

public class MenuItemData {
    public ArrayList<MenuItem> greenGooItems = new ArrayList<>();
    public ArrayList<MenuItem> krustyKrabItems = new ArrayList<>();

    public MenuItemData() {
        MenuItem krabbyPatty = new MenuItem.MenuItemBuilder("Krabby Patty", 3.0)
                .description("Delicious hamburger from under the sea")
                .isVegetarian(false)
                .ingredients("Lettuce, tomato, burger, pickles")
                .build();

        MenuItem kelpFries = new MenuItem.MenuItemBuilder("Kelp Fries", 1.0)
                .description("Delicious fries from under the sea")
                .isVegetarian(true)
                .ingredients("Kelp")
                .build();

        krustyKrabItems.add(krabbyPatty);
        krustyKrabItems.add(kelpFries);

        MenuItem impossibleWhopper = new MenuItem.MenuItemBuilder("Impossible Whopper", 6.0)
                .description("Delicious veggie burger from the land")
                .isVegetarian(true)
                .ingredients("Lettuce, tomato, veggie burger, pickles")
                .build();

        MenuItem greenGoo = new MenuItem.MenuItemBuilder("Green Goo", 20.0)
                .description("A Green Paste")
                .isVegetarian(false)
                .ingredients("Meat Paste")
                .build();

        krustyKrabItems.add(krabbyPatty);
        krustyKrabItems.add(kelpFries);
        greenGooItems.add(impossibleWhopper);
        greenGooItems.add(greenGoo);
    }
}
