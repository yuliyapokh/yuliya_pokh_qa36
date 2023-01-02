import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Index
{
    WebDriver wd;

    @BeforeMethod
    public void starting(){
        wd = new ChromeDriver();
        wd.get("file:///Users/yuliyapokh/Downloads/index.html");
        wd.manage().window().maximize();
    }



    @Test
    public void itemsTests(){
        // find Item1 & click() ===> assert that "div-alert" contains message  "Clicked by Item 1"
        WebElement item1 = wd.findElement(By.cssSelector("[href='#item1']"));
        item1.click();
        WebElement divAlert = wd.findElement(By.cssSelector("#alert"));
        String text1 = divAlert.getText();
        Assert.assertTrue(text1.contains("Clicked by Item 1"));

        // find Item3 & click() ===> assert that "div-alert" contains message  "Clicked by Item 3"
        WebElement item3 = wd.findElement(By.cssSelector("[href='#item3']"));
        item3.click();
        WebElement divAlert1 = wd.findElement(By.cssSelector("#alert"));
        String text2 = divAlert1.getText();
        Assert.assertTrue(text2.contains("Clicked by Item 3"));

    }


    @Test
    public void formTests(){
        // fill name & fill surename & click send
        WebElement element = wd.findElement(By.cssSelector("[name='name']"));
        element.click();
        element.clear();
        element.sendKeys("Yuliya");
        WebElement element1 = wd.findElement(By.cssSelector("[name='surename']"));
        element1.click();
        element1.clear();
        element1.sendKeys("Pokh");
        WebElement btnSend = wd.findElement(By.cssSelector(".btn"));
        btnSend.click();

        // Assert that "div-alert" contains text with name + surename
        WebElement divAlert2 = wd.findElement(By.cssSelector("#alert"));
        String text3 = divAlert2.getText();
        Assert.assertTrue(text3.contains("Yuliya Pokh"));

    }






    @Test
    public void tableTest(){
        //правда ли в таблице 4 строки
        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        Assert.assertEquals(rows.size(),4);

        //последняя строка содержит Mexico?
        WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
        String text =  lastRow.getText();
        System.out.println(text);
        //Poland Chine Mexico contains Mexico
        Assert.assertTrue(text.contains("Mexico"));
        //последняя ячейка содержит Mexico
        WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child td:last-child"));
        String str = lastCell.getText();
        Assert.assertTrue(str.contains("Mexico"));





    }

}
