package pl.gov.nauka.radon.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.SearchPage;
import pl.gov.nauka.radon.setup.BaseTest;

public class SearchPageTest extends BaseTest {

    SearchPage searchPageObjects;

    @Test(priority = 1)
    @Parameters({"searchPhrase"})
    public void check_search_results(String searchPhrase) {
        searchPageObjects = new SearchPage(driver);
        searchPageObjects.enterSearchedPhrase(searchPhrase);
        searchPageObjects.clickSearchButton();
        searchPageObjects.verifySearchResultsHeader();
        Assert.assertEquals(searchPageObjects.getReportsResults(), "https://radon.nauka.gov.pl/wyszukiwanie?searchType=raporty&pageNumber=1&q=Collegium%20Da%20Vinci");
        Assert.assertEquals(searchPageObjects.getAnalysisResults(), "https://radon.nauka.gov.pl/wyszukiwanie?searchType=analizy&pageNumber=1&q=Collegium%20Da%20Vinci");
    }


}