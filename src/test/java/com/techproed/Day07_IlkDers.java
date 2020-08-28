package com.techproed;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.amazon.com/");

        WebElement searchBox= driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("samsung headphones"+ Keys.ENTER);
        //searchBox.submit(); bunun benzeri yukarida


        WebElement Write = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        System.out.println(Write.getText());


        WebElement first = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
      //  first.click();

        List<WebElement> listem=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement w: listem){
            System.out.println(w.getText());
        }


    }
}
