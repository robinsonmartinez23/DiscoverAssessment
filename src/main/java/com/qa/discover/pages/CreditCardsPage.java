package com.qa.discover.pages;

import com.qa.discover.utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreditCardsPage{

    private WebDriver driver;
    private ElementUtil elementUtil;

    private JavaScriptUtil javaScriptUtil;

    public CreditCardsPage(WebDriver driver) {
        this.driver = driver;
        this.javaScriptUtil = new JavaScriptUtil(driver);
        elementUtil = new ElementUtil(this.driver);
    }

    By securedApplyBtn = By.xpath("//a[contains(@href,'CC_SECURED_APPLY')]");
    By studentApplyBtn = By.xpath("//a[contains(@href,'CC_STUDENT_CB_APPLY')]");
    By cashBackApplyBtn = By.xpath("//a[contains(@href,'CC_CB_APPLY')]");
    public ApplicationSecurePage goToApplicationSecureCreditCard() {
        elementUtil.waitForPageLoad(10);
        WebElement securedBtn = elementUtil.getElement(securedApplyBtn);
        javaScriptUtil.scrollIntoView(securedBtn);
        javaScriptUtil.scrollPageUp(236);
        elementUtil.doClick(securedApplyBtn);
        return new ApplicationSecurePage(driver);
    }
    public String getCreditCardsPageTitle() {
        return elementUtil.waitForTitleIsAndCapture("Apply for a",5);
    }
}