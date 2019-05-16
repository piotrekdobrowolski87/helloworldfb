package com.pdobrowolski.helloworldfb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class MainPage extends Page {


    private WebDriver driver;
    private By statusBarLocator = By.xpath("//textarea[@name='xhpc_message']");
    private By postButtonLocator = By.xpath("//button[@data-testid='react-composer-post-button']");
    private By picturesLocator = By.xpath("//div[@class='_3eny']/div[2]/table/tbody/tr/td");
    private WebElement statusBar;
    private WebElement postButton;
    private int timeout = 15;
    private int poolingTime = 100;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        setTitle("Facebook");
        statusBar = driver.findElement(statusBarLocator);
    }

    public void postStatus(String status) {

        mainPageWait(statusBar);
        statusBar.click();

        statusBar.sendKeys(status);

        picturesListWait();

        postButton = driver.findElement(postButtonLocator);
        postButton.click();
    }

    private void mainPageWait(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(poolingTime))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }


    private void picturesListWait() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(poolingTime))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.numberOfElementsToBe(picturesLocator, 17));
    }
    //local_1 aaa 111
    //local_2 bbb 222
    //local_3 eee ccc
    //local_4 ddd 555
    //local_5 fff
    //new_online_1
    //new_online_2
}
