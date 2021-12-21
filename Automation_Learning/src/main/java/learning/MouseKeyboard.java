package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.time.Duration;

public class MouseKeyboard {
    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://www.facebook.com");
        WebDriverWait Wait =new WebDriverWait(driver, Duration.ofMinutes(1));
        WebElement USN=driver.findElement(By.xpath("//input[@id='email']"));
        WebElement PWD=driver.findElement(By.xpath("//input[@id='pass']"));
        USN.sendKeys("9731211804");
        String UserName=USN.getText();
        //Robot class object creating

        Robot rbt= new Robot();
        //copying the data from mobile number text filed
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_A);
        System.out.println("username Selected from user name text filed---"+UserName);
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_C);
        System.out.println("username copied from user name text filed---"+UserName);
        rbt.keyRelease(KeyEvent.VK_A);
        rbt.keyRelease(KeyEvent.VK_C);

        //pasting the data on pwd tex filed from mobile number text filed

        Wait.until(ExpectedConditions.elementToBeClickable(PWD));
        Thread.sleep(5000);
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_V);;
        System.out.println("username pasted on the password text filed---"+UserName);
        rbt.keyRelease(KeyEvent.VK_V);

        //mouse actions

        rbt.mouseMove(300,500);
        driver.close();

    }
}