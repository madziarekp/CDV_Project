package pl.gov.nauka.radon.test;

import org.testng.annotations.*;
import pl.gov.nauka.radon.pages.HomePage;
import pl.gov.nauka.radon.setup.BaseTest;

public class HomePageTest extends BaseTest {

    HomePage homePageObjects;

    @Test(priority = 1)
    public void verifyHeader()
    {
        homePageObjects = new HomePage(driver);
        homePageObjects.verifyHeader();
    }

    @Test(priority = 2)
    public void verifySearchPlaceholder()
    {
        homePageObjects.verifySearch();
    }

    @Test(priority = 3)
    public void verifyContrastButtonDisabled()
    {
        homePageObjects.verifyContrastButtonDisabled();
    }

    @Test(priority = 4)
    public void verifyContrastButtonEnabled()
    {

        homePageObjects.verifyContrastButtonEnabled();
    }


}
