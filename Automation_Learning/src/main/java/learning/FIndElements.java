package learning;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FIndElements {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //open the Amazon application
        driver.get("https://www.amazon.com");
        String ExpectedTitle = "Amazon.com. Spend less. Smile more.";
        //to get the page title
        String ActualTitle=driver.getTitle();
        if (ActualTitle.equals(ExpectedTitle)){
            System.out.println("Expected page title is displayed-----"+ExpectedTitle);
        }
        else {
            System.out.println("Expected page title is not displayed -----" +ActualTitle);
        }
        Thread.sleep(2000);
        WebElement SearchBar=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        SearchBar.click();
        Thread.sleep(3000);
        SearchBar.sendKeys("Redmi");
        Thread.sleep(3000);
        List<WebElement> AutoSuggestions = driver.findElements(By.xpath("//div[contains(text(),'redmi')]"));
        Thread.sleep(3000);
        System.out.println("Size of auto suggestion which are there --"+AutoSuggestions.size());
        String ExpectedAutoSuggestion = "redmi 9";
         for (WebElement Auto:AutoSuggestions){
             String AutoText=Auto.getText();
             System.out.println("Auto suggestion texts---"+AutoText);
         }
        for (WebElement Auto2:AutoSuggestions){
            String AutoText=Auto2.getText();
            if (AutoText.equalsIgnoreCase(ExpectedAutoSuggestion)){
                Auto2.click();
                break;
            }
        }

        Thread.sleep(3000);
        String RedmiPageTitle = "Amazon.com : redmi 9";
         String ActualRedmiPageTitle=driver.getTitle();
         if (RedmiPageTitle.equals(ActualRedmiPageTitle)){
             System.out.println("User lands on Redmi 9 product listing page --"+RedmiPageTitle);
         }
         else {
             System.out.println("user unable to land on Redmi 9 home page--- "+ActualRedmiPageTitle);
         }
         driver.close();
    }
}
