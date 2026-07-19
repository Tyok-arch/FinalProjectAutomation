package automation.locators;

import org.openqa.selenium.By;

public class DashboardLocator {

    private DashboardLocator(){}

    public static final By MENU_DASHBOARD =
            By.xpath("//*[@id='layout-desktop-menu-item-box-dashboard']/div/p");

    public static final By MENU_EMPLOYEE =
            By.xpath("//*[@id='layout-desktop-menu-item-box-employee']/div/p");

}