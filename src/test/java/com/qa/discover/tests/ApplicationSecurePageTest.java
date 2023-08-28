package com.qa.discover.tests;

import com.qa.discover.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApplicationSecurePageTest extends BaseTest {
    @BeforeClass
    public void applicationSecurePageSetup(){
        creditCardsPage = loginPage.navigateToCreditCardsPage();
        applicationSecurePage = creditCardsPage.goToApplicationSecureCreditCard();
    }
    @Test
    public void applicationSecurePageTitleTest(){
        String actTitle = applicationSecurePage.getApplicationSecurePageTitle();
        Assert.assertTrue(actTitle.contains("Discover Card Application"));
    }
}
