package com.bluenotetherapeutics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BaseActions {

    public void printInfo() {
        System.out.println("CONGRATULATIONS - HOME PAGE LINKS TEST PASSED!!!");
    }

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Method for link verification
    public void checkLinksOnWebPage(String typeElement, String attribute) {
        List<WebElement> links = driver.findElements(By.xpath(typeElement));
        System.out.println("I start taking attributes on page");
        for (int i = 0; i < links.size(); i++) {
            WebElement ele = links.get(i);
            String url = ele.getAttribute(attribute);
            verifyLinkActive(url);
        }
        System.out.println("Total links are" + links.size());
    }

    //Method for link Active status
    public void verifyLinkActive(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            } else if (httpURLConnect.getResponseCode() >= 400 && httpURLConnect.getResponseCode() <= 504) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}