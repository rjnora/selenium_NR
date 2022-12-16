package demo.spring.selenium.pages;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login {
    WebDriver driver;

    @BeforeEach
    public void prepareBrowser(){
//        WebDriverManager.firefoxdriver().setup();
//        driver = new FirefoxDriver();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    void testLogin(){
        //Exercise
        driver.get("https://portaldev.ahm.co.id/jx02/ahmipdsh000-pst/login.htm");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Verify Page Login
        String getData = driver.findElement(By.xpath("//*[@id=\"helperLinks\"]/center/div")).getText();
        Assert.assertTrue(getData.contains("PT Astra Honda Motor"));

        //input login
        driver.findElement(By.name("username_login")).sendKeys("m.dummy.i0");
        driver.findElement(By.name("password_login")).sendKeys("Honda2020!");

        //click login button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[4]/button")).click();

        //verify error
//       Assert.assertEquals(driver.findElement(By.id("error-login")).getText(),"Invalid username / password");

        //verify login
        String getHome = driver.findElement(By.xpath("//*[@id=\"default_home\"]/div[1]/div/div[2]/div[1]/div[2]/h3")).getText();
        Assert.assertTrue(getHome.contains("Announcement"));
    }

    @Test
    void testSearching(){
        testLogin();

        //searching apps
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/input")).sendKeys("AHMFASCP002");
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"ahmdsh1_menu_ul\"]/li[14]/ul/li[1]/ul/li[1]/a/div")).click();
        driver.findElement(By.xpath("//*[@id=\"tablink_AHMFASCP002\"]/a[1]")).isDisplayed();

//        String getHeaderSCP002 = driver.findElement(By.xpath("//*[@id=\"tablink_AHMFASCP002\"]/a[1]")).getText();
//        Assert.assertTrue(getHeaderSCP002.contains("Monitoring SC Transaction"));
//        driver.findElement(By.xpath("//*[@id=\"AHMFASCP002_P01_FilterTransferDateStart\"]")).sendKeys("01-Sep-2022");
        driver.findElement(By.id("AHMFASCP002_P01_FilterTransferDateStart")).sendKeys("01-Sep-2022");
        driver.findElement(By.id("AHMFASCP002_P01_FilterTransferDateEnd")).sendKeys("30-Sep-2022");
        driver.findElement(By.xpath("//*[@id=\"AHMFASCP002_P01_PageMain\"]/div/div[1]/div[3]/div/button[1]")).click();

        WebElement loading = driver.findElement(By.xpath("//*[@id=\"AHMFASCP002_P00ViewTableContainer\"]/div[1]/idv[2]/div[2]/div"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOf(loading));
    }
}