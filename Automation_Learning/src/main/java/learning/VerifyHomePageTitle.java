package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VerifyHomePageTitle {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //maximise the window
        driver.manage().window().maximize();
        //make browser to wait till the application to load
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //open the udaan application
        driver.get("https://udaan.com/");
        //page title
        String ExpectedTitle = "Udaan - B2B Buying for Retailers";
        //to get the page title
        String ActualTitle=driver.getTitle();
        if (ActualTitle.equals(ExpectedTitle)){
            System.out.println("Expected page title is displayed  "+ExpectedTitle);
        }
        else {
            System.out.println("Expected page title is not displayed " +ActualTitle);
        }
        driver.close();
    }
}
