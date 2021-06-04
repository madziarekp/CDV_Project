package pl.gov.nauka.radon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

public class HyperlinksPage {

    WebDriver driver;

    //WebElements
    @FindBy(xpath = "//button[contains(text(),'systemie')]")
    WebElement aboutSystem;

    @FindBy(xpath = "//a[@href='https://polon2.opi.org.pl']")
    WebElement polonLink;

    @FindBy(xpath = "//a[@href='https://inventorum.opi.org.pl']")
    WebElement inventorumLink;

    //Constructor - called as soon as the object of the class is created
    public HyperlinksPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //check if clicked link is properly open in the new tab
    public String checkFirstHyperlink() {
        polonLink.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String firstCurrentURL = driver.getCurrentUrl();
        driver.close();
        return firstCurrentURL;

    }

    public String checkSecondHyperlink() {

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        inventorumLink.click();
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String secondCurrentURL = driver.getCurrentUrl();
        driver.close();
        return secondCurrentURL;
    }
}
