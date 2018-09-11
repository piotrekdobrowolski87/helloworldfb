package com.pdobrowolski.helloworldfb;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AppTest {

    WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser", "width", "height", "url"})
    public void setBrowser(String browser, int width, int height, String url) {
        SetBrowser setBrowser = new SetBrowser();
        driver = setBrowser.openBrowser(browser, width, height, url);
    }

    @Test
    public void truee() {
        System.out.println("!!!!!!!!!!!! TEST !!!!!!!!!!!!!!!");
        Assert.assertTrue(true);
    }

    @AfterSuite(alwaysRun = true)
    public void quite() {
        driver.quit();
    }
}
