package com.qa.discover.base;

import com.qa.discover.factory.DriverFactory;
import com.qa.discover.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    protected DriverFactory driverFactory;
    protected Properties properties;
    // Page References
    protected ApplicationSecurePage applicationSecurePage;

    protected LoginPage loginPage;
    protected CreditCardsPage creditCardsPage;
    protected TermsConditionsSecurePage termsConditionsSecurePage;
    // Soft Assertion reference
    protected SoftAssert softAssert;


    @Parameters({"browser", "browserversion"}) // This browser parameter is an option
    // to provide this value manually by the parameter in xml testng.xml file
    @BeforeTest
    public void setup(@Optional String browserName, @Optional String browserVersion) {   // Here the browser's value given in the xml file
        driverFactory = new DriverFactory();
        properties = driverFactory.initProperties();

            if(browserName!=null){
                properties.setProperty("browser",browserName);
                properties.setProperty("browserversion", browserVersion);                                                // given in xml file not based on configuration file
            }

        driver = driverFactory.initDriver(properties);

        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
