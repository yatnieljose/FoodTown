package Menu.MenuFactory;

import Menu.MenuIF;

public interface MenuFactoryIF 
{
    public MenuIF createLunchMenu();
    public MenuIF createDinnerMenu();
    public MenuIF createDessertMenu();
}
