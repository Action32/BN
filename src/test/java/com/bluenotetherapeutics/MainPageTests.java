package com.bluenotetherapeutics;

import org.testng.annotations.Test;

public class MainPageTests extends BaseUI {

    @Test()
    public void checkAllLinksOnMainPage() {
        mainPage.assertAllElements();
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");
        mainPage.printInfo();
    }
}