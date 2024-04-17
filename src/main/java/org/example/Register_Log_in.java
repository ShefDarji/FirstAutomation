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

public class Register_Log_in {
//To verify user should be successfully Registered
    protected static WebDriver driver;
   static String expected = "Your registration completed";
public static void openBrowser(){
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://demo.nopcommerce.com/");
}
public static void closeBrowser(){

    driver.quit();
}
public static void clickElements(By by){

    driver.findElement(by).click();
}
public static void typeText(By by, String text){

    driver.findElement(by).sendKeys(text);
}
public static String randomDate(){
    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");
    Date date = new Date();
    return dateFormat.format(date);
}
public static String getTextFromElement(By by){
  return driver.findElement(by).getText();
}

//@Test
public static void main (String[]args){
//open browser and type url
openBrowser();
//click on register on home page
clickElements(By.className("ico-register"));
//type first name as Jamie
typeText(By.id("FirstName"),"Jamie");
//type last name as Sons
typeText(By.id("LastName"),"Sons");
//type email id as jamiesons007@yahoo.com along with date&time
typeText(By.name("Email"),"jamiesons007"+ randomDate() + "@yahoo.com");
//type password as jamie007
typeText(By.name("Password"),"jamie007");
//confirm password as jamie007
typeText(By.name("ConfirmPassword"),"jamie007");
//click on register
clickElements(By.name("register-button"));
//confirm the Actual msg with Expected Msg
 String actual = getTextFromElement(By.className("result"));
//Syntax to find Actual = Expected
Assert.assertEquals(actual,expected,"Registration is not completed" );
closeBrowser();
}

}
