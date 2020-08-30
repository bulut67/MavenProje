package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_Assertion {
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
    @Test
    public  void  test1(){
        driver.get("http://google.com");
        String googleTittle =driver.getTitle();

        //Test Case: Google.com'un basligi "Google Arama sayfasi" olsun
        //Google'in title'i "Google arama sayfasi'na esit mi ,degil mi?

        Assert.assertEquals("Google Arama sayfasi",googleTittle);

    }

    @Test
    public  void  test2(){
        driver.get("http://amazon.com");
        //Amazon.com'un basligi Amazon kelimsini iceriyor olsun
        String amazonTitle=driver.getTitle();

        boolean iceriyorMu=amazonTitle.contains("Amazon");//true or false
        //Bunun true oldugunu dogrula demek
        //boolean veri type'inde bir deger giriyoruz
        Assert.assertTrue(iceriyorMu);



    }

    @Test
    public  void  test3(){
        driver.get("http://facebook.com");
        String faceTitle=driver.getTitle();
        boolean iceriyorMu=faceTitle.contains("Youtube");
        //Bunun false oldugunu dogrula demek yani testimiz basarili demek
        Assert.assertFalse(iceriyorMu);
    }

    @Test
    public  void  test4(){
        driver.get("http://google.com");
        String title=driver.getTitle();
        System.out.println("Merhabalar");

        Assert.assertEquals("Google arama sayfasi",title);
        //Eger testiniz basarisizsa kalan satirlari yazdirmaz

    }

    @Test
    public  void  test5(){
        driver.get("http://facebook.com");
        String faceTitle=driver.getTitle();
        boolean iceriyorMu=faceTitle.contains("Youtube");
        //Bunun false oldugunu dogrula demek yani testimiz basarili demek
        Assert.assertFalse(iceriyorMu);
    }
}
