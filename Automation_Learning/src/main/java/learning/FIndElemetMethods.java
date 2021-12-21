package learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FIndElemetMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
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
       //click on accpet button
       AcceptButton.click();
       //FInd the continue button
       WebElement ContinueButton=driver.findElement(By.xpath("//div[text()='Continue']"));
       //Click on continue button
       ContinueButton.click();
       //Find out the mobile number text filed
      WebElement MobileNumber=driver.findElement(By.xpath("//div[text()='Mobile Number']/following::input[@id='mobileNumber']"));
      //to get the mobile number attribute value
      String Attribute =MobileNumber.getAttribute("autocapitalize");
      //to print the attribute value
      System.out.println(Attribute);
      //to get te CSS value of the Mobile number text field
      String FontSize=MobileNumber.getCssValue("font-size");
      String FontStyle=MobileNumber.getCssValue("font-style");
      String LineHeight=MobileNumber.getCssValue("line-height");
      String BColor=MobileNumber.getCssValue("background-color");
      // to print the CSS values to verify
      System.out.println("FOnt Size " +FontSize);
        System.out.println("Font Style "+  FontStyle);
        System.out.println("lineHeight " +LineHeight);
        System.out.println("Background color " +BColor);
        //to get the tag name of the mobile number text filed and tore in one varibale
      String TagName=MobileNumber.getTagName();
      //print the tagName of the mobile number text filed
      System.out.println("Tag Name of mobile Number text field "+TagName);
      //To get the height of the Mobile number text filed
      int Higt=MobileNumber.getSize().getHeight();
      //to print the hight of mobile number text filed
      System.out.println("Height of the text filed"+  Higt);
      //to get the width of the mobile number text filed
      int Width=MobileNumber.getSize().getWidth();
      //print the mobile number text filed width
      System.out.println("Width of the text field"+   Width);
      //method to verify the CSS value of the FontStyle
         String ActualFontStyle= "normal";
         if (FontStyle.equals(ActualFontStyle)){
             System.out.println("Expected Font Style is present ");
         }
         //To get the Xco-ordinate value of the mobile number text filed
      Integer XPoint=MobileNumber.getLocation().getX();
         //print the xco-ordinate value
         System.out.println("Xpoint coordinates  "+ XPoint);
        //To get the yco-ordinate value of the mobile number text filed
         Integer YPoint=MobileNumber.getLocation().getY();
        //print the yco-ordinate value
        System.out.println("Ypoint Coordinates  "+ YPoint);
        //to enter the digit in mobile number text filed
      MobileNumber.sendKeys("123456789012334455");
      Thread.sleep(5000);
      //to clear the data present in the mobile number text filed
      MobileNumber.clear();
        Thread.sleep(5000);
        //close the browser
        //to get the text which is present on the text box or any element

    }
}
