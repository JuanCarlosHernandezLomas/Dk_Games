package com.ti.test;

import com.ti.testdata.DataClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.example.framework.util.extentreports.ExtentTestManager.startTest;
import static org.example.framework.util.ui.WaitUtil.driver;

public class LoginTest extends BaseTest{

    @Test
    void LoginDate( Method method) throws InterruptedException {
        startTest(method.getName(),"Logeo de usuarios");
        Login();
        Assert.assertTrue(driver.getTitle().contains("Mi cuenta"));
        WebElement inicio = driver.findElement(By.xpath("//a[contains(text(), \"Bienvenido -Yahaira\")]"));
        WebElement close = driver.findElement(By.xpath("//a[contains(text(),\"Cerrar sesión\")]"));
        Assert.assertTrue(inicio.getText().equals("Bienvenido -Yahaira"));
        Assert.assertEquals(close.getText(),"Cerrar sesión","esto tiene que ser igual ");


    }
}
