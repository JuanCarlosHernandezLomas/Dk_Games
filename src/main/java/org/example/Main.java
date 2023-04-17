package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Main {
    private static Logger log = LogManager.getLogger(Main.class.getName());
    static WebDriver driver;
    static String URL = "http://hottgamess.ga";
    static WebDriverWait wait;
    JavascriptExecutor js;

    private void highLight(WebElement element) {
        js = (JavascriptExecutor) driver;
        for (byte iCnt = 0; iCnt < 3; iCnt++) {
            try {
                js.executeScript("arguments[0].setAttribute('style','background:red')", element);
                Thread.sleep(500);
                js.executeScript("arguments[0].setAttribute('style','background:')", element);

            } catch (JavascriptException jse) {
                System.err.println("Class: EjemploJavaScript | Method: highLight | Exception dec: " + jse.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @BeforeTest()
    void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        log.info("Opening Website : " +URL);

    }

    @AfterTest()
    void closeBrowser() {
        driver.quit();
    }

    @Test()
    void testRegister() {
        try {
            WebElement Register = driver.findElement(By.xpath("//*[contains(text(),\"Iniciar sesión\")]"));
            highLight(Register);
            Register.click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("fullname"))));
            WebElement txtName = driver.findElement(By.name("fullname"));
            highLight(txtName);
            txtName.clear();
            txtName.sendKeys("pedro");

            WebElement txtEmail = driver.findElement(By.name("emailid"));
            highLight(txtEmail);
            txtEmail.clear();
            txtEmail.sendKeys("pedro@gmail.com");
            WebElement txtContacto = driver.findElement(By.name("contactno"));

            txtContacto.clear();
            txtContacto.sendKeys("4494131537");
            WebElement txtPass = driver.findElement(By.id("password"));
            txtPass.clear();
            txtPass.sendKeys("lomas");
            WebElement txtPassCon = driver.findElement(By.name("confirmpassword"));
            txtPassCon.clear();
            txtPassCon.sendKeys("lomas");
            driver.findElement(By.linkText("¿Olvidaste tu contraseña?")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//H4[contains(text(),\"Recuperar contraseñ\")]"))));



        }catch(NoSuchElementException e){
            System.err.println("El elemento no se econtro; " +e.getMessage());

        }catch (TimeoutException ti){
            System.err.println("El tiempo de espera se extendio: "+ti.getMessage());

        }

}
}
