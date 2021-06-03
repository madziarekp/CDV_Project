package pl.gov.nauka.radon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

        @FindBy(xpath = "//button[contains(@aria-label, 'Wyłącz tryb wysokiego kontrastu')]")
        WebElement contrastButtonEnabled;

        @FindBy(xpath = "//button[contains(text(),'systemie')]")
        WebElement aboutSystem;

        //Constructor - called as soon as the object of the class is created
        public HomePage(WebDriver driver) {
                this.driver = driver;
                PageFactory.initElements(driver,this);
        }
        // click sing in link to go to the Sign in Page
        public SignInPage clickSignIn()
        {
                SignIn.click();
                return new SignInPage(driver);
        }
        // click about link to go to the hyperlinks page
        public HyperlinksPage clickAboutPage ()
        {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOf(aboutSystem));
                aboutSystem.click();
                return new HyperlinksPage(driver);
        }

        //verify header of the website
        public String getHeader() {
                String getHeaderText = Header.getAttribute("innerHTML");
                return getHeaderText;
        }
        //verify search placeholder
        public String getSearchPlaceholder() {
                ExpectedConditions.visibilityOf(searchInput);
                String searchPlaceholderText = searchInput.getAttribute("placeholder");
                return searchPlaceholderText;
        }
        //verify contrast button if disabled
        public String  verifyContrastButtonDisabled()
        {
               String attributeContrastButton = contrastButtonDisabled.getAttribute("aria-label");
               return attributeContrastButton;

        }
        //verify contrast button if enabled
        public void verifyContrastButtonEnabled()
        {
                contrastButtonDisabled.click();
                String enabledContrast =  contrastButtonEnabled.getAttribute("aria-label");
                ExpectedConditions.textToBePresentInElement(contrastButtonEnabled, enabledContrast);
        }


}
