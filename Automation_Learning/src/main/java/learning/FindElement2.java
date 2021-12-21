package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FindElement2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        //open the Udaan application
        driver.get("https://udaan.com/");
        //Find the login button
        WebElement LoginButton=driver.findElement(By.xpath("//div[text()='LOGIN']"));
        //click on login button
        LoginButton.click();
        //FInd the accept button
        WebElement AcceptButton =driver.findElement(By.xpath("//div[text()='Accept']"));
        /*WebElement CheckBox=driver.findElement(By.xpath("//div[contains(text(),'WhatsApp')]/following::div[1]"));
        System.out.println("Check box is selected--" +CheckBox.isSelected());
        driver.close();*/
        //click on accept button
        AcceptButton.click();
        //FInd the continue button
        WebElement ContinueButton=driver.findElement(By.xpath("//div[text()='Continue']"));
        //Click on continue button
        ContinueButton.click();
        //Find out the mobile number text filed
        WebElement MobileNumber=driver.findElement(By.xpath("//div[text()='Mobile Number']/following::input[@id='mobileNumber']"));
        //to get the mobile number element
       WebElement MobileText=driver.findElement(By.xpath("//div[text()='Enter Mobile Number']"));
       //to get the text of the element
       String MobileNumberTEXT=MobileText.getText();
       System.out.println(MobileNumberTEXT);
       //verify whether the mobile number text filed is displayed or not
        System.out.println("Mobile number text filed is present--"+MobileNumber.isDisplayed());

        //verify whether the mobile number text filed is enabled
        System.out.println("Mobile number text filed is enabled --"+MobileNumber.isEnabled());

       //verify whether the submit button is enabled or disabled
        WebElement GetVerificationCode=driver.findElement(By.xpath("//div[text()='Get Verification Code']/../.."));
        GetVerificationCode.click();
        //System.out.println("Submit button is disabled --"+GetVerificationCode.isEnabled());
        //Enter mobile number
        MobileNumber.sendKeys("1110000006");
        GetVerificationCode.click();
        Thread.sleep(3000);
        WebElement OTPTextFiled =driver.findElement(By.xpath(" //input[@id='otp']"));
        OTPTextFiled.sendKeys("173131");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='Submit']")).click();
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

