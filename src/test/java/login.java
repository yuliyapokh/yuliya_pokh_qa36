import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class login {
    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
        //open browser
        wd = new ChromeDriver();
        //open site
        wd.get("https://telranedu.web.app/");
    }



    @Test
    public void findElementsOnPage(){
        //by tagName
       WebElement element =  wd.findElement(By.tagName("div"));
       List<WebElement> divs = wd.findElements(By.tagName("div"));

       //by id
        WebElement el1 = wd.findElement(By.id("root"));

        //by class
        WebElement el2 = wd.findElement(By.className("container"));

        //by linkText a href
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));

    }



    @Test
    public void loginSuccess(){
        //open form
        //wd find item + click

        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();

        //fill form
        //find email + click+ clear + type

        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("pokhy@i22.ua");

        //find password + click+ clear + type
        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("Jjp12345!");


        //submit form
        //find button login + click
        List<WebElement>buttons = wd.findElements(By.tagName("button"));
        WebElement buttonLogin = buttons.get(0);
        buttonLogin.click();


        Assert.assertEquals("", "");
        //ac==exp
    }



    

    @Test
    public void registrationSuccess(){


    }

   // @AfterMethod
   // public void postCondition(){
        //close browser
    }

