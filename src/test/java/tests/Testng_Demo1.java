package tests;

import config.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

public class Testng_Demo1 {
    WebDriver driver = null;
    public static String browserName = null;
    public static String result = null;

    @BeforeTest
    public void setUpTest() {
        String projectPath = System.getProperty("user.dir");
        PropertiesFile.getProperties();
        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    @Test
    public void searchTest() {
        driver.get("https://www.ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("ipod");
        driver.findElement(By.id("gh-btn")).click();
    }

    @AfterTest
    private void tearDownTest() {
        try{
            sleep(3000);// 3000 ms -- 3sec
        } catch (InterruptedException e) {
            //TODO Auto Generated Catch Block
            e.printStackTrace();
        }
        System.out.println("Test completed successfully");
        PropertiesFile.setProperties();
        if(result.equalsIgnoreCase("pass")) {
            System.out.println("result:" + result);
            driver.close();
        }
    }
}
