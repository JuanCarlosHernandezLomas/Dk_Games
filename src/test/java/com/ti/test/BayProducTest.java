package com.ti.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

import static org.example.framework.util.extentreports.ExtentTestManager.startTest;
import static org.example.framework.util.ui.WaitUtil.driver;

public class BayProducTest extends  BaseTest{

    @Test
    void BuyProduct(Method method) throws InterruptedException {
        startTest(method.getName(), "Compra de productos    ");
        Comprar();
        Assert.assertTrue(driver.getTitle().contains("Order History"));


    }
}
