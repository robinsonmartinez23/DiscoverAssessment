package com.qa.discover.pages;

import com.qa.discover.utility.ElementUtil;
import com.qa.discover.utility.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TermsConditionsSecurePage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    private JavaScriptUtil javaScriptUtil;

    public TermsConditionsSecurePage(WebDriver driver) {
        this.driver = driver;
        this.javaScriptUtil = new JavaScriptUtil(driver);
        elementUtil = new ElementUtil(this.driver);
    }

    By termsConScrollBox = By.xpath("//div[@id='terms-scrollbox']");
    By cashAdvanceAPR = By.xpath("(//h5[text()='APR for Cash Advances'])[1]/../div//b");
    public double checkAPRCashAdvancesSecure(){
        elementUtil.waitForPageLoad(10);
        WebElement termsElem = elementUtil.getElement(termsConScrollBox);
        javaScriptUtil.scrollIntoView(termsElem);
        javaScriptUtil.scrollToElementInScrollBox(termsConScrollBox,cashAdvanceAPR);
        WebElement cashAdvanceValue = elementUtil.getElement(cashAdvanceAPR);
        String value = cashAdvanceValue.getText().replace("%","");
        return Double.parseDouble(value);
    }
}
