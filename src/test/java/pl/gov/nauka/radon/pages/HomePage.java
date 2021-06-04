package pl.gov.nauka.radon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;


    //WebElements
    @FindBy(tagName = "title")
    WebElement Header;

    @FindBy(xpath = "//button[contains(@class, 'h-11')]")
    WebElement SignIn;

    @FindBy(xpath = "//input[@placeholder='Wyszukj w systemie']")
    WebElement searchInput;

    @FindBy(xpath = "//button[contains(@aria-label, 'Włącz tryb wysokiego kontrastu')]")
    WebElement contrastButtonDisabled;

    @FindBy(xpath = "//button[contains(text(),'systemie')]")
    WebElement aboutSystem;

    @FindBy(xpath = "//button[contains(text(),'Dane')]")
    WebElement dataButton;

    @FindBy(xpath = "//a[@href='/dane/nauczyciele-akademiccy-badacze-i-osoby-zaangazowane-w-dzialalnosc-naukowa']")
    WebElement employeeLink;

    @FindBy(xpath = "//button[contains(@aria-label, 'Wyłącz tryb wysokiego kontrastu')]")
    WebElement contrastButtonEnabled;

    //Constructor - called as soon as the object of the class is created
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // click sing in link to go to the Sign in Page
    public SignInPage clickSignIn() {
        SignIn.click();
        return new SignInPage(driver);
    }

    // click about link to go to the hyperlinks page
    public HyperlinksPage clickAboutPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(aboutSystem));
        aboutSystem.click();
        return new HyperlinksPage(driver);
    }

    // click Data link to go to the data page
    public FiltersPage clickDataPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(dataButton));
        dataButton.click();
        return new FiltersPage(driver);
    }

    // click Employee link to go to the search for Employees page
    public FiltersPage clickEmployeeLink() {
        employeeLink.click();
        return new FiltersPage(driver);
    }

    //verify header of the website
    public String getHeader() {
        return Header.getAttribute("innerHTML");
    }

    //verify search placeholder
    public String getSearchPlaceholder() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        return searchInput.getAttribute("placeholder");
    }

    //verify contrast button if disabled
    public String verifyContrastButtonDisabled() {
        return contrastButtonDisabled.getAttribute("aria-label");

    }

    //verify contrast button if enabled
    public String verifyContrastButtonEnabled() {
        contrastButtonDisabled.click();
        return contrastButtonEnabled.getAttribute("aria-label");
    }


}
