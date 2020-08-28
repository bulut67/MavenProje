package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class Day08_IkinciOrnek {

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }



    @Before
    public void methoddanOnce(){
        driver.get("http://google.com");
    }

    @Test
    public void test1(){
        WebElement searchBox= driver.findElement(By.name("q"));
        searchBox.sendKeys("samsung kulaklik"+Keys.ENTER);
    }

    @Test
    public void test2(){
        WebElement searchBox= driver.findElement(By.name("q"));
        searchBox.sendKeys("mackolik"+Keys.ENTER);
    }


    @Test
    public void test3(){
        WebElement searchBox= driver.findElement(By.name("q"));
        searchBox.sendKeys("gittigidiyor"+ Keys.ENTER);
    }


    @After
    public void methoddanSonra(){
        WebElement sonucSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisi.getText());
    }
}
