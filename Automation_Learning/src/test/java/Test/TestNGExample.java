package Test;

import configconstents.BaseClass;
import org.testng.Reporter;
import org.testng.annotations.*;

public class TestNGExample extends BaseClass {
    public class CreateAnnotationsAutomatically {

        @Test(dataProvider = "dp")
        public void DataAccept(Integer n, String s) {
            Reporter.log(s, n);
            System.out.println("Data provider method ");
        }

        @Test
        public void Method1() {
            System.out.println("Test Block ");
        }

        @BeforeMethod
        public void beforeMethod() {
         System.out.println(" Before method execution");

        }

        @AfterMethod
        public void afterMethod() {
           System.out.println(" After method execution");
        }

        @BeforeClass
        public void beforeClass() {
            System.out.println(" Before class method execution");

        }

        @AfterClass
        public void afterClass() {
            System.out.println(" After class method execution");

        }

        @BeforeTest
        public void beforeTest() {
            System.out.println(" Before test method execution");

        }

        @AfterTest
        public void afterTest() {
            System.out.println(" After test method execution");

        }
        @BeforeSuite
        public void beforeSuite() {
            System.out.println(" Before Suite method execution");

        }

        @AfterSuite
        public void afterSuite() {
            System.out.println(" After Suite method execution");

        }

        @DataProvider
        public Object[][] dp() {
            return new Object[][]{
                    new Object[]{1, "naveen "},
                    new Object[]{2, "Ningappa"},
            };

        }
    }

}
