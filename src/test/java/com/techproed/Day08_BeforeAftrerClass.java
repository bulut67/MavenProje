package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_BeforeAftrerClass {


    @BeforeClass
    public static void setUp(){
        System.out.println("SetUp calisti");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("tearDown calisti");
    }


    @Test
    public void test1() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://google.com");
        driver.quit();
    }

    @Test
    public void test2(){
        System.out.println("2'inci  test calisti");
}



}
