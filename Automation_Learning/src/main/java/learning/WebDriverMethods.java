package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //maximise the window
        driver.manage().window().maximize();
        //make browser to wait till the application to load
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //open the udaan application
        driver.get("https://www.naukri.com");
        //Method to get the page title
        String PageTitle = driver.getTitle();
        //print he page tile to verify
        System.out.println(PageTitle);
        /*//Method to get the page source code
        String PageSource = driver.getPageSource();
        //print the page source code
        System.out.println(PageSource);*/
        //Method to verify the URL
        String url=driver.getCurrentUrl();
        //Print the url of the current window
        System.out.println(url);
        //Method to get the session id of the windows
        String SessionId=driver.getWindowHandle();
        //print the session id
        System.out.println(SessionId);
        Set<String> SessionId2=driver.getWindowHandles();
        //print the session id
        System.out.println(SessionId2);
        //For each loop which is used to access the list of collection
        for (String childWindow:SessionId2){

            driver.switchTo().window(childWindow);

            String TitleOFChildWindow =driver.getTitle();
            System.out.println(TitleOFChildWindow);
            //it will close all the child window
             driver.close();
            //CLose only parent window
            driver.switchTo().window(SessionId);
        }
        //driver.quit();
        driver.close();
    }
}
