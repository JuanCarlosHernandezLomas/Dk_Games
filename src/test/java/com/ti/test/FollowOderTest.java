package com.ti.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.example.framework.util.extentreports.ExtentTestManager.startTest;
import static org.example.framework.util.ui.WaitUtil.driver;

public class FollowOderTest extends BaseTest{

    @Test
    void CheckOrders(Method method) throws InterruptedException {
        startTest(method.getName(), "chequeo de orden");
        Order();
        WebElement Name = driver.findElement(By.xpath("//a[contains(text(),\"god of war ragnarok\")]"));
        Assert.assertEquals(Name.getText(),"GOD OF WAR RAGNAROK");
    }
}
