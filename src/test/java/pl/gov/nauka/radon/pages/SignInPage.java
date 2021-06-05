package pl.gov.nauka.radon.pages;

import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pl.gov.nauka.radon.setup.CSVReaderFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SignInPage {

    WebDriver driver;

    //WebElements
    @FindBy(xpath = "//button[contains(text(), 'Zaloguj')]")
    WebElement signInButton;

    @FindBy(className = "radkc-global-message__content")
    WebElement errorMessage;

    @FindBy(xpath = "//a[contains(text(), 'Zarejestruj')]")
    WebElement registerLink;

    @FindBy(name = "username")
    WebElement input_email;

    @FindBy(name = "password")
    WebElement input_password;

    CSVReaderFile csvFileObjects;

    //Constructor - called as soon as the object of the class is created
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Method to click Zaloguj sie button
    public void clickSignInButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public SignInPage fillSignInForm() throws CsvValidationException, IOException {
        //initialize PageObject of CSV Reader File
        csvFileObjects = new CSVReaderFile();

        //read all data from csv file
        for (int i = 0; i < csvFileObjects.csvReadData().size(); i++) {
            String[] t1 = csvFileObjects.csvReadData().get(i);
            input_email.sendKeys(t1[0]);
            input_password.sendKeys(t1[0]);
            signInButton.click();
            input_email.clear();
            input_password.clear();

        }
        return new SignInPage(driver);

    }

    //verify error message after entering incorrect login and password
    public String getErrorMessage() {
        return errorMessage.getAttribute("innerHTML");
    }

    //click link Zarejestruj sie
    public void go_to_register_page() {
        registerLink.click();
    }
}

