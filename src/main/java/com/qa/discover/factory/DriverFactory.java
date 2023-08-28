package com.qa.discover.factory;

import com.qa.discover.frameworkException.FrameworkException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class DriverFactory {

    //WebDriver driver;
    OptionsManager optionsManager;
    public Properties properties;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public WebDriver initDriver(Properties properties) {

        String browserName = properties.getProperty("browser").trim();

        System.out.println("Browser name is: " + browserName);

        optionsManager = new OptionsManager(properties);

        switch (browserName.toLowerCase()) {
            case "chrome":
                    tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
                break;

            case "firefox":
                    tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));
                break;
            case "edge":
                    tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
                break;
            default:
                System.out.println(browserName + " is not a valid browser, please enter a valid one");
                throw new FrameworkException("NO_BROWSER_FOUND_EXCEPTION");
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(properties.getProperty("url"));
        return getDriver();
    }

    //Return the thread Local copy of the driver. Individual for each thread
    public synchronized static WebDriver getDriver() {
        return tlDriver.get();
    }

    public Properties initProperties(){

        properties = new Properties();
        FileInputStream fileInputStream = null;

        String envName = System.getProperty("env");
        System.out.println("Environment name is: " + envName);

        try {
            if (envName == null) {
                System.out.println("No env is given..hence running it on QA environment");
                fileInputStream = new FileInputStream("./src/main/resources/config/qa.config.properties");
            } else {
                System.out.println("Running test cases on env: " + envName);
                switch (envName.toLowerCase().trim()) {
                    case "qa":
                        fileInputStream = new FileInputStream("./src/main/resources/config/qa.config.properties");
                        break;
                    case "dev":
                        fileInputStream = new FileInputStream("./src/main/resources/config/dev.config.properties");
                        break;
                    case "stage":
                        fileInputStream = new FileInputStream("./src/main/resources/config/stage.config.properties");
                        break;
                    case "uat":
                        fileInputStream = new FileInputStream("./src/main/resources/config/uat.config.properties");
                        break;
                    case "prod":
                        fileInputStream = new FileInputStream("./src/main/resources/config/config.properties");
                        break;
                    default:
                        System.out.println(envName + " is an invalid environment name, please entry a valid one");
                        throw new FrameworkException("NON_VALID_ENV_NAME_GIVEN");
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static String getScreenshot() {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
