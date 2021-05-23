package pl.gov.nauka.radon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchPage {

     WebDriver driver;

     //WebElements
     @FindBy(xpath = "//button//span[text()='Szukaj']")
     WebElement searchButton;

     @FindBy(xpath = "//button[contains(text(), 'Dane (')]")
     WebElement dataLink;

     @FindBy(xpath = "//button[contains(text(), 'Raporty (')]")
     WebElement reportsLink;

     @FindBy(xpath = "//button[contains(text(), 'Analizy (')]")
     WebElement analysisLink;

     @FindBy(xpath = "//input[@placeholder='Szukaj w danych']")
     WebElement inputSearchResults;

     @FindBy(xpath = "//input[@placeholder='Wyszukj w systemie']")
     WebElement inputSearchField;

     @FindBy(tagName = "title")
     WebElement searchHeader;

     @FindBy(xpath = "//span[contains(text()='Raporty ')]")
     WebElement dataCategory;

     //Constructor - called as soon as the object of the class is created
     public SearchPage(WebDriver driver) {
          this.driver = driver;
          PageFactory.initElements(driver,this);
     }
     //enter search phrase using Parameter
     public void enterSearchedPhrase(String searchPhrase)
     {
          WebDriverWait wait = new WebDriverWait(driver, 10);
          wait.until(ExpectedConditions.visibilityOf(inputSearchField));
          inputSearchField.click();
          inputSearchField.sendKeys(searchPhrase);
     }
     //click Szukaj button
     public void clickSearchButton()
     {
          searchButton.click();
     }

     //verify the header of the page after searching for a phrase
     public void verifySearchResultsHeader() {
          WebDriverWait wait = new WebDriverWait(driver, 10);
          wait.until(ExpectedConditions.titleIs("Wyniki wyszukiwania - RAD-on: RAPORTY, ANALIZY, DANE"));
     }
     //verify if the results are shown and the URL is changed depending on the category
     public void verifySearchResults()
     {
          WebDriverWait wait = new WebDriverWait(driver, 10);
          wait.until(ExpectedConditions.elementToBeClickable(reportsLink));
          reportsLink.click();
          String reportsURL = driver.getCurrentUrl();
          Assert.assertEquals(reportsURL, "https://radon.nauka.gov.pl/wyszukiwanie?searchType=raporty&pageNumber=1&q=Collegium%20Da%20Vinci");
          analysisLink.click();
          String analysisURL = driver.getCurrentUrl();
          Assert.assertEquals(analysisURL, "https://radon.nauka.gov.pl/wyszukiwanie?searchType=analizy&pageNumber=1&q=Collegium%20Da%20Vinci");
     }
}
