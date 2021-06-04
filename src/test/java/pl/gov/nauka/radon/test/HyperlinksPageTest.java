package pl.gov.nauka.radon.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.HomePage;
import pl.gov.nauka.radon.pages.HyperlinksPage;
import pl.gov.nauka.radon.setup.BaseTest;

public class HyperlinksPageTest extends BaseTest {


    @Test(priority = 1)
    public void checkHyperlinks() {
        HomePage homePage = new HomePage(driver);
        HyperlinksPage hyperlinksPage = homePage.clickAboutPage();

        Assert.assertEquals(hyperlinksPage.checkFirstHyperlink(), "https://polon2.opi.org.pl/siec-polon");
        Assert.assertEquals(hyperlinksPage.checkSecondHyperlink(), "https://inventorum.opi.org.pl/");
    }

}
