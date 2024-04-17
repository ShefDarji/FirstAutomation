package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.Driver;

public class Add_to_Cart  {
    protected static WebDriver driver;

    public static void clickElements(By by){
    driver.findElement(by).click();
    }
public static void typeText(By by, String text){
    driver.findElement(by).sendKeys(text);
}

    public static String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

public static void openBrowser(){
  driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.get("https://demo.nopcommerce.com/");
}
public static void closeBrowser(){
 driver.quit();
}

String expected = "Add to cart";

public static void main(String[] args) {
    //Open Browser and type url
    openBrowser();
    //click on electronics
    clickElements(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
    //click on camera
    clickElements(By.xpath(" //img[@title='Show products in category Camera & photo']"));
    //compare First products compare button
    String image1 = getTextFromElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[2]"));
    //compare Second products compare button
    String image2 = getTextFromElement(By.xpath("//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]"));

    //if both are same will enter the loop if not else will be executed
    if (image1 == image2) {
        System.out.println("There is a cart button");
    } else {
        System.out.println("Add to cart is missing");
    }

closeBrowser();
}}
