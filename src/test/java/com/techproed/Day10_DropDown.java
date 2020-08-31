package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        select.selectByVisibleText("Baby");

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        select.selectByValue("search-alias=automotive-intl-ship");


        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        select.selectByIndex(5);

        //Sectigimiz katogoriyi ekrana yazdirabiliriz  en son secilen 5=books tu onu yazdirir
        WebElement options=select.getFirstSelectedOption();
        System.out.println(options.getText());

        List<WebElement>list= select.getOptions();//tum elemanlari ekrana yazdirabiliriz
        for (WebElement w: list){
            System.out.println(w.getText());
        }

        int toplamseceneksayisi=list.size();

    }

}
