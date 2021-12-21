package learning;

import com.sun.glass.ui.Window;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class Locators {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://www.selenium.dev/");
        WebDriverWait Wait =new WebDriverWait(driver, Duration.ofMinutes(1));
       WebElement CarearLinkText=driver.findElement(By.xpath("//h4[text()='Announcing Selenium 4']"));
       int XPoint=CarearLinkText.getLocation().getX();
       int YPoint = CarearLinkText.getLocation().getY();
       System.out.println(YPoint);
       System.out.println(XPoint);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Thread.sleep(5000);

        js.executeScript("window.scrollBy("+XPoint+","+YPoint+")",CarearLinkText);
        //js.executeScript("Window.scrollBy(48,1760)",CarearLinkText);
        Thread.sleep(5000);

        /*Creating the object of chrome class and accessing chrome libraries
        ChromeDriver ChromeDriver=new ChromeDriver();*/

       /* Upcasting Creating the object of chrome class and upcasting to SearchContext class and accessing libraries of it
        SearchContext SearchContextDriver=new ChromeDriver();*/

       /* DownCasting to chrome driver class and access the chrome driver class libraries
        ChromeDriver DownCasting=(ChromeDriver)SearchContextDriver;*/
        driver.close();


    }
}
