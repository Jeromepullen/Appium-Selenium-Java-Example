package pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class LoginPage {
    private IOSDriver driver;

    // Locators for login screen elements
    private By usernameField = By.id("username_field_id");
    private By passwordField = By.id("password_field_id");
    private By loginButton = By.id("login_button_id");
    private By errorMessage = By.id("error_message_id");

    public LoginPage(IOSDriver driver) {
        this.driver = driver;
    }

    // Actions on the login screen
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void tapLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}