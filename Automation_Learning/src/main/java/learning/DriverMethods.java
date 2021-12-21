package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //open the Udaan application
        driver.get("https://www.naukri.com");
        //TO get the page title
        String PageTitle=driver.getTitle();
        System.out.println(PageTitle);
        //to check current window URL
        String URL=driver.getCurrentUrl();
        System.out.println(URL);
        //to get the session id of the current window
       /* String parentSessionID =driver.getWindowHandle();
        System.out.println(parentSessionID);*/
        Set<String> ChildSessionID = driver.getWindowHandles();
        System.out.println(ChildSessionID);

        //to access the single element from set of collections

        for(String SessionID:ChildSessionID){
            //Switch to specific window
            driver.switchTo().window(SessionID);
            //get the specific window title
           String  Title=driver.getTitle();
           System.out.println(Title);
           //close each and every browser after getting the title of the page
           //driver.close();
            //close only cognizant window
            if (Title.equals("Cognizant")){
                driver.close();
            }
        }
        //driver.quit();

    }
}
