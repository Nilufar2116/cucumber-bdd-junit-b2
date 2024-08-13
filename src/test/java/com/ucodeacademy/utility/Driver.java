package com.ucodeacademy.utility;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.net.UrlChecker;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver(){

    }

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){

        if(threadLocalDriver.get() == null){

            String browserName = ConfigReader.getProperty("browser");
            browserName = browserName.toLowerCase(); // make sure it is lower case

            switch (browserName){

                case "chrome":
                    threadLocalDriver.set(new ChromeDriver());
                    break;
                case "firefox":
                    threadLocalDriver.set(new FirefoxDriver());
                    break;
                case "edge":
                    threadLocalDriver.set(new EdgeDriver());
                    break;
                case "safari":
                    threadLocalDriver.set(new SafariDriver());
                    break;
                case "chrome-headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    threadLocalDriver.set(new ChromeDriver(options));
                    break;
                case "remote":

                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");
                    capabilities.setPlatform(Platform.ANY);

                    try {
                        URL url = new URL("http://192.168.0.29:4444/"); // we will give the correct url later

                        threadLocalDriver.set(new RemoteWebDriver(url,capabilities));
                    } catch (Exception e){
                        e.getStackTrace();

                        throw new RuntimeException("Remote WebDriver or URL is not working");
                    }
                    break;
                default:
                    throw new RuntimeException("Invalid browser name");

            }

        }

        WebDriver driver = threadLocalDriver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;

    }


    public static void quitDriver(){

        WebDriver driver = threadLocalDriver.get();

        if (driver != null){

            driver.quit();
            threadLocalDriver.remove();
        }

    }


}
