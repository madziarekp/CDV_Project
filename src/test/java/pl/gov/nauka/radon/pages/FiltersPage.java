package pl.gov.nauka.radon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FiltersPage {

    WebDriver driver;

    //WebElements

    @FindBy(xpath = "//input[contains(@class, 'focus-1')]")
    WebElement inputName;

    @FindBy(className = "leading-4")
    WebElement searchButton;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    WebElement firstRowName;

    @FindBy(xpath = "//table/tbody/tr[1]/td[4]")
    WebElement firstRowSurname;


    @FindBy(xpath = "//span[contains(text(), ' Nazwisko A > Z ')]")
    WebElement sortAz;

    @FindBy(xpath = "//div[@class='tippy-content']/ul/li[2]/div[@class='p-2']")
    WebElement sortZa;

    //Constructor - called as soon as the object of the class is created
    public FiltersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //enter searched Name using Parameter
    public void enterFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(firstName);
    }

    //click Szukaj button
    public void clickSearch() {
        searchButton.click();
    }

    //check if URL contains search phrase, compare the Text in the first row of the table with the given string variable
    //refresh page - workaround, the website after searching still contains old values in the table from before searching

    public String getActualURL() {

        return driver.getCurrentUrl();
    }

    public String getFirstSurnameResult() {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(firstRowName));
        sortAz.click();
        return firstRowSurname.getText();

    }

    public String getLastSurnameResult() {
        sortZa.click();
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(firstRowSurname));
        return firstRowSurname.getText();
    }

    public String getFirstName() {
        return firstRowName.getText();
    }


}
