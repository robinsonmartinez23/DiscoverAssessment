package com.qa.discover.tests;

import com.qa.discover.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TermsConditionsSecurePageTest extends BaseTest {

    @BeforeClass
    public void termsConditionsSecurePageTest(){
        creditCardsPage = loginPage.navigateToCreditCardsPage();
        applicationSecurePage = creditCardsPage.goToApplicationSecureCreditCard();
        termsConditionsSecurePage = applicationSecurePage.skipToApplicationAndTermsPage();
    }

    @Test
    public void CashAdvancesAPRTest(){
        double apr = termsConditionsSecurePage.checkAPRCashAdvancesSecure();
        Assert.assertTrue(apr>20,"The APR is equal or less than 20");
    }
}
