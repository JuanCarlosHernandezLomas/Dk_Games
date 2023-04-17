package com.ti.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.framework.util.ui.WaitUtil.driver;

public class BuyPage {

    private By Seccion = By.xpath("//h3[contains(text(),\"Categoria\")]");
    private By Games= By.xpath("//a[text()=\" juegos\"]");
    private By Product = By.xpath("//a[text()=\"god of war ragnarok\"]");
    private By Car= By.xpath("//a[text()=' Agregar a compras']");
    private By Continuar = By.xpath("//a[text()=\"Continuar comprando\"]");
    private By Consolas = By.xpath("//a[text()=\" Consolas\"]");
    private By ProductC = By.xpath("//a[text()=\"Consola Estándar PlayStation 5 God of War Ragnärok\"]");
    private By Dalete = By.xpath("//input[@value=\"7\" ]");
    private By UpdateCar = By.name("submit");
    private By Bay = By.name("ordersubmit");
    private By Paypal= By.xpath("//span[text()=\"Pagar con \"]");
    private By Finalizar =By.xpath("//input[@value=\"CONTINUAR\"]");



    private void ButtonCategoryGames(){
        WebElement BtnGame = driver.findElement(Games);
        BtnGame.click();

    }
    private void ButtonProduct(){
        WebElement BtnProduct=driver.findElement(Product);
        BtnProduct.click();
    }

    private void ButtonCar(){

       WebElement BtnCar= driver.findElement(Car);
       BtnCar.click();
    }

    private void ButtonContinue(){
        WebElement BtnCont= driver.findElement(Continuar);
        BtnCont.click();
    }

    private void ButtonCategoryConsolas(){
        WebElement BtnConsolas = driver.findElement(Consolas);
        BtnConsolas.click();
    }

    private void ButtonProductConsolas(){
        WebElement BtnProduct= driver.findElement(ProductC);
        BtnProduct.click();

    }

    private void ButtonDelates(){
        WebElement BtnDelete = driver.findElement(Dalete);
        BtnDelete.click();
    }

    private void ButtonUpdate(){

       WebElement BtnUpCar= driver.findElement(UpdateCar);
       BtnUpCar.click();
    }

    private void ButtonBay(){
        WebElement BtnBay = driver.findElement(Bay);
        BtnBay.click();
    }

    private void ButtonPayPal(){
        WebElement BtnPaypal=driver.findElement(Paypal);
        BtnPaypal.click();
    }

    private void ButtonEndBuy(){
        WebElement BtnEndBay = driver.findElement(Finalizar);
        BtnEndBay.click();
    }

    public void BuyProduct() throws InterruptedException {
        ButtonCategoryGames();
        ButtonProduct();
        Thread.sleep(5000);
        ButtonCar();
        Thread.sleep(5000);
        ButtonContinue();
        ButtonCategoryConsolas();
        ButtonProductConsolas();
        Thread.sleep(5000);
        ButtonCar();
        ButtonDelates();
        Thread.sleep(5000);
        ButtonUpdate();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();
        ButtonBay();
        ButtonEndBuy();
        Thread.sleep(5000);

    }

}
