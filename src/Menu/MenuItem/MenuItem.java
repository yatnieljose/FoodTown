package Menu.MenuItem;

import Menu.Menu;

public class MenuItem {//implements MenuItemDiscountIF {
    String name;
    String description;
    double price;
    boolean isVegetarian;
    String ingredients;

    public MenuItem()
    {

    }

    private MenuItem(MenuItemBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.isVegetarian = builder.isVegetarian;
        this.ingredients = builder.ingredients;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isVegetarian() {
        return this.isVegetarian;
    }

    public String getIngredients() {
        return this.ingredients;
    }

    public double getDiscount() {
        return 0;
    }

    public static class MenuItemBuilder {
        private String name;
        private String description;
        private double price;
        private boolean isVegetarian;
        private String ingredients;

        public MenuItemBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public MenuItemBuilder description(String description) {
            this.description = description;
            return this;
        }

        public MenuItemBuilder isVegetarian(boolean isVegetarian) {
            this.isVegetarian = isVegetarian;
            return this;
        }

        public MenuItemBuilder ingredients(String ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public MenuItem build() {
            return new MenuItem(this);
        }
    }
}
