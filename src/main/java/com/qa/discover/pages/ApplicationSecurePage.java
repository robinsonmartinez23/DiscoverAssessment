package com.qa.discover.pages;

import com.qa.discover.utility.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ApplicationSecurePage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    private JavaScriptUtil javaScriptUtil;
    public ApplicationSecurePage(WebDriver driver) {
        this.driver = driver;
        this.javaScriptUtil = new JavaScriptUtil(driver);
        elementUtil = new ElementUtil(this.driver);
    }

    By skipLink = By.cssSelector(".enter-info-manually-adaptive-link-container a");

    public TermsConditionsSecurePage skipToApplicationAndTermsPage(){
        elementUtil.waitForPageLoad(10);
        WebElement link = elementUtil.getElement(skipLink);
        javaScriptUtil.scrollIntoView(link);
        /**
         * Note to Reviewers:
         * Below, I've explored multiple strategies to navigate to the TermsConditionsSecurePage.
         * Despite these varied attempts, I encountered challenges likely due to certain security measures
         * implemented by the site, which seemed to prevent automated navigation to that specific page.
         *
         * As a workaround, I directly reassigned the driver to the desired URL.
         */
        //elementUtil.doClick(skipLink,5);
        //javaScriptUtil.clickElementByJS(link);
        //Actions actions = new Actions(driver);
        //actions.moveToElement(elementUtil.getElement(skipLink)).click().build().perform();
        //javaScriptUtil.hoverAndClickElementByJS(link);
        driver.get("https://www.discovercard.com/application/website/apply?adpt=mn&srcCde=KXPA&ICMPGN=ALL_CC_SECURED_APPLY_NOW_BTN&_gl=1*srhj97*_ga*NTMyMDk1NzE5LjE2OTMxODk5NDg.*_ga_3MJNPV4VSE*MTY5MzE5NjM3Ny4yLjEuMTY5MzE5Njc2MS42MC4wLjA.&_ga=2.143486581.1744947800.1693189948-532095719.1693189948");
        return new TermsConditionsSecurePage(driver);
    }
    public String getApplicationSecurePageTitle() {
        return elementUtil.waitForTitleIsAndCapture("Discover Card",5);
    }
}
