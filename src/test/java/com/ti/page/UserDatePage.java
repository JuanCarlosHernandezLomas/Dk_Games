package com.ti.page;

import org.example.framework.util.ui.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.example.framework.util.ui.WaitUtil.driver;

public class UserDatePage {

    private By Adress = By.name("billingaddress");
    private By States = By.id("bilingstate");
    private By Citys = By.id("billingcity");
    private By Codes = By.id("billingpincode");

    private By ShippinAdres = By.name("shippingaddress");
    private By ShippinState = By.name("shippingstate");
    private By ShippinCity = By.name("shippingcity");
    private By ShippinCode = By.name("shippingpincode");



    public void setTxtAdress(String Adres){
        WebElement txtAdress = driver.findElement(Adress);
        txtAdress.clear();
        txtAdress.sendKeys(Adres);

    }
    public void setTxtState(String State){
        WebElement txtState = driver.findElement(States);
        txtState.clear();
        txtState.sendKeys(State);

    }
    public void setTxtCity(String City){
        WebElement txtCity = driver.findElement(Citys);
        txtCity.clear();
        txtCity.sendKeys(City);

    }
    public void setTxtCode(String Code){
        WebElement txtCode = driver.findElement(Codes);
        txtCode.clear();
        txtCode.sendKeys(Code);

    }
    public void setTxtShippinAdres(String Adress){
        WebElement txtShiAdres = driver.findElement(ShippinAdres);
        txtShiAdres.clear();
        txtShiAdres.sendKeys(Adress);

    }
    public void setTxtShippinState(String State){
        WebElement txtShiState = driver.findElement(ShippinState);
        txtShiState.clear();
        txtShiState.sendKeys(State);

    }
    public void setTxtShippinCity(String City){
        WebElement txtShiCity = driver.findElement(ShippinCity);
        txtShiCity.clear();
        txtShiCity.sendKeys(City);

    }
    public void setTxtShippinCode(String Code) {
        WebElement txtShiCode= driver.findElement(ShippinCode);
        txtShiCode.clear();
        txtShiCode.sendKeys(Code);
    }
    public void UserAddress(String addres, String state, String city,String code) throws InterruptedException {
        setTxtAdress(addres);
        setTxtState(state);
        setTxtCity(city);
        setTxtCode(code);
        Thread.sleep(500);
        driver.findElement(By.name("update")).click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(500);
    }

    public void ShippingAddress(String shippinaddress,String shippingstate,String shippingcity,String shippingcode) throws InterruptedException {

        driver.findElement(By.xpath("//h4[@class='unicase-checkout-title']/a/span[text()='2']")).click();
        Thread.sleep(1000);
        setTxtShippinAdres(shippinaddress);
        setTxtShippinState(shippingstate);
        setTxtShippinCity(shippingcity);
        setTxtShippinCode(shippingcode);
        driver.findElement(By.name("shipupdate")).click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(500);
        driver.findElement(By.linkText("Dk games")).click();
        Thread.sleep(500);

    }
}
