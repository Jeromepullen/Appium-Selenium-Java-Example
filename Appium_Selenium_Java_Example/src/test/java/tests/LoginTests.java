package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void setUpPages() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("validPassword");
        loginPage.tapLoginButton();

        String welcomeMessage = homePage.getWelcomeMessage();
        Assert.assertTrue(welcomeMessage.contains("Welcome"), "The welcome message was not displayed!");
    }

    @Test
    public void testUnsuccessfulLogin() {
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword("invalidPassword");
        loginPage.tapLoginButton();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid username or password", "The error message did not match!");
    }

    @Test
    public void testEmptyUsername() {
        loginPage.enterUsername("");
        loginPage.enterPassword("somePassword");
        loginPage.tapLoginButton();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Username is required", "The error message did not match!");
    }

    @Test
    public void testEmptyPassword() {
        loginPage.enterUsername("validUsername");
        loginPage.enterPassword("");
        loginPage.tapLoginButton();

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Password is required", "The error message did not match!");
    }
}