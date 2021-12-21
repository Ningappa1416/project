package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NavigationMethods {
    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //driver.get("https://udaan.com/");
        driver.navigate().to("https://udaan.com/");
        driver.navigate().forward();
        driver.navigate().to("https://fast.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.close();
    }
}
