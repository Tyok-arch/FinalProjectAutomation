package automation.pages;

import automation.locators.DashboardLocator;

public class DashboardPage extends BasePage {

    public void clickDashboard(){

        click(DashboardLocator.MENU_DASHBOARD);

    }

    public void clickEmployee(){

        click(DashboardLocator.MENU_EMPLOYEE);

    }

    // Method untuk assertion
    public boolean dashboardDisplayed(){

        return isDisplayed(DashboardLocator.MENU_DASHBOARD);

    }

}