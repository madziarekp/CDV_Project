package pl.gov.nauka.radon.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class RegisterPage {

    WebDriver driver;

    //WebElements
    @FindBy(className = "recaptcha-checkbox-border")
    WebElement recaptcha;

    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    WebElement captchaFrame;

    @FindBy(xpath = "//iframe[@title='Zadanie reCAPTCHA']")
    WebElement captchaFrameTask;

    @FindBy(id = "recaptcha-verify-button")
    WebElement verifyCaptchaButton;

    @FindBy(name = "lastName")
    WebElement inputSurname;

    @FindBy(name = "password")
    WebElement inputPassword;

    @FindBy(name = "email")
    WebElement inputEmail;

    @FindBy(name = "password-confirm")
    WebElement inputRepeatedPassword;

    @FindBy(xpath = "//span[text()='Proszę podać imię.']")
    WebElement errorMissingName;

    @FindBy(xpath = "//span[text()='Proszę podać nazwę użytkownika.']")
    WebElement errorMissingUsername;

    @FindBy(xpath = "//span[text()='Nieprawidłowe hasło: musi zawierać co najmniej 1 wielkich liter.']")
    WebElement errorPassword;

    @FindBy(xpath = "//span[text()='Potwierdzenie hasła nie pasuje.']")
    WebElement errorRepeatedPassword;

    @FindBy(xpath = "//span[text()='Nieprawidłowy adres e-mail.']")
    WebElement errorEmail;

    @FindBy(xpath = "//button[contains(text(),'Zarejestruj')]")
    WebElement registerButton;

    @FindBy(tagName="iframe")
    List<WebElement> iframes;

    //Variables
    String missingName = "Proszę podać imię.";
    String incorrectSurname = "nazwisko.";
    String incorrectEmail = "email@com.";
    String missingUserName = "Proszę podać nazwę użytkownika.";
    String incorrectPassword = "pass";
    String repeatPassword = "RepeatedPassword2";

    //Constructor - called as soon as the object of the class is created
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //Click on Zarejestruj sie button
    public void clickRegisterButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }
    //verify error messages related to the missing values on the page
    public void verifyErrorsMissingValues()  {
       String getErrorMessageText = errorMissingName.getAttribute("innerHTML");
       Assert.assertEquals(getErrorMessageText, missingName);
    }

    //insert incorrect values to the specific fields
    public void insertIncorrectValues()
    {
        inputSurname.sendKeys(incorrectSurname);
        inputEmail.sendKeys(incorrectEmail);
        inputPassword.sendKeys(incorrectPassword);
        inputRepeatedPassword.sendKeys(repeatPassword);
    }

    //verify error messages related to the incorrect values
    public void verifyErrorsIncorrectValues()
    {
        ExpectedConditions.visibilityOf(errorMissingUsername);
        ExpectedConditions.visibilityOf(errorRepeatedPassword);
        ExpectedConditions.visibilityOf(errorEmail);
        ExpectedConditions.visibilityOf(errorPassword);
    }
    //click recaptcha checkbox
    public void clickRecaptcha()
    {
        driver.switchTo().frame(captchaFrame);
        recaptcha.click();
        ExpectedConditions.visibilityOf(iframes.get(0));
        driver.switchTo().frame(iframes.get(0));
        captchaFrameTask.sendKeys(Keys.ESCAPE);

    }
}
