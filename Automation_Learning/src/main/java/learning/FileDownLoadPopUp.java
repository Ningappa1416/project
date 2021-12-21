package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.HashMap;

import static io.ous.jtoml.impl.Token.TokenType.Key;

public class FileDownLoadPopUp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
       //Create Hashmap object and assign the profile settings
        HashMap<String, Object> chromePrefs = new HashMap<String,Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", "D:\\");
        //Assign this chromePrefs object with ChromeOptions object
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        //Create Capability object and assign the option object
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(cap);
        driver.get(" http://www.seleniumhq.org/download/ ");
        Thread.sleep(3000);
        String xp = "//td[.='Java']/following-sibling::td/a[.='Download']";
        driver.findElement(By.xpath(xp)).click();
    }
}
