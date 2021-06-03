package pl.gov.nauka.radon.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import pl.gov.nauka.radon.pages.HomePage;
import pl.gov.nauka.radon.setup.BaseTest;

public class HomePageTest extends BaseTest {

    HomePage homePageObjects;

    final String searchInputText = "Wyszukaj w systemie";
    final String headerText = "Strona główna - RAD-on: RAPORTY, ANALIZY, DANE";
    final String contrastButtonDisabled = "Włącz tryb wysokiego kontrastu";

    @Test(priority = 1)
    public void verifyHeader()
    {
        homePageObjects = new HomePage(driver);
        Assert.assertEquals(headerText, homePageObjects.getHeader());
    }

    @Test(priority = 2)
    public void verifySearchPlaceholder()
    {
        Assert.assertEquals(homePageObjects.getSearchPlaceholder(),searchInputText);

    }

    @Test(priority = 3)
    public void verifyContrastButtonDisabled()
    {
        Assert.assertEquals(homePageObjects.verifyContrastButtonDisabled(), contrastButtonDisabled);

    }

    @Test(priority = 4)
    public void verifyContrastButtonEnabled()
    {
        homePageObjects.verifyContrastButtonEnabled();
    }


}
