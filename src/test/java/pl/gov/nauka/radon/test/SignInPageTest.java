package pl.gov.nauka.radon.test;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.HomePage;
import pl.gov.nauka.radon.pages.SignInPage;
import pl.gov.nauka.radon.setup.BaseTest;
import pl.gov.nauka.radon.setup.CSVReaderFile;

import java.io.IOException;
import java.util.Arrays;

public class SignInPageTest extends BaseTest {

    //SignInPage signInPageObjects;
    CSVReaderFile csvFileObjects;
    HomePage homePageObjects;

    String incorrectLoginData = "Nieprawidłowa nazwa użytkownika lub hasło.";

    @Test()
    public void check_sign_in_page() throws CsvValidationException, IOException {

        //initialize PageObject of sign in page
        SignInPage signInPageObjects;
        //initialize PageObject of home page
        homePageObjects = new HomePage(driver);

        signInPageObjects = homePageObjects.clickSignIn();

        //initialize PageObject of CSV Reader File
        csvFileObjects = new CSVReaderFile();

        //define variables
        String[] t1 = new String[0];

        //read all data from csv file
        for(int i=0; i<csvFileObjects.csvReadData().size();i++)
        {
            t1 = csvFileObjects.csvReadData().get(i);
            signInPageObjects.enterEmail(t1[0]);
            signInPageObjects.enterPassword(t1[0]);
            signInPageObjects.clickSignInButton();
            Assert.assertEquals(signInPageObjects.getErrorMessage(),incorrectLoginData);
            signInPageObjects.removeEmailValue();
            signInPageObjects.removePasswordValue();
        }

    }
}