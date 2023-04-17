package org.example.framework.util.ui;


import org.example.framework.base.DriverFactory;
import org.example.framework.base.FrameworkException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {
    public static WebDriver driver = DriverFactory.getInstance().getDriver();
    public static void sync() throws FrameworkException {
        String pageLoadStatus;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            do {
                pageLoadStatus= (String) js.executeScript("return document.readyState");
            }while (!pageLoadStatus.equals("complete"));
        }catch (JavascriptException jse){
            throw new FrameworkException(jse.getMessage());
        }
    }

    public static WebDriverWait explicytWait(){
        return  new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void elementVisible(WebElement element){
        explicytWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void allElementsVisible(List<WebElement> elements){
        explicytWait().until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void elementClickable(WebElement element){
        explicytWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static  void elementNotVisible(WebElement element){
        explicytWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public static void wairForAlert(){
        explicytWait().until(ExpectedConditions.alertIsPresent());
    }
}
