package com.bluenotetherapeutics;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BaseActions {

    public MainPage(WebDriver driver, WebDriverWait wait) {super(driver, wait);
    }

    public void assertAllElements() {
        Assert.assertTrue(driver.findElement(Locators.LEARNMORE_ABOUT_BUTTON).isDisplayed());
    }
}