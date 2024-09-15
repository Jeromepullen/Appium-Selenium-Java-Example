package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void sampleTest() {
        driver.findElement(By.id("button_id")).click();

        boolean isElementDisplayed = driver.findElement(By.id("new_element_id")).isDisplayed();
        Assert.assertTrue(isElementDisplayed, "The element was not displayed!");
    }
}