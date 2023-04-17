package com.ti.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.example.framework.util.ui.WaitUtil.driver;

public class FollowOrder {

    private By Count = By.xpath("//a[text()=\"Mi cuenta\"]");

    private By Order = By.xpath("//a[text()=\"Historial de Orden\"]");




    private void ButtonClickCount(){
        WebElement BtnCount= driver.findElement(Count);
        BtnCount.click();
    }

    private void ButtonClickOrder(){
        WebElement BtnOreden = driver.findElement(Order);
        BtnOreden.click();
    }


    public void CheckOrder() throws InterruptedException {
        ButtonClickCount();
        ButtonClickOrder();
        Thread.sleep(5000);
    }
}
