package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FileUploadPopUp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://www.naukri.com/");
        Thread.sleep(2000);
        WebElement uploadFIle=driver.findElement(By.xpath("//label[@id='wdgt-file-upload']"));
        uploadFIle.click();
        uploadFIle.sendKeys("C:\\Users\\Qapitol QA\\Page Object Model");
        Thread.sleep(4000);
        /*driver.findElement(By.xpath("//button[@ng-click='item.upload()']")).click();
        Thread.sleep(2000);*/
        driver.quit();

    }
}
