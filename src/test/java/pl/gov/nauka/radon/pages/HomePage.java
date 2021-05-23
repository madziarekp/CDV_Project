package pl.gov.nauka.radon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage {

        WebDriver driver;
        final String searchInputText = "Wyszukaj w systemie";
        final String headerText = "Strona główna - RAD-on: RAPORTY, ANALIZY, DANE";

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

        //Constructor - called as soon as the object of the class is created
        public HomePage(WebDriver driver) {
                this.driver = driver;
                PageFactory.initElements(driver,this);
        }
        // click sing in link to go to the Sign in Page
        public void clickSignIn()
        {
                SignIn.click();
        }

        //verify header of the website
        public void verifyHeader() {
                String getHeaderText = Header.getAttribute("innerHTML");
                Assert.assertEquals(headerText, getHeaderText);
        }
        //verify search placeholder
        public void verifySearch() {
                ExpectedConditions.visibilityOf(searchInput);
                Assert.assertEquals(searchInput.getAttribute("placeholder"),searchInputText);
        }
        //verify contrast button if disabled
        public void verifyContrastButtonDisabled()
        {
                Assert.assertEquals(contrastButtonDisabled.getAttribute("aria-label"), "Włącz tryb wysokiego kontrastu");
        }
        //verify contrast button if enabled
        public void verifyContrastButtonEnabled()
        {
                contrastButtonDisabled.click();
                String enabledContrast =  contrastButtonEnabled.getAttribute("aria-label");
                ExpectedConditions.textToBePresentInElement(contrastButtonEnabled, enabledContrast);
        }


}
