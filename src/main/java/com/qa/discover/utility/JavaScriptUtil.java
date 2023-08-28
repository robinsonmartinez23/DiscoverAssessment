package com.qa.discover.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
    private WebDriver driver;
    private JavascriptExecutor js;

    public JavaScriptUtil(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) this.driver;
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void scrollPageUp(int height) {
        js.executeScript("window.scrollBy(0, -" + height + ")");
    }
    public void scrollPageDown() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void scrollPageDown(String height) {
        js.executeScript("window.scrollTo(0, '" + height + "')");
    }

    public void scrollToElementInScrollBox(By scrollBoxLocator, By targetElementLocator) {
        WebElement scrollBox = driver.findElement(scrollBoxLocator);
        WebElement targetElement = driver.findElement(targetElementLocator);
        js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", scrollBox, targetElement);
    }
    public void clickElementByJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);

    }
    public void hoverAndClickElementByJS(WebElement element) {
        js.executeScript("arguments[0].focus(); arguments[0].click();", element);
    }

}
