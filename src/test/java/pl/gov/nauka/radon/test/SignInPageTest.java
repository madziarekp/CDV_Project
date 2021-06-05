package pl.gov.nauka.radon.test;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.HomePage;
import pl.gov.nauka.radon.pages.HyperlinksPage;
import pl.gov.nauka.radon.pages.SignInPage;
import pl.gov.nauka.radon.setup.BaseTest;
import pl.gov.nauka.radon.setup.CSVReaderFile;

import java.io.IOException;
import java.util.Arrays;

public class SignInPageTest extends BaseTest {


    CSVReaderFile csvFileObjects;

    String incorrectLoginData = "Nieprawidłowa nazwa użytkownika lub hasło.";

    @Test()
    public void check_sign_in_page() throws CsvValidationException, IOException {

        //initialize PageObject of home page
        HomePage homePageObjects = new HomePage(driver);
        SignInPage signInPage = homePageObjects.clickSignIn();
        SignInPage fillLoginForm = signInPage.fillSignInForm();

            Assert.assertEquals(fillLoginForm.getErrorMessage(), incorrectLoginData);

        }

    }