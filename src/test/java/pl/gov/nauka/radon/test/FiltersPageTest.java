package pl.gov.nauka.radon.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.FiltersPage;
import pl.gov.nauka.radon.setup.BaseTest;

public class FiltersPageTest extends BaseTest {

    FiltersPage filtersTestObjects;

    //Variables
    String expectedName = "Marcin";

    @Test(priority = 1)
    public void goToEmployeePage()
    {
        filtersTestObjects = new FiltersPage(driver);
        filtersTestObjects.clickDataButton();
        filtersTestObjects.clickEmployeeLink();
    }

    @Test(priority = 2)
    @Parameters({"firstName"})
    public void searchAndCheckResults(String firstName)
    {
        filtersTestObjects.enterFirstName(firstName);
        filtersTestObjects.clickSearch();

        Assert.assertNotEquals(filtersTestObjects.getFirstSurnameResult(), filtersTestObjects.getLastSurnameResult());
        Assert.assertTrue(filtersTestObjects.getActualURL().contains("firstName=Marcin&pageNumber=1"));
        Assert.assertEquals(filtersTestObjects.getFirstName(), expectedName);

    }

}
