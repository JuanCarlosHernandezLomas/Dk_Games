package com.ti.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.example.framework.util.extentreports.ExtentTestManager.startTest;
import static org.example.framework.util.ui.WaitUtil.driver;

public class AddressDataTest extends BaseTest{


        @Test
        void AdressDate(Method method) throws InterruptedException {
            startTest(method.getName(), "Registro de datos");
            AddressData();
            Assert.assertTrue(driver.getTitle().contains("Dk games"));


        }
    }
