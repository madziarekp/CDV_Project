package pl.gov.nauka.radon.test;

import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.HyperlinksPage;
import pl.gov.nauka.radon.setup.BaseTest;

public class HyperlinksPageTest extends BaseTest {

    HyperlinksPage HyperlinksPageObjects;

    @Test(priority = 1)
    public void checkHyperlinks()
    {
        HyperlinksPageObjects = new HyperlinksPage(driver);
        HyperlinksPageObjects.openHyperlinks();
    }
}
