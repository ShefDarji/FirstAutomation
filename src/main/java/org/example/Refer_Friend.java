package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Refer_Friend {
    //To verify user should be successfully Registered and Refer a product to a friend
    protected static WebDriver driver;
    static String expected = "Your registration completed";

    public static void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public static void clickElements(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static String randomDate() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }


    public static void main(String[] args) {
        //open browser and type url
        openBrowser();
        //click on register on home page
        clickElements(By.className("ico-register"));
        //type first name as Jamie
        typeText(By.id("FirstName"), "Jamie");
        //type last name as Sons
        typeText(By.id("LastName"), "Sons");
        //type email id as jamiesons007@yahoo.com along with date&time
        typeText(By.name("Email"), "jamiesons007" + randomDate() + "@yahoo.com");
        //type password as jamie007
        typeText(By.name("Password"), "jamie007");
        //confirm password as jamie007
        typeText(By.name("ConfirmPassword"), "jamie007");
        //click on register
        clickElements(By.name("register-button"));
        //confirm the Actual msg with Expected Msg
        String actual = getTextFromElement(By.className("result"));
        //Syntax to find Actual = Expected
        Assert.assertEquals(actual, expected, "Registration is not completed");
        //click on continue tab
        clickElements(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/a[1]"));
        //Click on Electronics
        clickElements(By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        //click on camera
        clickElements(By.xpath("//img[@title='Show products in category Camera & photo']"));
        //click on the product you want to refer
        clickElements(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        //click email a friend
        clickElements(By.xpath("//button[normalize-space()='Email a friend']"));
        //enter friends email
        typeText(By.xpath("//input[@id='FriendEmail']"),"jems" + randomDate() +"@gmail.com");
        //enter your email
        typeText(By.xpath("//input[@id='YourEmailAddress']"),"jamiesons007" + randomDate()+"@yahoo.com");
        //enter text
        typeText(By.xpath("//textarea[@id='PersonalMessage']"),"This product is really good and buy this");
        //click on send email
        clickElements(By.name("send-email"));
        closeBrowser();
    }

}


