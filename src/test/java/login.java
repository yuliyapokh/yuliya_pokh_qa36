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
    public void ccsLocatorsTest()
    {
        // нужно перейти на страницу логина, так как на главной странице мало элементов для поиска и тренировки
        // переход на страницу логина тут:
        wd.findElement(By.linkText("LOGIN")).click();

        // На странице логин найти несколько элементов по их  tagname

        wd.findElement(By.tagName("div"));
        WebElement el4 = wd.findElement(By.cssSelector("[name='email']"));
        WebElement el5 = wd.findElement(By.cssSelector("[name='password']"));

        // ON Login PAGE find some elements by class
        wd.findElement(By.cssSelector(".active"));

        // На странице логин найти несколько элементов по их  attribute
        wd.findElement(By.cssSelector("[aria-current='page']"));
        wd.findElement(By.cssSelector("[placeholder='Email']"));
        wd.findElement(By.cssSelector("[placeholder='Password']"));

        //На странице логин найти  элемент с  атрибутом placeholder, значение которого начинается на "Pass"
        WebElement el1 = wd.findElement(By.cssSelector("[placeholder ^='Pass']"));
        //На странице логин найти  элемент с  атрибутом placeholder, значение которого  начинается на  "ass"
        WebElement el2 = wd.findElement(By.cssSelector("[placeholder ^='ass']"));
        //На странице логин найти  элемент с  атрибутом placeholder, значение которого заканчивается на "ord"
        WebElement el3 = wd.findElement(By.cssSelector("[placeholder $='ord']"));

        // Объединение !!
        //найти элемент div, у которого есть id со значением "root"  и класс со значением container
        WebElement el6 = wd.findElement(By.cssSelector("div#root.container"));
        // найти элемент а, у которого есть атрибут href со значением /login
        WebElement el7 = wd.findElement(By.cssSelector("a[href='/login']"));
        // найти элемент input, у которого есть атрибут name cо значением email
        WebElement el8 = wd.findElement(By.cssSelector("input[name='email']"));
        // найти элемент button, у которого есть атрибут name cо значением login
        WebElement el9 = wd.findElement(By.cssSelector("button[name='login']"));


    }

   // @AfterMethod
   // public void postCondition(){
        //close browser
    }

