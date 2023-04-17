package com.ti.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.example.framework.util.extentreports.ExtentTestManager.startTest;
import static org.example.framework.util.ui.WaitUtil.driver;

public class RegisterTest extends BaseTest {

    @Test
    void RegisterDate(Method method) throws InterruptedException {
        startTest(method.getName(),"creacion de usuario");
        Register();
        WebElement com=driver.findElement(By.className("checkout-subtitle"));
        Assert.assertEquals(com.getText(),"REGISTRATE");

    }

}
