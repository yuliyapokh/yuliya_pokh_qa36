import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Registration {

    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
        wd = new ChromeDriver();
        wd.get("https://telranedu.web.app/");
    }

    @Test

    public void registrationSuccess(){
        WebElement registration = wd.findElement(By.linkText("LOGIN"));
        registration.click();

        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("pokhy@i22.ua");

        WebElement pass = wd.findElement(By.name("password"));
        pass.click();
        pass.clear();
        pass.sendKeys("Jjp12345!");



        List<WebElement> reg = wd.findElements(By.tagName("button"));
        WebElement buttonRegistration = reg.get(1);
        buttonRegistration.click();



    }

}
