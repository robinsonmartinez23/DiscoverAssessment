package com.qa.discover.utility;

import net.bytebuddy.pool.TypePool;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtil {
    private WebDriver driver;
    public final int DEFAULT_TIME_OUT = 5;
    private JavaScriptUtil javaScriptUtil;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        javaScriptUtil = new JavaScriptUtil(this.driver);
    }

    public WebElement getElement(By locator) {
        WebElement element;  // null by default
        try {
            element = driver.findElement(locator);
            System.out.println("Element has been found with locator " + locator);
        } catch (NoSuchElementException e) {
            System.out.println("Element hasn't been found using the locator " + locator);
            element = waitForElementVisible(locator,DEFAULT_TIME_OUT);
        }
        return element;
    }

    public void doClick(By locator){
        getElement(locator).click();
    }
    public void doClick(By locator, int timeOut) {
        checkElementClickable(locator,timeOut);
        doClick(locator);
    }
    public WebElement checkElementClickable(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement waitForElementVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public String waitForURLContainsAndCapture(String urlFraction, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
            String url = driver.getCurrentUrl();
            return url;
        } else {
            System.out.println("url is not present within the given timeout : " + timeOut);
            return null;
        }
    }
    public String waitForTitleIsAndCapture(String titleFraction, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
            String title = driver.getTitle();
            return title;
        } else {
            System.out.println("title is not present within the given timeout : " + timeOut);
            return null;
        }
    }
    public void waitForPageLoad(int timeOut){
        long endTime = System.currentTimeMillis()+ timeOut;
        while (System.currentTimeMillis() < endTime){
            JavascriptExecutor js = (JavascriptExecutor)driver;
            String pageState = js.executeScript("return document.readyState").toString();
            //document.readyState -> In JS
            if(pageState.equals("complete")){
                System.out.println("Page DOM is fully loaded now..");
                break;
            }
        }
    }
}
