package com.qa.discover.factory;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OptionsManager {
    private Properties prop;
    private ChromeOptions co;
    private FirefoxOptions fo;
    private EdgeOptions eo;

    public OptionsManager(Properties prop){
        this.prop=prop;
    }
    public ChromeOptions getChromeOptions(){
        co = new ChromeOptions();
        if(Boolean.parseBoolean((prop.getProperty("headless")))){
            co.addArguments("--headless");
            System.out.println("headless mode activated");
        }
        if(Boolean.parseBoolean((prop.getProperty("incognito")))){
            co.addArguments("--incognito");
            System.out.println("incognito mode activated");
        }
        if(Boolean.parseBoolean((prop.getProperty("user-agent")))){
            co.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/116.0.0.0 Safari/537.36");
            System.out.println("user-agent mode activated");
        }
        return co;

    }
    public FirefoxOptions getFireFoxOptions(){
        fo = new FirefoxOptions();
        if(Boolean.parseBoolean((prop.getProperty("headless")))){
            fo.addArguments("--headless");
            System.out.println("headless mode activated");
        }
        if(Boolean.parseBoolean((prop.getProperty("incognito")))){
            fo.addArguments("--incognito");
            System.out.println("incognito mode activated");
        }
        return fo;
    }

    public EdgeOptions getEdgeOptions(){
        eo = new EdgeOptions();
        if(Boolean.parseBoolean((prop.getProperty("headless")))){
            eo.addArguments("--headless");
            System.out.println("headless mode activated");
        }
        if(Boolean.parseBoolean((prop.getProperty("incognito")))){
            eo.addArguments("--incognito");
            System.out.println("incognito mode activated");
        }
        return eo;
    }
}
