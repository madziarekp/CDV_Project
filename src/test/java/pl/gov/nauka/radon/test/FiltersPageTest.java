package pl.gov.nauka.radon.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.FiltersPage;
import pl.gov.nauka.radon.pages.HomePage;
import pl.gov.nauka.radon.setup.BaseTest;

public class FiltersPageTest extends BaseTest {

    //Variables
    String expectedName = "Marcin";

    @Test(priority = 1)
    @Parameters({"firstName"})
    public void searchAndCheckResults(String firstName) {
        HomePage homePageObjects = new HomePage(driver);
        FiltersPage filtersPage = homePageObjects.clickDataPage();
        FiltersPage filtersPageEmployee = homePageObjects.clickEmployeeLink();
        filtersPage.enterFirstName(firstName);
        filtersPage.clickSearch();
        Assert.assertNotEquals(filtersPage.getFirstSurnameResult(), filtersPage.getLastSurnameResult());
        Assert.assertTrue(filtersPage.getActualURL().contains("firstName=Marcin&pageNumber=1"));
        Assert.assertEquals(filtersPage.getFirstName(), expectedName);


    }

}
