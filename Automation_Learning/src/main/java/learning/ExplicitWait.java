package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ExplicitWait {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

         //wait our browser ot lod in selenium 3.141.59

         /*driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.MINUTES);
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.DAYS);*/

        //selenium 4.0 new implicit wait methods

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        System.out.println("to print the implicit wait --"+driver.manage().timeouts().getImplicitWaitTimeout());
        /*driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));
        driver.manage().timeouts().implicitlyWait(Duration.ofHours(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofNanos(50));*/

        //open the Amazon application
        driver.get("https://www.amazon.com");

        /*Explicit wait of selenium 3.1414.59

        WebDriverWait wait= new WebDriverWait(driver,120);*/

        //Selenium 4.0 explicit wait methods

        /*WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(50));
        WebDriverWait Wait2=new WebDriverWait(driver, Duration.ofDays(1));
        WebDriverWait Wait3=new WebDriverWait(driver, Duration.ofHours(1));*/

        WebDriverWait Wait =new WebDriverWait(driver, Duration.ofMinutes(1));

        WebElement SearchBar=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //Using explicit wait to find out the Web search bar in amazon application

        Wait.until(ExpectedConditions.visibilityOf(SearchBar));
        Wait.until(ExpectedConditions.elementToBeClickable(SearchBar)).click();
        SearchBar.sendKeys("Redmi");
        List<WebElement> AutoSuggestions = driver.findElements(By.xpath("//div[contains(text(),'redmi')]"));
        Wait.until(ExpectedConditions.visibilityOfAllElements(AutoSuggestions));

        System.out.println("Size of auto suggestion which are there --"+AutoSuggestions.size());
        String ExpectedAutoSuggestion = "REDMI 9";
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
        String RedmiPageTitle = "Amazon.com : redmi 9";
        String ActualRedmiPageTitle=driver.getTitle();
        if (Wait.until(ExpectedConditions.titleContains(ActualRedmiPageTitle))){
            System.out.println("User lands on Redmi 9 product listing page --"+RedmiPageTitle);
        }
        else {
            System.out.println("user unable to land on Redmi 9 home page--- "+ActualRedmiPageTitle);
        }
        driver.close();

    }
}

