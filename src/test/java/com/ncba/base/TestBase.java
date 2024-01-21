package com.ncba.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {


    public static WebDriver driver;
    public static Properties prop;
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    public static void browser(){
        try{
            logger.info(">>>>>Before Opening the file<<<<<<<");
            prop =new Properties();
            FileInputStream fis = new
                    FileInputStream("src/main/java/com/ncba/config/config.properties");
            prop.load(fis);
        }
        catch (IOException e){e.printStackTrace();}
        catch (NullPointerException e) {e.printStackTrace();}
    }

    public static void setUp(){
        logger.info(">>>>Before opening the browser!<<<<<<");
        String browser = prop.getProperty("browser");
        if(browser!=null){
            switch (browser.toLowerCase()){
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "ff":
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                default:
                    logger.error("Invalid driver specification in config file:",browser);
                    throw new IllegalArgumentException("Invalid driver specification in Config:"+browser);
            }
        } else {
            logger.error("Invalid driver specification in config file:",browser);
            throw new IllegalArgumentException("Invalid driver specification in Config:"+browser);
        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
    }


    @AfterTest
    public static void closeBrowser(){

        driver.quit();
    }
}

