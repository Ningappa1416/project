package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Frames {
        public static void main(String[] args) throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            driver.get("file:///C:/Users/Qapitol%20QA/Pictures/page.html");
            //navigating to first frame by using index of the frame
            driver.switchTo().frame(0);
            /*driver.navigate().refresh();

            //Navigating to first frame by name
            driver.switchTo().frame("iframe1");
            driver.navigate().refresh();

            //Navigating to first frame by ID
            driver.switchTo().frame("IF1");
            driver.navigate().refresh();*/

            WebElement ContactUs=driver.findElement(By.xpath("//a[text()='Contact us']"));
            ContactUs.click();
            Thread.sleep(5000);

            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//input[@id='Naveen']")).sendKeys("1234567890");
            Thread.sleep(5000);

           /* Navigating to first frame by using WebElement
            driver.switchTo().frame(ContactUs);*/
            ContactUs.click();
            Thread.sleep(5000);
            driver.close();
        }
}
