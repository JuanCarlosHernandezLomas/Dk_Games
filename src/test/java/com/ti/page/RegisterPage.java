package com.ti.page;

import org.openqa.selenium.By;


import static org.example.framework.util.ui.WaitUtil.driver;


public class RegisterPage  {


    private By ButtonInicio = By.xpath("//*[contains(text(),\"Iniciar sesión\")]");
    private  By txtNameUser = By.name("fullname");
    private  By txtUserEmail = By.name("emailid");
    private By txtPhone =By.name("contactno");
    private  By txtUserPassword = By.id("password");
    private  By txtConPassword = By.id("confirmpassword");
    private  By ButtonSubmit =By.name("submit");

    private void clickInicio(){
        driver.findElement(ButtonInicio).click();
    }

    private void setTxtNameUser(String username){
        driver.findElement(txtNameUser).clear();
        driver.findElement(txtNameUser).sendKeys(username);

    }

    private void setTxtUserEmail(String emailuser){
        driver.findElement(txtUserEmail).clear();
        driver.findElement(txtUserEmail).sendKeys(emailuser);

    }

    private void setTxtPhone(String phone){
        driver.findElement(txtPhone).clear();
        driver.findElement(txtPhone).sendKeys(phone);
    }
    private void setTxtUserPassword(String password,String conpassword){
        driver.findElement(txtUserPassword).clear();
        driver.findElement(txtUserPassword).sendKeys(password);
        driver.findElement(txtConPassword).clear();
        driver.findElement(txtConPassword).sendKeys(conpassword);
    }
    private void clickRegister(){
        driver.findElement(ButtonSubmit).click();
    }
    public void RegisterUser(String name,  String email,String phone,String password,String conpassword) throws InterruptedException {
        clickInicio();
        setTxtNameUser(name);
        setTxtUserEmail(email);
        setTxtPhone(phone);
        setTxtUserPassword(password,conpassword);
        clickRegister();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Thread.sleep(500);

    }

}
