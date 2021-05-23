package pl.gov.nauka.radon.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {
        //initialize driver with protected access modifier.
        // Can be accessible from any class of same package or sub class of this class.
        protected WebDriver driver;

        @BeforeClass(alwaysRun = true)
        public void setup(){
            //Configure system properties of chrome driver
            System.setProperty("webdriver.chrome.driver","C:\\Users\\pabiam\\IdeaProjects\\CDV_Project\\chromedriver.exe");
            //Create a Chrome driver. It is used by all test classes
            driver = new ChromeDriver();
            // set 20 seconds for page to be loaded
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            //open website
            driver.get("https://radon.nauka.gov.pl/");
            //Maximize browser window
            driver.manage().window().maximize();
        }


        @AfterClass(alwaysRun = true)
        public void tear_down()
        {
            //close all browsers
            driver.quit();
        }


}

