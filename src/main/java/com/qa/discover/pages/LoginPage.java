package com.qa.discover.pages;

import com.qa.discover.utility.AppConstants;
import com.qa.discover.utility.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        elementUtil = new ElementUtil(this.driver);
    }

    private By creditCardLink = By.xpath("//p[text()='Credit Cards']");
    private By onlineBankingLink = By.xpath("//p[text()='Online Banking']");
    private By personalLoansLink = By.xpath("//p[text()='Personal Loans']");
    private By studentLoansLink = By.xpath("//p[text()='Student Loans']");
    private By homeLoansLink = By.xpath("//p[text()='Home Loans']");


    public String getLoginPageURL() {
        return elementUtil.waitForURLContainsAndCapture(AppConstants.LOGIN_PAGE_URL_MAIN_ROOT, AppConstants.SHORT_DEFAULT_TIME);
    }
    public CreditCardsPage navigateToCreditCardsPage() {
        elementUtil.waitForPageLoad(10);
        elementUtil.doClick(creditCardLink);
        return new CreditCardsPage(driver);
    }
}
