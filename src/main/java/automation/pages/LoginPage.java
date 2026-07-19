package automation.pages;

import automation.driver.DriverFactory;
import automation.locators.LoginLocator;
import automation.utils.ConfigReader;

public class LoginPage extends BasePage {

    public void openLoginPage(){

        DriverFactory.getDriver().get(
                ConfigReader.get("base.url"));

    }

    public void inputEmail(String email){
        type(LoginLocator.EMAIL_INPUT, email);
    }

    public void inputPassword(String password){
        type(LoginLocator.PASSWORD_INPUT, password);
    }

    public void clickSignIn(){
        click(LoginLocator.SIGN_IN_BUTTON);
    }


    public void login(){

        inputEmail(ConfigReader.get("email"));

        inputPassword(ConfigReader.get("password"));

        clickSignIn();

    }

    public void login(String email,String password){

        inputEmail(email);

        inputPassword(password);

        clickSignIn();

    }

}