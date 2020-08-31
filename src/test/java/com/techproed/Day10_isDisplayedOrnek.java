package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {
     static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Before
    public void testtenOnce(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://bestbuy.com");
    }
    @After
    public void testtenSonra(){
        driver.quit();
    }
    @Test
    public void test1() {
        String title = driver.getTitle();
        boolean iceriyormu=title.contains("Best");
        Assert.assertTrue(iceriyormu);

    }
    @Test
    public void logotest2() {
        WebElement logo = driver.findElement(By.className("logo"));
        boolean gorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(gorunuyorMu);
    }
    @Test
    public void test3() {
        WebElement logo = driver.findElement(By.partialLinkText("Mexico"));
        boolean gorunuyorMu = logo.isDisplayed();
        Assert.assertTrue(gorunuyorMu);

    }
    }




