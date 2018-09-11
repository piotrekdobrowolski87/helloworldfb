package com.pdobrowolski.helloworldfb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetBrowser {

    private WebDriver driver;


    public WebDriver openBrowser(String browser, String url) {
        setBrowser(browser);

        driver.manage()
                .window()
                .maximize();

        driver.get(url);

        return driver;
    }

    public WebDriver openBrowser(String browser, int width, int height, String url) {
        setBrowser(browser);

        Dimension dimension = new Dimension(width, height);

        driver.manage()
                .window()
                .setSize(dimension);

        driver.get(url);

        return driver;
    }


    private void setBrowser(String browser) {
        switch (browser) {

            case "Chrome":
                WebDriverManager.chromedriver()
                        .setup();
                driver = new ChromeDriver();
                break;

            case "Firefox":
                WebDriverManager.firefoxdriver()
                        .setup();
                driver = new FirefoxDriver();
                break;

            case "Edge":
                WebDriverManager.edgedriver()
                        .setup();
                driver = new EdgeDriver();
        }
    }
}
