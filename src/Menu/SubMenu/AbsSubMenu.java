package Menu.SubMenu;

import Menu.MenuIF;

public abstract class AbsSubMenu implements MenuIF
{
    private String foodStyle;
    private FoodItem[] foodItems;

    public String getFoodStyle()
    {
        return foodStyle;
    }

    public FoodItem[] getFoodItems()
    {
        return foodItems;
    }
}
