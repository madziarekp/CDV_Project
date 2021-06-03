package pl.gov.nauka.radon.test;

import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.gov.nauka.radon.pages.HomePage;
import pl.gov.nauka.radon.pages.RegisterPage;
import pl.gov.nauka.radon.pages.SignInPage;
import pl.gov.nauka.radon.setup.BaseTest;
import java.io.IOException;

public class RegisterPageTest extends BaseTest {

    SignInPage signInPageObjects;
    HomePage homePageObjects;
    RegisterPage registerPageObjects;

    String missingName = "Proszę podać imię.";

    @Test(priority = 1)
    public void check_register_page() throws CsvValidationException, IOException {
        signInPageObjects = new SignInPage(driver);
        homePageObjects = new HomePage(driver);
        registerPageObjects = new RegisterPage(driver);

        homePageObjects.clickSignIn();
        signInPageObjects.go_to_register_page();
        registerPageObjects.insertIncorrectValues();
        registerPageObjects.clickRecaptcha();
        registerPageObjects.clickRegisterButton();
        Assert.assertTrue(registerPageObjects.isMissingNameErrorMessageVisible());

    }
/*
    @Test(priority = 2)
    public void checkErrors()
    {
        Assert.assertEquals(registerPageObjects.verifyErrorsMissingValues(), missingName );
    }
*/

}


