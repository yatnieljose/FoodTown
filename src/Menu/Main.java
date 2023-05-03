package Menu;

import Menu.MenuItem.MenuItem;

public class Main {
    MenuItem pizza = new MenuItem.MenuItemBuilder("Pizza", 9.99)
            .description("Delicious pizza with tomato sauce and cheese")
            .isVegetarian(false)
            .ingredients("Dough. Tomato sauce, Mozzarella cheese")
            .build();
}
