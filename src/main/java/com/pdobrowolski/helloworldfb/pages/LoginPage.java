package com.pdobrowolski.helloworldfb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class LoginPage extends Page {

    private WebDriver driver;
    private By emailLocator = By.id("email");
    private By passwordLocator = By.id("pass");
    private By loginButtonLocator = By.id("loginbutton");
    private WebElement emailInput;
    private WebElement passwordInput;
    private WebElement loginButton;
    private int timeout = 5;
    private int poolingTime = 100;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        setTitle("Facebook – zaloguj się lub zarejestruj");
        emailInput = driver.findElement(emailLocator);
        passwordInput = driver.findElement(passwordLocator);
        loginButton = driver.findElement(loginButtonLocator);
    }

    public void login(String email, String password) {

        loginPageWait(emailInput);
        loginPageWait(passwordInput);
        loginPageWait(loginButton);

        typeInEmail(email);
        typeInPassword(password);
        clickLoginButton();
    }

    private void loginPageWait(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(poolingTime))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void typeInEmail(String email) {
        emailInput.sendKeys(email);
    }

    private void typeInPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void clickLoginButton() {
        loginButton.click();
    }
}
