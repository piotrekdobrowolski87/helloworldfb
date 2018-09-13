package com.pdobrowolski.helloworldfb;


import com.pdobrowolski.helloworldfb.pages.LoginPage;
import com.pdobrowolski.helloworldfb.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AppTest {

    private WebDriver driver;
    private String expectedTitle;
    private String actualTitle;
    private String fbStatus = "Hello world";
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser", "width", "height", "url"})
    public void setBrowser(String browser, int width, int height, String url) {
        SetBrowser setBrowser = new SetBrowser();
        driver = setBrowser.openBrowser(browser, width, height, url);


    }

    @Test(priority = 0)
    public void loginPage() {

        loginPage = new LoginPage(driver);
        expectedTitle = loginPage.getTitle();
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Wrong page title");
    }

    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void loginFb(String email, String password) {
        loginPage.login(email, password);

        mainPage = new MainPage(driver);
        expectedTitle = mainPage.getTitle();
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.endsWith(expectedTitle), "Wrong page title. Page title should ends with " + expectedTitle);
    }

    @Test(priority = 3)
    public void postStatus() {
        mainPage.postStatus(fbStatus);
    }

    @AfterSuite(alwaysRun = true)
    public void quite() {
        driver.quit();
    }
}
