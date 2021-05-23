package pl.gov.nauka.radon.test;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.HomePage;
import pl.gov.nauka.radon.pages.SignInPage;
import pl.gov.nauka.radon.setup.BaseTest;
import pl.gov.nauka.radon.setup.CSVReaderFile;

import java.io.IOException;

public class SignInPageTest extends BaseTest {

    SignInPage signInPageObjects;
    CSVReaderFile csvFileObjects;
    HomePage homePageObjects;

    @Test()
    public void check_sign_in_page() throws CsvValidationException, IOException {

        //initialize PageObject of sign in page
        signInPageObjects = new SignInPage(driver);
        //initialize PageObject of home page
        homePageObjects = new HomePage(driver);

        homePageObjects.clickSignIn();
        csvFileObjects = new CSVReaderFile();
        String[] t1 = csvFileObjects.csvReadData().get(0);
        String[] t2 = csvFileObjects.csvReadData().get(1);

        signInPageObjects.enterEmail(t1[0]);
        signInPageObjects.enterPassword(t2[1]);
        signInPageObjects.clickSignInButton();
        signInPageObjects.checkErrorMessage();

    }
}
