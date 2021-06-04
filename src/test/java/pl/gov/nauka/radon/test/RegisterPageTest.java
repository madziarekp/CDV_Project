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

    String missingName = "Proszę podać imię.";

    @Test(priority = 1)
    public void check_register_page() throws CsvValidationException, IOException {

        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.clickSignIn();
        signInPage.go_to_register_page();
        registerPage.insertIncorrectValues();
        registerPage.clickRecaptcha();
        registerPage.clickRegisterButton();
        Assert.assertTrue(registerPage.isMissingNameErrorMessageVisible());
        registerPage.verifyErrorsIncorrectValues();

    }

}


