package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpFunctions {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        WebDriverWait Wait= new WebDriverWait(driver,Duration.ofMinutes(1));
        //open the application
        driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");
        //to find the say my name button and tap on it
        driver.findElement(By.xpath("//input[@value='Say my name!']")).click();

        //navigate to the prompt po-up and set/pass the name the name string
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(200);
        driver.switchTo().alert().sendKeys("Naveen");
        Thread.sleep(200);
        //after entering the name click on ok on the pop-up to handle it
        driver.switchTo().alert().accept();
        //driver.switchTo().alert().dismiss();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(200);
        //handle alert pop-up by using driver driver.switchTo method
        //driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();


        driver.close();
    }
}
