package automation.utils;

import automation.driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static void capture(String fileName){

        File source =
                ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.FILE);

        File folder = new File("target/screenshots");

        if(!folder.exists()){
            folder.mkdirs();
        }

        File target =
                new File(folder,fileName + ".png");

        try{

            FileUtils.copyFile(source,target);

            System.out.println("Screenshot : " + target.getAbsolutePath());

        }catch(IOException e){

            e.printStackTrace();

        }

    }

}