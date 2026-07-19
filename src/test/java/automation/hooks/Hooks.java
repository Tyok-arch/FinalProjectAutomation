package automation.hooks;

import automation.driver.DriverFactory;
import automation.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setup(){

        DriverFactory.getDriver();

    }

    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){

            ScreenshotUtil.capture(scenario.getName());

        }

        DriverFactory.quitDriver();

    }

}