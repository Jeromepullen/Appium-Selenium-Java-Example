package pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class HomePage {
    private IOSDriver driver;

    private By welcomeMessage = By.id("welcome_message_id");

    public HomePage(IOSDriver driver) {
        this.driver = driver;
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }
}