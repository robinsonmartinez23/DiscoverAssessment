package com.qa.discover.tests;

import com.qa.discover.base.BaseTest;
import com.qa.discover.utility.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginPageUrlTest(){
        String actUrl = loginPage.getLoginPageURL();
        Assert.assertEquals(actUrl,AppConstants.LOGIN_PAGE_URL_MAIN_ROOT);
    }
}
