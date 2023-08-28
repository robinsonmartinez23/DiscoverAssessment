package com.qa.discover.tests;

import com.qa.discover.base.BaseTest;
import com.qa.discover.utility.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreditCardsPageTest extends BaseTest {
    @BeforeClass
    public void CreditCardsPageSetup(){
        creditCardsPage = loginPage.navigateToCreditCardsPage();
    }
    @Test
    public void creditCardsPageTitleTest(){
        String actTitle = creditCardsPage.getCreditCardsPageTitle();
        System.out.println(actTitle);
        Assert.assertTrue(actTitle.contains("Apply for a Credit"));
    }
}
