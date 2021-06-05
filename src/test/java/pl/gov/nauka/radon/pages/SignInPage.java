package pl.gov.nauka.radon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    //verify error message after entering incorrect login and password
    public String getErrorMessage() {
        return errorMessage.getAttribute("innerHTML");
    }

    public void removeEmailValue() {
        input_email.clear();
    }

    public void removePasswordValue() {
        input_password.clear();
    }

    //enter email from csv file
    public void enterEmail(String email) {
        input_email.sendKeys(email);
    }

    //enter password from csv file
    public void enterPassword(String passwords) {
        input_password.sendKeys(passwords);
    }

    //click link Zarejestruj sie
    public void go_to_register_page() {
        registerLink.click();
    }
}

