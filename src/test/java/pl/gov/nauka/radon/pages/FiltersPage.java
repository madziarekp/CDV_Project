package pl.gov.nauka.radon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FiltersPage {

    WebDriver driver;

    //WebElements
    @FindBy(xpath = "//button[contains(text(),'Dane')]")
    WebElement dataButton;

    @FindBy(xpath = "//a[@href='/dane/nauczyciele-akademiccy-badacze-i-osoby-zaangazowane-w-dzialalnosc-naukowa']")
    WebElement employeeLink;

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

    //Variables
    String expectedName = "Marcin";

    //Constructor - called as soon as the object of the class is created
    public FiltersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // click Data link to go to the data page
    public void clickDataButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(dataButton));
        dataButton.click();
    }

    // click Employee link to go to the search for Employees page
    public void clickEmployeeLink()
    {
        employeeLink.click();
    }

    //enter searched Name using Parameter
    public void enterFirstName(String firstName)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(firstName);
    }
    //click Szukaj button
    public void clickSearch()
    {
        searchButton.click();
    }

    //check if URL contains search phrase, compare the Text in the first row of the table with the given string variable
    //refresh page - workaround, the website after searching still contains old values in the table from before searching
    public void checkResults()
    {
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains("firstName=Marcin&pageNumber=1"));
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(firstRowName));
        String getFirstName = firstRowName.getText();
        Assert.assertEquals(getFirstName, expectedName);
        String getFirstSurname = firstRowSurname.getText();
        sortAz.click();
        sortZa.click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOf(firstRowSurname));
        String getLastSurname = firstRowSurname.getText();
        Assert.assertNotEquals(getLastSurname, getFirstSurname);
    }

 }
