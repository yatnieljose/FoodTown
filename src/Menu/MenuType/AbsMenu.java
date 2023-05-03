package Menu.MenuType;

import Menu.MenuIF;
import Menu.SubMenu.AbsSubMenu;

public abstract class AbsMenu implements MenuIF
{
    private String foodStyle;
    private AbsSubMenu lunchMenu;
    private AbsSubMenu dinnerMenu;
    private AbsSubMenu dessertMenu;
}
