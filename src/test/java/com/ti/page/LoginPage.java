package com.ti.page;

import org.example.framework.base.DriverFactory;
import org.example.framework.util.ui.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.example.framework.util.ui.WaitUtil.driver;


public class LoginPage  {


    private By  Inicio = By.xpath("//*[contains(text(),\"Iniciar sesión\")]");
    private By Email= By.name("email");
    private By Password= By.name("password");
    private By Login= By.name("login");


    private void clickInicio(){
        WebElement BtnInicio = driver.findElement(Inicio);
        BtnInicio.click();
    }
    private void setTxtEmail(String useremail){
        WebElement txtEmail= driver.findElement(Email);
        txtEmail.clear();
        txtEmail.sendKeys(useremail);
    }


    private void setTxtPassword(String userpassword){
        WebElement txtPassword = driver.findElement(Password);
         txtPassword.clear();
        txtPassword.sendKeys(userpassword);

    }

    private void clickLogin(){

        WebElement BtnLogin =
        driver.findElement(Login);
        BtnLogin.click();
    }



    public void  LoginUser(String useremail, String userpassword) throws InterruptedException {
        clickInicio();
        setTxtEmail(useremail);
        setTxtPassword(userpassword);
        Thread.sleep(5000);
        clickLogin();

    }


}
