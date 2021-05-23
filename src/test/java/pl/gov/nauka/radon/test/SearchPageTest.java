package pl.gov.nauka.radon.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.SearchPage;
import pl.gov.nauka.radon.setup.BaseTest;

public class SearchPageTest extends BaseTest {

    SearchPage searchPageObjects;

    @Test(priority = 1)
    @Parameters({"searchPhrase"})
    public void check_search_results(String searchPhrase)
    {
        searchPageObjects = new SearchPage(driver);
        searchPageObjects.enterSearchedPhrase(searchPhrase);
        searchPageObjects.clickSearchButton();
        searchPageObjects.verifySearchResultsHeader();
        searchPageObjects.verifySearchResults();
    }


}