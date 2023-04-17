package org.example.framework.util.ui;


import org.apache.commons.io.FileUtils;
import org.example.framework.base.DriverFactory;
import org.example.framework.base.FrameworkException;
import org.example.framework.util.logs.Log;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.example.framework.config.Constants.SCREENSHOT_FOLDER;
import static org.example.framework.config.CreateFolder.createFolder;


public class SeleniumUtil {

    private  static WebDriver driver = DriverFactory.getInstance().getDriver();
    public void highLight(WebElement element){
        for (int i=0; i< 3; i++){
            JavascriptExecutor js= (JavascriptExecutor) driver;
            for (int iCnt = 0; iCnt<3; iCnt++){
                js.executeScript("arguments[0].setAttribute('style','background: yellow')",
                element);
                try {
                    Thread.sleep(20);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                js.executeScript("arguments[0].setAttribute('style','background:')",element);
            }
        }
    }
    public static String getScreenShot(WebElement element) throws FrameworkException {
        String ssDateTime = new SimpleDateFormat("yyMMddHHmmss")
                .format(Calendar.getInstance().getTime());
        String file = null;
        file= createFolder(SCREENSHOT_FOLDER) + "/"+ ssDateTime +".png";
        try{
            File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(
                    (element == null ? srcFile : element.getScreenshotAs(OutputType.FILE)),
                    new File(file));

        }catch (Exception e){
            Log.error(
                    "Class SeleniumUtils | Method takeSnapShot | Exception desc: "+ e.getMessage()
            );

        }
        return file;

    }
    public static void scrollToElemnt(WebElement element)throws FrameworkException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].scrollIntoView(true)",element);
        }catch (JavascriptException jse){
            throw  new FrameworkException(jse.getMessage());
        }
    }
    public static void refresh(){
        driver.navigate().refresh();
    }
}
